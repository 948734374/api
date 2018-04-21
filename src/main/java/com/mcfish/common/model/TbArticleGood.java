package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article_good")
public class TbArticleGood {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 帖子id
     */
    @Column(name = "article_id")
    private Integer articleId;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取帖子id
     *
     * @return article_id - 帖子id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置帖子id
     *
     * @param articleId 帖子id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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