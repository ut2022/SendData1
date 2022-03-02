package com.example.senddata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

    public class ApiResults implements Serializable
    {

        @SerializedName("name")
        @Expose
        private String name;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        @SerializedName("userid")
        @Expose
        private String userid;
        @SerializedName("city")
        @Expose
        private String city;
        private final static long serialVersionUID = -5166673581974552349L;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city= city;
        }

    }

