package com.cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Collection <Car> cars = new ArrayList<Car>();

        int menuOption;

        System.out.println("Good day. Welcome to the Vehicle Registration App!");

        do {
            // Show the menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register a new vehicle");
            System.out.println("2. View vehicle report");
            System.out.println("3. Exit the application");
            System.out.println("Enter your choice: ");

            menuOption = input.nextInt();
            input.nextLine(); // Consume leftover newline

            if(menuOption == 1) {
                // Option 1: Register new vehicle
                Car car = new Car();
                System.out.println("Enter vehicle make (e.g., BMW): ");
                car.setMake(input.nextLine());

                System.out.println("Enter vehicle model (e.g., M4): ");
                car.setModel(input.nextLine());

                String vin;
                while (true) {
                    System.out.println("Enter VIN (17 characters): ");
                    vin = input.nextLine();
                    if (vin.length() == 17) {
                        car.setVin(vin);
                        break;
                    } else {
                        System.out.println("VIN must be exactly 17 characters long.");
                    }
                }

                System.out.println("Select licence plate format:");
                System.out.println("1. Old format (e.g., ABC123GP)");
                System.out.println("2. New format (e.g., AB12CDGP)");

                System.out.println("Enter your choice: ");
                int plateChoice = input.nextInt();
                input.nextLine();

                if (plateChoice == 1) {
                    System.out.println("Enter old format plate number (e.g., ABC123GP): ");
                } else if (plateChoice == 2) {
                    System.out.println("Enter new format plate number (e.g., AB12CDGP): ");
                } else {
                    System.out.println("Invalid choice. Skipping plate input.");
                }

                car.setPlateNumber(input.nextLine());

                System.out.println("Enter vehicle mileage: ");
                car.setMileage(input.nextInt());

                System.out.println("Enter year of manufacture (e.g., 2020): ");
                car.setYear(input.nextInt());
                input.nextLine();

                cars.add(car);
                System.out.println("Vehicle registered successfully!");
            } else if (menuOption == 2) {
                System.out.println("\n********** VEHICLE REPORT **********");
                if (cars.isEmpty()) {
                    System.out.println("No vehicles have been registered yet.");
            }else{
                for (Car c : cars){
                    System.out.println("-----------------------------");
                    System.out.println("Make: " + c.getMake());
                    System.out.println("Model: " + c.getModel());
                    System.out.println("VIN: " + c.getVin());
                    System.out.println("Plate Number:" + c.getPlateNumber());
                    System.out.println("Mileage: " + c.getMileage());
                    System.out.println("Year: " + c.getYear());
                }
            }
            } else if (menuOption == 3) {
                System.out.println("Thank you for using the Vehicle Registration App. Goodbye!");
            }else{
                System.out.println("Invalid option. Please select 1, 2, or 3.");
            }

            }while (menuOption !=3);
            input.close();
        }
}
