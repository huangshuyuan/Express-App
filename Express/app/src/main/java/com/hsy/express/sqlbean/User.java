package com.hsy.express.sqlbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author: syhuang
 * Date:  2017/12/26
 */
@Entity
public class User {
    @Id
    private long   id;
    private String name;
    private String passowrd;
    private String phone;
    private String sex;
    private int    age;
    private String info;
    private String address;


    @Generated(hash = 308907033)
    public User(long id, String name, String passowrd, String phone, String sex,
            int age, String info, String address) {
        this.id = id;
        this.name = name;
        this.passowrd = passowrd;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.info = info;
        this.address = address;
    }

    @Generated(hash = 586692638)
    public User() {
    }

  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassowrd() {
        return this.passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
