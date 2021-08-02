package com.demo.service;


import com.demo.model.DevelopersEntity;
import com.demo.model.Team;
import com.demo.model.TeamEntity;

import java.util.List;

public interface AlertServiceH2 {
	public List<DevelopersEntity> addTeam(TeamEntity team);
	public List<Team> getAllTeamDetails();
	public String sendSms(String teamId);
}
