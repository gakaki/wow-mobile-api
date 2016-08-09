package com.wow.product.service.impl;

import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.product.mapper.DesignerMapper;
import com.wow.product.mapper.ProductDesignerMapper;
import com.wow.product.model.*;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.DesignerVo;
import com.wow.product.vo.response.ProductDesignerResponse;
import com.wow.product.vo.response.ProductDesignerVoResponse;
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

    @Override
    public int createDesigner(Designer designer) {
        return designerMapper.insertSelective(designer);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductDesignerResponse getDesignerById(int designerId) {
    	ProductDesignerResponse productDesignerResponse = new ProductDesignerResponse();
    	Designer designer = designerMapper.selectByPrimaryKey(designerId);
    	productDesignerResponse.setDesigner(designer);
        return productDesignerResponse;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductDesignerVoResponse getDesignerVoById(Integer designerId) {
    	ProductDesignerVoResponse productDesignerVoResponse = new ProductDesignerVoResponse();
    	if (designerId == null) {
    		productDesignerVoResponse.setResCode("40205");
    		productDesignerVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40205"));
            return productDesignerVoResponse;
        }
    	
    	Designer designer = designerMapper.selectByPrimaryKey(designerId);
    	DesignerVo designerVo = new DesignerVo();
    	if(designer!=null){
    		designerVo.setId(designer.getId());
    		designerVo.setDesignerName(designer.getDesignerName());
    		designerVo.setDesignerDesc(designer.getDesignerDesc());
            designerVo.setDesignerPhoto(designer.getDesignerPhoto());
    	}
    	
    	productDesignerVoResponse.setDesignerVo(designerVo);
        return productDesignerVoResponse;
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
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ProductDesigner> getProductDesigners(Integer productId) {
        ProductDesignerExample productDesignerExample = new ProductDesignerExample();
        productDesignerExample.or().andProductIdEqualTo(productId).andIsDeletedEqualTo(false);
        return productDesignerMapper.selectByExample(productDesignerExample);
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

    @Override
    public List<SimpleDesigner> getAllSimpleDesigners() {
        return designerMapper.getAllSimpleDesigners();
    }

    @Override
    public int addProductDesignersByBatch(List<ProductDesigner> list) {
        return productDesignerMapper.addByBatch(list);
    }

    private static ProductDesigner createDeletedProductDesignerRecord() {
        ProductDesigner record = new ProductDesigner();
        record.setIsDeleted(true);
        return record;
    }

    private static final ProductDesigner deletedProductDesignerRecord = createDeletedProductDesignerRecord();

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int replaceProductDesigners(Integer productId, List<ProductDesigner> designers) {
        ProductDesignerExample example = new ProductDesignerExample();
        example.or().andProductIdEqualTo(productId);
        productDesignerMapper.updateByExampleSelective(deletedProductDesignerRecord, example);

        return productDesignerMapper.addByBatch(designers);
    }
}
