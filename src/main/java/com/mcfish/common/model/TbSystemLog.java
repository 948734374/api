package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_log")
public class TbSystemLog {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 管理员账号
     */
    private String username;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作内容
     */
    private String desc;

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
     * 获取管理员账号
     *
     * @return username - 管理员账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置管理员账号
     *
     * @param username 管理员账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取操作内容
     *
     * @return desc - 操作内容
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置操作内容
     *
     * @param desc 操作内容
     */
    public void setDesc(String desc) {
        this.desc = desc;
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