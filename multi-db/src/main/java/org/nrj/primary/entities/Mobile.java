package org.nrj.primary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="MOBILE")
public class Mobile {
	
	@Id
	@Column(name="MOB_ID")
	private Integer mobId;
	
	@Column(name="MOB_BRAND")
	private String mobBrand;
	
	@Column(name="MOB_MODEL")
	private String mobModel;
	
	@Column(name="MOB_MAKE")
	private String mobMake;

	public Integer getMobId() {
		return mobId;
	}

	public void setMobId(Integer mobId) {
		this.mobId = mobId;
	}

	public String getMobBrand() {
		return mobBrand;
	}

	public void setMobBrand(String mobBrand) {
		this.mobBrand = mobBrand;
	}

	public String getMobModel() {
		return mobModel;
	}

	public void setMobModel(String mobModel) {
		this.mobModel = mobModel;
	}

	public String getMobMake() {
		return mobMake;
	}

	public void setMobMake(String mobMake) {
		this.mobMake = mobMake;
	}
	
}
