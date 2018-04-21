package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_chat_group")
public class TbUserChatGroup {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 创建者
     */
    private Integer creater;

    /**
     * 房间id
     */
    private String room;

    /**
     * 群名
     */
    private String name;

    /**
     * 聊天室头像
     */
    private String head;

    /**
     * 消息免打扰 0-开启 1-关闭
     */
    @Column(name = "is_quiet")
    private Byte isQuiet;

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
     * 获取创建者
     *
     * @return creater - 创建者
     */
    public Integer getCreater() {
        return creater;
    }

    /**
     * 设置创建者
     *
     * @param creater 创建者
     */
    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    /**
     * 获取房间id
     *
     * @return room - 房间id
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置房间id
     *
     * @param room 房间id
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取群名
     *
     * @return name - 群名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置群名
     *
     * @param name 群名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取聊天室头像
     *
     * @return head - 聊天室头像
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置聊天室头像
     *
     * @param head 聊天室头像
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取消息免打扰 0-开启 1-关闭
     *
     * @return is_quiet - 消息免打扰 0-开启 1-关闭
     */
    public Byte getIsQuiet() {
        return isQuiet;
    }

    /**
     * 设置消息免打扰 0-开启 1-关闭
     *
     * @param isQuiet 消息免打扰 0-开启 1-关闭
     */
    public void setIsQuiet(Byte isQuiet) {
        this.isQuiet = isQuiet;
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
     * 设置状态 0-正常 1-无效
     *
     * @param status 状态 0-正常 1-无效
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