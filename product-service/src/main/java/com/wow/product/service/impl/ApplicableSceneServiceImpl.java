package com.wow.product.service.impl;

import com.wow.product.mapper.ApplicableSceneMapper;
import com.wow.product.mapper.ProductApplicableSceneMapper;
import com.wow.product.model.ApplicableScene;
import com.wow.product.model.ApplicableSceneExample;
import com.wow.product.model.ProductApplicableScene;
import com.wow.product.model.ProductApplicableSceneExample;
import com.wow.product.service.ApplicableSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Created by fangying@wowdsgn on 2016/7/7.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ApplicableSceneServiceImpl implements ApplicableSceneService {
    @Autowired
    private ApplicableSceneMapper applicableSceneMapper;
    @Autowired
    private ProductApplicableSceneMapper productApplicableSceneMapper;
    @Override
    public int createApplicableScene(ApplicableScene applicableScene) {
        return applicableSceneMapper.insertSelective(applicableScene);
    }

    @Override
    public int updateApplicableScene(ApplicableScene applicableScene) {
        return applicableSceneMapper.updateByPrimaryKeySelective(applicableScene);
    }

    @Override
    public int deleteApplicableScene(ApplicableScene applicableScene) {
        if(applicableScene!=null) {
            applicableScene.setIsDeleted(true);
            return updateApplicableScene(applicableScene);
        }
        return 0;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ApplicableScene getApplicableSceneById(int applicableSceneId) {
        return applicableSceneMapper.selectByPrimaryKey(applicableSceneId);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ApplicableScene> getApplicableSceneById(List<Integer> applicableSceneIds)
    {
        ApplicableSceneExample applicableSceneExample=new ApplicableSceneExample();
        applicableSceneExample.or().andIsDeletedEqualTo(false).andIdIn(applicableSceneIds);
        return applicableSceneMapper.selectByExample(applicableSceneExample);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ApplicableScene getApplicableSceneByName(String applicableSceneName) throws Exception {
        ApplicableSceneExample applicableSceneExample=new ApplicableSceneExample();
        applicableSceneExample.or().andIsDeletedEqualTo(false).andApplicableSceneNameEqualTo(applicableSceneName);
        return applicableSceneMapper.selectByExample(applicableSceneExample).get(0);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ApplicableScene> getAllApplicableScene() {
        return applicableSceneMapper.selectAll();
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ApplicableScene> getApplicableSceneInProduct(int productId) {
        ProductApplicableSceneExample productApplicableSceneExample=new ProductApplicableSceneExample();
        productApplicableSceneExample.or().andIsDeletedEqualTo(false).andProductIdEqualTo(productId);
        List<ProductApplicableScene> productApplicableScenes=productApplicableSceneMapper.selectByExample(productApplicableSceneExample);
        if(!productApplicableScenes.isEmpty())
        {
            HashSet<Integer> productApplicableScenes1=new HashSet<>();
            for(ProductApplicableScene productApplicableScene:productApplicableScenes)
            {
                //productApplicableScenes1.add(productApplicableScene.getApplicableSceneId());
            }
            return getApplicableSceneById(new ArrayList<Integer>(productApplicableScenes1));
        }
        return null;
    }

    @Override
    public int createProductApplicableScene(List<ProductApplicableScene> applicableScenes) {
        if(!applicableScenes.isEmpty())
            for(ProductApplicableScene productApplicableScene:applicableScenes)
            {
                productApplicableSceneMapper.insertSelective(productApplicableScene);
            }
        return 0;
    }

    @Override
    public int updateProductApplicableScene(List<ProductApplicableScene> applicableScenes) {
        if(!applicableScenes.isEmpty())
            for(ProductApplicableScene productApplicableScene:applicableScenes)
            {
                productApplicableSceneMapper.updateByPrimaryKeySelective(productApplicableScene) ;
            }
        return 0;
    }

}
