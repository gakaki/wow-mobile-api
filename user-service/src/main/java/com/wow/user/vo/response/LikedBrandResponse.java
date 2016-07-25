package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.LikedBrandVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedBrandResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<LikedBrandVo> likedBrandVoList;

    public List<LikedBrandVo> getLikedBrandVoList() {
        return likedBrandVoList;
    }

    public void setLikedBrandVoList(List<LikedBrandVo> likedBrandVoList) {
        this.likedBrandVoList = likedBrandVoList;
    }
}
