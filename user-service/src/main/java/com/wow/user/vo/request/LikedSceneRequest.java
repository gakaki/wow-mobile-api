package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;

public class LikedSceneRequest extends ApiRequest {
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
