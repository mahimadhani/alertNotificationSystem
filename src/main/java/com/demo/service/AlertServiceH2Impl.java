package com.demo.service;


import com.demo.dao.AlertDaoDevelopersH2;
import com.demo.dao.AlertDaoH2;
import com.demo.model.Developers;
import com.demo.model.DevelopersEntity;
import com.demo.model.Team;
import com.demo.model.TeamEntity;
import com.demo.sender.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlertServiceH2Impl implements AlertServiceH2 {
	
	@Autowired
	private AlertDaoH2 alertDaoH2;
	
	@Autowired
	private AlertDaoDevelopersH2 alertDaoDevelopersH2;
	
	@Autowired
	private SendSms sendSms;
	
	@Override
	public List<DevelopersEntity> addTeam(TeamEntity team) {
		TeamEntity entity = alertDaoH2.save(team);
		if (!entity.getDevelopersEntityList().isEmpty()) {
			List<DevelopersEntity> developersEntityList = team.getDevelopersEntityList();
			if (!developersEntityList.isEmpty()) {
				
				for (DevelopersEntity dev : developersEntityList) {
					DevelopersEntity developersEntity = new DevelopersEntity();
					developersEntity.setName(dev.getName());
					developersEntity.setPhoneNumber(dev.getPhoneNumber());
					developersEntity.setTeamsId(team);
					alertDaoDevelopersH2.save(developersEntity);
				}
				return developersEntityList;
				
			}
			
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<Team> getAllTeamDetails() {
		Iterable<TeamEntity> teamEntities= alertDaoH2.findAll();
		Iterable<DevelopersEntity> developersEntities=alertDaoDevelopersH2.findAll();
		
		List<Team> teams=new ArrayList<>();
		List<Developers> developersList=new ArrayList<>();
		
		for(TeamEntity entity:teamEntities){
			Team t=new Team();
			t.setTeamId(entity.getTeamId());
			t.setTeamName(entity.getTeamName());
			for(DevelopersEntity devEntity:developersEntities){
				Developers d=new Developers();
				d.setTeamId(entity.getTeamId());
				d.setName(devEntity.getName());
				d.setPhoneNumber(devEntity.getPhoneNumber());
				d.setDevelopersId(devEntity.getDevelopersId());
				developersList.add(d);
			}
			t.setDevelopersList(developersList);
			teams.add(t);
		}
		return teams;
	}
	
	@Override
	public String sendSms(String teamId) {
		Optional<TeamEntity> teamEntity=alertDaoH2.findById(teamId);
		String teamIdForDev=teamEntity.get().getTeamId();
		Optional<DevelopersEntity> developersEntity=alertDaoDevelopersH2.findById(teamIdForDev);
		if(developersEntity.get().getTeamsId()!=null){
			List<DevelopersEntity> developersList=teamEntity.get().getDevelopersEntityList();
            DevelopersEntity dev = developersList.get(new Random().nextInt(developersList.size()));
			String phoneNumber=dev.getPhoneNumber();
			return sendSms.sendSms(phoneNumber);
		}
		return "Team Does Not Exist";
	}
}
