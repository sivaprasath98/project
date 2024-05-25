package project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class RentalSystem {
		private List<Bike> bikes;
		private List<Car> cars;
		private List<Customer> customers;
		private List<Rental> rentals;

		public RentalSystem() {
			bikes = new ArrayList<>();
			cars = new ArrayList<>();
			customers = new ArrayList<>();
			rentals = new ArrayList<>();
		}

		public void addBike(Bike bike) {
			bikes.add(bike);
		}

		public void addCustomer1(Customer customer) {
			customers.add(customer);
		}

		public void rentBike(Bike bike, Customer customer, int days1) {
			if (bike.bikeisAvailable()) {
				bike.rent();
				rentals.add(new Rental(bike, customer, days1));
			} else {
				System.out.println("bike is not available for rent.");
			}
		}

		public void returnBike(Bike bike) {
			bike.returnBike();
			Rental rentalToRemove = null;
			for (Rental rental : rentals) {
				if (rental.getBike() == bike) {
					rentalToRemove = rental;
					break;
				}
			}
			if (rentalToRemove != null) {
				rentals.remove(rentalToRemove);

			} else {
				System.out.println("Bike was not rented.");
			}
		}

		// -------------------------------------------
		public void addCar(Car car) {
			cars.add(car);
		}

		public void addCustomer(Customer customer) {
			customers.add(customer);
		}

		public void rentCar(Car car, Customer customer, int days2) {
			if (car.isAvailable()) {
				car.rent();
				rentals.add(new Rental(car, customer, days2));

			} else {
				System.out.println("Car is not available for rent.");
			}
		}

		public void returnCar(Car car) {
			car.returnCar();
			Rental rentalToRemove = null;
			for (Rental rental : rentals) {
				if (rental.getCar() == car) {
					rentalToRemove = rental;
					break;
				}
			}
			if (rentalToRemove != null) {
				rentals.remove(rentalToRemove);

			} else {
				System.out.println("Car was not rented.");
			}
		}

		public void menu() {
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("===== Rental System =====");
				System.out.println("1. Rent a Bike");
				System.out.println("2. Rent a Car");
				System.out.println("3. Return a Bike");
				System.out.println("4. Return a Car");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();
				scanner.nextLine();

				if (choice == 1) {
					System.out.println("== Rent a Bike ==");
					System.out.print("Enter your name: ");
					String customerName = scanner.nextLine();

					System.out.println("Available Bikes:");
					for (Bike bike : bikes) {
						if (bike.bikeisAvailable()) {
							System.out.println(bike.getBikeId() + " - " + bike.getBikeBrand() + " " + bike.getBikeModel());
						}
					}

					System.out.print("Enter the bike ID you want to rent: ");
					String bikeId = scanner.nextLine();
					bikeId = bikeId.toUpperCase();

					System.out.print("Enter the number of days for rental: ");
					int rentalDays = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					Customer newCustomer = new Customer("BIKE" + (customers.size() + 1), customerName);
					addCustomer(newCustomer);

					Bike selectedbike = null;
					for (Bike bike : bikes) {
						if (bike.getBikeId().equals(bikeId) && bike.bikeisAvailable()) {
							selectedbike = bike;
							break;
						}
					}

					if (selectedbike != null) {
						double totalPrice1 = selectedbike.calculatePrice1(rentalDays);
						System.out.println("==  Your Rental Information ==");
						System.out.println("Customer ID: " + newCustomer.getCustomerId());
						System.out.println("Customer Name: " + newCustomer.getName());
						System.out.println("Bike : " + selectedbike.getBikeBrand() + " " + selectedbike.getBikeModel());
						System.out.println("Rental Days: " + rentalDays);
						System.out.printf("Total Price: %.2f", totalPrice1);

						System.out.print("Confirm rental (YES or NO): ");
						String confirm = scanner.nextLine();
						confirm = confirm.toUpperCase();

						if (confirm.equals("YES")) {
							rentBike(selectedbike, newCustomer, rentalDays);
							System.out.println("Bike rented successfully.");
						} else {
							System.out.println("Rental canceled.");
						}
					} else {
						System.out.println("Invalid Bike selection or Bike not available for rent.");
					}
				}

				else if (choice == 2) {
					System.out.println("== Rent a Car ==");
					System.out.print("Enter your name: ");
					String customerName1 = scanner.nextLine();

					System.out.println("Available Cars:");
					for (Car car : cars) {
						if (car.isAvailable()) {
							System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
						}
					}

					System.out.print("Enter the car ID you want to rent: ");
					String carId = scanner.nextLine();
					carId = carId.toUpperCase();

					System.out.print("Enter the number of days for rental: ");
					int rentalDays1 = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					Customer newCustomer1 = new Customer("CUS" + (customers.size() + 1), customerName1);
					addCustomer(newCustomer1);
					Car selectedCar = null;
					for (Car car : cars) {
						if (car.getCarId().equals(carId) && car.isAvailable()) {
							selectedCar = car;
							break;
						}
					}

					if (selectedCar != null) {
						double totalPrice = selectedCar.calculatePrice(rentalDays1);
						System.out.println("==  Your Rental Information ==");
						System.out.println("Customer ID: " + newCustomer1.getCustomerId());
						System.out.println("Customer Name: " + newCustomer1.getName());
						System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
						System.out.println("Rental Days: " + rentalDays1);
						System.out.printf("Total Price: %.2f%n", totalPrice);

						System.out.print("Confirm rental (YES or NO): ");
						String confirm = scanner.nextLine();
						confirm = confirm.toUpperCase();

						if (confirm.equals("YES")) {
							rentCar(selectedCar, newCustomer1, rentalDays1);
							System.out.println("Car rented successfully.");
						} else {
							System.out.println("Rental canceled.");
						}
					}

					else {
						System.out.println("Invalid car selection or car not available for rent.");
					}
				} else if (choice == 3) {
					System.out.println("== Return a Bike ==");
					System.out.print("Enter the Bike ID you want to return: ");
					String bikeId = scanner.nextLine();
					bikeId = bikeId.toUpperCase();

					Bike bikeToReturn = null;
					for (Bike bike : bikes) {
						if (bike.getBikeId().equals(bikeId) && !bike.bikeisAvailable()) {
							bikeToReturn = bike;
							break;
						}
					}
					if (bikeToReturn != null) {
						Customer customer = null;
						for (Rental rental : rentals) {
							if (rental.getBike() == bikeToReturn) {
								customer = rental.getCustomer();
								break;
							}
						}

						if (customer != null) {
							returnBike(bikeToReturn);
							System.out.println("Bike returned successfully by " + customer.getName());
						} else {
							System.out.println("bike was not rented or rental information is missing.");
						}
					} else {
						System.out.println("Invalid Bike ID or Bike is not rented.");
					}
				} else if (choice == 4) {
					System.out.println("== Return a Car ==");
					System.out.print("Enter the car ID you want to return: ");
					String carId1 = scanner.nextLine();
					carId1 = carId1.toUpperCase();

					Car carToReturn = null;
					for (Car car : cars) {
						if (car.getCarId().equals(carId1) && !car.isAvailable()) {
							carToReturn = car;
							break;
						}
					}
					if (carToReturn != null) {
						Customer customer = null;
						for (Rental rental : rentals) {
							if (rental.getCar() == carToReturn) {
								customer = rental.getCustomer();
								break;
							}
						}
						if (customer != null) {
							returnCar(carToReturn);
							System.out.println("Car returned successfully by " + customer.getName());
						} else {
							System.out.println("Car was not rented or rental information is missing.");
						}
					} else {
						System.out.println("Invalid car ID or car is not rented.");
					}
				} else if (choice == 5) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			}
			System.out.println("Thank you for using the Car Rental System!");
			scanner.close();
		}
	}

	
	
	
	





	