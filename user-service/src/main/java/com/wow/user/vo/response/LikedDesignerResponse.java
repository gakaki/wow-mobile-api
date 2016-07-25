package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.LikedBrandVo;
import com.wow.user.vo.LikedDesignerVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedDesignerResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<LikedDesignerVo> likedDesignerVoList;

    public List<LikedDesignerVo> getLikedDesignerVoList() {
        return likedDesignerVoList;
    }

    public void setLikedDesignerVoList(List<LikedDesignerVo> likedDesignerVoList) {
        this.likedDesignerVoList = likedDesignerVoList;
    }
}
