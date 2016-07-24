package com.wow.attribute.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.attribute.mapper.CategoryMapper;
import com.wow.attribute.model.Category;
import com.wow.attribute.model.CategoryExample;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.response.CategoryListResponse;
import com.wow.attribute.vo.response.CategoryResponse;
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
    private StringBuffer categoryIds;

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
     * 查询指定分类所有三级分类(递归查询)
     *
     * @param categoryId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public String getLastLevelCategoryByCategory(int categoryId) {
        //TODO:
        //如果该分类已经是第三级(也是最后一级),返回该分类本身
        //否则,递归查询该分类的子分类,直到最后一级
    	categoryIds = new StringBuffer();
    	List<Category> categoryListAll = categoryMapper.selectAllCategory();
    	String childId = getChildNodes(categoryListAll,categoryId);
    	if(childId.length()>0)
    		childId = childId.substring(0,childId.length()-1);
        return childId;
    }
    
    /**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    private String getChildNodes(List<Category> list, Integer typeId) {
        if(list == null && typeId == null) return "";
        for (Iterator<Category> iterator = list.iterator(); iterator.hasNext();) {
        	Category node = (Category) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (typeId==node.getParentCategoryId()) {
                recursionFn(list, node);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*if (node.getParentCategoryId()==0) {
                recursionFn(list, node);
            }*/
        }
        return categoryIds.toString();
    }
     
    private void recursionFn(List<Category> list, Category node) {
        List<Category> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
        	categoryIds.append(node.getId()).append(",");
            Iterator<Category> it = childList.iterator();
            while (it.hasNext()) {
            	Category n = (Category) it.next();
                recursionFn(list, n);
            }
        } else {
        	categoryIds.append(node.getId()).append(",");
        }
    }
     
    // 得到子节点列表
    private List<Category> getChildList(List<Category> list, Category node) {
        List<Category> nodeList = new ArrayList<Category>();
        Iterator<Category> it = list.iterator();
        while (it.hasNext()) {
        	Category n = (Category) it.next();
            if (n.getParentCategoryId() == node.getId()) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }
 
    // 判断是否有子节点
    private boolean hasChild(List<Category> list, Category node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }
}
