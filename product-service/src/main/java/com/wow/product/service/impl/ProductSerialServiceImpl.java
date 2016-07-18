package com.wow.product.service.impl;

import com.wow.common.util.CollectionUtil;
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.product.Vo.Response.SerialResponse;
import com.wow.product.mapper.ProductSerialMapper;
import com.wow.product.model.*;
import com.wow.product.service.BrandService;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductSerialServiceImpl implements ProductSerialService {

    @Autowired
    ProductSerialMapper productSerialMapper;
    @Autowired
    ProductService productService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private DesignerService designerService;
    private  static  final  Integer serialBannerCount=5;
    /**
     * 创建系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int createProductSerial(List<ProductSerial> productSerials) {
        if(!productSerials.isEmpty())
            productSerials.forEach(o->productSerialMapper.insertSelective(o));
        return 0;
    }

    /**
     * 更新系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int updateProductSerial(List<ProductSerial> productSerials) {
        if(!productSerials.isEmpty())
        {
            productSerials.forEach(o->productSerialMapper.updateByPrimaryKeySelective(o));
        }
        return 0;
    }

    /**
     * 根据系列主品查找所有子品
     * @param productId 产品ID
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ProductSerial> getProductSerials(int productId) {
        ProductSerialExample productSerialExample=new ProductSerialExample();
        ProductSerialExample.Criteria criteria=productSerialExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productSerialMapper.selectByExample(productSerialExample);

    }

    /**
     * 删除系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int deleteProductSerial(List<ProductSerial> productSerials) {
        if(!productSerials.isEmpty())
        {
            productSerials.forEach(new Consumer<ProductSerial>() {
                @Override
                public void accept(ProductSerial productSerial) {
                    productSerial.setIsDeleted(true);
                    productSerialMapper.updateByPrimaryKeySelective(productSerial);
                }
            });
        }
        return 0;
    }

    /**
     * 根据产品ID删除
     * @param productId
     * @return
     */
    public  int deleteProductSerial(int productId)
    {
        ProductSerialExample productSerialExample=new ProductSerialExample();
        ProductSerialExample.Criteria criteria=productSerialExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        ProductSerial productSerial=new ProductSerial();
        productSerial.setIsDeleted(true);
        return  productSerialMapper.updateByExampleSelective(productSerial,productSerialExample);
    }

    /**
     * 判断产品是否系列主品
     *
     * @param productId
     * @return
     */
    @Override
    public boolean isProductSerial(int productId) {
        List<ProductSerial> productSerials=getProductSerials(productId);
        return !productSerials.isEmpty();

    }

    /**
     * 查询系列品的主子品
     *
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductSerial getPrimarySubProductOfProductSerial(int productId) {
        return  getProductSerials(productId).stream().filter(o->o.getIsPrimary()==true).findAny().get();
    }

    private SerialResponse getSerialByProductId(Integer productId) throws Exception
    {
        if(!isProductSerial(productId))
            return null;
        SerialResponse serialResponse=new SerialResponse();
        Product product=productService.getProductById(productId);
        if(product!=null)
        {
            serialResponse.setProductName(product.getProductName());
            serialResponse.setTips(product.getTips());
            serialResponse.setDetailDescription(product.getDetailDescription());
            serialResponse.setVerboseInfo(product.getVerboseInfo());
            serialResponse.setApplicableSceneText(product.getApplicableSceneText());
            serialResponse.setOrigin(product.getOriginCountry()+product.getOriginCity());
            serialResponse.setWeight(product.getWeight());
            serialResponse.setMaterialText(product.getMaterialText());
            serialResponse.setSpec(product.getSpec());
            serialResponse.setNeedAssemble(product.getNeedAssemble());
            serialResponse.setStyle(product.getStyle());
            serialResponse.setSellingPoint(product.getSellingPoint());
            Brand brand=  brandService.getBrandById(product.getBrandId());
            if(brand!=null)
            {
                serialResponse.setBrandCname(brand.getBrandCname());
                serialResponse.setBrandLogoImg(brand.getBrandLogoImg());
            }
            Designer designer= designerService.getPrimaryDesignerByProduct(product);
            if(designer!=null)
            {
                serialResponse.setDesignerName(designer.getDesignerName());
                serialResponse.setDesignerPhoto(designer.getDesignerPhoto());
            }

            List<ProductImage> productImages=  productService.getProductImages(productId);
            if(CollectionUtil.isNotEmpty(productImages))
            {
                List<String> list=new ArrayList<>();
                Map<String,String> map=new HashMap<>();
                for (ProductImage productImage:productImages)
                {
                    if(productImage.getIsPrimary() && list.size()<serialBannerCount)
                        list.add(productImage.getImgUrl());
                    if(!productImage.getIsPrimary())
                        map.put(productImage.getImgUrl(),productImage.getImgDesc());
                }
                serialResponse.setBanner(list);
            }
            ProductPrice productPrice= priceService.queryProductPrice(productId).getProductPrice();
            if(productPrice!=null)
            {
                serialResponse.setSellPrice(productPrice.getSellPrice());
                serialResponse.setOriginalPrice(productPrice.getOriginalPrice());
            }
        }
        return  serialResponse;
    }
}
