package com.fynd.task.service;

import com.fynd.task.model.Car;
import com.fynd.task.taskDEFynd.TaskDeFyndApplication;

import java.util.Iterator;
import java.util.Map;

public class ETLPipeline {
	public void etlConvert() {
		// Transforming the Map to a Car object
		while (!TaskDeFyndApplication.prodQueue.isEmpty()) {
			Boolean isExistNameOrBrand = false;
			Car car = new Car();
			Map<String, String> m = TaskDeFyndApplication.prodQueue.poll();

			for (Map.Entry<String, String> entry : m.entrySet()) {
				if (entry.getKey().equals("name")) {
					car.setName(entry.getValue());
					isExistNameOrBrand = true;
				} else if (entry.getKey().equals("brand")) {
					car.setBrand(entry.getValue());
					isExistNameOrBrand = true;
				}
			}

			if (isExistNameOrBrand) {
				car.setId(TaskDeFyndApplication.counter.incrementAndGet());
			}

			// Adding car object in different queues based on brand type

			if (car.getBrand() != null && car.getBrand().equalsIgnoreCase("audi")) {
				TaskDeFyndApplication.audi.add(car);
			} else if (car.getBrand() != null && car.getBrand().equalsIgnoreCase("nisaan")) {
				TaskDeFyndApplication.nisaan.add(car);
			} else if (car.getBrand() != null && car.getBrand().equalsIgnoreCase("volvo")) {
				TaskDeFyndApplication.volvo.add(car);
			}
		}

	}
}
