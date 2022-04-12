package com.codeplanet;

import org.springframework.web.multipart.MultipartFile;

public class UserModel {

	private String psw;
	private String fname;
	private String email;
	private String lname;
	private String country;
	private String phone;
    private  MultipartFile userFile;
	
	
	
	
	public MultipartFile getUserFile() {
		return userFile;
	}
	public void setUserFile(MultipartFile userFile) {
		this.userFile = userFile;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
