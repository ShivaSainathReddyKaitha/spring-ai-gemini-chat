package com.project.LLM.Advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;


public class LatencyTrackingAdvisor implements CallAdvisor {

	Logger log =LoggerFactory.getLogger(LatencyTrackingAdvisor.class);
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "LatencyTrackingAdvisor";
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain chain) {
		Long startTime = System.currentTimeMillis();
		try {			
			return chain.nextCall(chatClientRequest);
		}
		finally {
			long duration = System.currentTimeMillis()-startTime;
			log.info("Total latency :: "+duration);
		}
	}

}
