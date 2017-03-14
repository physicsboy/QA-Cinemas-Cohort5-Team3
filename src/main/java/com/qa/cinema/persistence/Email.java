package com.qa.cinema.persistence;

public class Email {

    private String name;
    private String email;
    private String subject;
    private StringBuilder message;

    public Email(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = new StringBuilder();
        createEmail();
    }

    private void createEmail() {
    	setName(name);
    	setEmail(email);
    	setSubject(subject);
    	setMessage(message);
    	
        String head = "From: " + getName() + " Email Address: " + getEmail() + " \n";
        String subjectBody = "Concerning : " + getSubject() + " \n \n ";
        String messageBody = "Message : " + getMessage() + " \n \n";

        this.message.append(head + subjectBody + messageBody);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public StringBuilder getMessage() {
		return message;
	}

	public void setMessage(StringBuilder message) {
		this.message = message;
	}




}