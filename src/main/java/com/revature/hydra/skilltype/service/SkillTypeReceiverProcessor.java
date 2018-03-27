package com.revature.hydra.skilltype.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;

@Service
public class SkillTypeReceiverProcessor {
	@Autowired
	private SimpleSkillTypeBucketLookupRepository sstblr;

	@Autowired
	private SimpleSkillTypeRepository sstr;

	/**
	 * Processes a message and replies back with a list of bucketIds.
	 * 
	 * @param request
	 * @return
	 */
	public List<Integer> processBucketIdRequest(JsonObject request) {
		List<Integer> bucketIds = new ArrayList<>();
		String methodName = request.get("methodName").getAsString();

		switch (methodName) {
		case "findBucketIdsBySkillType":
			Integer skillTypeId = request.get("skillTypeId").getAsInt();
			SimpleSkillType simpleSkillType = sstr.findBySkillTypeId(skillTypeId);
			List<SimpleSkillTypeBucketLookup> lookupList = sstblr.findBySkillType(simpleSkillType);
			
			for(SimpleSkillTypeBucketLookup item : lookupList) {
				bucketIds.add(item.getBucket());
			}
			
			break;
		}

		return bucketIds;
	}
}
