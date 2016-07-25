package com.wow.mobileapi.response.page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageBannerVoResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<PageBannerVo> carouselBanners;

    private List<PageBannerVo> bannerList;

    public List<PageBannerVo> getCarouselBanners() {
        return carouselBanners;
    }

    public void setCarouselBanners(List<PageBannerVo> carouselBanners) {
        this.carouselBanners = carouselBanners;
    }

    public List<PageBannerVo> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<PageBannerVo> bannerList) {
        this.bannerList = bannerList;
    }
}
