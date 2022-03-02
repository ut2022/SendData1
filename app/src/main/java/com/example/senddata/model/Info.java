package com.example.senddata.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {
    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };

    public Info() {

    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public String name;
    public String phonenumber;

    protected Info(Parcel in) {
        name = in.readString();
        phonenumber = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Info(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phonenumber);
    }

}
