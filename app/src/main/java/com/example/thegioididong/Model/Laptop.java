package com.example.thegioididong.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Laptop implements Parcelable {
    @SerializedName("TenSP")
    @Expose
    private String tenSP;
    @SerializedName("HinhSP")
    @Expose
    private String hinhSP;
    @SerializedName("GiaSP")
    @Expose
    private String giaSP;
    @SerializedName("IdSP")
    @Expose
    private String idSP;
    @SerializedName("LinkSP")
    @Expose
    private String linkSP;

    public String getTenSP() {
        return tenSP;
    }

    public String getHinhSP() {
        return hinhSP;
    }


    public String getGiaSP() {
        return giaSP;
    }


    public String getLinkSP() {
        return linkSP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idSP);
        parcel.writeString(tenSP);
        parcel.writeString(hinhSP);
        parcel.writeString(giaSP);
        parcel.writeString(linkSP);
    }

    private Laptop(Parcel in){
        idSP = in.readString();
        tenSP = in.readString();
        hinhSP = in.readString();
        giaSP = in.readString();
        linkSP = in.readString();
    }

    public static final Creator<Laptop> CREATOR = new Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel parcel) {
            return new Laptop(parcel);
        }

        @Override
        public Laptop[] newArray(int i) {
            return new Laptop[i];
        }
    };

}
