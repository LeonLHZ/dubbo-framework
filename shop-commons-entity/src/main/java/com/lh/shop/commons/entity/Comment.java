package com.lh.shop.commons.entity;

import java.util.Date;

public class Comment extends BaseEntity
{

    private Integer id;

    private Date createTime;

    private Integer parentId;

    /**
     * 0未删除,1已删除
     */
    private Byte deleteStatus;

    private Integer goodsId;

    private Integer userId;

    private String content;

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
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}