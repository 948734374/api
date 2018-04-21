package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_admin")
public class TbSystemAdmin {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 头像
     */
    private String head;

    /**
     * 性别 0-男 1-女
     */
    private Byte sex;

    /**
     * 管理员类别 0-普通管理 1-超级管理员
     */
    private Byte type;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 查看菜单权限，如：100,101,102
     */
    private String views;

    /**
     * 编辑菜单权限，如：101,102
     */
    private String edits;

    /**
     * 备注信息
     */
    private String comment;

    /**
     * 状态 0-正常 1-冻结
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
     * 获取昵称
     *
     * @return name - 昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置昵称
     *
     * @param name 昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取头像
     *
     * @return head - 头像
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置头像
     *
     * @param head 头像
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取性别 0-男 1-女
     *
     * @return sex - 性别 0-男 1-女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别 0-男 1-女
     *
     * @param sex 性别 0-男 1-女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取管理员类别 0-普通管理 1-超级管理员
     *
     * @return type - 管理员类别 0-普通管理 1-超级管理员
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置管理员类别 0-普通管理 1-超级管理员
     *
     * @param type 管理员类别 0-普通管理 1-超级管理员
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取查看菜单权限，如：100,101,102
     *
     * @return views - 查看菜单权限，如：100,101,102
     */
    public String getViews() {
        return views;
    }

    /**
     * 设置查看菜单权限，如：100,101,102
     *
     * @param views 查看菜单权限，如：100,101,102
     */
    public void setViews(String views) {
        this.views = views;
    }

    /**
     * 获取编辑菜单权限，如：101,102
     *
     * @return edits - 编辑菜单权限，如：101,102
     */
    public String getEdits() {
        return edits;
    }

    /**
     * 设置编辑菜单权限，如：101,102
     *
     * @param edits 编辑菜单权限，如：101,102
     */
    public void setEdits(String edits) {
        this.edits = edits;
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
     * 获取状态 0-正常 1-冻结
     *
     * @return status - 状态 0-正常 1-冻结
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-正常 1-冻结
     *
     * @param status 状态 0-正常 1-冻结
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