package com.wow.product.service;

import com.wow.product.model.ProductComment;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ProductCommentService {
    //table: product_comment
    /**
     * 评论产品
     *
     * @param productComment
     * @return
     */
    int createProductComment(ProductComment productComment);

    /**
     * 修改产品评论
     * @param productComment
     * @return
     */
    int updateProductComment(ProductComment productComment);

    /**
     * 查找产品的评论
     * @param productId
     * @return
     */
    List<ProductComment> getProductCommentsByProduct(int productId);

    /**
     * 根据用户查找产品评论
     * @param endUserId
     * @return
     */
    List<ProductComment> getProductCommentsByUser(int endUserId);

    /**
     * 根据订单查找产品评论
     * @param orderId
     * @return
     */
    List<ProductComment> getProductCommentsByOrder(int orderId);
}
