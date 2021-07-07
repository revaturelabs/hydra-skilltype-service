package com.revature.hydra.skilltype.service;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.beans.SimpleBucket;

/**
 * 
 * @author Sungkwon Kudo
 *
 */
@Service
public class SkillTypeMessageSender {

	private static final String BUCKET_ROUTING_KEY = "ahb47krjWESgXQFQ";
	private static final String RABBIT_EXCHANGE = "revature.hydra.repos";

	@Autowired
	AmqpTemplate rabbitTemplate;

	/**
	 * Send a message to the bucketService microservice to get a list of bucketIds
	 * 
	 * @param bucketIds
	 * @return List of bucket ids
	 */
	public List<SimpleBucket> getBucketListByIds(List<Integer> bucketIds) {
		JsonObject bucketRequest = new JsonObject();
		Gson gson = new Gson();

		bucketRequest.addProperty("methodName", "getBucketListByIds");
		bucketRequest.add("bucketIds", gson.toJsonTree(bucketIds, List.class));
		
		
		return (List<SimpleBucket>) rabbitTemplate.convertSendAndReceive(RABBIT_EXCHANGE, BUCKET_ROUTING_KEY,
				bucketRequest.toString());
	}

}
