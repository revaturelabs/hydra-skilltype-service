package com.revature.hydra.skilltype.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Creates and persists the information that comprises a SkillType and it's relation to Bucket objects
	 * 
	 * @param skillTypeId the unique id of the SkillType
	 * @param skillTypeName the name of the SkillType
	 * @param bucketIds the unique ids of Bucket objects associated with this SkillType
	 * @param weights the weights of the Bucket objects in relation to this SkillType
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/createSkillType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSkillType(@RequestParam(value="skillTypeId") Integer skillTypeId, @RequestParam(value = "skillTypeName") String skillTypeName, @RequestParam(value = "buckets") Integer[] bucketIds, @RequestParam(value="weights") Integer[] weights){
		skillTypeCompositionService.createSkill(skillTypeId, skillTypeName, bucketIds, weights);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Updates a SkillType object and it's relation to Bucket objects
	 * 
	 * @param skillTypeId the unique id of the SkillType
	 * @param skillTypeName the name of the SkillType
	 * @param bucketIds the unique ids of Bucket objects associated with this SkillType
	 * @param weights the weights of the Bucket objects in relation to this SkillType
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateSkillType(@RequestParam(value="skillTypeId") Integer skillTypeId, @RequestParam(value = "skillTypeName") String skillTypeName, @RequestParam(value = "buckets") Integer[] bucketIds, @RequestParam(value = "weights") Integer[] weights){
		skillTypeCompositionService.updateSkill(skillTypeId, skillTypeName, bucketIds, weights);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Updates the isActive state of the given SkillType to false.
	 * 
	 * @param skillTypeId the unique id of a SkillType object
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/deactiveSkillType/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void>	deactivateSkillType(@PathVariable("id") Integer skillTypeId	){
		skillTypeRepository.toggleSkillTypeStatusById(false, skillTypeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Updates the isActive state of the given skillType to true.
	 * 
	 * @param skillTypeId the unique id of a SkillType object
	 * @return An HttpStatus of No_Content
	 */
	@RequestMapping(value = "/skillType/activeSkillType/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void>	activateSkillType(@PathVariable("id") Integer skillTypeId){
		skillTypeRepository.toggleSkillTypeStatusById(true, skillTypeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Finds and returns all SkillTypes currently persisted in the database
	 * 
	 * @return Returns a list of SkillType objects
	 */
	@RequestMapping(value = "/skillType/getSkillTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleSkillType>> getSkillTypes(){
		List<SimpleSkillType> sts = skillTypeRepository.findAll();
		return new ResponseEntity<>(sts, HttpStatus.FOUND);
	}
	
	/**
	 * Finds and returns all information associated with a SkillType
	 * 
	 * @param skillTypeId The unique id of a SkillType object.
	 * @return The SkillTypeBucketLookup objects and SkillType object associated with the given id
	 */
	@RequestMapping(value = "/skillType/getSkillType/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleSkillTypeBucketLookup>> getSkillTypeInformation(@PathVariable("id") Integer skillTypeId){
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(skillTypeId);
		List<SimpleSkillTypeBucketLookup> sstbl	= skillTypeBucketLookupRepository.findAllBySkillType(sst);
		return new ResponseEntity<>(sstbl, HttpStatus.FOUND);
		//TO-DO Need to probably create a new conjoined object that owns a list of SkillTypeBucketLookup and a SkillType. Front-end wants
		//all of that information, and it's probably better to give them all of it rather than have them try to persist SkillType info though
		//components.
	}
	
	/**
	 * Finds and returns all information associated with a list of Bucket objects associated with the given SkillType
	 * 
	 * @param skillTypeId The unique id of a SkillType object
	 * @return The SkillTypeBucketLookup and associated Bucket objects.
	 */
	@RequestMapping(value = "skillType/getTopics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleBucket>> getBucketsBySkillType(@PathVariable("id") Integer skillTypeId	){
		SimpleSkillType sst = skillTypeRepository.findBySkillTypeId(skillTypeId);
		//TO-DO Need to ask the Bucket service for all the buckets associated with this skillTypeId.
		
		return new ResponseEntity<>( new ArrayList<SimpleBucket>(), HttpStatus.FOUND);
	}
	
}
