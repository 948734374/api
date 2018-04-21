package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article_comment_reply")
public class TbArticleCommentReply {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 评论id
     */
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复用户id
     */
    @Column(name = "from_uid")
    private Integer fromUid;

    /**
     * 目标用户id
     */
    @Column(name = "to_uid")
    private Integer toUid;

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
     * 获取评论id
     *
     * @return comment_id - 评论id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     *
     * @param commentId 评论id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取回复内容
     *
     * @return content - 回复内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置回复内容
     *
     * @param content 回复内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取回复用户id
     *
     * @return from_uid - 回复用户id
     */
    public Integer getFromUid() {
        return fromUid;
    }

    /**
     * 设置回复用户id
     *
     * @param fromUid 回复用户id
     */
    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    /**
     * 获取目标用户id
     *
     * @return to_uid - 目标用户id
     */
    public Integer getToUid() {
        return toUid;
    }

    /**
     * 设置目标用户id
     *
     * @param toUid 目标用户id
     */
    public void setToUid(Integer toUid) {
        this.toUid = toUid;
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