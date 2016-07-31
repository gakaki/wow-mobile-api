package com.wow.attribute.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wow.common.util.ErrorResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.attribute.mapper.CategoryMapper;
import com.wow.attribute.model.Category;
import com.wow.attribute.model.CategoryExample;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.SubCategoryVoList;
import com.wow.attribute.vo.response.CategoryListResponse;
import com.wow.attribute.vo.response.CategoryResponse;
import com.wow.attribute.vo.response.CategorySecondResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;

/**
 * 类目服务
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
@Transactional(value = "attributeTransactionManager")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //一级分类的父分类:0
    private final int PARENT_CATEGORY_OF_FIRST_LEVEL_CATEGORY=0;


    /**
     * 创建类目
     *
     * @param category
     * @return
     */
    public CommonResponse createCategory(Category category) {
        CommonResponse response = new CommonResponse();
        categoryMapper.insertSelective(category);
        return response;
    }

    /**
     * 更新类目
     *
     * @param category
     * @return
     */
    public CommonResponse updateCategory(Category category) {
        CommonResponse response = new CommonResponse();
        categoryMapper.updateByPrimaryKeySelective(category);
        return response;
    }

    /**
     * 删除类目
     * @param categoryId
     * @return
     */
    public CommonResponse deleteCategoryById(int categoryId) {
        CommonResponse response = new CommonResponse();
        Category category=new Category();
        category.setId(categoryId);
        category.setIsDeleted(true);
        updateCategory(category);
        return response;
    }

    /**
     * 根据id查询类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategoryResponse getCategoryById(int categoryId) {
        CategoryResponse categoryResponse = new CategoryResponse();
        Category category =  categoryMapper.selectByPrimaryKey(categoryId);
        categoryResponse.setCategory(category);
        return categoryResponse;
    }



    /**
     * 查询指定类目的子类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategoryListResponse getSubCategory(int categoryId) {
        CategoryListResponse categoryListResponse = new CategoryListResponse();
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria=categoryExample.createCriteria();
        criteria.andParentCategoryIdEqualTo(categoryId);
        criteria.andIsDeletedEqualTo(false);
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        if (CollectionUtil.isEmpty(categoryList)) {
            categoryListResponse.setResCode("40402");
            categoryListResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40402"));
        } else {
            categoryListResponse.setCategoryList(categoryList);
        }
        return categoryListResponse;
    }

    /**
     * 查询指定类目的父类目
     *
     * @param categoryId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategoryResponse getParentCategory(int categoryId) {
        CategoryResponse categoryResponse = new CategoryResponse();
        Category category= categoryMapper.selectByPrimaryKey(categoryId);
        if(category.getParentCategoryId() != null) {
            category = categoryMapper.selectByPrimaryKey(category.getParentCategoryId());
        } else {
            categoryResponse.setResCode("40401");
            categoryResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40401"));
        }
        categoryResponse.setCategory(category);
        return categoryResponse;
    }

    /**
     * 查询所有一级类目
     *
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategoryListResponse getFirstLevelCategory() {
        CategoryListResponse categoryListResponse =  getSubCategory(PARENT_CATEGORY_OF_FIRST_LEVEL_CATEGORY);
        if ("40402".equals(categoryListResponse.getResCode())) {
            categoryListResponse.setResCode("40403");
            categoryListResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40403"));
        }
        return categoryListResponse;
    }

    /**
     * 查询指定分类所有三级分类
     *
     * @param categoryId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategoryListResponse getLastLevelCategoryByCategory(int categoryId) {
        CategoryListResponse categoryListResponse = new CategoryListResponse();
        List<Category> categoryList = new ArrayList<>();
        Category currentCategory = categoryMapper.selectByPrimaryKey(categoryId);
        if (currentCategory == null) {
            ErrorResponseUtil.setErrorResponse(categoryListResponse,"40404");
            return categoryListResponse;
        }
        if (currentCategory.getCategoryLevel()==3) {
            categoryList.add(currentCategory);
        } else if (currentCategory.getCategoryLevel() ==2) {
            CategoryListResponse categoryListResponse1 = getSubCategory(categoryId);
            if (categoryListResponse1 != null && categoryListResponse1.getCategoryList() != null
                    && categoryListResponse1.getCategoryList().size() > 0) {
                categoryList = categoryListResponse1.getCategoryList();
            } else {
                ErrorResponseUtil.setErrorResponse(categoryListResponse,"40403");
                return categoryListResponse;
            }
        } else if (currentCategory.getCategoryLevel() == 1) {
            //先找二级类目,再遍历找三级类目
            CategoryListResponse categoryListResponseSecondLevel = getSubCategory(categoryId);
            if (categoryListResponseSecondLevel == null || CollectionUtil.isEmpty(categoryListResponseSecondLevel.getCategoryList())) {
                ErrorResponseUtil.setErrorResponse(categoryListResponse,"40403");
                return categoryListResponse;
            }
            List<Category> secondaryCategory =categoryListResponseSecondLevel.getCategoryList();
            for (Category category : secondaryCategory) {
                int secondLevelCategoryId = category.getId();
                CategoryListResponse categoryListResponseThirdLevel = getSubCategory(secondLevelCategoryId);
                if (categoryListResponseThirdLevel != null && CollectionUtil.isNotEmpty(categoryListResponseThirdLevel.getCategoryList())) {
                    categoryList.addAll(categoryListResponseThirdLevel.getCategoryList());
                }
            }
        }

        categoryListResponse.setCategoryList(categoryList);

        return categoryListResponse;
    }
    
    /**
     * 根据父节点的ID获取所有子节点
     * @param categoryList 分类表
     * @param parentCategoryId 传入的父节点ID
     * @return String
     */
    private static List<Integer> getChildCategories(List<Category> categoryList, Integer parentCategoryId) {
        if(CollectionUtil.isEmpty(categoryList)) return null;
        List<Integer> subCategoryList = new ArrayList<Integer>();

        for (Category category : categoryList) {
            if (category.getParentCategoryId()==parentCategoryId) {
            	subCategoryList.add(category.getId());
            	subCategoryList.addAll(getChildCategories(categoryList,category.getId()));
            }else if(category.getCategoryLevel() == 3){
            	subCategoryList.add(category.getId());
            	
            }
        }
        return subCategoryList;
    }
    
    /**
     * 查询二级分类
     *
     * @param categoryParentId
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public CategorySecondResponse getCategoryByParentId(Integer categoryParentId){
    	CategorySecondResponse categorySecondResponse = new CategorySecondResponse();
    	
    	if (categoryParentId == null) {
    		categorySecondResponse.setResCode("40404");
    		categorySecondResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40404"));
            return categorySecondResponse;
        }
    	
//    	Category firstCategory = categoryMapper.selectByPrimaryKey(categoryParentId);
//    	CategoryFirstVo categoryFirstVo = new CategoryFirstVo();
//    	if(firstCategory!=null){
//    		categoryFirstVo.setId(firstCategory.getId());
//    		categoryFirstVo.setCategoryIconSmall(firstCategory.getCategoryIconSmall());
//    		categoryFirstVo.setCategoryIconBig(firstCategory.getCategoryIconBig());   
//    		categoryFirstVo.setCategoryLevel(firstCategory.getCategoryLevel());
//    	}
//    	categorySecondResponse.setCategoryFirstVo(categoryFirstVo);
    	
    	List<Category> categoryList = categoryMapper.selectCategoryByParentId(categoryParentId);
    	List<SubCategoryVoList> subCategoryVoList = new ArrayList<SubCategoryVoList>();
    	for(Category category : categoryList){
    		SubCategoryVoList vo = new SubCategoryVoList();
    		vo.setId(category.getId());
    		vo.setCategoryName(category.getCategoryName());  
    		vo.setCategoryLevel(category.getCategoryLevel());
    		subCategoryVoList.add(vo);
    	}
    	categorySecondResponse.setSubCategoryList(subCategoryVoList);
    	return categorySecondResponse;
    }
}
