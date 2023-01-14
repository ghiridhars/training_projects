package com.mindtree.teamApp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.teamApp.dto.PlayerDto;
import com.mindtree.teamApp.entity.Player;
import com.mindtree.teamApp.entity.Team;
import com.mindtree.teamApp.exception.FranchiseServiceException;
import com.mindtree.teamApp.exception.InvalidPlayerException;
import com.mindtree.teamApp.exception.InvalidTeamException;
import com.mindtree.teamApp.repository.PlayerRepository;
import com.mindtree.teamApp.repository.TeamRepository;
import com.mindtree.teamApp.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Autowired
	TeamRepository teamRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<PlayerDto> getAllPlayers() throws FranchiseServiceException {

		List<Player> pList = null;

		pList = playerRepo.findAll();

		return pList.stream()
				.map(x -> (mapper.map(x, PlayerDto.class)))
				.collect(Collectors.toList());

	}

	@Override
	public PlayerDto addPlayerByTeam(PlayerDto p) throws FranchiseServiceException {

		Team team = null;

		Player player = mapper.map(p, Player.class);
		
		int currentCount=0,max = 0;
		
		try {
			
			team = teamRepo.findById(p.getTeamId())
					.orElseThrow(() -> new InvalidTeamException("Team not found"));
			int id = team.gettId();
			currentCount = playerRepo.findAll()
					.stream().filter(x -> x.getTeam().gettId() == id)
					.collect(Collectors.toList()).size();

			max = team.getMaxLimit();
			
			System.out.println(max + " "+ currentCount);
			
			if(currentCount == max) {
				throw new InvalidPlayerException("Limit Reached for Team");
			}
			
			player.setTeam(team);
			player = playerRepo.save(player);
			team = teamRepo.save(team);
		} catch (InvalidTeamException e) {
			throw new FranchiseServiceException(e.getMessage(), e);
		}
		System.out.println("Added Details");
		return mapper.map(p, PlayerDto.class);

	}

	@Override
	public List<PlayerDto> getPlayerByTeam(String name) throws FranchiseServiceException {
		List<Player> pList = null;

		try {
			pList = playerRepo.findAll();

			pList = pList.stream()
					.filter(x -> x.getTeam().getName().equalsIgnoreCase(name))
					.collect(Collectors.toList());
			
			System.out.println(pList.size());

			if (pList.size() == 0)
				throw new InvalidTeamException("No players found for Team Name");
		} catch (InvalidTeamException e) {
			throw new FranchiseServiceException(e.getMessage(), e);
		}

		return pList.stream().map(x -> (mapper.map(x, PlayerDto.class)))
				.collect(Collectors.toList());

	}

	@Override
	public Float getAverageAge(String name) throws FranchiseServiceException {
		List<Player> pList = null;
		
		pList = playerRepo.findAll().stream()
				.filter(x -> x.getTeam().getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (pList.size() == 0)
			throw new InvalidTeamException("No players found for Team Name");
		
		List<Float> average = new ArrayList<>();
		for(Player p: pList) {
			average.add((float) p.getAge());
		}
		
		Optional<Float> sum = average.stream().reduce((x,y) -> x+y);
		int size = average.size();
		
		sum = sum.map(x -> x/size);
		System.out.println(sum);
		return sum.get();
	}
}
