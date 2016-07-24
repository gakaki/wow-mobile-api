package com.wow.product.service.impl;


import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.response.CategoryResponse;
import com.wow.common.enums.*;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.*;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.product.mapper.*;
import com.wow.product.model.*;
import com.wow.product.service.*;
import com.wow.product.vo.request.*;
import com.wow.product.vo.response.ProductImgResponse;
import com.wow.product.vo.response.ProductParameter;
import com.wow.product.vo.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private ProductAttributeMapper productAttributeMapper;

    @Autowired
    private  ProductMaterialMapper productMaterialMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttributeService attributeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private DesignerService designerService;

    @Autowired
    private ApplicableSceneService applicableSceneService;

    @Autowired
    private ProductSerialService productSerialService;

    @Autowired
    private PriceService priceService;

    /**
     * @param product
     * @return
     */
    @Override
    public int createProduct(Product product) {
        int productId = productMapper.insertSelective(product);
        return productId;
    }

    /**
     * 创建产品(注意要调用生码接口)
     *
     * @param productCreateRequest
     */
    public CommonResponse createProductInfo(ProductCreateRequest productCreateRequest) {

        CommonResponse commonResponse = new CommonResponse();

        Product product = new Product();

        byte applicablePeople = productCreateRequest.getApplicablePeople();
        int brandId = productCreateRequest.getBrandId();
        int categoryId = productCreateRequest.getCategoryId();
        String detailDescription = productCreateRequest.getDetailDescription();
        short length = productCreateRequest.getLength();
        short width = productCreateRequest.getWidth();
        short height = productCreateRequest.getHeight();
        String originCity = productCreateRequest.getOriginCity();
        int originCountryId = productCreateRequest.getOriginCountryId();
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
        product.setSizeText("L"+length + "xW" + width + "xH" + height + "cm");
        product.setOriginCity(originCity);
        product.setOriginCountryId(originCountryId);
        product.setProductModel(productModel);
        product.setProductName(productName);
        product.setSellingPoint(sellingPoint);
        product.setStyleId(styleId);

        List<Integer> applicableSceneIds = productCreateRequest.getApplicableSceneList();
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
        product.setProductType((byte)2);

        createProduct(product);
        int productId = product.getId();
        Product parentProduct = new Product();
        parentProduct.setId(productId);
        //创建产品设计师绑定
        for (DesignerVo designerVo : designerVoList) {
            ProductDesigner productDesigner = new ProductDesigner();
            int designerId = designerVo.getDesignerId();
            boolean isPrimary = designerVo.isPrimary();
            productDesigner.setDesignerId(designerId);
            productDesigner.setIsPrimary(isPrimary);
            productDesigner.setProductId(productId);
            designerService.createProductDesigner(productDesigner);
        }

        //创建产品材质绑定
        String materialText = "";
        List<ProductMaterial> productMaterialList = new ArrayList<ProductMaterial>();
        for (Integer materialId : materialIds) {
            ProductMaterial productMaterial = new ProductMaterial();
            productMaterial.setProductId(productId);
            productMaterial.setMaterialId(materialId);
            productMaterialList.add(productMaterial);
            materialText += MaterialEnum.get(materialId) + ",";
        }
        createProductMaterial(productMaterialList);
        if (StringUtil.isNotEmpty(materialText)) {
            parentProduct.setMaterialText(materialText.substring(0,materialText.length()-1));
        }

        //创建产品适用场景绑定
        String applicableSceneText = "";
        List<ProductApplicableScene> productApplicableSceneList = new ArrayList<>();
        for (Integer applicableSceneId : applicableSceneIds) {
            ProductApplicableScene productApplicableScene = new ProductApplicableScene();

            productApplicableScene.setProductId(productId);
            productApplicableScene.setApplicableSceneId(applicableSceneId);
            productApplicableSceneList.add(productApplicableScene);

            applicableSceneText += ApplicableSceneEnum.get(applicableSceneId) + ",";
        }
        applicableSceneService.createProductApplicableScene(productApplicableSceneList);

        if (StringUtil.isNotEmpty(applicableSceneText)) {
            //TODO: 将适用场景和材质进行逗号分隔,插入
            parentProduct.setApplicableSceneText(applicableSceneText.substring(0,applicableSceneText.length()-1));
        }

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
                    subProduct.setProductType((byte)1);//系列品子品
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
                    productPrice.setCostPrice(specVo.getCostPrice());
                    priceService.createProductPrice(productPrice);
                }
            }
        }

        return commonResponse;
    }

    /**
     * 生成产品编码
     * @return
     */
    private String generateProductCode() {
        //TODO: 要求是数字,且不重复
        return RandomGenerator.createRandom(true, 8);
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
        productExample.or().andBrandIdEqualTo(brandId).andIsDeletedEqualTo(false);
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
        if (CollectionUtil.isNotEmpty(productImages)) {
            for (ProductImage productImage : productImages) {
                addProductImage(productImage);
            }
        }
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

        ProductMaterialExample productMaterialExample=new ProductMaterialExample();
        productMaterialExample.or().andIsDeletedEqualTo(false).andProductIdEqualTo(productId);
        List<ProductMaterial> productMaterials=productMaterialMapper.selectByExample(productMaterialExample);
        if(!productMaterials.isEmpty())
        {
            HashSet<Integer> materialIds=new HashSet<>();
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
        if(!productMaterials.isEmpty())
            for(ProductMaterial productMaterial:productMaterials)
            {
                productMaterialMapper.insertSelective(productMaterial);
            }
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
     * @param category
     * @param sortBy   1:上架时间 2:销量 3:价格
     * @param asc      是否升序
     * @return
     */
    @Override
    public List<Product> getProductByCategoryId(int category, int sortBy, boolean asc) {
        //TODO:
        //1. 根据category查询该类目下所有三级类目
        categoryService.getLastLevelCategoryByCategory(category);
        //2. 查询属于该类目三级类目的所有产品,按排序规则排序
        //3. 分页待定:插件、注解
        return null;
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
            productParameter.setOrigin(CountryEnum.get((int)product.getOriginCountryId()) + "," + product.getOriginCity());
            productParameter.setMaterialText(product.getMaterialText());
            productParameter.setNeedAssemble(product.getNeedAssemble());

            productParameter.setStyle(StyleEnum.get((int)product.getStyleId()));
            productParameter.setApplicablePeople(ApplicablePeopleEnum.get((int)product.getApplicablePeople()));

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
}