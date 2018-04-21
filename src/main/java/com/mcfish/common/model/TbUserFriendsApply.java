package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_friends_apply")
public class TbUserFriendsApply {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 主用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 申请人id
     */
    @Column(name = "apply_id")
    private Integer applyId;

    /**
     * 申请备注
     */
    private String comment;

    /**
     * 状态 0-待同意 1-同意 2-拒绝 3-过期
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
     * 获取主用户id
     *
     * @return user_id - 主用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置主用户id
     *
     * @param userId 主用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取申请人id
     *
     * @return apply_id - 申请人id
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * 设置申请人id
     *
     * @param applyId 申请人id
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * 获取申请备注
     *
     * @return comment - 申请备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置申请备注
     *
     * @param comment 申请备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取状态 0-待同意 1-同意 2-拒绝 3-过期
     *
     * @return status - 状态 0-待同意 1-同意 2-拒绝 3-过期
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-待同意 1-同意 2-拒绝 3-过期
     *
     * @param status 状态 0-待同意 1-同意 2-拒绝 3-过期
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