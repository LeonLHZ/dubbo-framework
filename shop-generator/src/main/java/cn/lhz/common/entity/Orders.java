package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sell_dog..orders")
public class Orders extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String code;

    @Column(name = "total_price")
    private Long totalPrice;

    /**
     * 0待付款,1已付款
     */
    private Byte status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "pay_time")
    private Date payTime;

    private String address;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return total_price
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取0待付款,1已付款
     *
     * @return status - 0待付款,1已付款
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0待付款,1已付款
     *
     * @param status 0待付款,1已付款
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return pay_time
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

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
}