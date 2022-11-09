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
	private String room_type;

	@Column(name = "price")
	private Integer price;
	
	@Column(name = "is_booked")
	private Boolean is_booked;



	


	public Integer getRoomNo() {
		return roomNo;
	}



	public void setRoomId(Integer roomId) {
		this.roomNo = roomId;
	}



	public RoomDetails(Integer roomNo, String room_type, Integer price, Boolean is_booked) {
		super();
		this.roomNo = roomNo;
		this.room_type = room_type;
		this.price = price;
		this.is_booked = is_booked;
	}



	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getRoom_type() {
		return room_type;
	}



	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public Boolean getIs_booked() {
		return is_booked;
	}



	public void setIs_booked(Boolean is_booked) {
		this.is_booked = is_booked;
	}

	
	
	
	

}
								