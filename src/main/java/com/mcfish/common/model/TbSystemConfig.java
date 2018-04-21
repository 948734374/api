package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_config")
public class TbSystemConfig {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 关键词KEY
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 关键词的值
     */
    private String value;

    /**
     * 备注说明
     */
    private String comment;

    /**
     * 0-有效 1-无效
     */
    @Column(name = "`status`")
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 关键词名称
     */
    @Column(name = "key_name")
    private String keyName;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关键词KEY
     *
     * @return key - 关键词KEY
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置关键词KEY
     *
     * @param key 关键词KEY
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取关键词的值
     *
     * @return value - 关键词的值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置关键词的值
     *
     * @param value 关键词的值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取备注说明
     *
     * @return comment - 备注说明
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注说明
     *
     * @param comment 备注说明
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取0-有效 1-无效
     *
     * @return status - 0-有效 1-无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0-有效 1-无效
     *
     * @param status 0-有效 1-无效
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

    /**
     * 获取关键词名称
     *
     * @return key_name - 关键词名称
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * 设置关键词名称
     *
     * @param keyName 关键词名称
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}