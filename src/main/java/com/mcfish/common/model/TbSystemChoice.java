package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_choice")
public class TbSystemChoice {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 类型 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
     */
    private Byte type;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态 0-正常  1-无效
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取类型 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
     *
     * @return type - 类型 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
     *
     * @param type 类型 0-语言  1-工作行业 2-岗位类别 3-学历 4-宗教 5-
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态 0-正常  1-无效
     *
     * @return status - 状态 0-正常  1-无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-正常  1-无效
     *
     * @param status 状态 0-正常  1-无效
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}