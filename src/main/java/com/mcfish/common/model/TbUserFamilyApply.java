package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_family_apply")
public class TbUserFamilyApply {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator="JDBC")
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
     * 备注信息
     */
    private String comment;

    /**
     * 状态 0-待同意  1-同意  2-拒绝 3-过期
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
     * 获取状态 0-待同意  1-同意  2-拒绝 3-过期
     *
     * @return status - 状态 0-待同意  1-同意  2-拒绝 3-过期
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-待同意  1-同意  2-拒绝 3-过期
     *
     * @param status 状态 0-待同意  1-同意  2-拒绝 3-过期
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