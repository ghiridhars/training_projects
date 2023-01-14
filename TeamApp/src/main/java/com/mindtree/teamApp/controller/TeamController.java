package com.mindtree.teamApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.teamApp.dto.TeamDto;
import com.mindtree.teamApp.exception.FranchiseAppException;
import com.mindtree.teamApp.exception.FranchiseServiceException;
import com.mindtree.teamApp.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(method = RequestMethod.GET, value = "/addTeam")
	public String addCountry() {
		return "addTeam";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showTeam")
	public String showCountry(@ModelAttribute("team") TeamDto cDto, BindingResult br, Model m) throws FranchiseAppException {

		try {
			if (!br.hasErrors()) {
				
				teamService.addTeam(cDto);
				return "redirect:getAllTeam";
			} else {
				m.addAttribute("errors", br.getAllErrors());
				return "errors";
			}
		} catch (FranchiseServiceException e) {
			e.printStackTrace();
			throw new FranchiseAppException(e.getMessage(),e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllTeam")
	public String getAllEmployees(Model m) throws FranchiseAppException {
		System.out.println("Getting all Teams");
		try {
			System.out.println(teamService.getAllTeams());
			m.addAttribute("teamList", teamService.getAllTeams());
			return "getTeam";
		} catch (FranchiseServiceException e) {
			e.printStackTrace();
			throw new FranchiseAppException(e.getMessage(),e);
		}
	}

}