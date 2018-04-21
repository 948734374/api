package com.mcfish.common.model;

import javax.persistence.*;

@Table(name = "tb_system_region")
public class TbSystemRegion {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 地级市名
     */
    private String name;

    /**
     * 父id
     */
    private Integer parent_id;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取地级市名
     *
     * @return name - 地级市名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置地级市名
     *
     * @param name 地级市名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置父id
     *
     * @param parent_id 父id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}