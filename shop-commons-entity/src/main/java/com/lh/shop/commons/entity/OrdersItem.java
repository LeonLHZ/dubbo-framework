package com.lh.shop.commons.entity;

import java.util.Date;


public class OrdersItem extends BaseEntity
{
    private Integer id;

    private Integer number;

    private Long itemTotalPrice;

    /**
     * 0未付款,1待发货,2已发货,3确认收货
     */
    private Byte itemStatus;

    private Date createTime;

    /**
     * 发货时间
     */
    private Date deliverTime;

    /**
     * 确认收货时间
     */
    private Date fixedTime;

    private Integer ordersId;

    private Integer goodsId;

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
     * @return item_total_price
     */
    public Long getItemTotalPrice() {
        return itemTotalPrice;
    }

    /**
     * @param itemTotalPrice
     */
    public void setItemTotalPrice(Long itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    /**
     * 获取0未付款,1待发货,2已发货,3确认收货
     *
     * @return item_status - 0未付款,1待发货,2已发货,3确认收货
     */
    public Byte getItemStatus() {
        return itemStatus;
    }

    /**
     * 设置0未付款,1待发货,2已发货,3确认收货
     *
     * @param itemStatus 0未付款,1待发货,2已发货,3确认收货
     */
    public void setItemStatus(Byte itemStatus) {
        this.itemStatus = itemStatus;
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
     * 获取发货时间
     *
     * @return deliver_time - 发货时间
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliverTime 发货时间
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取确认收货时间
     *
     * @return fixed_time - 确认收货时间
     */
    public Date getFixedTime() {
        return fixedTime;
    }

    /**
     * 设置确认收货时间
     *
     * @param fixedTime 确认收货时间
     */
    public void setFixedTime(Date fixedTime) {
        this.fixedTime = fixedTime;
    }

    /**
     * @return orders_id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * @param ordersId
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}