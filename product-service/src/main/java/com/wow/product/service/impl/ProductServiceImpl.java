package com.wow.product.service.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.response.CategoryResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.product.mapper.MaterialMapper;
import com.wow.product.mapper.ProductAttributeMapper;
import com.wow.product.mapper.ProductImageMapper;
import com.wow.product.mapper.ProductMapper;
import com.wow.product.mapper.ProductMaterialMapper;
import com.wow.product.model.Material;
import com.wow.product.model.MaterialExample;
import com.wow.product.model.Product;
import com.wow.product.model.ProductAttribute;
import com.wow.product.model.ProductExample;
import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductImageExample;
import com.wow.product.model.ProductMaterial;
import com.wow.product.model.ProductMaterialExample;
import com.wow.product.service.BrandService;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.ProductVo;
import com.wow.product.vo.response.ProductParameter;
import com.wow.product.vo.response.ProductResponse;


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



    /**
     * 创建产品(注意要调用生码接口)
     *
     * @param product
     */
    public int createProduct(Product product) {
        if(product==null)
            return -1;
        String productCode = generateProductCode();
        product.setProductCode(productCode.substring(0,7));
        return productMapper.insertSelective(product);
    }

    /**
     * 生成产品编码
     * @return
     */
    private String generateProductCode() {
        //TODO: 要求是数字,且不重复
        return java.util.UUID.randomUUID().toString();
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
    public List<ProductVo> getProductByCategoryId(int categoryId, int sortBy, boolean asc) {
        //TODO:
        //1. 根据category查询该类目下所有三级类目
        //2. 查询属于该类目三级类目的所有产品,按排序规则排序
        //3. 分页待定:插件、注解
    	String categoryids = categoryService.getLastLevelCategoryByCategory(categoryId);
    	
    	String px = asc==true?"asc":"desc";
    	System.out.println(px);
    	List<ProductVo> productList = new ArrayList<ProductVo>();
    	if(sortBy == 1)
    		productList = productMapper.selectPageByCategoryIdOrderbyShelfTime(categoryids,px);
    	if(sortBy == 2)
    		productList = productMapper.selectPageByCategoryIdOrderbyTotalSold(categoryids,px);
    	if(sortBy == 3)
    		productList = productMapper.selectPageByCategoryIdOrderbySellPrice(categoryids,px);
    	List<ProductVo> list = new ArrayList<ProductVo>();
    	for(ProductVo product : productList){
    		ProductImage pi = productImageMapper.selectProductPrimaryOneImg(product.getProductId());
    		if(pi!=null){
    			product.setProductImg(pi.getImgUrl());
        		list.add(product);
    		}
    	}
        return list;
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
            productParameter.setOrigin(product.getOriginCountry() + "," + product.getOriginCity());
            productParameter.setMaterialText(product.getMaterialText());
            productParameter.setNeedAssemble(product.getNeedAssemble());
            productParameter.setStyle(product.getStyle());

            productResponse.setProductParameter(productParameter);

        }
        return productResponse;
    }
}