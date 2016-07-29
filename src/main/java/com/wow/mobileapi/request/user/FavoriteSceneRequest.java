package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

public class FavoriteSceneRequest extends ApiRequest {
	private static final long serialVersionUID = 1L;

    private Integer sceneId;
    private Integer id;
    
    
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    
}
