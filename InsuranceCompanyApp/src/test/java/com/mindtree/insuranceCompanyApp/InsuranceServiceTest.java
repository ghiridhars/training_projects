package com.mindtree.insuranceCompanyApp;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.insuranceCompanyApp.entity.Company;
import com.mindtree.insuranceCompanyApp.exception.CompanyServiceException;
import com.mindtree.insuranceCompanyApp.repository.CompanyRepository;
import com.mindtree.insuranceCompanyApp.service.CompanyService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InsuranceServiceTest {

	@Autowired
	CompanyRepository companyRepo;

	@Test
	public void testAddCompany() {
		Company c = new Company();
		companyRepo.save(c);		
		Assert.assertNotNull(c);
	}
	
//	@Test
//	public void testDeleteCompany() {
//		Company c = new Company();
//		companyRepo.save(c);		
//		Assert.assertNotNull(c);
//	}

}
