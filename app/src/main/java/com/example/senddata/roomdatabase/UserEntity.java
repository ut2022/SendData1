package com.example.senddata.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

    @Entity(tableName = "table_name")
    public class UserEntity  implements Serializable {

        @PrimaryKey(autoGenerate = true)
        Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserphno() {
            return userphno;
        }

        public void setUserphno(String userphno) {
            this.userphno = userphno;
        }

        @ColumnInfo(name="userId")
        String userId;

        @ColumnInfo(name = "name")
        String name;

        @ColumnInfo(name="userphno")
        String userphno;

    }

