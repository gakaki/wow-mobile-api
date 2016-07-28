package com.wow.mobileapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.page.PageModel;
import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.ImgPrefixUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.MapUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.product.ProductInfoRequest;
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.mobileapi.response.product.ColorMapVo;
import com.wow.mobileapi.response.product.ColorSpecVo;
import com.wow.mobileapi.response.product.ItemDetailResponse;
import com.wow.mobileapi.response.product.ItemSpecResponse;
import com.wow.mobileapi.response.product.ProductImageResponse;
import com.wow.mobileapi.response.product.SpecColorVo;
import com.wow.mobileapi.response.product.SpecMapVo;
import com.wow.mobileapi.response.product.SubProductInfo;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.price.vo.ProductPriceResponse;
import com.wow.product.model.Brand;
import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.model.ProductImage;
import com.wow.product.service.BrandService;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.ProductVo;
import com.wow.product.vo.request.ProductImgVo;
import com.wow.product.vo.request.ProductQueryVo;
import com.wow.product.vo.response.ProductImgResponse;
import com.wow.product.vo.response.ProductResponse;
import com.wow.product.vo.response.ProductVoResponse;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStockVo;
import com.wow.stock.vo.response.AvailableStocksResponse;

@RestController
public class ProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSerialService productSerialService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private StockService stockService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private DesignerService designerService;

    private static final Integer productPrimaryImgCountLimit = 5;

    /**
     * 产品详情页(系列主品和独立主品)
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product", method = RequestMethod.GET)
    public ApiResponse getItemDetail(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ItemDetailResponse itemDetailResponse = new ItemDetailResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(productQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        int productId = productQueryRequest.getProductId();

        try {
            //获取产品基本信息
            ProductResponse productResponse = productService.getItemDetailById(productId);

            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productResponse);
                return apiResponse;
            } else {
                BeanUtil.copyProperties(productResponse, itemDetailResponse);
            }

            //品牌
            Brand brand = brandService.getBrandById(productResponse.getBrandId()).getBrand();
            if (brand != null) {
                itemDetailResponse.setBrandCname(brand.getBrandCname());
                itemDetailResponse.setBrandLogoImg(ImgPrefixUtil.addPrefixForImgUrl(brand.getBrandLogoImg()));
            }

            //主设计师
            Designer designer = designerService.getPrimaryDesignerByProduct(productId);
            if (designer != null) {
                itemDetailResponse.setDesignerName(designer.getDesignerName());
                itemDetailResponse.setDesignerPhoto(ImgPrefixUtil.addPrefixForImgUrl(designer.getDesignerPhoto()));
            }

            //产品图片(要求最多5张主图和一张细节图)
            List<ProductImage> productImages = productService.getProductImages(productId);
            if (CollectionUtil.isNotEmpty(productImages)) {
                List<String> primaryImgUrlList = new ArrayList<String>();

                int primaryImgCnt = 0;
                int nonPrimaryImgCnt = 0;

                for (ProductImage productImage : productImages) {
                    if (primaryImgCnt == productPrimaryImgCountLimit && nonPrimaryImgCnt == 1) {
                        break;
                    }
                    if (productImage.getIsPrimary() && primaryImgCnt < productPrimaryImgCountLimit) {
                        primaryImgUrlList.add(ImgPrefixUtil.addPrefixForImgUrl(productImage.getImgUrl()));
                        primaryImgCnt++;
                    }
                    if (!productImage.getIsPrimary() && nonPrimaryImgCnt < 1) {
                        itemDetailResponse.setFirstNonPrimaryImgUrl(ImgPrefixUtil.addPrefixForImgUrl(productImage.getImgUrl()));
                        itemDetailResponse.setFirstNonPrimaryImgDesc(productImage.getImgDesc());
                        nonPrimaryImgCnt++;
                    }
                }
                itemDetailResponse.setPrimaryImgs(primaryImgUrlList);
            }

            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(itemDetailResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, itemDetailResponse);
            } else {
                //产品价格(售价和原价)
                ProductPriceResponse productPriceResponse = priceService.getProductPrice(productId);
                if (productPriceResponse != null && productPriceResponse.getProductPrice() != null) {
                    itemDetailResponse.setSellPrice(productPriceResponse.getProductPrice().getSellPrice());
                    itemDetailResponse.setOriginalPrice(productPriceResponse.getProductPrice().getOriginalPrice());
                } else {
                    //TODO 价格异常
                }

                apiResponse.setData(itemDetailResponse);
            }
        } catch (Exception e) {
            logger.error("查找产品详情发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 系列品规格选择页详细信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/spec", method = RequestMethod.GET)
    public ApiResponse getItemSpecInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ItemSpecResponse itemSpecResponse = new ItemSpecResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(productQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        int productId = productQueryRequest.getProductId();

        try {
            //获取系列品基本信息
            Product product = productService.getProductById(productId);
            if (product == null) {
                ErrorResponseUtil.setErrorResponse(apiResponse,"40202");
                return apiResponse;
            }
            itemSpecResponse.setProductId(productId);
            itemSpecResponse.setSizeText(product.getSizeText());
            itemSpecResponse.setProductName(product.getProductName());

            //颜色集合
            List<String> colorDisplayNameList = new ArrayList<>();
            //规格集合
            List<String> specNameList = new ArrayList<>();

            //获取系列品所有子品
            List<Product> subProductList = productSerialService.getProductSerialsDetail(productId);
            if (CollectionUtil.isEmpty(subProductList)) {
                ErrorResponseUtil.setErrorResponse(apiResponse,"40203");
                return apiResponse;
            }
            List<Integer> allProductIds = new ArrayList<>();//主品+子品的ID
            List<Integer> subProductIds = new ArrayList<>();

            for (Product subProduct : subProductList) {
                subProductIds.add(subProduct.getId());
            }
            allProductIds.add(productId);
            allProductIds.addAll(subProductIds);

            Map<Integer, Integer> availableStockMap = new HashMap<Integer, Integer>();
            //批量查库存
            AvailableStocksResponse availableStocksResponse = stockService.batchGetAvailableStock(subProductIds);
            if (availableStocksResponse != null && CollectionUtil.isNotEmpty(availableStocksResponse.getAvailableStockVoList())) {
                List<AvailableStockVo> availableStockVoList = availableStocksResponse.getAvailableStockVoList();
                for (AvailableStockVo availableStockVo : availableStockVoList) {
                    availableStockMap.put(availableStockVo.getProductId(), availableStockVo.getTotalAvailableStockQty());
                }
            }
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            //批量查询价格
            ProductListPriceResponse productPriceListResponse = priceService.batchGetProductPrice(allProductIds);
            if (productPriceListResponse != null && MapUtil.isNotEmpty(productPriceListResponse.getMap())) {
                priceMap = productPriceListResponse.getMap();
            }

            if(priceMap.get(productId)!=null) {
                itemSpecResponse.setProductPrice(priceMap.get(productId).getSellPrice());
            }

            //颜色list
            List<ColorSpecVo> colorSpecVoList = new ArrayList<>();
            Map<String, ColorSpecVo> colorSepcVoMap = new HashMap<>();
            //规格list
            List<SpecColorVo> specColorVoList = new ArrayList<>();
            Map<String, SpecColorVo> specColorVoMap = new HashMap<>();

            for (Product subProduct : subProductList) {
                int subProductId = subProduct.getId();

                subProductIds.add(subProductId);
                String colorDisplayName = subProduct.getColorDisplayName();
                if (!colorDisplayNameList.contains(colorDisplayName)) {
                    colorDisplayNameList.add(colorDisplayName);
                }

                if (!colorSepcVoMap.containsKey(colorDisplayName)) {
                    ColorSpecVo colorSpecVo = new ColorSpecVo();
                    colorSpecVo.setColorDisplayName(colorDisplayName);
                    colorSpecVo.setSpecMapVoList(new ArrayList<>());
                    colorSpecVoList.add(colorSpecVo);
                    colorSepcVoMap.put(colorDisplayName,colorSpecVo);
                }

                String specName = subProduct.getSpecName();
                if (!specNameList.contains(specName)) {
                    specNameList.add(specName);
                }

                if (!specColorVoMap.containsKey(specName)) {
                    SpecColorVo specColorVo = new SpecColorVo();
                    specColorVo.setSpecName(specName);
                    specColorVo.setColorMapVoList(new ArrayList<>());
                    specColorVoList.add(specColorVo);
                    specColorVoMap.put(specName,specColorVo);
                }

                SubProductInfo subProductInfo = new SubProductInfo();
                subProductInfo.setSizeText(subProduct.getSizeText());
                subProductInfo.setProductColorImg(subProduct.getProductColorImg());
                subProductInfo.setSubProductId(subProductId);
                subProductInfo.setWeight(subProduct.getWeight());

                //设置库存
                if(availableStockMap.containsKey(subProductId) && availableStockMap.get(subProductId) > 0) {
                    subProductInfo.setHasStock(true);
                    subProductInfo.setAvailableStock(availableStockMap.get(subProductId));
                } else {
                    subProductInfo.setHasStock(false);
                    subProductInfo.setAvailableStock(0);
                }

                //设置价格
                if(priceMap.containsKey(subProductId) && priceMap.get(subProductId) != null) {
                    subProductInfo.setSellPrice(priceMap.get(subProductId).getSellPrice());
                } else {
                    setInternalErrorResponse(apiResponse);
                }
                SpecMapVo specMapVo = new SpecMapVo();
                specMapVo.setSpecName(specName);
                specMapVo.setSubProductInfo(subProductInfo);
                ColorSpecVo colorSpecVo1 = colorSepcVoMap.get(colorDisplayName);
                colorSpecVo1.getSpecMapVoList().add(specMapVo);

                ColorMapVo colorMapVo = new ColorMapVo();
                colorMapVo.setColorDisplayName(colorDisplayName);
                colorMapVo.setSubProductInfo(subProductInfo);
                SpecColorVo specColorVo1 = specColorVoMap.get(specName);
                specColorVo1.getColorMapVoList().add(colorMapVo);

            }

            itemSpecResponse.setColorDisplayNameList(colorDisplayNameList);
            itemSpecResponse.setSpecNameList(specNameList);
            itemSpecResponse.setColorSpecVoList(colorSpecVoList);
            itemSpecResponse.setSpecColorVoList(specColorVoList);

            apiResponse.setData(itemSpecResponse);
        } catch (Exception e) {
            logger.error("查找产品规格发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 产品图文详情页(细节图)
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/images/detail", method = RequestMethod.GET)
    public ApiResponse getProductNonPrimaryImgs(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ProductImageResponse productImageResponse = new ProductImageResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(productQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }
        int productId = productQueryRequest.getProductId();
        try {
            //获取非主图信息
            ProductImgResponse productImgResponse = productService.getProductNonPrimaryImages(productId);

            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productImgResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productImgResponse);
                return apiResponse;
            } else {
                List<ProductImgVo> productImgVos = productImgResponse.getProductImgVoList();
                for (ProductImgVo productImgVo : productImgVos) {
                    productImgVo.setImgUrl(ImgPrefixUtil.addPrefixForImgUrl(productImgVo.getImgUrl()));
                }
                productImageResponse.setProductImgVoLit(productImgResponse.getProductImgVoList());
                apiResponse.setData(productImageResponse);
            }
        } catch (Exception e) {
            logger.error("查找产品详情发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 按分类查询产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/products/list-by-category", method = RequestMethod.GET)
    public ApiResponse getProductListByCategory(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ProductInfoRequest productInfoRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), ProductInfoRequest.class);
        //判断json格式参数是否有误
        if (productInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(productInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        PageModel page = new PageModel();
        page.setShowCount(productInfoRequest.getShowCount());
        page.setCurrentPage(productInfoRequest.getCurrentPage());
        ProductQueryVo pqv = new ProductQueryVo();
        BeanUtil.copyProperties(productInfoRequest, pqv);
        page.setModel(pqv);
        
        try {
        	ProductVoResponse productVoResponse = productService.getProductByCategoryIdListPage(page);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productVoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productVoResponse);
            } 
            apiResponse.setData(productVoResponse);
        } catch (Exception e) {
            logger.error("按分类查询产品列表---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 根据品牌查询产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/brand", method = RequestMethod.GET)
    public ApiResponse getProductByBrandId(ApiRequest apiRequest) {
        logger.info("start to get product_brand on page");
        ApiResponse apiResponse = new ApiResponse();
        ProductQueryRequest productQueryRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
        	ProductVoResponse productVoResponse = productService.selectProductByBrandId(productQueryRequest.getBrandId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productVoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productVoResponse);
            } else {
                List<ProductVo> productList = new ArrayList<ProductVo>();

                for (ProductVo productVo : productVoResponse.getProductVoList()) {
                    ProductImage pi = productService.selectProductPrimaryOneImg(productVo.getProductId());
                    if(pi!=null){
                        productVo.setProductImg(ImgPrefixUtil.addPrefixForImgUrl(pi.getImgUrl()));
                        productList.add(productVo);
                    }
                }
                productVoResponse.setProductVoList(productList);
                apiResponse.setData(productVoResponse);
            }
        } catch (Exception e) {
            logger.error("查找product_brand错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 根据设计师查询产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/designer", method = RequestMethod.GET)
    public ApiResponse getProductByDesignerId(ApiRequest apiRequest) {
        logger.info("start to get product_designer on page");
        ApiResponse apiResponse = new ApiResponse();
        ProductQueryRequest productQueryRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
        	ProductVoResponse productVoResponse = productService.selectProductByDesignerId(productQueryRequest.getDesignerId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productVoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productVoResponse);
            } else {
                List<ProductVo> productList = new ArrayList<ProductVo>();

                for (ProductVo productVo : productVoResponse.getProductVoList()) {
                    ProductImage pi = productService.selectProductPrimaryOneImg(productVo.getProductId());
                    if(pi!=null){
                        productVo.setProductImg(ImgPrefixUtil.addPrefixForImgUrl(pi.getImgUrl()));
                        productList.add(productVo);
                    }
                }
                productVoResponse.setProductVoList(productList);
                apiResponse.setData(productVoResponse);
            }
        } catch (Exception e) {
            logger.error("查找product_designer错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}