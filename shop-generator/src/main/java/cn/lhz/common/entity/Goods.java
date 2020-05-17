package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sell_dog..goods")
public class Goods extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String name;

    private Long price;

    private Integer number;

    /**
     * 0下架,1上架
     */
    private Byte active;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 0未删除,1已删除
     */
    @Column(name = "delete_status")
    private Byte deleteStatus;

    private String description;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取0下架,1上架
     *
     * @return active - 0下架,1上架
     */
    public Byte getActive() {
        return active;
    }

    /**
     * 设置0下架,1上架
     *
     * @param active 0下架,1上架
     */
    public void setActive(Byte active) {
        this.active = active;
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
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取0未删除,1已删除
     *
     * @return delete_status - 0未删除,1已删除
     */
    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置0未删除,1已删除
     *
     * @param deleteStatus 0未删除,1已删除
     */
    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}