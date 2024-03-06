package com.hibernate.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "HOUSE_NO")
	private int houseno;
	@Column(name="CITY",length = 50)
	private String city;
	private String state;
	private String streetString;
	@Lob
	private byte[] image;
	private boolean isempty;
	@Transient
	private double x;
	public Address(int houseno, String city, String state, String streetString, byte[] image, boolean isempty, double x,
			Date date) {
		super();
		this.houseno = houseno;
		this.city = city;
		this.state = state;
		this.streetString = streetString;
		this.image = image;
		this.isempty = isempty;
		this.x = x;
		this.date = date;
	}

	@Temporal(TemporalType.DATE)
	private Date date;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetString() {
		return streetString;
	}

	public void setStreetString(String streetString) {
		this.streetString = streetString;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public boolean isIsempty() {
		return isempty;
	}

	public void setIsempty(boolean isempty) {
		this.isempty = isempty;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", city=" + city + ", state=" + state + ", streetString=" + streetString
				+ ", image=" + Arrays.toString(image) + ", isempty=" + isempty + ", x=" + x + ", date=" + date + "]";
	}
}
