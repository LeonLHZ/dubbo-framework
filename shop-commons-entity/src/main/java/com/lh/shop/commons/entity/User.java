package com.lh.shop.commons.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;

public class User extends BaseEntity implements Serializable
{

    private static final long serialVersionUID = 141903279484720298L;
    private Integer id;

    private String username;

    private String password;

    private String fullname;

    private String email;

    private String mobile;

    private Byte gender;

    private String avator;

    private String salt;


    private Date createTime;


    private Date loginTime;


    private String loginIp;

    /**
     * 0未删除1已删除
     */

    private Byte deleteStatus;

    public User()
    {

    }

    public User(Integer id)
    {
        this.id = id;
    }

    /**
     * @return id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return fullname
     */
    public String getFullname()
    {
        return fullname;
    }

    /**
     * @param fullname
     */
    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    /**
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return mobile
     */
    public String getMobile()
    {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * @return gender
     */
    public Byte getGender()
    {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(Byte gender)
    {
        this.gender = gender;
    }

    /**
     * @return avator
     */
    public String getAvator()
    {
        return avator;
    }

    /**
     * @param avator
     */
    public void setAvator(String avator)
    {
        this.avator = avator;
    }

    /**
     * @return salt
     */
    public String getSalt()
    {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime()
    {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * @return login_time
     */
    public Date getLoginTime()
    {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }

    /**
     * @return login_ip
     */
    public String getLoginIp()
    {
        return loginIp;
    }

    /**
     * @param loginIp
     */
    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    /**
     * 获取0未删除1已删除
     *
     * @return delete_status - 0未删除1已删除
     */
    public Byte getDeleteStatus()
    {
        return deleteStatus;
    }

    /**
     * 设置0未删除1已删除
     *
     * @param deleteStatus 0未删除1已删除
     */
    public void setDeleteStatus(Byte deleteStatus)
    {
        this.deleteStatus = deleteStatus;
    }
}