package com.mindtree.franchise.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.franchise.dto.PlayerDto;
import com.mindtree.franchise.entity.Player;
import com.mindtree.franchise.exception.FranchiseServiceException;
import com.mindtree.franchise.repository.PlayerRepository;
import com.mindtree.franchise.service.PlayerService;

public class PlayerServiceImpl implements PlayerService  {

	@Autowired
	PlayerRepository playerRepo;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<PlayerDto> getAllPlayers() throws FranchiseServiceException {
		
		List<Player> pList = null;
		
		pList = playerRepo.findAll();
		
		return pList.stream().map(x -> (mapper.map(x, PlayerDto.class))).collect(Collectors.toList());
		
	}

	@Override
	public PlayerDto addPlayerByTeam(PlayerDto p) throws FranchiseServiceException {
		
		

	}
}
