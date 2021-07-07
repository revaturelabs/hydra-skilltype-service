package com.revature.beans;

import java.io.Serializable;

public class Bucket implements Serializable{
	
	private static final long serialVersionUID = -4148453774353044141L;
	
	private Integer bucketId;
	private String bucketCategory;
	private String bucketDescription;
	private Boolean isActive;

	public Bucket(Integer bucketId, String bucketCategory, 
				  String bucketDescription, Boolean isActive) {
		super();
		this.bucketId = bucketId;
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}
	
	public Bucket(SimpleBucket sb) {
		super();
		this.bucketId = sb.getBucketId();
		this.bucketCategory = sb.getBucketCategory();
		this.bucketDescription = sb.getBucketDescription();
		this.isActive = sb.getIsActive();
	}

	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	public String getBucketCategory() {
		return bucketCategory;
	}

	public void setBucketCategory(String bucketCategory) {
		this.bucketCategory = bucketCategory;
	}

	public String getBucketDescription() {
		return bucketDescription;
	}

	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
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
		result = prime * result + ((bucketCategory == null) ? 0 : bucketCategory.hashCode());
		result = prime * result + ((bucketDescription == null) ? 0 : bucketDescription.hashCode());
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
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
		Bucket other = (Bucket) obj;
		if (bucketCategory == null) {
			if (other.bucketCategory != null)
				return false;
		} else if (!bucketCategory.equals(other.bucketCategory))
			return false;
		if (bucketDescription == null) {
			if (other.bucketDescription != null)
				return false;
		} else if (!bucketDescription.equals(other.bucketDescription))
			return false;
		if (bucketId == null) {
			if (other.bucketId != null)
				return false;
		} else if (!bucketId.equals(other.bucketId))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket[bucketId="+bucketId+", bucketCategory="+bucketCategory
				+", bucketDescription="+bucketDescription+", isActive="+isActive+"]";
	}
}
