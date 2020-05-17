package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;

@Table(name = "sell_dog..user_role")
public class UserRole extends BaseEntity
{
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}