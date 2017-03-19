package com.jobll.web.email;

public class Email {
	 private String subject;
	 private String content;
	 private String regdate;
	 private String reciver;
	 
	 public Email() {}
	 
	 public Email(String subject, String content, String regdate, String reciver) {
	  this.subject = subject;
	  this.content = content;
	  this.regdate = regdate;
	  this.reciver = reciver;
	 }
	 
	 public String getSubject() {
	  return subject;
	 }
	 public void setSubject(String subject) {
	  this.subject = subject;
	 }
	 public String getContent() {
	  return content;
	 }
	 public void setContent(String content) {
	  this.content = content;
	 }
	 public String getRegdate() {
	  return regdate;
	 }
	 public void setRegdate(String regdate) {
	  this.regdate = regdate;
	 }
	 public String getReciver() {
	  return reciver;
	 }
	 public void setReciver(String reciver) {
	  this.reciver = reciver;
	 }
	}