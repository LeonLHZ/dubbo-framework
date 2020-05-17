package com.lh.shop.commons.entity;

public class UserRole extends BaseEntity
{

    private Integer userId;


    private Integer roleId;

    /**
     * @return user_id
     */
    public Integer getUserId()
    {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId()
    {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
}