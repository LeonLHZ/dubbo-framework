package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sell_dog..area")
public class Area extends BaseEntity
{
    /**
     * 区域主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 区域名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 区域代码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 区域简称
     */
    @Column(name = "area_short")
    private String areaShort;

    /**
     * 是否热门(0:否、1:是)
     */
    @Column(name = "area_is_hot")
    private String areaIsHot;

    /**
     * 区域序列
     */
    @Column(name = "area_sequence")
    private Integer areaSequence;

    /**
     * 上级主键
     */
    @Column(name = "area_parent_id")
    private Integer areaParentId;

    /**
     * 初始时间
     */
    @Column(name = "init_date")
    private Date initDate;

    /**
     * 初始地址
     */
    @Column(name = "init_addr")
    private String initAddr;

    /**
     * 获取区域主键
     *
     * @return id - 区域主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置区域主键
     *
     * @param id 区域主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区域名称
     *
     * @return area_name - 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名称
     *
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取区域代码
     *
     * @return area_code - 区域代码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置区域代码
     *
     * @param areaCode 区域代码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取区域简称
     *
     * @return area_short - 区域简称
     */
    public String getAreaShort() {
        return areaShort;
    }

    /**
     * 设置区域简称
     *
     * @param areaShort 区域简称
     */
    public void setAreaShort(String areaShort) {
        this.areaShort = areaShort;
    }

    /**
     * 获取是否热门(0:否、1:是)
     *
     * @return area_is_hot - 是否热门(0:否、1:是)
     */
    public String getAreaIsHot() {
        return areaIsHot;
    }

    /**
     * 设置是否热门(0:否、1:是)
     *
     * @param areaIsHot 是否热门(0:否、1:是)
     */
    public void setAreaIsHot(String areaIsHot) {
        this.areaIsHot = areaIsHot;
    }

    /**
     * 获取区域序列
     *
     * @return area_sequence - 区域序列
     */
    public Integer getAreaSequence() {
        return areaSequence;
    }

    /**
     * 设置区域序列
     *
     * @param areaSequence 区域序列
     */
    public void setAreaSequence(Integer areaSequence) {
        this.areaSequence = areaSequence;
    }

    /**
     * 获取上级主键
     *
     * @return area_parent_id - 上级主键
     */
    public Integer getAreaParentId() {
        return areaParentId;
    }

    /**
     * 设置上级主键
     *
     * @param areaParentId 上级主键
     */
    public void setAreaParentId(Integer areaParentId) {
        this.areaParentId = areaParentId;
    }

    /**
     * 获取初始时间
     *
     * @return init_date - 初始时间
     */
    public Date getInitDate() {
        return initDate;
    }

    /**
     * 设置初始时间
     *
     * @param initDate 初始时间
     */
    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    /**
     * 获取初始地址
     *
     * @return init_addr - 初始地址
     */
    public String getInitAddr() {
        return initAddr;
    }

    /**
     * 设置初始地址
     *
     * @param initAddr 初始地址
     */
    public void setInitAddr(String initAddr) {
        this.initAddr = initAddr;
    }
}