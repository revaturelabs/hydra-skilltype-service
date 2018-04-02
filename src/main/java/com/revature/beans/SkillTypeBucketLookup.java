package com.revature.beans;

import java.io.Serializable;
import java.util.Arrays;

public class SkillTypeBucketLookup implements Serializable {

	private static final long serialVersionUID = 1444288553114351059L;

	private Integer skillTypeBucketLookupId;
	private SkillType skillType;
	private Bucket[] bucket;
	private Double[] weight;

	public SkillTypeBucketLookup(int skillTypeBucketLookupId, SkillType skillType, Bucket[] bucket, Double[] weight) {
		super();
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
		this.skillType = skillType;
		this.bucket = bucket;
		this.weight = weight;
	}

	public SkillTypeBucketLookup(SimpleSkillTypeBucketLookup sstbl) {
		this.skillTypeBucketLookupId = sstbl.getSkillTypeBucketLookupId();
		this.skillType = new SkillType(sstbl.getSkillType());
		this.weight = null;
	}

	public int getSkillTypeBucketLookupId() {
		return skillTypeBucketLookupId;
	}

	public void setSkillTypeBucketLookupId(int skillTypeBucketLookupId) {
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public Bucket[] getBucket() {
		return bucket;
	}

	public void setBucket(Bucket[] bucket) {
		this.bucket = bucket;
	}

	public Double []getWeight() {
		return weight;
	}

	public void setWeight(Double[] weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bucket);
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((skillTypeBucketLookupId == null) ? 0 : skillTypeBucketLookupId.hashCode());
		result = prime * result + Arrays.hashCode(weight);
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
		SkillTypeBucketLookup other = (SkillTypeBucketLookup) obj;
		if (!Arrays.equals(bucket, other.bucket))
			return false;
		if (skillType == null) {
			if (other.skillType != null)
				return false;
		} else if (!skillType.equals(other.skillType))
			return false;
		if (skillTypeBucketLookupId == null) {
			if (other.skillTypeBucketLookupId != null)
				return false;
		} else if (!skillTypeBucketLookupId.equals(other.skillTypeBucketLookupId))
			return false;
		if (!Arrays.equals(weight, other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillTypeBucketLookup [skillTypeBucketLookupId=" + skillTypeBucketLookupId + ", skillType=" + skillType
				+ ", bucket=" + Arrays.toString(bucket) + ", weight=" + Arrays.toString(weight) + "]";
	}

	public SkillTypeBucketLookup() {
		super();
	}


}
