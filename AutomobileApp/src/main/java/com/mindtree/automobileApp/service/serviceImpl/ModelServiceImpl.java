package com.mindtree.automobileApp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.automobileApp.dto.ModelDto;
import com.mindtree.automobileApp.entity.Company;
import com.mindtree.automobileApp.entity.Model;
import com.mindtree.automobileApp.exception.ServiceException;
import com.mindtree.automobileApp.exception.DaoException.InvalidCompanyException;
import com.mindtree.automobileApp.repository.CompanyRepo;
import com.mindtree.automobileApp.repository.ModelRepo;
import com.mindtree.automobileApp.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	private CompanyRepo companyRepo;

	ModelMapper mapper = new ModelMapper();

	public ModelDto entityToDto(Model m) {
		return mapper.map(m, ModelDto.class);
	}

	public Model dtoToEntity(ModelDto mDto) {
		return mapper.map(mDto, Model.class);
	}

	public List<ModelDto> entityToDto(List<Model> m) {
		return m.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public List<Model> dtoToEntity(List<ModelDto> mDto) {
		return mDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	@Override
	public ModelDto addModel(ModelDto mDto, String name) throws ServiceException {

		Model m = null;
		try {
			m = dtoToEntity(mDto);

			Company c = companyRepo.findByName(name)
					.orElseThrow(() -> new InvalidCompanyException("Company Name not Found"));

			m.setCompany(c);
			m = modelRepo.save(m);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return entityToDto(m);

	}

	@Override
	public List<ModelDto> getAllModels() throws ServiceException {

		List<ModelDto> cList = null;
		try {
			cList = entityToDto(modelRepo.findAll());
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return cList;

	}

	@Override
	public Optional<Float> getAverage(String name) throws ServiceException {

		Optional<Float> avg = null;
		try {
			Company c = companyRepo.findByName(name)
					.orElseThrow(() -> new InvalidCompanyException("Company Name not Found"));

			List<Model> model = c.getModels();

			List<Float> prices = new ArrayList<>();
			for (Model m : model) {
				prices.add(m.getPrice());
			}

			avg = prices.stream().reduce((a, b) -> a + b);
			int count = prices.size();

			avg = avg.map(x -> x / count);

		} catch (InvalidCompanyException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return avg;

	}

	@Override
	public List<ModelDto> getSortedModels(String color, String name) throws ServiceException {
		List<ModelDto> mList = null;

		try {
			Company c = companyRepo.findByName(name)
					.orElseThrow(() -> new InvalidCompanyException("Comapny not found"));
			mList = getAllModels();
			mList = mList.stream().filter(x -> x.getCompany().getName().equalsIgnoreCase(name))
					.filter(x -> x.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return mList;

	}

}
