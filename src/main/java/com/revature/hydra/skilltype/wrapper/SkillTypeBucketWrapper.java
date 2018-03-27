package com.revature.hydra.skilltype.wrapper;

import java.util.Arrays;

public class SkillTypeBucketWrapper {
	
	private Integer skillTypeId;
	private String skillTypeName;
	private Integer [] bucketIds;
	private Double [] weights;
	
	
	public SkillTypeBucketWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillTypeBucketWrapper(Integer skillTypeId, String skillTypeName, Integer[] bucketIds, Double[] weights) {
		super();
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
		this.bucketIds = bucketIds;
		this.weights = weights;
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
	public Integer[] getBucketIds() {
		return bucketIds;
	}
	public void setBucketIds(Integer[] bucketIds) {
		this.bucketIds = bucketIds;
	}
	public Double[] getWeights() {
		return weights;
	}
	public void setWeights(Double[] weights) {
		this.weights = weights;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bucketIds);
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
		result = prime * result + ((skillTypeName == null) ? 0 : skillTypeName.hashCode());
		result = prime * result + Arrays.hashCode(weights);
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
		SkillTypeBucketWrapper other = (SkillTypeBucketWrapper) obj;
		if (!Arrays.equals(bucketIds, other.bucketIds))
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
		if (!Arrays.equals(weights, other.weights))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SkillTypeBucketWrapper [skillTypeId=" + skillTypeId + ", skillTypeName=" + skillTypeName
				+ ", bucketIds=" + Arrays.toString(bucketIds) + ", weights=" + Arrays.toString(weights) + "]";
	}
	
	
}
