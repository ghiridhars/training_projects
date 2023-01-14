package com.mindtree.teamApp.controller;

import java.lang.StackWalker.Option;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.teamApp.dto.PlayerDto;
import com.mindtree.teamApp.dto.TeamDto;
import com.mindtree.teamApp.exception.FranchiseAppException;
import com.mindtree.teamApp.exception.FranchiseServiceException;
import com.mindtree.teamApp.exception.InvalidTeamException;
import com.mindtree.teamApp.service.PlayerService;
import com.mindtree.teamApp.service.TeamService;
import com.sun.el.stream.Optional;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	TeamService teamService;

	@Autowired
	PlayerService playerService;

	@RequestMapping(method = RequestMethod.GET, value = "/addPlayer")
	public String addPlayer(Model m) throws FranchiseAppException {
		try {
			m.addAttribute("teamList", teamService.getAllTeams());
		} catch (FranchiseServiceException e) {
			e.printStackTrace();
			throw new FranchiseAppException(e.getMessage(), e);
		}
		return "addPlayer";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showPlayer")
	public String showCountry(@ModelAttribute("player") PlayerDto cDto, BindingResult br, Model m)
			throws FranchiseAppException {

		try {
			if (!br.hasErrors()) {
				System.out.println(cDto);
				playerService.addPlayerByTeam(cDto);
				return "redirect:getAllPlayers";
			} else {
				m.addAttribute("errors", br.getAllErrors());
				return "errors";
			}
		} catch (FranchiseServiceException e) {
			e.printStackTrace();
			throw new FranchiseAppException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllPlayers")
	public String getAllEmployees(Model m) throws FranchiseAppException {
		System.out.println("Getting all t");
		return "getPlayers";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getFilteredPlayers")
	public String getFilteredEmployees(Model m) throws FranchiseAppException {
		System.out.println("Getting all t");
		return "getFilteredPlayers";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/error/{errorName}")
	public String error(@PathVariable String errorName) throws FranchiseAppException {
		throw new FranchiseAppException(errorName);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getPlayersByTeam/{name}")
	public List<PlayerDto> getPlayersByTeam(@PathVariable String name, Model m) throws FranchiseServiceException {
		List<PlayerDto> pList = null;
		pList = playerService.getPlayerByTeam(name);
		return pList;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getAverageAge/{name}")
	public Float getAverageAge(@PathVariable String name, Model m) throws FranchiseServiceException {
		float avg = 0.0f;
		avg = playerService.getAverageAge(name);
		return avg;
	}
	
}
