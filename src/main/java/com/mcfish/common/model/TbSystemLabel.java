package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_label")
public class TbSystemLabel {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 标签类型
     */
    private Byte type;

    /**
     * 标签名
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
     * 获取标签类型
     *
     * @return type - 标签类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置标签类型
     *
     * @param type 标签类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取标签名
     *
     * @return name - 标签名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置标签名
     *
     * @param name 标签名
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