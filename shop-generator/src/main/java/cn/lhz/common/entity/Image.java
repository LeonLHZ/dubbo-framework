package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;

@Table(name = "sell_dog..image")
public class Image extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String type;

    private String url;

    @Column(name = "other_id")
    private Integer otherId;

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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return other_id
     */
    public Integer getOtherId() {
        return otherId;
    }

    /**
     * @param otherId
     */
    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
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