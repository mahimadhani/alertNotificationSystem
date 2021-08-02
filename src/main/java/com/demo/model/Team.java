package com.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Team {
	private String teamId;
	private String teamName;
	private List<Developers> developersList;
}
