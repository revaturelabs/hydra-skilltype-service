package com.revature.beans;

import java.io.Serializable;

public class SkillType implements Serializable {

	private static final long serialVersionUID = 1886465103481784278L;

	private Integer skillTypeId;
	private String skillTypeName;
	private String skillTypeDescription;
	private Boolean isActive;

	public SkillType(int skillTypeId, String skillTypeName, Boolean isActive) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
		this.isActive = isActive;
	}

	public SkillType(Integer skillTypeId, String skillTypeName, String skillTypeDescription, Boolean isActive) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
		this.skillTypeDescription = skillTypeDescription;
		this.isActive = isActive;
	}

	public SkillType(SimpleSkillType st) {
		super();
		this.skillTypeId = st.getSkillTypeId();
		this.skillTypeName = st.getSkillTypeName();
		this.isActive = st.getIsActive();
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
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
		result = prime * result + ((skillTypeName == null) ? 0 : skillTypeName.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
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
		SkillType t = (SkillType) obj;
		if (this.skillTypeId == null) {
			if (t.getSkillTypeId() != null) {
				return false;
			}
		}
		if (this.skillTypeId != t.getSkillTypeId()) {
			return false;
		}

		if (this.skillTypeName == null) {
			if (t.getSkillTypeName() != null) {
				return false;
			}
		}
		if (this.skillTypeName.equals(t.getSkillTypeName())) {
			return false;
		}

		if (this.isActive == null) {
			if (t.isActive != null) {
				return false;
			}
		}
		if (this.isActive != t.getIsActive()) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "SkillType[skillTypeId=" + skillTypeId + ", skillTypeName=" + skillTypeName + ", isActive=" + isActive
				+ "]";
	}
}
