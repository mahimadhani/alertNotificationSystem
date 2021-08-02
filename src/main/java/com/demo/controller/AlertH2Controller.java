package com.demo.controller;

import com.demo.exception.TeamNotAddedException;
import com.demo.model.DevelopersEntity;
import com.demo.model.Team;
import com.demo.model.TeamEntity;
import com.demo.service.AlertServiceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertH2Controller {
	
	@Autowired
	private AlertServiceH2 alertServiceH2;
	
	@PostMapping("/teamH2")
	public ResponseEntity<Object> addTeam(@RequestBody @NonNull TeamEntity team){
		List<DevelopersEntity> developersList= alertServiceH2.addTeam(team);
		String teamId= team.getTeamId();
		if(developersList.isEmpty()) throw new TeamNotAddedException();
		return new ResponseEntity<>("{\n" +
				"team_id: "+teamId+" \n" +
				"}", HttpStatus.OK);
	}
	@GetMapping("/teamH2")
	public List<Team> getAllTeamDetails(){
		
		return alertServiceH2.getAllTeamDetails();
	}
	
	@PostMapping("/{teamId}/alert")
	public String sendSms(@PathVariable String teamId){
		return alertServiceH2.sendSms(teamId);
	}
}
