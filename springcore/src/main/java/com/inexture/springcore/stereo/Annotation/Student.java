package com.inexture.springcore.stereo.Annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//To get an object using annotation @Component is used
@Component("jemy")
//To change the scope of bean @Scope annoatation is used
@Scope("prototype")
public class Student {

	@Value("12")
	private int studentId;
	@Value("Jemy Dalsaniya")
	private String studentName;
	@Value("#{temp}")
	private List<String> studentAddress;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<String> getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(List<String> studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentName() {
		return studentName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}

}
