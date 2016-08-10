package com.wow.product.service.impl;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.response.CategoryListResponse;
import com.wow.attribute.vo.response.CategoryResponse;
import com.wow.common.constant.BizConstant;
import com.wow.common.constant.ErrorCodeConstant;
import com.wow.common.enums.MaterialEnum;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.*;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.product.mapper.*;
import com.wow.product.model.*;
import com.wow.product.service.ApplicableSceneService;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.*;
import com.wow.product.vo.request.*;
import com.wow.product.vo.request.DesignerVo;
import com.wow.product.vo.response.*;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStockVo;
import com.wow.stock.vo.response.AvailableStocksResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private ProductAttributeMapper productAttributeMapper;

    @Autowired
    private  ProductMaterialMapper productMaterialMapper;

    @Autowired
    private ProductApplicableSceneMapper productApplicableSceneMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttributeService attributeService;

    @Autowired
    private DesignerService designerService;

    @Autowired
    private ApplicableSceneService applicableSceneService;

    @Autowired
    private ProductSerialService productSerialService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private StockService stockService;

    /**
     * @param product
     * @return
     */
    @Override
    public int createProduct(Product product) {
        int productId = productMapper.insertSelective(product);
        return productId;
    }

    private List<ProductMaterial> getProductMaterials(Integer productId) {
        ProductMaterialExample productMaterialExample = new ProductMaterialExample();
        productMaterialExample.or().andProductIdEqualTo(productId).andIsDeletedEqualTo(false);
        return productMaterialMapper.selectByExample(productMaterialExample);
    }

    private List<ProductApplicableScene> getProductApplicableScenes(Integer productId) {
        ProductApplicableSceneExample example = new ProductApplicableSceneExample();
        example.or().andProductIdEqualTo(productId).andIsDeletedEqualTo(false);
        return productApplicableSceneMapper.selectByExample(example);
    }

    private ProductDetailInfo getProductDetailInfo(Integer productId) {
        Product product = getProductById(productId);

        ProductDetailInfo productInfo = new ProductDetailInfo();
        productInfo.setupBaseInfo(product);

        List<ProductDesigner> productDesigners = designerService.getProductDesigners(productId);
        productInfo.setupDesigners(productDesigners);

        List<ProductMaterial> productMaterials = getProductMaterials(productId);
        productInfo.setupMaterials(productMaterials);

        List<ProductApplicableScene> productApplicableScenes = getProductApplicableScenes(productId);
        productInfo.setupApplicableScenes(productApplicableScenes);

        return productInfo;
    }

    private Map<Integer, ProductPrice> getProductPriceMap(List<Integer> productIds) {
        ProductListPriceResponse priceList = priceService.batchGetProductPrice(productIds);
        if (priceList == null) {
            return Collections.emptyMap();
        }
        return priceList.getMap();
    }

    private List<ProductDetailSerial> getProductDetailSerials(Integer productId) {
        List<Product> subProducts = productSerialService.getProductSerialsDetail(productId);
        if (subProducts == null || subProducts.isEmpty()) {
            return Collections.emptyList();
        }

        List<ProductDetailSerial> productDetailSerials = ListUtil.transform(subProducts, ProductDetailSerial::createFromProduct);

        List<Integer> subProductIds = ListUtil.transform(subProducts, Product::getId);
        Map<Integer, ProductPrice> priceMap = getProductPriceMap(subProductIds);
        productDetailSerials.forEach(serial -> serial.setupPriceFromPriceMap(priceMap));

        return productDetailSerials;
    }

    private List<ProductDetailImage> getProductDetailImages(Integer productId) {
        List<ProductImage> productImages = getProductImages(productId);
        return ListUtil.transform(productImages, ProductDetailImage::createFromProductImage);
    }

    @Override
    public ProductDetailResponse getProductDetail(Integer productId) {
        ProductDetailResponse response = new ProductDetailResponse();
        response.setProductId(productId);

        response.setInfo(getProductDetailInfo(productId));
        response.setSerials(getProductDetailSerials(productId));
        response.setImages(getProductDetailImages(productId));

        return response;
    }

    private String buildProductSizeText(Short length, Short width, Short height) {
        if (length == null || width == null || height == null) {
            return null;
        }
        return buildProductSizeText(length, width, height);
    }

    private String buildProductSizeText(short length, short width, short height) {
        return "L"+length + "xW" + width + "xH" + height + "cm";
    }

    private Product createProductFromProductInfo(Integer productId, ProductDetailInfo info) {
        Product product = new Product();
        product.setId(productId);
        product.setProductName(info.getProductName());
        product.setProductModel(info.getProductModel());
        product.setSellingPoint(info.getSellingPoint());
        product.setBrandId(info.getBrandId());
        product.setOriginCountryId(info.getOriginCountryId());
        product.setOriginProvinceId(info.getOriginProvinceId());
        product.setOriginCity(info.getOriginCity());
        if (product.getOriginCountryId() != 0) {
            if (product.getOriginCity() == null) {
                product.setOriginCity("");
            }
            if (product.getOriginProvinceId() == null) {
                product.setOriginProvinceId(0);
            }
        }
        product.setStyleId(info.getStyleId());
        product.setLength(info.getLength());
        product.setWidth(info.getWidth());
        product.setHeight(info.getHeight());
        product.setSizeText(buildProductSizeText(product.getLength(), product.getWidth(), product.getHeight()));
        product.setApplicablePeople(info.getApplicablePeople());
        product.setCanCustomized(info.getCanCustomized());
        product.setDetailDescription(info.getDetailDescription());
        return product;
    }

    private class ProductApplicableSceneList {
        List<ProductApplicableScene> applicableSceneList;
        String applicableSceneText;
    }

    private ProductApplicableSceneList buildProductApplicableSceneList(Integer productId, List<String> applicableSceneTexts) {
        if (CollectionUtil.isEmpty(applicableSceneTexts)) {
            return null;
        }
        //创建产品适用场景绑定
        StringBuilder applicableSceneTextBuilder = new StringBuilder();
        List<ProductApplicableScene> productApplicableSceneList = new ArrayList<>();
        long i = 0;
        for (String text : applicableSceneTexts) {
            ProductApplicableScene productApplicableScene = new ProductApplicableScene();

            productApplicableScene.setProductId(productId);
            productApplicableScene.setApplicableSceneId(text);
            productApplicableSceneList.add(productApplicableScene);
            if (i != 0) {
                applicableSceneTextBuilder.append(",");
            }
            ++i;
            applicableSceneTextBuilder.append(DictionaryUtil.getDictionary(BizConstant.DICTIONARY_GROUP_APPLICABLE_SCENE,text).getKeyValue());
        }
        ProductApplicableSceneList productApplicableSceneInfo = new ProductApplicableSceneList();
        productApplicableSceneInfo.applicableSceneList = productApplicableSceneList;
        productApplicableSceneInfo.applicableSceneText = applicableSceneTextBuilder.toString();
        return productApplicableSceneInfo;
    }

    private class ProductMaterialList {
        List<ProductMaterial> productMaterialList;
        String productMaterialText;
    }

    private ProductMaterialList buildProductMaterialList(Integer productId, List<Integer> materialIds) {
        if (CollectionUtil.isEmpty(materialIds)) {
            return null;
        }
        //创建产品材质绑定
        StringBuilder materialTextBuilder = new StringBuilder();
        List<ProductMaterial> materialList = new ArrayList<ProductMaterial>();
        long i = 0;
        for (Integer materialId : materialIds) {
            ProductMaterial productMaterial = new ProductMaterial();
            productMaterial.setProductId(productId);
            productMaterial.setMaterialId(materialId);
            materialList.add(productMaterial);
            if (i != 0) {
                materialTextBuilder.append(",");
            }
            ++i;
            materialTextBuilder.append(MaterialDataUtil.getMaterialById(materialId));
        }
        ProductMaterialList productMaterialList = new ProductMaterialList();
        productMaterialList.productMaterialList = materialList;
        productMaterialList.productMaterialText = materialTextBuilder.toString();
        return productMaterialList;
    }

    private List<ProductDesigner> buildProductDesignerList(Integer productId, List<DesignerVo> designerVoList) {
        if (CollectionUtil.isEmpty(designerVoList)) {
            return null;
        }
        List<ProductDesigner> productDesignerList = new ArrayList<>();
        for (DesignerVo designerVo : designerVoList) {
            ProductDesigner productDesigner = new ProductDesigner();
            int designerId = designerVo.getDesignerId();
            boolean isPrimary = designerVo.isPrimary();
            productDesigner.setDesignerId(designerId);
            productDesigner.setIsPrimary(isPrimary);
            productDesigner.setProductId(productId);
            productDesignerList.add(productDesigner);
        }
        return productDesignerList;
    }

    private static ProductMaterial createDeletedProductMaterialRecord() {
        ProductMaterial productMaterial = new ProductMaterial();
        productMaterial.setIsDeleted(true);
        return productMaterial;
    }

    private static ProductMaterial deletedProductMaterialRecord = createDeletedProductMaterialRecord();

    private int markProductMaterialsDeleted(Integer productId) {
        ProductMaterialExample example = new ProductMaterialExample();
        example.or().andProductIdEqualTo(productId);
        return productMaterialMapper.updateByExampleSelective(deletedProductMaterialRecord, example);
    }

    private int replaceProductMaterials(Integer productId, List<ProductMaterial> productMaterials) {
        markProductMaterialsDeleted(productId);
        return productMaterialMapper.addByBatch(productMaterials);
    }

    /**
     * 更新产品的描述信息
     * @param productUpdateRequest
     * @return
     */
    @Override
    public CommonResponse updateProductInfo(ProductUpdateRequest productUpdateRequest) {
        CommonResponse commonResponse = new CommonResponse();

        Integer productId = productUpdateRequest.getProductId();

        ProductDetailInfo productInfo = productUpdateRequest.getInfo();
        Product product = createProductFromProductInfo(productId, productInfo);

        List<ProductDesigner> productDesigners = buildProductDesignerList(productId, productInfo.getDesignerVoList());
        ProductMaterialList productMaterialList = buildProductMaterialList(productId, productInfo.getMaterialList());
        ProductApplicableSceneList productApplicableSceneList = buildProductApplicableSceneList(productId, productInfo.getApplicableSceneList());

        if (productDesigners != null) {
            designerService.replaceProductDesigners(productId, productDesigners);
        }

        if (productMaterialList != null) {
            product.setMaterialText(productMaterialList.productMaterialText);
            replaceProductMaterials(productId, productMaterialList.productMaterialList);
        }

        if (productApplicableSceneList != null) {
            product.setApplicableSceneText(productApplicableSceneList.applicableSceneText);
            applicableSceneService.replaceProductApplicableScene(productId, productApplicableSceneList.applicableSceneList);
        }

        updateProduct(product);

        return commonResponse;
    }

    /**
     * 更新子产品信息
     * @param productUpdateRequest
     * @return
     */
    @Override
    public CommonResponse updateProductSerials(ProductUpdateRequest productUpdateRequest) {
        CommonResponse commonResponse = new CommonResponse();

        return commonResponse;
    }

    /**
     * 更新产品的图文信息
     * @param productUpdateRequest
     * @return
     */
    @Override
    public CommonResponse updateProductImages(ProductUpdateRequest productUpdateRequest) {
        CommonResponse commonResponse = new CommonResponse();

        return commonResponse;
    }

    private List<Integer> getSubProductIds(Integer productId) {
        List<ProductSerial> productSerialList = productSerialService.getProductSerials(productId);
        return ListUtil.transform(productSerialList, ProductSerial::getSubProductId);
    }

    /**
     * 删除产品
     * @param productId
     */
    @Override
    public CommonResponse deleteProduct(Integer productId) {
        CommonResponse commonResponse = new CommonResponse();

        markProductMaterialsDeleted(productId);
        designerService.markProductDesignersDeleted(productId);
        applicableSceneService.markProductApplicableScenesDeleted(productId);

        List<Integer> allProductIds = getSubProductIds(productId);
        allProductIds.add(productId);
        priceService.markProductPricesDeleted(allProductIds);
        productSerialService.deleteProductSerial(productId);

        return commonResponse;
    }

    /**
     * 创建产品(注意要调用生码接口)
     *
     * @param productCreateRequest
     */
    public CommonResponse createProductInfo(ProductCreateRequest productCreateRequest) {

        CommonResponse commonResponse = new CommonResponse();

        Product product = new Product();

        //售价最小的子品,用于设置系列品价格
        ProductPrice subProductMinPrice = new ProductPrice();
        subProductMinPrice.setCostPrice(BigDecimal.ZERO);
        BigDecimal minPrice = null;

        String applicablePeople = productCreateRequest.getApplicablePeople();
        int brandId = productCreateRequest.getBrandId();
        int categoryId = productCreateRequest.getCategoryId();
        String detailDescription = productCreateRequest.getDetailDescription();
        short length = productCreateRequest.getLength();
        short width = productCreateRequest.getWidth();
        short height = productCreateRequest.getHeight();
        String originCity = productCreateRequest.getOriginCity();
        int originCountryId = productCreateRequest.getOriginCountryId();
        int originProvinceId=productCreateRequest.getOriginProvinceId();
        String productModel = productCreateRequest.getProductModel();
        String productName = productCreateRequest.getProductName();
        String sellingPoint = productCreateRequest.getSellingPoint();
        byte styleId = productCreateRequest.getStyleId();

        product.setApplicablePeople(applicablePeople);
        product.setBrandId(brandId);
        product.setCategoryId(categoryId);
        product.setDetailDescription(detailDescription);
        product.setLength(length);
        product.setWidth(width);
        product.setHeight(height);
        product.setSizeText(buildProductSizeText(length, width, height));
        product.setOriginCity(originCity);
        product.setOriginProvinceId(originProvinceId);
        product.setOriginCountryId(originCountryId);
        product.setProductModel(productModel==null?"":productModel);
        product.setProductName(productName);
        product.setSellingPoint(sellingPoint);
        product.setStyleId(styleId);
        product.setProductStatus(ProductStatusEnum.ORDER_STATUS_SHELVE.getKey().byteValue());

        List<String> applicableSceneTexts = productCreateRequest.getApplicableSceneList();
        List<ColorSpecVo> colorSpecVoList = productCreateRequest.getColorSpecVoList();
        List<ProductImgVo> productImgVoList = productCreateRequest.getProductImgVoList();
        List<DesignerVo> designerVoList = productCreateRequest.getDesignerVoList();
        List<Integer> materialIds = productCreateRequest.getMaterialList();

        //统统存成系列品
        if(CollectionUtil.isEmpty(colorSpecVoList)) {
            ErrorResponseUtil.setErrorResponse(commonResponse, "40201");
            return commonResponse;
        }

        //新建一个系列品主品
        product.setProductType(BizConstant.PRODUCT_TYPE_SERIAL);

        createProduct(product);
        int productId = product.getId();
        Product parentProduct = new Product();
        parentProduct.setId(productId);

        //创建产品设计师绑定
        if (CollectionUtil.isNotEmpty(designerVoList)) {
            List<ProductDesigner> productDesignerList = buildProductDesignerList(productId, designerVoList);
            designerService.addProductDesignersByBatch(productDesignerList);
        }

        //创建产品材质绑定
        ProductMaterialList materialList = buildProductMaterialList(productId, materialIds);
        createProductMaterial(materialList.productMaterialList);
        parentProduct.setMaterialText(materialList.productMaterialText);

        //创建产品适用场景绑定
        ProductApplicableSceneList productApplicableSceneList = buildProductApplicableSceneList(productId, applicableSceneTexts);
        applicableSceneService.createProductApplicableScene(productApplicableSceneList.applicableSceneList);
        parentProduct.setApplicableSceneText(productApplicableSceneList.applicableSceneText);

        //TODO: 将适用场景和材质进行逗号分隔,插入

        updateProduct(parentProduct);

        //创建产品图片
        List<ProductImage> productImageList = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(productImgVoList)) {
            for(ProductImgVo productImgVo : productImgVoList) {
                ProductImage productImage = new ProductImage();
                productImage.setIsPrimary(productImgVo.isPrimary());
                productImage.setProductId(productId);
                productImage.setImgDesc(productImgVo.getImgDesc());
                productImage.setImgUrl(productImgVo.getImgUrl());
                productImage.setSortOrder(productImgVo.getSortOrder());
                productImageList.add(productImage);
            }
        }
        addProductImages(productImageList);

        //创建系列品子品
        for(ColorSpecVo colorSpecVo:colorSpecVoList) {
            List<SpecVo> specVoList = colorSpecVo.getSpecVoList();
            if (CollectionUtil.isNotEmpty(specVoList)) {
                for (SpecVo specVo:specVoList) {
                    Product subProduct = new Product();
                    BeanUtil.copyProperties(product,subProduct,"id");
                    subProduct.setProductType(BizConstant.PRODUCT_TYPE_SERIAL_SUB);//系列品子品
                    subProduct.setWeight(specVo.getWeight());
                    subProduct.setSpecName(specVo.getSpecName());
                    subProduct.setColorId(colorSpecVo.getColorId());
                    subProduct.setColorDisplayName(colorSpecVo.getColorDisplayName());
                    subProduct.setProductColorImg(colorSpecVo.getProductColorImg());
                    subProduct.setProductCode(generateProductCode());
                    createProduct(subProduct);
                    int subProductId = subProduct.getId();

                    ProductSerial productSerial = new ProductSerial();
                    productSerial.setProductId(productId);
                    productSerial.setSubProductId(subProductId);
                    List<ProductSerial> list = new ArrayList<>();
                    list.add(productSerial);
                    productSerialService.createProductSerial(list);

                    //创建子品价格
                    ProductPrice productPrice = new ProductPrice();
                    productPrice.setProductId(subProductId);
                    productPrice.setSellPrice(specVo.getSellPrice());
//                    productPrice.setCostPrice(specVo.getCostPrice());
                    productPrice.setCostPrice(BigDecimal.ZERO);
                    priceService.createProductPrice(productPrice);

                    //计算最小价格
                    if (minPrice == null || minPrice.compareTo(specVo.getSellPrice()) > 0) {
                        minPrice = specVo.getSellPrice();
                        subProductMinPrice.setSellPrice(specVo.getSellPrice());
//                        subProductMinPrice.setCostPrice(specVo.getCostPrice());
                        subProductMinPrice.setCostPrice(BigDecimal.ZERO);
                        subProductMinPrice.setProductId(productId);
                    }
                }
            }
        }

        //创建系列品的价格
        logger.info("start to create product serial price:" + minPrice);
        if (subProductMinPrice != null && subProductMinPrice.getSellPrice().compareTo(BigDecimal.ZERO) > 0) {
            priceService.createProductPrice(subProductMinPrice);
        }

        return commonResponse;
    }

    /**
     * 生成产品编码
     * @return
     */
    private String generateProductCode() {
        //TODO: 要求是数字,且不重复
        return CodeGenerator.createProductCode();
        //return RandomGenerator.createRandom(true, 8);
    }


    /**
     * 根据ID查询产品
     *
     * @param productId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Product getProductById(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    /**
     * 批量查询产品
     * @param productIds
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Product> getProductById(List<Integer> productIds)
    {
        ProductExample productExample=new ProductExample();
        productExample.or().andIdIn(productIds).andIsDeletedEqualTo(false);
        return productMapper.selectByExample(productExample);
    }

    /**
     * 查看品牌产品
     * @param brandId
     * @return
     */
    @Override
    public List<Product> getProductByBrandId(int brandId) {
        ProductExample productExample=new ProductExample();
        //只查询系列品
        productExample.or().andBrandIdEqualTo(brandId)
                .andProductTypeEqualTo(BizConstant.PRODUCT_TYPE_SERIAL)
                .andIsDeletedEqualTo(false);
        return productMapper.selectByExample(productExample);
    }

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * 添加产品图片
     *
     * @param productImage
     * @return
     */
    public int addProductImage(ProductImage productImage) {
        return productImageMapper.insertSelective(productImage);
    }

    /**
     * 批量添加产品图片
     *
     * @param productImages
     * @return
     */
    public int addProductImages(List<ProductImage> productImages) {
        /*if (CollectionUtil.isNotEmpty(productImages)) {
            for (ProductImage productImage : productImages) {
                addProductImage(productImage);
            }
        }*/
        if (CollectionUtil.isNotEmpty(productImages))
            productImageMapper.addByBatch(productImages);
        return 0;
    }

    /**
     * 查找产品图片
     *
     * @param productId
     * @return
     */
    @Override
    public List<ProductImage> getProductImages(int productId) {
        ProductImageExample productImageExample = new ProductImageExample();
        productImageExample.setOrderByClause("is_primary desc, sort_order asc");
        ProductImageExample.Criteria criteria = productImageExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productImageMapper.selectByExample(productImageExample);
    }

    public int updateProductImage(ProductImage productImage) {
        return productImageMapper.updateByPrimaryKeySelective(productImage);
    }

    /**
     * 删除产品图片
     *
     * @param productImages
     * @return
     */
    public int deleteProductImages(List<ProductImage> productImages) {
        if(!productImages.isEmpty()) {
            for(ProductImage productImage:productImages)
            {
                productImage.setIsDeleted(true);
                updateProductImage(productImage);
            }

        }
        return 0;
    }

    /**
     * 查询产品的属性:根据product找category,根据category找category_attributes
     *
     * @param product
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Attribute> getAttributesInProduct(Product product){
        if(product==null)
            return null;
        CategoryResponse categoryResponse= categoryService.getCategoryById(product.getCategoryId());
        Category category = categoryResponse.getCategory();
        if(category!=null)
            return attributeService.getAttributesInCategory(category.getId());

        return null;
    }

    /**
     * 批量设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int createProductAttribute(List<ProductAttribute> productAttributes) {
        if(!productAttributes.isEmpty()) {
            for(ProductAttribute productAttribute:productAttributes)
            {
                productAttributeMapper.insertSelective(productAttribute);
            }
        }
        return 0;
    }

    /**
     * 批量更新产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int updateProductAttribute(List<ProductAttribute> productAttributes) {
        if(!productAttributes.isEmpty()) {
            for(ProductAttribute productAttribute:productAttributes)
            {
                productAttributeMapper.updateByPrimaryKeySelective(productAttribute);
            }
        }
        return 0;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Material> getMaterialInProduct(Integer productId) {
        List<ProductMaterial> productMaterials=getProductMaterials(productId);
        if(!productMaterials.isEmpty())
        {
            List<Integer> materialIds=new ArrayList<>();
            for(ProductMaterial productMaterial:productMaterials)
            {
                materialIds.add(productMaterial.getMaterialId());
            }
            return getMaterialById(new ArrayList<>(materialIds));
        }

        return null;
    }

    private  List<Material> getMaterialById(List<Integer> ids)
    {
        MaterialExample example=new MaterialExample();
        example.or().andIdIn(ids).andIsDeletedEqualTo(false);
        return materialMapper.selectByExample(example);
    }
    @Override
    public int createProductMaterial(List<ProductMaterial> productMaterials) {
        /*if(!productMaterials.isEmpty())
            for(ProductMaterial productMaterial:productMaterials)
            {
                productMaterialMapper.insertSelective(productMaterial);
            }*/
        if(!productMaterials.isEmpty())
            productMaterialMapper.addByBatch(productMaterials);
        return 0;
    }

    @Override
    public int updateProductMaterial(List<ProductMaterial> productMaterials) {
        if(!productMaterials.isEmpty())
            for(ProductMaterial productMaterial:productMaterials)
            {
                productMaterialMapper.updateByPrimaryKeySelective(productMaterial);
            }
        return 0;
    }

    /**
     * 根据分类查询产品
     *
     * @param page   1:上架时间 2:销量 3:价格
     * @return
     */
    @Override
    public ProductVoResponse getProductByCategoryIdListPage(PageModel page) {
        //TODO:
        //1. 根据category查询该类目下所有三级类目
        //2. 查询属于该类目三级类目的所有产品,按排序规则排序
        //3. 分页待定:插件、注解
    	
    	ProductVoResponse productVoResponse = new ProductVoResponse();
    	
    	ProductQueryVo pqv = (ProductQueryVo)page.getModel();
        CategoryListResponse categoryListResponse = categoryService.getLastLevelCategoryByCategory(pqv.getCategoryId());
        List<Category> categoryList = categoryListResponse.getCategoryList();

        List<Integer> categoryIdList = new ArrayList<>();
        if (categoryList == null) {
            categoryListResponse.setResCode("40404");
            ErrorResponseUtil.setErrorResponse(productVoResponse,"40404");
            return productVoResponse;
        }
        for (Category category: categoryList) {
            categoryIdList.add(category.getId());
        }

        logger.info("categoryIdList:" + categoryIdList);

    	pqv.setCategoryIdList(categoryIdList);
    	page.setModel(pqv);

        List<PageData> dataList = null;
        
    	if(pqv.getSortBy() == 1 || pqv.getSortBy() == null)
    		dataList = productMapper.selectProductByCategoryOrderByOnShelfTimeListPage(page);
    	if(pqv.getSortBy() == 2)
    		dataList = productMapper.selectProductByCategoryOrderBySoldQtyListPage(page);
    	if(pqv.getSortBy() == 3)
    		dataList = productMapper.selectProductByCategoryOrderBySellPriceListPage(page);

    	List<ProductVo> productList = Arrays.asList(JsonUtil.fromJSON(dataList, ProductVo[].class));

    	if(productList.size()>0){
    		List<Integer> productIds = new ArrayList<Integer>();
            for(ProductVo productVo:productList){
            	productIds.add(productVo.getProductId());
            }
            
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);

        	List<ProductVo> list = new ArrayList<ProductVo>();
        	for(ProductVo productVo : productList){
            	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productVo.getProductId()) != null){
            		productVo.setProductImg(productImageMap.get(productVo.getProductId()).getImgUrl());
            	}
            	if(MapUtil.isNotEmpty(priceMap) && priceMap.get(productVo.getProductId()) != null){
            		productVo.setSellPrice(priceMap.get(productVo.getProductId()).getSellPrice());
            	}
            	list.add(productVo);
        	}
        	productVoResponse.setProductVoList(list);
    	}
        return productVoResponse;
    }

    /**
     * 获取产品(包括单品和系列品)详情页信息
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductResponse getItemDetailById(int productId) {
        ProductResponse productResponse = new ProductResponse();

        Product product = getProductById(productId);
        if (product != null) {

            //产品基本信息
            productResponse.setProductName(product.getProductName());
            productResponse.setTips(product.getTips());
            productResponse.setDetailDescription(product.getDetailDescription());
            productResponse.setVerboseInfo(product.getVerboseInfo());
            productResponse.setWeight(product.getWeight());
            productResponse.setSellingPoint(product.getSellingPoint());
            productResponse.setBrandId(product.getBrandId());

            //产品参数
            ProductParameter productParameter = new ProductParameter();
            productParameter.setApplicableSceneText(product.getApplicableSceneText());
//            String origin = DictionaryUtil.getDictionary(BizConstant.DICTIONARY_GROUP_COUNTRY,product.getOriginCountryId()).getKeyValue();
            String origin = CountryUtil.getCountryById(product.getOriginCountryId());
            //因为城市数据无法拿到,只显示国家
//            String city = product.getOriginCity();
//            if (StringUtil.isNotEmpty(city)) {
//                origin = origin + "," + city;
//            }
            productParameter.setOrigin(origin);
            productParameter.setMaterialText(product.getMaterialText());
            productParameter.setNeedAssemble(product.getNeedAssemble());

            productParameter.setStyle(DictionaryUtil.getDictionary(BizConstant.DICTIONARY_GROUP_STYLE,String.valueOf(product.getStyleId())).getKeyValue());
            productParameter.setApplicablePeople(DictionaryUtil.getDictionary(BizConstant.DICTIONARY_GROUP_APPLICABLE_PEOPLE,product.getApplicablePeople()).getKeyValue());
            productResponse.setProductParameter(productParameter);
        } else {
            ErrorResponseUtil.setErrorResponse(productResponse,"40202");
        }
        return productResponse;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductImgResponse getProductNonPrimaryImages(int productId) {
        ProductImgResponse productImgResponse = new ProductImgResponse();
        List<ProductImgVo> productImgVoList = new ArrayList<>();
        ProductImageExample productImageExample = new ProductImageExample();
        productImageExample.setOrderByClause("sort_order asc");
        ProductImageExample.Criteria criteria = productImageExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsPrimaryEqualTo(false);
        criteria.andIsDeletedEqualTo(false);
        List<ProductImage> productImageList = productImageMapper.selectByExample(productImageExample);
        for (ProductImage productImage : productImageList) {
            ProductImgVo productImgVo = new ProductImgVo();
            productImgVo.setImgDesc(productImage.getImgDesc());
            productImgVo.setImgUrl(productImage.getImgUrl());
            productImgVo.setSortOrder(productImage.getSortOrder());
            productImgVo.setPrimary(false);
            productImgVoList.add(productImgVo);
        }
        productImgResponse.setProductImgVoList(productImgVoList);
        return productImgResponse;
    }
    
    /**
     * 查询产品主图
     * @param productId
     * @return
     */
    public ProductImage selectProductPrimaryOneImg(Integer productId){
    	return productImageMapper.selectProductPrimaryOneImg(productId);
    }
    
    /**
     * 查询产品主图
     * @param productIds
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Map<Integer, ProductImage> selectProductListPrimaryOneImg(List<Integer> productIds){
    	List<ProductImage> productImageList = productImageMapper.selectProductListPrimaryOneImg(productIds);
    	Map<Integer, ProductImage> map = new HashMap<Integer, ProductImage>();
        for (ProductImage productImage:productImageList) {
            int productId = productImage.getProductId();
            map.put(productId, productImage);
        }
    	return map;
    }
    
    /**
     * 查询品牌的产品信息
     * @param brandId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductVoResponse selectProductByBrandId(Integer brandId){
    	ProductVoResponse productVoResponse = new ProductVoResponse();
    	
    	if (brandId == null) {
    		productVoResponse.setResCode("40204");
    		productVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return productVoResponse;
        }
    	
    	List<ProductVo> productVoList = productMapper.selectProductByBrandId(brandId);
        
    	if(productVoList.size()>0){
    		List<Integer> productIds = new ArrayList<Integer>();
            for(ProductVo productVo:productVoList){
            	productIds.add(productVo.getProductId());
            }
            
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);
            
            List<ProductVo> returnProductVoList = new ArrayList<ProductVo>();
            for(ProductVo productVo:productVoList){
            	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productVo.getProductId()) != null){
            		productVo.setProductImg(productImageMap.get(productVo.getProductId()).getImgUrl());
            	}
            	if(MapUtil.isNotEmpty(priceMap) && priceMap.get(productVo.getProductId()) != null){
            		productVo.setSellPrice(priceMap.get(productVo.getProductId()).getSellPrice());
            	}
            	returnProductVoList.add(productVo);
            }
        	
        	productVoResponse.setProductVoList(returnProductVoList);
    	}        
    	return productVoResponse;
    }
    
    /**
     * 查询设计师的产品信息
     * @param designerId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductVoResponse selectProductByDesignerId(Integer designerId){
        //先根据designerId拿到productId(注意是系列品)列表
        //再根据上一步列表取查询价格
    	ProductVoResponse productVoResponse = new ProductVoResponse();
    	
    	if (designerId == null) {
    		productVoResponse.setResCode("40205");
    		productVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return productVoResponse;
        }
    	
    	List<ProductVo> productVoList = productMapper.selectProductByDesignerId(designerId);
    	if(productVoList.size()>0){
    		List<Integer> productIds = new ArrayList<Integer>();
            for(ProductVo productVo:productVoList){
            	productIds.add(productVo.getProductId());
            }
            
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);
            
            List<ProductVo> returnProductVoList = new ArrayList<ProductVo>();
            for(ProductVo productVo:productVoList){
            	if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productVo.getProductId()) != null){
            		productVo.setProductImg(productImageMap.get(productVo.getProductId()).getImgUrl());
            	}
            	if(MapUtil.isNotEmpty(priceMap) && priceMap.get(productVo.getProductId()) != null){
            		productVo.setSellPrice(priceMap.get(productVo.getProductId()).getSellPrice());
            	}
            	returnProductVoList.add(productVo);
            }
        	
        	productVoResponse.setProductVoList(returnProductVoList);
    	}
    	
        
    	return productVoResponse;
    }

    @Override
    public ProductVoResponse selectProductByBrandIdListPage(ProductListQuery query) {
        ProductVoResponse productVoResponse = new ProductVoResponse();
        if (query.getBrandId() == null) {
            productVoResponse.setResCode("40204");
            productVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return productVoResponse;
        }
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
            //仅在第一页时获取相应的分页记录
            if (query.getCurrentPage() == 1) {
                model.setIsPage(true);
            }
        }
        model.setModel(query);
        List<PageData> pageDataList = productMapper.selectProductByBrandIdListPage(model);
        if(pageDataList.size()>0){
            List<ProductVo> productVoList = Arrays.asList(JsonUtil.fromJSON(pageDataList, ProductVo[].class));
            List<Integer> productIds = new ArrayList<Integer>();
            for(ProductVo productVo:productVoList){
                productIds.add(productVo.getProductId());
            }
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);
            List<ProductVo> returnProductVoList = new ArrayList<ProductVo>();
            for(ProductVo productVo:productVoList){
                if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productVo.getProductId()) != null){
                    productVo.setProductImg(productImageMap.get(productVo.getProductId()).getImgUrl());
                }
                if(MapUtil.isNotEmpty(priceMap) && priceMap.get(productVo.getProductId()) != null){
                    productVo.setSellPrice(priceMap.get(productVo.getProductId()).getSellPrice());
                }
                returnProductVoList.add(productVo);
            }
            productVoResponse.setProductVoList(returnProductVoList);
            productVoResponse.setCurrentPage(query.getCurrentPage());
            productVoResponse.setPageSize(query.getPageSize());
            productVoResponse.setTotalPage(model.getTotalPage());
            productVoResponse.setTotalResult(model.getTotalResult());
        }
        return productVoResponse;
    }

    @Override
    public ProductVoResponse selectProductByDesignerIdListPage(ProductListQuery query) {
        ProductVoResponse productVoResponse = new ProductVoResponse();
        if (query.getDesignerId() == null) {
            productVoResponse.setResCode("40205");
            productVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return productVoResponse;
        }
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
            //仅在第一页时获取相应的分页记录
            if (query.getCurrentPage() == 1) {
                model.setIsPage(true);
            }
        }
        model.setModel(query);
        List<PageData> pageDataList = productMapper.selectProductByDesignerIdListPage(model);
        if(pageDataList.size()>0){
            List<ProductVo> productVoList = Arrays.asList(JsonUtil.fromJSON(pageDataList, ProductVo[].class));
            List<Integer> productIds = new ArrayList<Integer>();
            for(ProductVo productVo:productVoList){
                productIds.add(productVo.getProductId());
            }
            //批量查询价格
            ProductListPriceResponse batchGetProductPrice = priceService.batchGetProductPrice(productIds);
            Map<Integer, ProductPrice> priceMap = new HashMap<Integer, ProductPrice>();
            if (batchGetProductPrice != null && MapUtil.isNotEmpty(batchGetProductPrice.getMap())) {
                priceMap = batchGetProductPrice.getMap();
            }
            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);
            List<ProductVo> returnProductVoList = new ArrayList<ProductVo>();
            for(ProductVo productVo:productVoList){
                if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productVo.getProductId()) != null){
                    productVo.setProductImg(productImageMap.get(productVo.getProductId()).getImgUrl());
                }
                if(MapUtil.isNotEmpty(priceMap) && priceMap.get(productVo.getProductId()) != null){
                    productVo.setSellPrice(priceMap.get(productVo.getProductId()).getSellPrice());
                }
                returnProductVoList.add(productVo);
            }
            productVoResponse.setProductVoList(returnProductVoList);
            productVoResponse.setCurrentPage(query.getCurrentPage());
            productVoResponse.setPageSize(query.getPageSize());
            productVoResponse.setTotalPage(model.getTotalPage());
            productVoResponse.setTotalResult(model.getTotalResult());
        }
        return productVoResponse;
    }
    
    /**
     * 分页查询产品列表
     * @param pageModel
     * @return
     */
    public ProductPageResponse getProductListPage(PageModel pageModel){
    	ProductPageResponse productPageResponse = new ProductPageResponse();
    	//初始化产品分类查询条件
    	ProductPageRequest ppqv = (ProductPageRequest)pageModel.getModel();
    	if(ppqv.getCategoryId()!=null){
    		CategoryListResponse categoryListResponse = categoryService.getLastLevelCategoryByCategory(ppqv.getCategoryId());
            List<Category> categoryList = categoryListResponse.getCategoryList();

            List<Integer> categoryIds = new ArrayList<>();
            if (categoryList == null) {
                categoryListResponse.setResCode("40404");
                ErrorResponseUtil.setErrorResponse(productPageResponse,"40404");
                return productPageResponse;
            }
            for (Category category: categoryList) {
                categoryIds.add(category.getId());
            }

        	ppqv.setCategoryIds(categoryIds);
        	pageModel.setModel(ppqv);
    	}
    	
    	//查询符合条件的产品ids
    	List<PageData> pageDataList = productMapper.selectProductListPage(pageModel);
    	if(pageDataList.size()>0){
            List<ProductPageVo> productVoList = Arrays.asList(JsonUtil.fromJSON(pageDataList, ProductPageVo[].class));
            List<Integer> productIds = new ArrayList<Integer>();
            for(ProductPageVo productPageVo:productVoList){
                productIds.add(productPageVo.getProductId());
            }
            // 批量查产品信息
            List<ProductListVo> productList = productMapper.selectProductByProductIds(productIds);
            
            List<Integer> subProductIds = new ArrayList<Integer>();
            for(ProductListVo product : productList){
            	subProductIds.add(product.getSubProductId());
            }

            //批量查询主图
            Map<Integer, ProductImage> productImageMap = this.selectProductListPrimaryOneImg(productIds);
            for(ProductPageVo productPageVo:productVoList){
                if(MapUtil.isNotEmpty(productImageMap) && productImageMap.get(productPageVo.getProductId()) != null){
                    productPageVo.setProductImg(productImageMap.get(productPageVo.getProductId()).getImgUrl());
                }
            }
            
            //批量查库存
        	Map<Integer, Integer> availableStockMap = new HashMap<Integer, Integer>();
            if(subProductIds.size()>0){
                AvailableStocksResponse availableStocksResponse = stockService.batchGetAvailableStock(subProductIds);
                if (availableStocksResponse != null && CollectionUtil.isNotEmpty(availableStocksResponse.getAvailableStockVoList())) {
                    List<AvailableStockVo> availableStockVoList = availableStocksResponse.getAvailableStockVoList();
                    for (AvailableStockVo availableStockVo : availableStockVoList) {
                        availableStockMap.put(availableStockVo.getProductId(), availableStockVo.getTotalAvailableStockQty());
                    }
                }
            }            

            //循环赋值返回
            List<ProductListPageVo> volist = new ArrayList<ProductListPageVo>();
            for(ProductPageVo productVo:productVoList){
            	ProductListPageVo vo = new ProductListPageVo();
            	List<ProductListVo> plist = new ArrayList<ProductListVo>();
            	vo.setProductPageVo(productVo);
            	if(productList!=null){
            		for(ProductListVo product : productList){
                		if((product.getProductId()).equals(productVo.getProductId())){
                			if(availableStockMap != null){
                				//设置库存数
                    			product.setStockQty(availableStockMap.get(product.getProductId()));
                			}
                			plist.add(product);                			
                		}
                	}
                	vo.setProductListVo(plist);
            	}
            	volist.add(vo);
            }
            productPageResponse.setProductListPageVo(volist);
            productPageResponse.setCurrentPage(pageModel.getCurrentPage());
            productPageResponse.setPageSize(pageModel.getShowCount());
            productPageResponse.setTotalPage(pageModel.getTotalPage());
            productPageResponse.setTotalResult(pageModel.getTotalResult());
    	}
    	
    	return productPageResponse;
    }
    

    @Override
    public ApiResponse queryProductByTopicGroupListPage(ProductListQuery query) {
        ApiResponse resp=new ApiResponse();
        GroupProductResponse groupProductResponse = new GroupProductResponse();
        if (query==null||query.getTopicId() == null) {
            resp.setResCode(ErrorCodeConstant.INVALID_PARAMJSON);
            resp.setResMsg(ErrorCodeUtil.getErrorMsg(ErrorCodeConstant.INVALID_PARAMJSON));
            return resp;
        }
        switch(query.getColumn()){
            case 1:query.setOrderColumn("product_summary.total_sold_qty");break;
            case 2:query.setOrderColumn("product_price.sell_price");break;
            default :query.setOrderColumn("product_short_list_in_topic.sort_order");break;
        }
        switch (query.getType()){
            case 1:query.setOrderType("desc");break;
            default:query.setOrderType("asc");
        }
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
            //仅在第一页时获取相应的分页记录
            if (query.getCurrentPage() == 1) {
                model.setIsPage(true);
            }
        }
        model.setModel(query);
        List<PageData> pageDataList = productMapper.queryProductByTopicGroupListPage(model);
        if(pageDataList.size()>0){
            List<GroupProduct> productList = Arrays.asList(JsonUtil.fromJSON(pageDataList, GroupProduct[].class));
            groupProductResponse.setProductList(productList);
            groupProductResponse.setCurrentPage(query.getCurrentPage());
            groupProductResponse.setPageSize(query.getPageSize());
            groupProductResponse.setTotalPage(model.getTotalPage());
            groupProductResponse.setTotalResult(model.getTotalResult());
        }
        resp.setData(groupProductResponse);
        return resp;
    }

    @Override
    public ProductInTopicResponse getProductInTopic(int topicId) {
        ProductInTopicResponse resp=new ProductInTopicResponse();
        List<ProductVo> productVoList = productMapper.selectProductInTopic(topicId);
        List<Integer> productIdList = new ArrayList<>();
        for (ProductVo product : productVoList) {
            productIdList.add(product.getProductId());
        }
        Map<Integer, ProductImage> productImgMap = selectProductListPrimaryOneImg(productIdList);
        for (ProductVo product : productVoList) {
            if (productImgMap.get(product.getProductId()) != null) {
                product.setProductImg(productImgMap.get(product.getProductId()).getImgUrl());
            }
        }
        resp.setProductList(productVoList);
        return resp;
    }
}
