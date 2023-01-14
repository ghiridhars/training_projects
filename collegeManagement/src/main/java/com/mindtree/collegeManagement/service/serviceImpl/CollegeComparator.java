package com.mindtree.collegeManagement.service.serviceImpl;


import java.util.Comparator;

import com.mindtree.collegeManagement.dto.CollegeDto;
import com.mindtree.collegeManagement.entity.College;

public class CollegeComparator implements Comparator<College>{
	
	@Override
	public int compare(College s1, College s2) {
		int val = s1.getStrength() - s2.getStrength();
		if(val == 0)
			val = s1.getCollegeName().compareTo(s2.getCollegeName());
		return val;
	}


}
