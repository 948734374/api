package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_chat_member")
public class TbUserChatMember {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 房间id
     */
    @Column(name = "chat_id")
    private Integer chatId;

    /**
     * 成员id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 备注名
     */
    @Column(name = "pet_name")
    private String petName;

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
     * 获取房间id
     *
     * @return chat_id - 房间id
     */
    public Integer getChatId() {
        return chatId;
    }

    /**
     * 设置房间id
     *
     * @param chatId 房间id
     */
    public void setChatId(Integer chatId) {
        this.chatId = chatId;
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
     * 获取备注名
     *
     * @return pet_name - 备注名
     */
    public String getPetName() {
        return petName;
    }

    /**
     * 设置备注名
     *
     * @param petName 备注名
     */
    public void setPetName(String petName) {
        this.petName = petName;
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