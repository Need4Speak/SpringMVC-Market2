package com.pancake.entity;

import java.util.List;

public class GoodForm {
	private String userName;
	private String goodName;
	private Double price;
	private List pictures;
	private Double freight;

	public GoodForm() {
	}

	public GoodForm(String userName, Double price, List pictures, Double freight) {
		super();
		this.userName = userName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	public GoodForm(String userName, String goodName, Double price,
			List pictures, Double freight) {
		super();
		this.userName = userName;
		this.goodName = goodName;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	@Override
	public String toString() {
		return "GoodForm [userName=" + userName + ", goodName=" + goodName
				+ ", price=" + price + ", pictures=" + pictures + ", freight="
				+ freight + "]";
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

}
