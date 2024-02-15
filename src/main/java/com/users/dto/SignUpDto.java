package com.users.dto;

public class SignUpDto {
	private String name;
	private String mailId;
	private String password;
	private String confirmPass;
	
	public SignUpDto(String name, String mailId, String password,String confirmPass) {
		super();
		this.name = name;
		this.mailId = mailId;
		this.password = password;
		this.confirmPass=confirmPass;
	}
	
	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
