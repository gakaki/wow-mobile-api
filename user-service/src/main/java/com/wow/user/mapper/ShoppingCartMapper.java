package com.wow.user.mapper;

import com.wow.user.model.ShoppingCart;
import com.wow.user.model.ShoppingCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

}