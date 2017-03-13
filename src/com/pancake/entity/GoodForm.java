package com.pancake.entity;

import java.util.List;

public class GoodForm {
	private int goodId;
	private String userName;
	private String goodName;
	private Double price;
	private List pictures;
	private Double freight;
	private int status;
	private String classificationNameString;

	public GoodForm() {
	}

	public GoodForm(String userName, Double price, List pictures, Double freight) {
		super();
		this.userName = userName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	public GoodForm(String userName, String goodName, Double price, List pictures, Double freight) {
		super();
		this.userName = userName;
		this.goodName = goodName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	public GoodForm(int goodId, String userName, String goodName, Double price, List pictures, Double freight,
			int status) {
		super();
		this.goodId = goodId;
		this.userName = userName;
		this.goodName = goodName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.status = status;
	}

	/**
	 * @param goodId
	 * @param userName
	 * @param goodName
	 * @param price
	 * @param pictures
	 * @param freight
	 * @param status
	 * @param classificationNameString
	 */
	public GoodForm(int goodId, String userName, String goodName, Double price, List pictures, Double freight,
			int status, String classificationNameString) {
		super();
		this.goodId = goodId;
		this.userName = userName;
		this.goodName = goodName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.status = status;
		this.classificationNameString = classificationNameString;
	}

	@Override
	public String toString() {
		return "GoodForm [goodId=" + goodId + ", userName=" + userName + ", goodName=" + goodName + ", price=" + price
				+ ", pictures=" + pictures + ", freight=" + freight + ", status=" + status
				+ ", classificationNameString=" + classificationNameString + "]";
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List getPictures() {
		return pictures;
	}

	public void setPictures(List pictures) {
		this.pictures = pictures;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getClassificationNameString() {
		return classificationNameString;
	}

	public void setClassificationNameString(String classificationNameString) {
		this.classificationNameString = classificationNameString;
	}

}
