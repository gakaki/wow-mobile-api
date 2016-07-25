package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.LikedProductVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<LikedProductVo> likedProductVoList;

    public List<LikedProductVo> getLikedProductVoList() {
        return likedProductVoList;
    }

    public void setLikedProductVoList(List<LikedProductVo> likedProductVoList) {
        this.likedProductVoList = likedProductVoList;
    }
}
