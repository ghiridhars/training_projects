package com.mindtree.collegeManagement.service.serviceImpl;

import java.util.Comparator;

import com.mindtree.collegeManagement.entity.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int val = s1.getAge() - s2.getAge();
		if (val == 0)
			val = s2.getName().compareTo(s1.getName());
		return val;
	}
}