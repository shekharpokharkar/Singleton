package com.seleniumExpress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IOException, ClassNotFoundException {
		
		Student student=Student.getStudentInstance("shekhar","1012");
		System.out.println("Hashcode of student:"+student.hashCode());
//		Student student1=(Student)student.clone();
//		System.out.println("Hashcode of student1:"+student1.hashCode());
//		
		File foo=new File("Demo.txt");
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(foo));
		oos.writeObject(student);
		System.out.println("Serialization is done successfully");
		ObjectInputStream ios=new ObjectInputStream(new FileInputStream(foo));
		Student student2=(Student)ios.readObject();
		System.out.println("Hashcode of student2:"+student2.hashCode());
		
	}

}
