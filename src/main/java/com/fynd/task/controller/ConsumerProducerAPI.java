package com.fynd.task.controller;

import com.fynd.task.service.ConsumerService;
import com.fynd.task.service.ETLPipeline;
import com.fynd.task.taskDEFynd.TaskDeFyndApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ConsumerProducerAPI {
	ConsumerService consumerService = new ConsumerService();
	ETLPipeline pipeline = new ETLPipeline();
	int audi = 0;
	int nisaan = 0;
	int volvo = 0;

	@RequestMapping(value = "/produceCar", method = RequestMethod.POST)
	public void produceCar(
			@RequestBody
					Map<String, String> payload) throws Exception {

		TaskDeFyndApplication.prodQueue.add(payload);
		pipeline.etlConvert();
	}

	@RequestMapping(value = "/produceBatchCar", method = RequestMethod.POST)
	public void produceBatchCar(
			@RequestBody
					List<Map<String, String>> payload) throws Exception {

		for(Map<String, String> item: payload){
			TaskDeFyndApplication.prodQueue.add(item);
		}

		pipeline.etlConvert();
	}

	@GetMapping("/consumer")
	public String consumer(
			@RequestBody
					Map<String, String> requestParams) throws Exception {

		if (requestParams.get("audi") != null)
			audi = Integer.parseInt(requestParams.get("audi"));
		if (requestParams.get("nisaan") != null)
			nisaan = Integer.parseInt(requestParams.get("nisaan"));
		if (requestParams.get("volvo") != null)
			volvo = Integer.parseInt(requestParams.get("volvo"));
		try {
			consumerService.consume(audi, nisaan, volvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}
}
