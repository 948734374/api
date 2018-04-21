package com.mcfish.common.model;

import javax.persistence.*;

@Table(name = "tb_system_crc")
public class TbSystemCrc {
    @Id
    private Integer id;

    private String country;

    private String name;

    private String abb;

    private String code;

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
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
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
     * @return abb
     */
    public String getAbb() {
        return abb;
    }

    /**
     * @param abb
     */
    public void setAbb(String abb) {
        this.abb = abb;
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
}