package cn.lhz.common.entity;

import com.lh.shop.commons.entity.BaseEntity;

import javax.persistence.*;

@Table(name = "sell_dog..role")
public class Role extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String code;

    private String name;

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
}