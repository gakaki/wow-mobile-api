package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.FavoriteProductVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FavoriteProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<FavoriteProductVo> favoriteProductVoList;

    public List<FavoriteProductVo> getFavoriteProductVoList() {
        return favoriteProductVoList;
    }

    public void setFavoriteProductVoList(List<FavoriteProductVo> favoriteProductVoList) {
        this.favoriteProductVoList = favoriteProductVoList;
    }
}
