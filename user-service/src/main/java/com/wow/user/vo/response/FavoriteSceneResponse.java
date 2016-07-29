package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.FavoriteSceneVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FavoriteSceneResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<FavoriteSceneVo> favoriteSceneVoList;

    public List<FavoriteSceneVo> getFavoriteSceneVoList() {
        return favoriteSceneVoList;
    }

    public void setFavoriteSceneVoList(List<FavoriteSceneVo> favoriteSceneVoList) {
        this.favoriteSceneVoList = favoriteSceneVoList;
    }
}
