package com.fynd.task.service;

import com.fynd.task.model.Car;
import com.fynd.task.taskDEFynd.TaskDeFyndApplication;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class ConsumerService {
	public void consume(Integer audi, Integer nisaan, Integer volvo){
		// Creating a file if not exist
		try {
			File myObj = new File("consumer.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		//Writing the result to the file
		try {
			FileWriter myWriter = new FileWriter("consumer.txt");
			String outputFile = "";

			while(audi>0 && !TaskDeFyndApplication.audi.isEmpty()){
				outputFile += TaskDeFyndApplication.audi.poll().toString();
				audi--;
			}
			while(nisaan>0 && !TaskDeFyndApplication.nisaan.isEmpty()){
				outputFile += TaskDeFyndApplication.nisaan.poll().toString();
				nisaan--;
			}
			while(volvo>0 && !TaskDeFyndApplication.volvo.isEmpty()){
				outputFile += TaskDeFyndApplication.volvo.poll().toString();
				volvo--;
			}

			myWriter.write(outputFile);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
