/**
 * Stome.com Co.,Ltd.
 * Copyright (c) 2004-2017, All Rights Reserved.
 */
package com.stome.workbanch.core.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.stome.workbanch.common.util.ToString;
import com.stome.workbanch.common.util.formater.JsonDateFormater;

/** 
 * 用户模型
 * 
 * @author Robin 
 * @date 2017-01-29 08:04:37 
 * @version $id: User.java v1.0 
 */
@JsonIgnoreProperties({ "name", "age" })
public class User extends ToString {

    /** serialVersionUID */
    private static final long serialVersionUID = 1433299963012212711L;

    /** 用户 */
    private int               id;

    /** 用户姓名 */
    private String            name;

    /** 用户年龄 */
    //@JsonIgnore
    private int               age;

    /** 用户生日 */
    @JsonSerialize(using = JsonDateFormater.class)
    private Date              birthday;

    /** 
     * Getter method for property <tt>id</tt>. 
     * 
     * @return property value of id 
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Getter method for property <tt>name</tt>. 
     * 
     * @return property value of name 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Getter method for property <tt>age</tt>. 
     * 
     * @return property value of age 
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age 
     */
    public void setAge(int age) {
        this.age = age;
    }

    /** 
     * Getter method for property <tt>birthday</tt>. 
     * 
     * @return property value of birthday 
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Setter method for property <tt>birthday</tt>.
     * 
     * @param birthday value to be assigned to property birthday 
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
