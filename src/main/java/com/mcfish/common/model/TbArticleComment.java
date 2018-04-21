package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article_comment")
public class TbArticleComment {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 帖子id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取评论用户
     *
     * @return user_id - 评论用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评论用户
     *
     * @param userId 评论用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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