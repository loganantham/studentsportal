package com.studentsportal.jsf.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.studentsportal.jsf.dao.StudentDAO;
import com.studentsportal.jsf.pojo.Student;

@ManagedBean
@ViewScoped
public class StudentController {
	
	private String studentControllerMessage;
	private int id;
	private String name;
	private String year;
	private String registrationNumber;
	private String contactNumber;
	
	@ManagedProperty(value="#{login}") 
	Login login;
	
	public void createStudentProfile() {
		Student student = new Student();
		student.setContactNumber(this.getContactNumber());
		student.setName(this.getName());
		student.setRegistrationNumber(this.getRegistrationNumber());
		student.setYear(this.getYear());
		StudentDAO.saveStudent(student);
		student = StudentDAO.getStudentProfile(login.getUser());
		if(student != null) {
			this.setContactNumber(student.getContactNumber());
			this.setName(student.getName());
			this.setRegistrationNumber(student.getRegistrationNumber());
			this.setYear(student.getYear());
			this.setId(student.getId());
		}
	}
	
	@PostConstruct
	public void fetchStudentDetails() {
		Student student = StudentDAO.getStudentProfile(login.getUser());
		if(student != null) {
			this.setContactNumber(student.getContactNumber());
			this.setName(student.getName());
			this.setRegistrationNumber(student.getRegistrationNumber());
			this.setYear(student.getYear());
			this.setId(student.getId());
		}
	}

	public String getStudentControllerMessage() {
		return studentControllerMessage;
	}

	public void setStudentControllerMessage(String studentControllerMessage) {
		this.studentControllerMessage = studentControllerMessage;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	

}
