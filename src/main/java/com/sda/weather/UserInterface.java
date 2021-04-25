package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    public void runApplication() {
        System.out.println("Witaj w SDA Weather");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. dodaj lokację");
            System.out.println("2. pokaż zapisane lokacje");
            System.out.println("3. ściągnij dane pogodowe");
            System.out.println("0. zamknij aplikację");

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
                    System.out.println("zamykam aplikację");
                    return;
            }
        }
    }

    private void downloadWeatherData() {
        System.out.println("funkcja jescze nie dostępna");
    }

    private void showLocations() {
        System.out.println("funkcja jescze nie dostępna");
    }

    private void newLocation() {
        System.out.println("funkcja jescze nie dostępna");
    }
}
