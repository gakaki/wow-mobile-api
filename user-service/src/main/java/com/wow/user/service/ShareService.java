package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUserShareBrand;
import com.wow.user.model.EndUserShareDesigner;
import com.wow.user.model.EndUserShareProduct;
import com.wow.user.model.EndUserShareScene;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface ShareService {

    /**
     * 用户分享品牌
     *
     * @param endUserShareBrand
     * @return
     */
    CommonResponse shareBrand(EndUserShareBrand endUserShareBrand);

    /**
     * 用户分享设计师
     *
     * @param endUserShareDesigner
     * @return
     */
    CommonResponse shareDesigner(EndUserShareDesigner endUserShareDesigner);

    /**
     * 用户分享设计师
     *
     * @param endUserShareProduct
     * @return
     */
    CommonResponse shareProduct(EndUserShareProduct endUserShareProduct);

    /**
     * 用户分享场景
     * @param endUserShareScene
     * @return
     */
    CommonResponse shareScene(EndUserShareScene endUserShareScene);
}
