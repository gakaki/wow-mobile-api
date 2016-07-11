package com.wow.page.pageEnum;

import com.wow.product.model.Scene;

/**
 * Created by fangying@wowdsgn on 2016/7/11.
 */
public enum PageType {

    Topice("主题",0),Scenes("场景",1),Banners("Banner",2);

    private PageType(String name, int index)
    {
        this.name=name;
        this.index=index;
    }

    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PageType{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

}
