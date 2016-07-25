package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.LikedSceneVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedSceneResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<LikedSceneVo> likedSceneVoList;

    public List<LikedSceneVo> getLikedSceneVoList() {
        return likedSceneVoList;
    }

    public void setLikedSceneVoList(List<LikedSceneVo> likedSceneVoList) {
        this.likedSceneVoList = likedSceneVoList;
    }
}
