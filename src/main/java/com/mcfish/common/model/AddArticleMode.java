package com.mcfish.common.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AddArticleMode {
	/**
	 * 标题
	 */
	@NotBlank(message="文章标题不能为空")
	private String title;
	
	/**
	 * 内容
	 */
	@NotBlank(message="文章内容不能为空")
	private String content;
	/**
	 * 链接
	 */
	private String url;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 经度
	 */
	private Double lng;
	/**
	 * 纬度
	 */
	private Double lat;
	/**
	 * 标签
	 */
	private String tag;
	
	/**
	 * 文章权限类型
	 */
	@NotNull(message="文章权限类型必填")
	private Byte rang;
	
	/**
	 * 文章类型：类型 0-原创 1-转发
	 */
	@NotNull(message="文章类型必填")
	private Byte type;
	
	/**
	 * 原创帖子id
	 */
	private Integer originalArticleId;
	
	/**
	 * 应许查看的用户id,多个用英文逗号分开
	 */
	private String userids;
	
	/**
	 * 家庭id列表
	 */
	private String familyids;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Byte getRang() {
		return rang;
	}

	public void setRang(Byte rang) {
		this.rang = rang;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Integer getOriginalArticleId() {
		return originalArticleId;
	}

	public void setOriginalArticleId(Integer originalArticleId) {
		this.originalArticleId = originalArticleId;
	}

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	public String getFamilyids() {
		return familyids;
	}

	public void setFamilyids(String familyids) {
		this.familyids = familyids;
	}
}
