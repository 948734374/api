package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_version")
public class TbSystemVersion {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * APP类型 0-Android 1-IOS
     */
    private Byte type;

    /**
     * 版本号
     */
    private String version;

    /**
     * 备注信息
     */
    private String comment;

    /**
     * 试调开关 0-正式 1-调试
     */
    @Column(name = "is_debug")
    private Byte isDebug;

    /**
     * 是否强制更新 0-否 1-是
     */
    @Column(name = "is_force")
    private Byte isForce;

    /**
     * 下载地址
     */
    private String download;

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
     * 获取APP类型 0-Android 1-IOS
     *
     * @return type - APP类型 0-Android 1-IOS
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置APP类型 0-Android 1-IOS
     *
     * @param type APP类型 0-Android 1-IOS
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取备注信息
     *
     * @return comment - 备注信息
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注信息
     *
     * @param comment 备注信息
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取试调开关 0-正式 1-调试
     *
     * @return is_debug - 试调开关 0-正式 1-调试
     */
    public Byte getIsDebug() {
        return isDebug;
    }

    /**
     * 设置试调开关 0-正式 1-调试
     *
     * @param isDebug 试调开关 0-正式 1-调试
     */
    public void setIsDebug(Byte isDebug) {
        this.isDebug = isDebug;
    }

    /**
     * 获取是否强制更新 0-否 1-是
     *
     * @return is_force - 是否强制更新 0-否 1-是
     */
    public Byte getIsForce() {
        return isForce;
    }

    /**
     * 设置是否强制更新 0-否 1-是
     *
     * @param isForce 是否强制更新 0-否 1-是
     */
    public void setIsForce(Byte isForce) {
        this.isForce = isForce;
    }

    /**
     * 获取下载地址
     *
     * @return download - 下载地址
     */
    public String getDownload() {
        return download;
    }

    /**
     * 设置下载地址
     *
     * @param download 下载地址
     */
    public void setDownload(String download) {
        this.download = download;
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