package com.revature.hydra.skilltype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.SimpleBucket;
import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;

@Service
public class SkillTypeCompositionService {

	@Autowired
	private SkillTypeMessageSender messageSender;

	@Autowired
	SimpleSkillTypeRepository skillTypeRepository;

	@Autowired
	SimpleSkillTypeBucketLookupRepository skillTypeBucketLookupRepository;

	public SimpleSkillType findSkillTypeByName(String name) {
		SimpleSkillType skillType = skillTypeRepository.findBySkillTypeName(name);
		return skillType;
	}

	public void createSkill(String skillTypeName, String skillTypeDescription) {
		SimpleSkillType st = new SimpleSkillType(skillTypeName, skillTypeDescription, true);
		skillTypeRepository.save(st);
	}

	/**
	 * Create a new association between one skillType and multiple buckets.
	 * 
	 * Checks to see if the weights add up to 100% before performing further
	 * actions. Deletes skillType from table before adding the information.
	 * 
	 * @param skillTypeId
	 * @param skillTypeName
	 * @param bucketIds
	 * @param weights
	 */
	public Boolean updateSkillTypeBucketLookup(Integer skillTypeId, String skillTypeName, Integer[] bucketIds,
			Double[] weights) {
		Double sum = 0.0;
		for (Double x : weights) {
			sum += x;
		}

		if (sum == 100d) {
			SimpleSkillType st = skillTypeRepository.findOne(skillTypeId);
			List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findBySkillType(st);
			
			// Update skillType. 
			// Delete old skillType Bucket associations
			if (sstbl.size() == 0 && st != null) {
				skillTypeBucketLookupRepository.deleteBySkillType(st);
				
				for (int i = 0; i < bucketIds.length && i < weights.length; i++) {
					skillTypeBucketLookupRepository.save(new SimpleSkillTypeBucketLookup(st, bucketIds[i], weights[i]));
				}
				return true;
			}
		}
		return false;
	}

	public Boolean createSkillTypeBucketLookup(String skillTypeName, Integer[] bucketIds, Double[] weights) {
		Double sum = 0.0;
		for (Double x : weights) {
			sum += x;
		}

		if (sum == 100d) {
			SimpleSkillType st = skillTypeRepository.findBySkillTypeName(skillTypeName);
			List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findBySkillType(st);
			// Create a new skill type association if it doesn't exist.
			if (sstbl.size() == 0 && st != null) {
				// Go through both arrays and add entries accordingly.
				for (int i = 0; i < bucketIds.length && i < weights.length; i++) {
					skillTypeBucketLookupRepository.save(new SimpleSkillTypeBucketLookup(st, bucketIds[i], weights[i]));
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Message bucket service to get a list of bucket information
	 * 
	 * @param bucketIds
	 * @return
	 */
	public List<SimpleBucket> getBucketListByIds(List<Integer> bucketIds) {
		return messageSender.getBucketListByIds(bucketIds);
	}
}
