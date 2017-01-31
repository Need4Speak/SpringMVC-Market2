package com.pancake.entity;

/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good implements java.io.Serializable {

	// Fields

	private Integer goodId;
	private User user;
	private String name;
	private Double price;
	private String pictures;
	private Double freight;
	private String description;
	private Integer status;

	// Constructors

	/** default constructor */
	public Good() {
	}

	/** minimal constructor */
	public Good(String name, Double price, String pictures, Double freight) {
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
	}

	/** full constructor */
	public Good(User user, String name, Double price, String pictures,
			Double freight, String description, Integer status) {
		this.user = user;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}