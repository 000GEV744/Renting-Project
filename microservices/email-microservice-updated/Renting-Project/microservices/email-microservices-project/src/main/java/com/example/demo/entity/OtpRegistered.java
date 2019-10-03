package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OtpRegistered {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Email
	@Column(nullable = false, unique = true)
	private String to;
	private String otp;
	private long timeStamp;
	
	public OtpRegistered(@Email String to, String otp, long timeStamp) {
		super();
		this.to = to;
		this.otp = otp;
		this.timeStamp = timeStamp;
	}
	
	
}
