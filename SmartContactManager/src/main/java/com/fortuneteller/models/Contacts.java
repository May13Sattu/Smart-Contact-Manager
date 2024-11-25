package com.fortuneteller.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Contact_Master")
public class Contacts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	private String contactName;
	private String contactNickName;
	private String contactWork;
	private String contactMobileNumber;
	private String contactEmail;
	@Column(length = 5000)
	private String contactAbout;
	private String contactImgURL;
	
	@ManyToOne
	private User user;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNickName() {
		return contactNickName;
	}
	public void setContactNickName(String contactNickName) {
		this.contactNickName = contactNickName;
	}
	public String getContactWork() {
		return contactWork;
	}
	public void setContactWork(String contactWork) {
		this.contactWork = contactWork;
	}
	public String getContactMobileNumber() {
		return contactMobileNumber;
	}
	public void setContactMobileNumber(String contactMobileNumber) {
		this.contactMobileNumber = contactMobileNumber;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactAbout() {
		return contactAbout;
	}
	public void setContactAbout(String contactAbout) {
		this.contactAbout = contactAbout;
	}
	public String getContactImgURL() {
		return contactImgURL;
	}
	public void setContactImgURL(String contactImgURL) {
		this.contactImgURL = contactImgURL;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
