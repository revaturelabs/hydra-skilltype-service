package com.revature.hydra.skilltype.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bucket;
import com.revature.beans.SimpleBucket;
import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.beans.SkillType;
import com.revature.beans.SkillTypeBucketLookup;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;
import com.revature.hydra.skilltype.service.SkillTypeCompositionService;
import com.revature.hydra.skilltype.wrapper.SkillTypeBucketWrapper;

@RestController
@CrossOrigin
@ComponentScan("com.revature.hydra.skilltype.*")
public class SkillTypeController {

	@Autowired
	SimpleSkillTypeRepository skillTypeRepository;

	@Autowired
	SimpleSkillTypeBucketLookupRepository skillTypeBucketLookupRepository;

	@Autowired
	SkillTypeCompositionService skillTypeCompositionService;

	/**
	 * Creates and persists the information that comprises a SkillType and its
	 * relation to Bucket objects
	 * 
	 * @param SimpleSkillType
	 * @return An HttpStatus of No_Content
	 * @return An HttpStatus of Bad_Request if there are duplicate skill type names
	 */
	@RequestMapping(value = "/skillType/createSkillType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSkillType(@RequestBody SimpleSkillType simpleSkillType) {
		if (skillTypeCompositionService.findSkillTypeByName(simpleSkillType.getSkillTypeName()) == null) {
			skillTypeCompositionService.createSkill(simpleSkillType.getSkillTypeName(), simpleSkillType.getSkillTypeDescription());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Updates the isActive state of the given SkillType to false.
	 * 
	 * @param skillTypeId
	 *            the unique id of a SkillType object
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/deactiveSkillType/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> deactivateSkillType(@PathVariable("id") Integer skillTypeId) {
		skillTypeRepository.toggleSkillTypeStatusById(false, skillTypeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Updates the isActive state of the given skillType to true.
	 * 
	 * @param skillTypeId
	 *            the unique id of a SkillType object
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/activeSkillType/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> activateSkillType(@PathVariable("id") Integer skillTypeId) {
		skillTypeRepository.toggleSkillTypeStatusById(true, skillTypeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Update skilltype with new information.
	 * 
	 * @param skillType
	 * @return
	 */
	@RequestMapping(value = "/skillType/updateSkillType", method = RequestMethod.POST)
	public ResponseEntity<Void> activateSkillType(@RequestBody SimpleSkillType skillType){
		skillTypeRepository.updateSkillType(skillType.getSkillTypeId(), skillType.getSkillTypeName(), skillType.getSkillTypeDescription());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Finds and returns all SkillTypes currently persisted in the database
	 * 
	 * @return Returns a list of SkillType objects
	 */
	@RequestMapping(value = "/skillType/getSkillTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleSkillType>> getSkillTypes() {
		List<SimpleSkillType> sts = skillTypeRepository.findAll();
		return new ResponseEntity<>(sts, HttpStatus.FOUND);
	}

	/**
	 * Create a new set of associations between skillType and skillTypeBucketLookup
	 * 
	 * @param skillTypeBuckets
	 */
	@RequestMapping(value = "/skillType/setSkillTypeBucket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> setSkillTypeBucket(@RequestBody SkillTypeBucketWrapper skillTypeBuckets) {
		if (skillTypeCompositionService.createSkillTypeBucketLookup(skillTypeBuckets.getSkillTypeName(),
				skillTypeBuckets.getBucketIds(), skillTypeBuckets.getWeights())) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Updates a SkillTypeBucketLookup object and it's relation to Bucket objects
	 * 
	 * @param SkillTypeBucketWrapper
	 *            class for receiving the request
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/updateSkillTypeBucket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateSkillType(@RequestBody SkillTypeBucketWrapper skillTypeBuckets) {

		if (skillTypeCompositionService.updateSkillTypeBucketLookup(skillTypeBuckets.getSkillTypeId(),
				skillTypeBuckets.getSkillTypeName(), skillTypeBuckets.getBucketIds(), skillTypeBuckets.getWeights())) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Return a list of buckets that based on skillTypeId provided.
	 * 
	 * @param skillTypeId
	 * @return
	 */
	@RequestMapping(value = "/skillType/getSkillTypeBuckets/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleBucket>> getSkillTypeBuckets(@PathVariable("id") Integer skillTypeId) {
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(skillTypeId);

		List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findBySkillType(sst);
    
		// Get a list of bucketIds
		List<Integer> bucketIds = new ArrayList<>();
		if (sstbl.size() != 0) {
			for (SimpleSkillTypeBucketLookup s : sstbl) {
				bucketIds.add(s.getBucket());
			}
		}
		
		// Send list to a composition service.
		List<SimpleBucket> bucketList = skillTypeCompositionService.getBucketListByIds(bucketIds);
		
		return new ResponseEntity<>(bucketList, HttpStatus.OK);
	}
	
	/**
	 * Get a list of buckets and return arrays of buckets and their weights.
	 * 
	 * @param skillTypeId
	 * @return
	 */
	@RequestMapping(value="/skillType/getSkillTypeBucketsWithWeights/{skillTypeId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillTypeBucketLookup> getSkillTypeBucketWithWeights(@PathVariable("skillTypeId") Integer skillTypeId){
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(skillTypeId);

		List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findBySkillType(sst);
    
		// Get a list of bucketIds
		List<Integer> bucketIds = new ArrayList<>();
		if (sstbl.size() != 0) {
			for (SimpleSkillTypeBucketLookup s : sstbl) {
				bucketIds.add(s.getBucket());
			}
		}
		
		// Send list to a composition service.
		List<SimpleBucket> bucketList = skillTypeCompositionService.getBucketListByIds(bucketIds);
		Bucket[] buckets = new Bucket[bucketList.size()];
		int y = 0;
		for(SimpleBucket b : bucketList) {
			
			buckets[y] = new Bucket(b);
		}
		
		// Get a Double[] of weights
		Double[] weights = new Double[sstbl.size()];
		int i = 0;
		for(SimpleSkillTypeBucketLookup s : sstbl) {
			weights[i] = s.getWeight();
			i++;
		}
		
		SkillType skillType = new SkillType(sst);
		
		SkillTypeBucketLookup stbl = new SkillTypeBucketLookup(0, skillType, buckets, weights);
		
		return new ResponseEntity<SkillTypeBucketLookup>(stbl, HttpStatus.OK);
	}

	/**
	 * Finds and returns all information associated with a SkillType
	 * 
	 * @param skillTypeId
	 *            The unique id of a SkillType object.
	 * @return The SkillTypeBucketLookup objects and SkillType object associated
	 *         with the given id
	 */
	@RequestMapping(value = "/skillType/getSkillType/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleSkillTypeBucketLookup>> getSkillTypes(@PathVariable("id") Integer skillTypeId) {
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(skillTypeId);
		List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findBySkillType(sst);
		return new ResponseEntity<>(sstbl, HttpStatus.FOUND);
	}
}
