package com.seleniumExpress;

import java.io.Serializable;

public class Student implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Student student = null;

	private String studentName;
	private String studentId;

	private Student() {

		if (student != null) {
			throw new RuntimeException("use getStudentInstance Method of student class");
		}
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public static Student getStudentInstance(String studentName, String studentId) {
		if (student == null) {
			synchronized (Student.class) {
				if (student == null) {
					student = new Student();
					student.studentId = studentId;
					student.studentName = studentName;
				}
			}
		}

		return student;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Given student class is not supported for cloning");
	}

	// Ensures singleton during deserialization
	private Object readResolve() {
		return student;
	}
}
