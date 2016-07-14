package com.wow.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import com.wow.user.vo.ShoppingCartResultVo;
import com.wow.user.vo.request.ShoppingCartRequest;

public interface ShoppingCartMapper {
    int countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    

    /**
     * 查找用户购物车信息
     * @param endUserId
     * @return
     */
    List<ShoppingCart> selectByEndUser(@Param("endUserId") int endUserId);
    
    /**
     * 
     * 根据用户和产品id更新用户购物车信息表
     * @param record
     * @return
     */
    int updateByProductAndEndUserId(ShoppingCart record);
    
    /**
     * 根据查询条件 返回唯一结果 如果返回多个则抛出异常
     * 
     * @param example
     * @return
     */
    ShoppingCart  selectUniqueByExample(ShoppingCartExample example);
    
    /**
     * 删除用户指定产品的购物车信息
     * 
     * @param productIds
     * @return
     */
    int updateByPrimaryKeys(ShoppingCartRequest request);
    
    /**
     * 
     * 获取用户购物车信息列表明细
     * @param request
     * @return
     */
    List<ShoppingCartResultVo> queryByUserId(ShoppingCartRequest request);
}