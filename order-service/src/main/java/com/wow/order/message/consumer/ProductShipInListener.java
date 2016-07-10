package com.wow.order.message.consumer;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
public class ProductShipInListener {
    public void onMessage(int productId) {
        //iterate all order_item contain this product and has frozen virtual stock
        //to check if available real stock can satisfy this order item
        //if yes, transfer virtual frozen to real frozen
        //change order status to be ready, notify warehouse admin to delivery goods
    }
}
