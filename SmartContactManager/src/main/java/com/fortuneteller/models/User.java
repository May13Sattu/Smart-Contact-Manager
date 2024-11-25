package com.fortuneteller.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Master")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	@Column(unique = true)
	private String userUserName;
	private String userImgURL;
	private String userPassword;
	private String userRole;
	@Column(length = 500)
	private String userDiscription;
	private boolean is_user_active;
	private String userPhoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Contacts> contactList = new ArrayList<Contacts>(); 
	
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserUserName() {
		return userUserName;
	}
	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}
	public String getUserImgURL() {
		return userImgURL;
	}
	public void setUserImgURL(String userImgURL) {
		this.userImgURL = userImgURL;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserDiscription() {
		return userDiscription;
	}
	public void setUserDiscription(String userDiscription) {
		this.userDiscription = userDiscription;
	}
	public boolean isIs_user_active() {
		return is_user_active;
	}
	public void setIs_user_active(boolean is_user_active) {
		this.is_user_active = is_user_active;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public List<Contacts> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contacts> contactList) {
		this.contactList = contactList;
	}
	
	
	
}
