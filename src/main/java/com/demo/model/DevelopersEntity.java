package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Table(name="developers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevelopersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("developersId")
	private String developersId;
	
	private String name;
	
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	private TeamEntity teamsId;
}
