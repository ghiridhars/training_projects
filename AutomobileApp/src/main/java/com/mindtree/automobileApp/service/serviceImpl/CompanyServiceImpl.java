package com.mindtree.automobileApp.service.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.automobileApp.dto.CompanyDto;
import com.mindtree.automobileApp.dto.ModelDto;
import com.mindtree.automobileApp.entity.Company;
import com.mindtree.automobileApp.exception.ServiceException;
import com.mindtree.automobileApp.exception.DaoException.InvalidCompanyException;
import com.mindtree.automobileApp.repository.CompanyRepo;
import com.mindtree.automobileApp.repository.ModelRepo;
import com.mindtree.automobileApp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private ModelRepo modelRepo;

	ModelMapper mapper = new ModelMapper();

	public CompanyDto entityToDto(Company m) {
		return mapper.map(m, CompanyDto.class);
	}

	public Company dtoToEntity(CompanyDto mDto) {
		return mapper.map(mDto, Company.class);
	}

	public List<CompanyDto> entityToDto(List<Company> m) {
		return m.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public List<Company> dtoToEntity(List<CompanyDto> mDto) {
		return mDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	@Override
	public List<CompanyDto> getAllCompanies() throws ServiceException {
		List<CompanyDto> cList = null;
		try {
			cList = entityToDto(companyRepo.findAll());
			cList.sort(new Comparator<CompanyDto>() {
				@Override
				public int compare(CompanyDto o1, CompanyDto o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return cList;
	}

	@Override
	public CompanyDto addCompany(CompanyDto cDto) throws ServiceException {
		Company c = null;
		try {
			c = dtoToEntity(cDto);
			companyRepo.save(c);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return entityToDto(c);

	}

	@Override
	public CompanyDto getSortedCompanies(String color, String name) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public CompanyDto getSortedCompanies(String color, String name) throws ServiceException {
//		List<CompanyDto> cList = null;
//		CompanyDto res= null;
//		try {
//			cList = getAllCompanies();
//			Company c = companyRepo.findByName(name)
//					.orElseThrow(() -> new InvalidCompanyException("Company not found"));
//			
//			res = cList.stream()
//					.filter(x-> x.getName().equalsIgnoreCase(name))
//					.filter((model) -> {
//						boolean validC = false;
//						List<Model> mList = model.getModels();
//						for(ModelDto mod: mList) {
//							if(mod.getColor().equalsIgnoreCase(color)) {
//								validC = true;
//								System.out.println(mList);
//							}
//							else {
//								mList.remove(mod);
//								break;
//							}
//						}
//						return validC;
//					})
//					.findAny().orElseThrow(() -> new InvalidCompanyException("Company with specified constraints not found"));
//						
//		} catch (ServiceException e) {
//			throw new ServiceException(e.getMessage(), e);
//		}
//		
//
//		return res;
//
//	}

}
