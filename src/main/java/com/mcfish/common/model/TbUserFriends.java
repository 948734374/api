package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_friends")
public class TbUserFriends {
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
     * 好友id
     */
    @Column(name = "friend_id")
    private Integer friendId;

    /**
     * 状态 0-有效  1-无效
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
     * 获取好友id
     *
     * @return friend_id - 好友id
     */
    public Integer getFriendId() {
        return friendId;
    }

    /**
     * 设置好友id
     *
     * @param friendId 好友id
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    /**
     * 获取状态 0-有效  1-无效
     *
     * @return status - 状态 0-有效  1-无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-有效  1-无效
     *
     * @param status 状态 0-有效  1-无效
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