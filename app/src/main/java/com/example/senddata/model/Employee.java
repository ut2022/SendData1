package com.example.senddata.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    public String id;
    public String name;
    public String phoneno;
    public String Spin;
    public String age;
    public String salary;

    public Employee(String id, String name, String phoneno, String Spin,String age,String salary) {
        this.id = id;
        this.name = name;
        this.phoneno = phoneno;
        this.Spin = Spin;
        this.age=age;
        this.salary=salary;
    }

    protected Employee(Parcel in) {
        id = in.readString();
        name = in.readString();
        phoneno = in.readString();
        Spin = in.readString();
        age=in.readString();
        salary=in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getSpin() {
        return Spin;
    }

    public void setSpin(String Spin) {
        this.Spin = Spin;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(phoneno);
        dest.writeString(Spin);
        dest.writeString(age);
        dest.writeString(salary);
    }
}

