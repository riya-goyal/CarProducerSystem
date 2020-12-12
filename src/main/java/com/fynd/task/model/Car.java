package com.fynd.task.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.util.Objects;

//@Entity
public class Car {
//	private @Id
//	@GeneratedValue
	private int id;
	private String name;
	private String brand;

	public Car() {}

	public Car(String name, String brand) {

		this.name = name;
		this.brand = brand;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

//	@Override
//	public boolean equals(Object o) {
//
//		if (this == o)
//			return true;
//		if (!(o instanceof Car))
//			return false;
//		Car car = (Car) o;
//		return Objects.equals(this.id, car.id) && Objects.equals(this.name, car.name)
//				&& Objects.equals(this.brand, car.brand);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.name, this.brand);
//	}
//
	@Override
	public String toString() {
		return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", brand='" + this.brand + '\'' + '}';
	}
}
