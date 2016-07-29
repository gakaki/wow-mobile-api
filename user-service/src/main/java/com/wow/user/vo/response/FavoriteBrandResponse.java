package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.FavoriteBrandVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FavoriteBrandResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<FavoriteBrandVo> favoriteBrandVoList;

    public List<FavoriteBrandVo> getFavoriteBrandVoList() {
        return favoriteBrandVoList;
    }

    public void setFavoriteBrandVoList(List<FavoriteBrandVo> favoriteBrandVoList) {
        this.favoriteBrandVoList = favoriteBrandVoList;
    }
}
