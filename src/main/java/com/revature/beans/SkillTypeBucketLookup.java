package com.revature.beans;

import java.io.Serializable;

public class SkillTypeBucketLookup implements Serializable{
	
	private static final long serialVersionUID = 1444288553114351059L;
	
	private Integer skillTypeBucketLookupId;
	private SkillType skillType;
	private Bucket bucket;
	private Double weight;

	public SkillTypeBucketLookup(int skillTypeBucketLookupId, SkillType skillType, Bucket bucket, Double weight) {
		super();
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
		this.skillType = skillType;
		this.bucket = bucket;
		this.weight = weight;
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

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillTypeBucketLookupId == null) ? 0 : skillTypeBucketLookupId.hashCode());
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((bucket == null) ? 0 : bucket.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		SkillTypeBucketLookup tbl = (SkillTypeBucketLookup) obj;
		if(this.skillTypeBucketLookupId == null) {
			if(tbl.skillTypeBucketLookupId != null) {
				return false;
			}
		}
		if(this.skillTypeBucketLookupId != tbl.getSkillTypeBucketLookupId()) {
			return false;
		}
		
		if(this.skillType == null) {
			if(tbl.getSkillType() != null) {
				return false;
			}
		}
		if(!this.skillType.equals(tbl.getSkillType())) {
			return false;
		}
		
		if(this.bucket == null) {
			if(tbl.getBucket() != null) {
				return false;
			}
		}
		if(!this.bucket.equals(tbl.getBucket())) {
			return false;
		}
		
		if(this.weight == null) {
			if(tbl.getWeight() != null) {
				return false;
			}
		}
		if(this.weight != tbl.getWeight()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "SkillTypeBucketLookup[skillTypeBucketLookupId="+skillTypeBucketLookupId
				+", bucket="+bucket+", skillType="+skillType+", weight="+weight+"]";
	}
}
