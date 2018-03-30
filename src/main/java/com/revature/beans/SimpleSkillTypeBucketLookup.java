package com.revature.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL_TYPE_BUCKET_LOOKUP")
public class SimpleSkillTypeBucketLookup implements Serializable {

	private static final long serialVersionUID = 67213928524176831L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_TYPE_BUCKET_LOOKUP_SEQUENCE")
	@SequenceGenerator(name = "SKILL_TYPE_BUCKET_LOOKUP_SEQUENCE", sequenceName = "SKILL_TYPE_BUCKET_LOOKUP_SEQUENCE")
	@Column(name = "SKILL_TYPE_BUCKET_LOOKUP_ID")
	private Integer skillTypeBucketLookupId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SKILL_TYPE_ID")
	private SimpleSkillType skillType;

	@Column(name = "BUCKET_ID")
	private Integer bucket;

	@Column(name = "WEIGHT")
	private Double weight;

	public SimpleSkillTypeBucketLookup() {
		super();
	}

	public SimpleSkillTypeBucketLookup(SimpleSkillType skillType, Double weight) {
		super();
		this.skillType = skillType;
		this.weight = weight;
	}

	public SimpleSkillTypeBucketLookup(SimpleSkillType skillType, Integer bucket, Double weight) {
		super();
		this.skillType = skillType;
		this.bucket = bucket;
		this.weight = weight;
	}

	public SimpleSkillTypeBucketLookup(int skillTypeBucketLookupId, SimpleSkillType skillType, Integer bucket,
			Double weight) {
		super();
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
		this.skillType = skillType;
		this.bucket = bucket;
		this.weight = weight;
	}

	public SimpleSkillTypeBucketLookup(SkillTypeBucketLookup stbl) {
		super();
		this.skillTypeBucketLookupId = stbl.getSkillTypeBucketLookupId();
		this.skillType = new SimpleSkillType(stbl.getSkillType());
		this.bucket = 1;
		this.weight = 1.0;
	}

	public Integer getSkillTypeBucketLookupId() {
		return skillTypeBucketLookupId;
	}

	public void setSkillTypeBucketLookupId(int skillTypeBucketLookupId) {
		this.skillTypeBucketLookupId = skillTypeBucketLookupId;
	}

	public SimpleSkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SimpleSkillType skillType) {
		this.skillType = skillType;
	}

	public Integer getBucket() {
		return bucket;
	}

	public void setBucket(SimpleBucket bucket) {
		this.bucket = bucket.getBucketId();
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
		SimpleSkillTypeBucketLookup tbl = (SimpleSkillTypeBucketLookup) obj;
		if (this.skillTypeBucketLookupId == null) {
			if (tbl.skillTypeBucketLookupId != null) {
				return false;
			}
		}
		if (this.skillTypeBucketLookupId != tbl.getSkillTypeBucketLookupId()) {
			return false;
		}

		if (this.skillType == null) {
			if (tbl.getSkillType() != null) {
				return false;
			}
		}
		if (!this.skillType.equals(tbl.getSkillType())) {
			return false;
		}

		if (this.bucket == null) {
			if (tbl.getBucket() != null) {
				return false;
			}
		}
		if (!this.bucket.equals(tbl.getBucket())) {
			return false;
		}

		if (this.weight == null) {
			if (tbl.getWeight() != null) {
				return false;
			}
		}
		if (this.weight != tbl.getWeight()) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "SkillTypeBucketLookup[skillTypeBucketLookupId=" + skillTypeBucketLookupId + ", bucket=" + bucket
				+ ", skillType=" + skillType + ", weight=" + weight + "]";
	}
}
