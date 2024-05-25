package project2;

public class Bike {
		private String bikeId;
		private String bikeBrand;
		private String bikeModel;	
		private double bikeBasePricePerDay;
		private boolean bikeisAvailable;

		Bike(String bikeId, String bikeBrand, String bikeModel, double bikeBasePricePerDay) {
			this.bikeId = bikeId;
			this.bikeBrand = bikeBrand;
			this.bikeModel = bikeModel;
			this.bikeBasePricePerDay = bikeBasePricePerDay;
			this.bikeisAvailable = true;
		}

		public String getBikeId() {
			return bikeId;
		}

		public String getBikeBrand() {
			return bikeBrand;
		}

		public String getBikeModel() {
			return bikeModel;
		}

		public double calculatePrice1(int rentalDays1) {
			return bikeBasePricePerDay * rentalDays1;
		}

		public boolean bikeisAvailable() {
			return bikeisAvailable;
		}

		public void rent() {
			bikeisAvailable = false;
		}

		public void returnBike(){	
			bikeisAvailable=true;
		}
	}



