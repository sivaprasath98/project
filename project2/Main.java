package project2;

public class Main {

		public static void main(String[] args) {
			RentalSystem rentalSystem = new RentalSystem();   

			Car car1 = new Car("C001", "Toyota", "Camry", 600.0); // Different base price per day for each car
			Car car2 = new Car("C002", "Honda", "Accord", 700.0);
			Car car3 = new Car("C003", "Mahindra", "Thar", 1000.0);
			Car car4 = new Car("C004", "Kia", "Seltos", 900.0);
			Car car5 = new Car("C005", "Tata", "Punch", 1000.0);
			Car car6 = new Car("C006", "Toyota", "Fortuner", 1500.0);
			
			rentalSystem.addCar(car1);
			rentalSystem.addCar(car2);
			rentalSystem.addCar(car3);
			rentalSystem.addCar(car4);
			rentalSystem.addCar(car5);
			rentalSystem.addCar(car6);

			Bike bike1 = new Bike("B001", "Honda", "Shine", 100.0);
			Bike bike2 = new Bike("B002", "Hero", "Splendor", 80.0);
			Bike bike3 = new Bike("B003", "Bajaj", "Pulsar", 140.0);
			Bike bike4 = new Bike("B004", "TVS", "Apache RTR 160", 120.0);
			Bike bike5 = new Bike("B005", "Yamaha", "Mt15", 200.0);
			Bike bike6 = new Bike("B006", "Royal Enfield", "Classic 350", 250.0);
			
			rentalSystem.addBike(bike1);
			rentalSystem.addBike(bike2);
			rentalSystem.addBike(bike3);
			rentalSystem.addBike(bike4);
			rentalSystem.addBike(bike5);
			rentalSystem.addBike(bike6);

			rentalSystem.menu();
		}
	}


