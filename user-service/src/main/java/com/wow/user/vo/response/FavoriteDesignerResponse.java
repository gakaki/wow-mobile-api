package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.FavoriteDesignerVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FavoriteDesignerResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<FavoriteDesignerVo> favoriteDesignerVoList;

    public List<FavoriteDesignerVo> getFavoriteDesignerVoList() {
        return favoriteDesignerVoList;
    }

    public void setFavoriteDesignerVoList(List<FavoriteDesignerVo> favoriteDesignerVoList) {
        this.favoriteDesignerVoList = favoriteDesignerVoList;
    }
}
