package com.revature.beans;

import java.io.Serializable;

public class SimpleBucket implements Serializable{
	
	private static final long serialVersionUID = 2435095816452768808L;

	private Integer bucketId;

	private String bucketCategory;
	
	private String bucketDescription;
	
	private Boolean isActive;
	
	public SimpleBucket() {
		super();
	}

	public SimpleBucket(Integer bucketId, String bucketCategory, 
						String bucketDescription, Boolean isActive) {
		super();
		this.bucketId = bucketId;
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}
	
	public SimpleBucket(Bucket b) {
		super();
		this.bucketId = b.getBucketId();
		this.bucketCategory = b.getBucketCategory();
		this.bucketDescription = b.getBucketDescription();
		this.isActive = b.getIsActive();
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
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
		result = prime * result + ((bucketCategory == null) ? 0 : bucketCategory.hashCode());
		result = prime * result + ((bucketDescription == null) ? 0 : bucketDescription.hashCode());
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
		SimpleBucket b = (SimpleBucket) obj;
		if(this.bucketId == null) {
			if(b.getBucketId() != null) {
				return false;
			}
		}
		if(this.bucketId != b.getBucketId()) {
			return false;
		}
		
		if(this.bucketCategory == null) {
			if(b.getBucketCategory() != null) {
				return false;
			}
		}
		if(!this.bucketCategory.equals(b.getBucketCategory())) {
			return false;
		}
		
		if(this.bucketDescription == null) {
			if(b.getBucketDescription() != null) {
				return false;
			}
		}
		if(!this.bucketDescription.equals(b.getBucketDescription())) {
			return false;
		}
		
		if(this.isActive == null) {
			if(b.isActive != null) {
				return false;
			}
		}
		if(this.isActive != b.getIsActive()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Bucket[bucketId="+bucketId+", bucketCategory="+bucketCategory
				+", bucketDescription="+bucketDescription+", isActive="+isActive+"]";
	}
}
