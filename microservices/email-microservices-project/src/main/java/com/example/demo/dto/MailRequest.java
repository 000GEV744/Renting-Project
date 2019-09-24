package com.example.demo.dto;

import lombok.Data;

@Data
public class MailRequest {
	
	private String fname;
	private String lname;
	private String to;
	private String subject;
}
