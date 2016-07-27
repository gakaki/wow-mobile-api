package com.wow.product.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ImgPrefixUtil;
import com.wow.product.mapper.DesignerMapper;
import com.wow.product.mapper.ProductDesignerMapper;
import com.wow.product.model.Designer;
import com.wow.product.model.DesignerExample;
import com.wow.product.model.Product;
import com.wow.product.model.ProductDesigner;
import com.wow.product.model.ProductDesignerExample;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.response.ProductDesignerResponse;


/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class DesignerServiceImpl implements DesignerService {

    @Autowired
    private DesignerMapper designerMapper;
    @Autowired
    private ProductDesignerMapper productDesignerMapper;
    @Autowired
    private ProductService productService;

    @Override
    public int createDesigner(Designer designer) {
        return designerMapper.insertSelective(designer);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductDesignerResponse getDesignerById(int designerId) {
    	Designer designer = designerMapper.selectByPrimaryKey(designerId);
    	//增加前缀
        designer.setDesignerPhoto(ImgPrefixUtil.addPrefixForImgUrl(designer.getDesignerPhoto()));
    	ProductDesignerResponse productDesignerResponse = new ProductDesignerResponse();
    	productDesignerResponse.setDesigner(designer);
        return productDesignerResponse;
    }

    @Override
    public int updateDesigner(Designer designer) {
        return designerMapper.updateByPrimaryKeySelective(designer);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByCountry(String country) {
        DesignerExample designerExample=new DesignerExample();
        designerExample.or().andIsDeletedEqualTo(false).andDesignerCountryEqualTo(country);
        return designerMapper.selectByExample(designerExample);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignerByIds(List<Integer> designerIds) {
        DesignerExample designerExample=new DesignerExample();
        designerExample.or().andIsDeletedEqualTo(false).andIdIn(designerIds);
        return designerMapper.selectByExample(designerExample);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByStyle(String style) {
        DesignerExample designerExample=new DesignerExample();
        designerExample.or().andIsDeletedEqualTo(false).andDesignerStyleEqualTo(style);
        return designerMapper.selectByExample(designerExample);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Product> getProductsByDesigner(int designerId) {
//        ProductDesignerExample productDesignerExample=new ProductDesignerExample();
//        ProductDesignerExample.Criteria criteria = productDesignerExample.createCriteria();
//        criteria.andIsDeletedEqualTo(false);
//        criteria.andDesignerIdEqualTo(designerId);
//        List<ProductDesigner> productDesigners=productDesignerMapper.selectByExample(productDesignerExample);
//        return getProducts(productDesigners);
        //TODO
        return null;
    }

    private List<Product> getProducts(List<ProductDesigner> productDesigners) {
        List<Product> products=new ArrayList<>();

        if(!productDesigners.isEmpty()) {
            HashSet<Integer> productIds = new HashSet();
            productDesigners.forEach(o->productIds.add(o.getProductId()));
            productService.getProductById(new ArrayList(productIds));
}
        return  products;
    }

    @Override
    public int createProductDesigner(ProductDesigner productDesigner) {
        return productDesignerMapper.insertSelective(productDesigner);
    }

    @Override
    public int createProductDesigners(List<ProductDesigner> productDesigners) {
        if (CollectionUtil.isNotEmpty(productDesigners)) {
            for (ProductDesigner productDesigner : productDesigners) {
                productDesignerMapper.insertSelective(productDesigner);
            }
        }
        return productDesigners.size();
    }

    /**
     * 查询产品的设计师(可以多个)
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByProduct(int productId) {
        //TODO
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Designer getPrimaryDesignerByProduct(int productId) {
        Designer designer = new Designer();
        ProductDesignerExample productDesignerExample = new ProductDesignerExample();
        ProductDesignerExample.Criteria criteria = productDesignerExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsPrimaryEqualTo(true);
        List<ProductDesigner> productDesignerList = productDesignerMapper.selectByExample(productDesignerExample);

        if (CollectionUtil.isNotEmpty(productDesignerList)) {
            ProductDesigner productDesigner = productDesignerList.get(0);
            designer = getDesignerById(productDesigner.getDesignerId()).getDesigner();
        }
        return designer;
    }

    /**
     * 查看品牌设计师列表
     *
     * @param brandId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByBrand(int brandId) throws Exception {
//        List<Product> products=productService.getProductsByBrand(brandId);
//        List<Designer> designers=new ArrayList<>();
//        if(!products.isEmpty())
//            for(Product product:products)
//            {
//                designers.addAll(designerService.getDesignersByProduct(product));
//            }
//        return  designers;
        return null;
    }
    
    /**
     * 查询所有设计师
     *
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductDesignerResponse getAllDesigners() {
    	ProductDesignerResponse productDesignerResponse = new ProductDesignerResponse();
    	productDesignerResponse.setDesignerList(designerMapper.selectAll());
    	return productDesignerResponse;
    }
}
