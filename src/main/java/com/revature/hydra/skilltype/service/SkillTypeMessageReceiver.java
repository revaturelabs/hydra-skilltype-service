package com.revature.hydra.skilltype.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class SkillTypeMessageReceiver {

	@Autowired
	private SkillTypeReceiverProcessor strp;

	/**
	 * Listens for messages going through the skilltype queue
	 * 
	 * @param message
	 * @return
	 */
	@RabbitListener(queues = "revature.hydra.repos.skilltype")
	public List<Integer> receiveBucketRequest(String message) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message);
		JsonObject request = element.getAsJsonObject();

		return strp.processBucketIdRequest(request);
	}

}
