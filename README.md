# hydra-skilltype-service
### Hydra MSA element for persisting and accessing technology tracks (skill types). 

This service has the following methods for interacting with it's data:
* createSkillType
  * Description
	  * Creates a new SkillType with the given SkillType name and description.
  * Endpoint
		* /skillType/createSkillType
* deactivateSkillType
	* Description
		* Deactivates a SkillType by its unique id.
	* Endpoint
		* /skillType/deactiveSkillType/{id}
* activateSkillType
	* Description
		* Activates a SkillType by its unique id.
	* Endpoint
		* /skillType/activeSkillType/{id}
* updateSkillType
	* Description
		* Update a SkillType by its unique id with any changes to name and description.
	* Endpoint
		* /skillType/updateSkillType
* getSkillTypes
	* Description
		* Returns all SkillTypes from the database.
	* Endpoint
		* /skillType/getSkillTypes
* setSkillTypeBucket
	* Description
		* Takes a SkillType and a list of BucketId's and weights to create a new SkillTypeBucketLookup entry.
	* Endpoint
		* /skillType/setSkillTypeBucket
* updateSkillType
  * Description
    * Updates the skill type bucket lookup for the skill type. Consumes new skill type name, description, bucket relations, and associated weights.
  * Endpoint
    * /skillType/updateSkillTypeBucket
* getSkillTypeBuckets
  * Description
    * Returns a list of Buckets that are associated with the given SkillTypeId.
  * Endpoint
    * /skillType/getSkillTypeBuckets/{id}
* getSkillTypeBucketsWithWeights/{skillTypeId}
  * Description
    * Returns a list of Buckets with their associated weights according to SkillTypeId
  * Endpoint
    * /skillType/getSkillTypeBucketWithWeights/{skillTypeId}
* getSkillTypes
  * Description
    * Returns all information for a given SkillTypeId
  * Endpoint
    * /skillType/getSkillType/{id}

This service communicates with the following services:
* Bucket
* Question
