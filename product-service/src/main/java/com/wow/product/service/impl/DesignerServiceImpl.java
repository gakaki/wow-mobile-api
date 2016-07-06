package com.wow.product.service.impl;

import com.wow.product.mapper.DesignerMapper;
import com.wow.product.mapper.ProductDesignerMapper;
import com.wow.product.model.*;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    public Designer getDesignerById(int designerId) {
        return designerMapper.selectByPrimaryKey(designerId);
    }

    @Override
    public int updateDesigner(Designer designer) {
        return designerMapper.updateByPrimaryKeySelective(designer);
    }

    @Override
    public List<Designer> getDesignersByCountry(String country) {
        DesignerExample designerExample=new DesignerExample();
        DesignerExample.Criteria criteria=designerExample.createCriteria();
        criteria.andDesignerCountryEqualTo(country);
        return designerMapper.selectByExample(designerExample);
    }

    @Override
    public List<Designer> getDesignersByStyle(String style) {
        DesignerExample designerExample=new DesignerExample();
        DesignerExample.Criteria criteria=designerExample.createCriteria();
        criteria.andDesignerStyleEqualTo(style);
        criteria.andIsDeletedEqualTo(false);
        return designerMapper.selectByExample(designerExample);
    }

    @Override
    public List<Product> getProductsByDesigner(int designerId) {
        ProductDesignerExample productDesignerExample=new ProductDesignerExample();
        ProductDesignerExample.Criteria criteria=productDesignerExample.createCriteria();
        criteria.andDesignerIdEqualTo(designerId);
        criteria.andIsDeletedEqualTo(false);
        List<ProductDesigner> productDesigners=productDesignerMapper.selectByExample(productDesignerExample);
        List<Product> products=new ArrayList<>();
        if(!productDesigners.isEmpty())
            productDesigners.forEach(new Consumer<ProductDesigner>() {
                @Override
                public void accept(ProductDesigner productDesigner) {
                 Product product= productService.getProductById(productDesigner.getProductId());
                    if(product!=null)
                        products.add(product);
                }
            });
        return products;
    }

    @Override
    public List<Product> getProductsByDesigner(String designerName) {
        return null;
    }

    @Override
    public int createProductDesigner(ProductDesigner productDesigner) {
        return 0;
    }

    @Override
    public int createProductDesigners(List<ProductDesigner> productDesigners) {
        return 0;
    }

    @Override
    public List<Designer> getDesignersByProduct(Product product) {
        return null;
    }

    @Override
    public Designer getPrimaryDesignerByProduct(Product product) {
        return null;
    }
}
