package com.mindtree.teamApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.teamApp.dto.PlayerDto;
import com.mindtree.teamApp.dto.TeamDto;
import com.mindtree.teamApp.exception.FranchiseServiceException;

@Service
public interface TeamService {
	
	public List<TeamDto> getAllTeams()throws FranchiseServiceException;
	
	public TeamDto addTeam(TeamDto p)throws FranchiseServiceException;

}
