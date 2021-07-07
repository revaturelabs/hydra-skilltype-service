package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_TYPE")
public class SimpleSkillType implements Serializable {

	private static final long serialVersionUID = -2921585672870839165L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_TYPE_SEQUENCE")
	@SequenceGenerator(name = "SKILL_TYPE_SEQUENCE", sequenceName = "SKILL_TYPE_SEQUENCE")
	@Column(name = "SKILL_TYPE_ID")
	private Integer skillTypeId;

	@Column(name = "SKILL_TYPE_NAME")
	private String skillTypeName;

	@Column(name = "SKILL_TYPE_DESCRIPTION")
	private String skillTypeDescription;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	public SimpleSkillType() {
		super();
	}

	public SimpleSkillType(int skillTypeId, String skillTypeName, Boolean isActive) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
		this.isActive = isActive;
	}

	public SimpleSkillType(Integer skillTypeId, String skillTypeName) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
	}

	public SimpleSkillType(String skillTypeName, String skillTypeDescription, Boolean isActive) {
		super();
		this.skillTypeName = skillTypeName;
		this.skillTypeDescription = skillTypeDescription;
		this.isActive = isActive;
	}

	public SimpleSkillType(SkillType t) {
		super();
		this.skillTypeId = t.getSkillTypeId();
		this.skillTypeName = t.getSkillTypeName();
		this.skillTypeDescription = t.getSkillTypeDescription();
		this.isActive = t.getIsActive();
	}

	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public String getSkillTypeName() {
		return skillTypeName;
	}

	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	public String getSkillTypeDescription() {
		return skillTypeDescription;
	}

	public void setSkillTypeDescription(String skillTypeDescription) {
		this.skillTypeDescription = skillTypeDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((skillTypeDescription == null) ? 0 : skillTypeDescription.hashCode());
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
		result = prime * result + ((skillTypeName == null) ? 0 : skillTypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleSkillType other = (SimpleSkillType) obj;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (skillTypeDescription == null) {
			if (other.skillTypeDescription != null)
				return false;
		} else if (!skillTypeDescription.equals(other.skillTypeDescription))
			return false;
		if (skillTypeId == null) {
			if (other.skillTypeId != null)
				return false;
		} else if (!skillTypeId.equals(other.skillTypeId))
			return false;
		if (skillTypeName == null) {
			if (other.skillTypeName != null)
				return false;
		} else if (!skillTypeName.equals(other.skillTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillType[skillTypeId=" + skillTypeId + ", skillTypeName=" + skillTypeName + ", isActive=" + isActive
				+ "]";
	}
}
