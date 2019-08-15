package com.example.thegioididong.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("HinhQuangCao")
    @Expose
    private String hinhQuangCao;

    public QuangCao(String hinhQuangCao) {
        this.hinhQuangCao = hinhQuangCao;
    }

    public String getHinhQuangCao() {
        return hinhQuangCao;
    }

}
