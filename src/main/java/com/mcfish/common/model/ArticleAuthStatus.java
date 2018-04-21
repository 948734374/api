package com.mcfish.common.model;

public class ArticleAuthStatus {
	/**
	 * 是否存在
	 */
	private Byte exist;
	/**
	 * 是否是作者，0-不是 1-是,-1-沒有关联数据
	 */
	private Byte isAuthor;
	
	/**
	 * 状态： 0-正常 1-冻结，-1-沒有关联数据
	 */
	private Byte status;
	
	/**
	 * 是否有权查看
	 */
	private Byte haveAuth;

	public Byte getExist() {
		return exist;
	}

	public void setExist(Byte exist) {
		this.exist = exist;
	}

	public Byte getIsAuthor() {
		return isAuthor;
	}

	public void setIsAuthor(Byte isAuthor) {
		this.isAuthor = isAuthor;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getHaveAuth() {
		return haveAuth;
	}

	public void setHaveAuth(Byte haveAuth) {
		this.haveAuth = haveAuth;
	}
	
}
