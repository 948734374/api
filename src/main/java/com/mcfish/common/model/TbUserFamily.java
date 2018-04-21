package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_family")
public class TbUserFamily {
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
     * 家庭名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 家庭头像
     */
    private String head;

    /**
     * 家庭简述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 是否接受新成员 0-接受 1-不接受
     */
    private Byte accpet;

    /**
     * 状态 0-有效 1-无效
     */
    @Column(name = "`status`")
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
     * 获取家庭名称
     *
     * @return name - 家庭名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置家庭名称
     *
     * @param name 家庭名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取家庭头像
     *
     * @return head - 家庭头像
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置家庭头像
     *
     * @param head 家庭头像
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取家庭简述
     *
     * @return desc - 家庭简述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置家庭简述
     *
     * @param desc 家庭简述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取是否接受新成员 0-接受 1-不接受
     *
     * @return accpet - 是否接受新成员 0-接受 1-不接受
     */
    public Byte getAccpet() {
        return accpet;
    }

    /**
     * 设置是否接受新成员 0-接受 1-不接受
     *
     * @param accpet 是否接受新成员 0-接受 1-不接受
     */
    public void setAccpet(Byte accpet) {
        this.accpet = accpet;
    }

    /**
     * 获取状态 0-有效 1-无效
     *
     * @return status - 状态 0-有效 1-无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-有效 1-无效
     *
     * @param status 状态 0-有效 1-无效
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