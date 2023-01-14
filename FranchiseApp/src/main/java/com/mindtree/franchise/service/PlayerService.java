package com.mindtree.franchise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.franchise.dto.PlayerDto;
import com.mindtree.franchise.exception.FranchiseServiceException;

@Service
public interface PlayerService {
	
	public List<PlayerDto> getAllPlayers()throws FranchiseServiceException;
	
	public PlayerDto addPlayerByTeam(PlayerDto p)throws FranchiseServiceException;
	

}
