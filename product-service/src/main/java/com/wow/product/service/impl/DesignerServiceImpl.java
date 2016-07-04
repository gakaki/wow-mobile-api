package com.wow.product.service.impl;

import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.model.ProductDesigner;
import com.wow.product.service.DesignerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class DesignerServiceImpl implements DesignerService {
    @Override
    public int createDesigner(Designer designer) {
        return 0;
    }

    @Override
    public Designer getDesignerById(int designerId) {
        return null;
    }

    @Override
    public int updateDesigner(Designer designer) {
        return 0;
    }

    @Override
    public List<Designer> getDesignersByCountry(String country) {
        return null;
    }

    @Override
    public List<Designer> getDesignersByStyle(String style) {
        return null;
    }

    @Override
    public List<Product> getProductsByDesigner(int designerId) {
        return null;
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
