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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="User_Master")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotBlank(message = "Name should not be blank")
	@Size(min = 2 , max = 45, message = "2 to 45 character are allowed only") 
	private String userName;
	@Column(unique = true)
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", 
	message = "Please enter a valid email address")
	private String userEmail;
	@Column(unique = true)
	private String userUserName;
	private String userImgURL;
	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
     message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit, and one special character.")
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userUserName="
				+ userUserName + ", userImgURL=" + userImgURL + ", userPassword=" + userPassword + ", userRole="
				+ userRole + ", userDiscription=" + userDiscription + ", is_user_active=" + is_user_active
				+ ", userPhoneNumber=" + userPhoneNumber + ", contactList=" + contactList + "]";
	}
	
	
}
