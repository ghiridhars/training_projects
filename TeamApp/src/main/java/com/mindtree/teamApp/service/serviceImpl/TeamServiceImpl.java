package com.mindtree.teamApp.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.teamApp.dto.TeamDto;
import com.mindtree.teamApp.entity.Team;
import com.mindtree.teamApp.exception.FranchiseServiceException;
import com.mindtree.teamApp.exception.InvalidTeamException;
import com.mindtree.teamApp.repository.TeamRepository;
import com.mindtree.teamApp.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<TeamDto> getAllTeams() throws FranchiseServiceException {
		List<Team> tList = null;

		tList = teamRepo.findAll();
		
		return tList.stream().map(x -> (mapper.map(x, TeamDto.class))).collect(Collectors.toList());
	}

	@Override
	public TeamDto addTeam(TeamDto p) throws FranchiseServiceException {
		Team team = null;

		try {
			team = mapper.map(p, Team.class);

			Team dupe = teamRepo.findAll()
					.stream()
					.filter(x -> x.getName().equals(p.getTeamName())).findAny()
					.orElse(null);
			
			System.out.println(dupe);

			if (dupe != null)
				throw new InvalidTeamException("Team already Present");
			else
				team = teamRepo.save(team);
		} catch (InvalidTeamException e) {
			throw new FranchiseServiceException(e.getMessage(), e);
		}

		return mapper.map(team, TeamDto.class);
	}

}
