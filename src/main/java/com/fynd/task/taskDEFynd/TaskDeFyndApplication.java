package com.fynd.task.taskDEFynd;

import com.fynd.task.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableAsync
@ComponentScan({ "com.fynd.task" })
public class TaskDeFyndApplication {

	public static Queue<Map<String, String>> prodQueue = new LinkedList<>();
	public static Queue<Car> audi = new LinkedList<>();
	public static Queue<Car> nisaan = new LinkedList<>();
	public static Queue<Car> volvo = new LinkedList<>();
	public static final AtomicInteger counter = new AtomicInteger();

	public static void main(String[] args) {
		SpringApplication.run(TaskDeFyndApplication.class, args);
	}

}
