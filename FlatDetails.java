package com.cg.aps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Vedang
 * entity for flat details
 *
 */
@Entity
@Table(name = "flat_details_aps")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlatDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flatId;
	private Integer flatNo;
	private Integer floorNo;
}
