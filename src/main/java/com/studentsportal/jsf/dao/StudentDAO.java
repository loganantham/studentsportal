package com.studentsportal.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentsportal.jsf.pojo.Student;
import com.studentsportal.jsf.util.DataConnect;

public class StudentDAO {
	
	public static Student getStudentProfile(String registrationNumber) {
		Connection con = null;
		PreparedStatement ps = null;
		Student student = new Student();
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select name, year, contact_number, registration_number,id from Students where registration_number = ?");
			ps.setString(1, registrationNumber);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Student Result Set Matched!!!");
				student.setName(rs.getString(1));
				student.setYear(rs.getString(2));
				student.setContactNumber(rs.getString(3));
				student.setRegistrationNumber(rs.getString(4));
				student.setId(rs.getInt(5));
			}
		} catch (SQLException ex) {
			System.out.println("Fetch Student Details error -->" + ex.getMessage());
			return student;
		} finally {
			DataConnect.close(con);
		}
		return student;
	}

	public static void saveStudent(Student student) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnect.getConnection();
			String query = " insert into Students (name, year, contact_number, registration_number,id)"
			        + " values (?, ?, ?, ?, ?)";

			      ps = con.prepareStatement(query);
			      ps.setString (1, student.getName());
			      ps.setString (2, student.getYear());
			      ps.setString (3, student.getContactNumber());
			      ps.setString (4, student.getRegistrationNumber());
			      ps.setString (5, "1");
			      ps.execute();
		} catch (SQLException ex) {
			System.out.println("Save Student Details error -->" + ex.getMessage());
		} finally {
			DataConnect.close(con);
		}
	}

}
