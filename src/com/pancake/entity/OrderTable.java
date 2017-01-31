package com.pancake.entity;

import java.sql.Timestamp;

/**
 * OrderTable entity. @author MyEclipse Persistence Tools
 */

public class OrderTable implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer goodId;
	private Integer buyerId;
	private Integer sellerId;
	private Timestamp creationTime;
	private Timestamp cancelTime;
	private Integer status;
	private String deliveryAddress;
	private Double freight;
	private String description;

	// Constructors

	/** default constructor */
	public OrderTable() {
	}

	/** minimal constructor */
	public OrderTable(Integer goodId, Integer buyerId, Integer sellerId) {
		this.goodId = goodId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
	}

	/** full constructor */
	public OrderTable(Integer goodId, Integer buyerId, Integer sellerId,
			Timestamp creationTime, Timestamp cancelTime, Integer status,
			String deliveryAddress, Double freight, String description) {
		this.goodId = goodId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.creationTime = creationTime;
		this.cancelTime = cancelTime;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.freight = freight;
		this.description = description;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Timestamp cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
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

}