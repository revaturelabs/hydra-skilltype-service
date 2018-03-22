package com.revature.hydra.skilltype.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.SimpleSkillType;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;

@Service
public class SkillTypeCompositionService {
	
	@Autowired
	AmqpTemplate rabbitTemplate;
	
	@Autowired
	SimpleSkillTypeRepository skillTypeRepository;
	
	@Autowired
	SimpleSkillTypeBucketLookupRepository skillTypeBucketLookupRepository;
	
	public void createSkill(Integer skillTypeId, String skillTypeName, Integer[] bucketIds, Integer[] weights) {
		SimpleSkillType st = new SimpleSkillType(skillTypeId, skillTypeName, true);
		skillTypeRepository.save(st);
		for(int i = 0; i < bucketIds.length;i++) {
			/**
			 * SimpleBucket sb = (SimpleBucket)bucketReceiver.find(bucketIds[i]);
			 * SimpleSkillTypeBucketLookup stbl = new SimpleSkillTypeBucketLookup(123, st, sb, weights[i];
			 */
		}
	}
	
	public void updateSkill(Integer skillTypeId, String skillTypeName, Integer[] bucketIds, Integer[] weights) {
		SimpleSkillType st = skillTypeRepository.findOne(skillTypeId);
		st.setSkillTypeName(skillTypeName);
		skillTypeRepository.save(st);
		skillTypeBucketLookupRepository.deleteBySkillType(st);
		for(int i = 0; i < bucketIds.length; i++) {
			/**
			 * SimpleBucket sb = (SimpleBucket)bucketReceiver.find(bucketIds[i]);
			 * SimpleSkillBucketLookup stbl = new SimpleSkillTypeBucketLookup(123, st, sb, weights[i]);
			 */
		}
	}
}
