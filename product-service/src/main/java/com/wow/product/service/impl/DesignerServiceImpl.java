package com.wow.product.service.impl;

import com.wow.product.mapper.DesignerMapper;
import com.wow.product.mapper.ProductDesignerMapper;
import com.wow.product.model.*;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


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

    private  ProductDesignerExample productDesignerExample;
    @Override
    public int createDesigner(Designer designer) {
        return designerMapper.insertSelective(designer);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Designer getDesignerById(int designerId) {
        return designerMapper.selectByPrimaryKey(designerId);
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

    public List<Designer> getDesignerById(List<Integer> designerIds)
    {
        DesignerExample designerExample=new DesignerExample();
        designerExample.or().andIsDeletedEqualTo(false).andIdIn(designerIds);
        return designerMapper.selectByExample(designerExample);
    }

    private List<Designer> getDesignersByName(String designerName) {
        DesignerExample designerExample=new DesignerExample();
        designerExample.or().andIsDeletedEqualTo(false).andDesignerNameEqualTo(designerName);
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
        productDesignerExample=new ProductDesignerExample();
        productDesignerExample.or().andDesignerIdEqualTo(designerId).andIsDeletedEqualTo(false);
        List<ProductDesigner> productDesigners=productDesignerMapper.selectByExample(productDesignerExample);
        return getProducts(productDesigners);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Product> getProductsByDesigner(String designerName) {
        Designer designer= getDesignersByName(designerName).stream().findAny().get();
        if(designer==null)
            return  null;
        productDesignerExample=new ProductDesignerExample();
        productDesignerExample.or().andIsDeletedEqualTo(false).andDesignerIdEqualTo(designer.getId());
        List<ProductDesigner> productDesigners=productDesignerMapper.selectByExample(productDesignerExample);
        return getProducts(productDesigners);
       // return null;
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
        if(!productDesigners.isEmpty())
            productDesigners.forEach(o->productDesignerMapper.insertSelective(o));
        return 0;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByProduct(Product product) {
        if(product!=null) {
            productDesignerExample=new ProductDesignerExample();
            productDesignerExample.or().andIsDeletedEqualTo(false).andProductIdEqualTo( product.getId());
          List<ProductDesigner> productDesigners= productDesignerMapper.selectByExample(productDesignerExample);
            if(!productDesigners.isEmpty())
              return  getDesigners(productDesigners);
        }
        return null;
    }

    private  List<Designer> getDesigners(List<ProductDesigner> productDesigners)
    {
        if(!productDesigners.isEmpty()) {
            HashSet<Integer> set = new HashSet<>();
            productDesigners.forEach(o->set.add(o.getDesignerId()));
            return  getDesignerById(new ArrayList<Integer>(set));
        }
        return  null;
    }
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Designer getPrimaryDesignerByProduct(Product product) throws Exception {
              return getDesignersByProduct(product).get(0);
    }
}
