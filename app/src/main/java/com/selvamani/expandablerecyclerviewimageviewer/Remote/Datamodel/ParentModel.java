package com.selvamani.expandablerecyclerviewimageviewer.Remote.Datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ParentModel implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image_URL")
    @Expose
    private String image_URL;
    @SerializedName("childarray")
    @Expose
    private List<ChildModel> childarray = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ChildModel> getChildarray() {
        return childarray;
    }

    public void setChildarray(List<ChildModel> childarray) {
        this.childarray = childarray;
    }



    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }
}