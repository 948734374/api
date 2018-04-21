package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_message")
public class TbUserMessage {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Integer id;

    /**
     * 创建者
     */
    private Integer creater;
    
    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 业务id
     */
    private String data;

    /**
     * 消息类型 0-平台消息 1-家庭邀请消息
     */
    private Byte type;

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
     * 获取消息标题
     *
     * @return title - 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置消息标题
     *
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取消息内容
     *
     * @return content - 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     *
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取链接地址
     *
     * @return url - 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     *
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取业务id
     *
     * @return data - 业务id
     */
    public String getData() {
        return data;
    }

    /**
     * 设置业务id
     *
     * @param data 业务id
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 获取消息类型 0-平台消息 1-家庭邀请消息
     *
     * @return type - 消息类型 0-平台消息 1-家庭邀请消息
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置消息类型 0-平台消息 1-家庭邀请消息
     *
     * @param type 消息类型 0-平台消息 1-家庭邀请消息
     */
    public void setType(Byte type) {
        this.type = type;
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

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}
}