package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    private LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void runApplication() {
        System.out.println("Welcome to SDA Weather");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose option:");
            System.out.println("1. Add new location");
            System.out.println("2. Show saved locations");
            System.out.println("3. Download weather data");
            System.out.println("0. Close application");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    newLocation();
                    break;
                case 2:
                    showLocations();
                    break;
                case 3:
                    downloadWeatherData();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    return;
            }
        }
    }

    private void downloadWeatherData() {
        System.out.println("Not available yet");
    }

    public void showLocations() {
        System.out.println("Not available yet");
    }

    private void newLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new location details.\nCity name:");
        String city = scanner.nextLine();
        System.out.println("Region:");
        String region = scanner.nextLine();
        System.out.println("Country:");
        String country = scanner.nextLine();
        System.out.println("Longitude:");
        Double longitude = scanner.nextDouble();
        System.out.println("Latitude:");
        Double latitude = scanner.nextDouble();
        String confirmation = locationController.addNewLocation(city, longitude, latitude, region, country);

        System.out.println("You have successfully added a new location" + confirmation);
    }
}
