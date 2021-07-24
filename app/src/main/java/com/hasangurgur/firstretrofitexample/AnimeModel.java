package com.hasangurgur.firstretrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeModel {

    @SerializedName("anime")
    @Expose
    private String animeName;


    @SerializedName("character")
    @Expose
    private String charName;

    @SerializedName("quote")
    @Expose
    private String quoteName;


    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }
}
