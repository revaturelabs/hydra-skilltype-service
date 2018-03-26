package com.revature.hydra.skilltype.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleBucket;
import com.revature.beans.SimpleSkillType;
import com.revature.beans.SimpleSkillTypeBucketLookup;
import com.revature.hydra.skilltype.data.SimpleSkillTypeBucketLookupRepository;
import com.revature.hydra.skilltype.data.SimpleSkillTypeRepository;
import com.revature.hydra.skilltype.service.SkillTypeCompositionService;
import com.revature.hydra.skilltype.wrapper.SkillTypeBucketWrapper;

@RestController
@CrossOrigin
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
		List<SimpleSkillTypeBucketLookup> sstbl = skillTypeBucketLookupRepository.findAllBySkillType(sst);
		return new ResponseEntity<>(sstbl, HttpStatus.FOUND);
	}
}
