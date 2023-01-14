package com.mindtree.teamApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.teamApp.dto.PlayerDto;
import com.mindtree.teamApp.exception.FranchiseServiceException;

@Service
public interface PlayerService {
	
	public List<PlayerDto> getAllPlayers()throws FranchiseServiceException;
	
	public PlayerDto addPlayerByTeam(PlayerDto p)throws FranchiseServiceException;
	
	public List<PlayerDto> getPlayerByTeam(String name)throws FranchiseServiceException;

	public Float getAverageAge(String name)throws FranchiseServiceException;

}
