public class Vehicle {
    int noOfSeats;
    int noOfWheels;

    public Vehicle(int numSeats, int numWheels) {
        this.noOfSeats = numSeats;
        this.noOfWheels = numWheels;
    }

    public void showVehicle() {
        System.out.println("Total Number of seats: " + noOfSeats);
        System.out.println("Total Number of wheels: " + noOfWheels);
    }

    public static void main(String[] args) {
        Vehicle motorcycle = new Vehicle(1, 2);
        Vehicle car = new Vehicle(4, 4);

        System.out.println("Details of Car:");
        car.showVehicle();

        System.out.println("Details of Motorcycle:");
        motorcycle.showVehicle();
    }
}
