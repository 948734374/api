package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_family_member")
public class TbUserFamilyMember {
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
     * 成员id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 身份位 0-普通成员  1-管理员
     */
    private Byte identity;

    /**
     * 关系
     */
    private String relationship;

    /**
     * 状态 0-正常 1-无效
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
     * 获取成员id
     *
     * @return user_id - 成员id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置成员id
     *
     * @param userId 成员id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取身份位 0-普通成员  1-管理员   2-等待成员确认
     *
     * @return identity - 身份位 0-普通成员  1-管理员
     */
    public Byte getIdentity() {
        return identity;
    }

    /**
     * 设置身份位 0-普通成员  1-管理员
     *
     * @param identity 身份位 0-普通成员  1-管理员
     */
    public void setIdentity(Byte identity) {
        this.identity = identity;
    }

    /**
     * 获取关系
     *
     * @return relationship - 关系
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * 设置关系
     *
     * @param relationship 关系
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * 获取状态 0-正常 1-无效
     *
     * @return status - 状态 0-正常 1-无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-正常 1-无效 2-等待成员确认
     *
     * @param status 状态 0-正常 1-无效 2-等待成员确认
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