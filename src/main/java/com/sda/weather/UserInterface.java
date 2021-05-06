package com.sda.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private SessionFactory sessionFactory;

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

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Location> locationQuery = session.createQuery("SELECT allLocations FROM Location AS allLocations", Location.class);
        List<Location> allLocations = locationQuery.getResultList();
        allLocations.stream().map(Location::getCity).forEach(System.out::println);

        transaction.commit();
        session.close();
    }

    private LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
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
