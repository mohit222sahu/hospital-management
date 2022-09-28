package com.innoeye.hospitalmanagementsystem.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_details")
public class RoomDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	@Column(name = "room_no")
	private Integer roomNo;

	@Column(name = "room_type")
	private String roomType;

	@Column(name = "price")
	private Integer price;
	
	@Column(name = "is_booked")
	private Boolean isBooked;


	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomId(Integer roomId) {
		this.roomNo = roomId;
	}

	public RoomDetails(Integer roomNo, String room_type, Integer price, Boolean is_booked) {
		super();
		this.roomNo = roomNo;
		this.roomType = room_type;
		this.price = price;
		this.isBooked = is_booked;
	}

	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String room_type) {
		this.roomType = room_type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean is_booked) {
		this.isBooked = is_booked;
	}

}
								