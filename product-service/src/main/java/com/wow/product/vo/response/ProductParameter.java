package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/22.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    //材质,多个用文本表示,逗号分隔
    private String materialText;

    //是否需要安装
    private Boolean needAssemble;

    //产地
    private String  origin;

    //风格
    private String style;

    //使用场景,多个用文本表示,逗号分隔
    private String applicableSceneText;

    //使用人群
    private String applicablePeople;

    public String getMaterialText() {
        return materialText;
    }

    public void setMaterialText(String materialText) {
        this.materialText = materialText;
    }

    public Boolean getNeedAssemble() {
        return needAssemble;
    }

    public void setNeedAssemble(Boolean needAssemble) {
        this.needAssemble = needAssemble;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getApplicableSceneText() {
        return applicableSceneText;
    }

    public void setApplicableSceneText(String applicableSceneText) {
        this.applicableSceneText = applicableSceneText;
    }

    public String getApplicablePeople() {
        return applicablePeople;
    }

    public void setApplicablePeople(String applicablePeople) {
        this.applicablePeople = applicablePeople;
    }
}
