package com.cg.aps.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Vedang
 * owner entity class and class has associations with delivery, domestic help, visitors,
 * alerts and vehicles
 *
 */
@Entity
@Table(name = "owners_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner {
	@Id
	private Integer ownerId;
	private String ownerName;
	private Long mobileNo;
	private String emailId;
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private Set<Delivery> deliverySet;
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private Set<DomesticHelp> helpSet;
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private Set<Visitor> visitorSet;
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private Set<Vehicle> vehicleSet;
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private Set<SecurityAlert> alertSet;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "flatId"),name = "flatId")
	@JsonIgnore
	private FlatDetails flatDetails;
	@OneToOne(mappedBy = "owner")
	@JsonIgnore
	private User user;
	/*
	 * public Owner(Integer ownerId, String ownerName, Long mobileNo, String
	 * emailId, User user) { super(); this.ownerId = ownerId; this.ownerName =
	 * ownerName; this.mobileNo = mobileNo; this.emailId = emailId; this.user =
	 * user; }
	 */
	
	
}
