package com.mindtree.franchise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.franchise.dto.TeamDto;
import com.mindtree.franchise.exception.FranchiseServiceException;

@Service
public interface TeamService {
	
	public List<TeamDto> getAllTeams()throws FranchiseServiceException;
	
	public TeamDto addTeam(TeamDto p)throws FranchiseServiceException;

}
