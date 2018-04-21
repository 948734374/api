package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_family_moment")
public class TbUserFamilyMoment {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 家庭id
     */
    @Column(name = "family_id")
    private Integer familyId;

    /**
     * 资源所属用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源类型 0-图片  1-视频
     */
    private Byte type;

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
     * 获取家庭id
     *
     * @return family_id - 家庭id
     */
    public Integer getFamilyId() {
        return familyId;
    }

    /**
     * 设置家庭id
     *
     * @param familyId 家庭id
     */
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    /**
     * 获取资源所属用户id
     *
     * @return user_id - 资源所属用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置资源所属用户id
     *
     * @param userId 资源所属用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取资源地址
     *
     * @return url - 资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源地址
     *
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取资源类型 0-图片  1-视频
     *
     * @return type - 资源类型 0-图片  1-视频
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置资源类型 0-图片  1-视频
     *
     * @param type 资源类型 0-图片  1-视频
     */
    public void setType(Byte type) {
        this.type = type;
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