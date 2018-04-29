package org.nrj.secondary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="COMPUTER")
public class Computer {
	
	@Id
	@Column(name="COMP_ID")
	private Integer compId;
	
	@Column(name="COMP_BRAND")
	private String compBrand;
	
	@Column(name="COMP_MODEL")
	private String compModel;
	
	@Column(name="COMP_TYPE")
	private String compType;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCompBrand() {
		return compBrand;
	}

	public void setCompBrand(String compBrand) {
		this.compBrand = compBrand;
	}

	public String getCompModel() {
		return compModel;
	}

	public void setCompModel(String compModel) {
		this.compModel = compModel;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

}
