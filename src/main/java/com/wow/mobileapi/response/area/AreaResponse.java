package com.wow.mobileapi.response.area;

import java.util.List;

import com.wow.common.response.ApiResponse;
import com.wow.user.model.Area;

public class AreaResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;
	
	private List<Area> areaList;

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	
	
}
