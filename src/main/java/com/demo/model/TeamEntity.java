package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name="teams")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("teamId")
	private String teamId;
	
	@Column(name="team_name")
	@JsonProperty("teamName")
	private String teamName;
	
	@Column(name="developers")
	@JsonProperty("developers")
	@OneToMany(mappedBy = "teamsId")
	private List<DevelopersEntity> developersEntityList;
}
