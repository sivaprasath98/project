package project2;

public class Rental {
		private Bike bike;
		private Car car;
		private Customer customer;
		private int days1;
		private int days2;

		public Rental(Bike bike, Customer customer, int days1) {
			this.bike = bike;
			this.customer = customer;
			this.days1 = days1;
		}

		public Rental(Car car, Customer customer, int days2) {
			this.car = car;
			this.customer = customer;
			this.days2 = days2;
		}

		public Bike getBike() {
			return bike;
		}

		public Car getCar() {
			return car;
		}

		public Customer getCustomer() {
			return customer;
		}

		public int getBikeDays() {
			return days1;
		}

		public int getCarDays() {
			return days2;
		}
	}


