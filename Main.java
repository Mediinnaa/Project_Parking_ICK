import java.util.*;


public class Main {
    private static int totalSlots;                     // Total number of parking slots
    private static int availableSlots;                 // Number of available slots
    private static Map<String, String> parkedCars = new HashMap<>();  // Map to store parked cars (license plate -> owner name)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of parking slots:");
        totalSlots = scanner.nextInt();
        availableSlots = totalSlots;


        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Park a car");
            System.out.println("2. Remove a car by license plate number");
            System.out.println("3. Remove a car by owner's name");
            System.out.println("4. View parked cars");
            System.out.println("5. Search for a car");
            System.out.println("6. Get information about empty slots");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkCar(scanner);
                    break;
                case 2:
                    removeCarByLicensePlate(scanner);
                    break;
                case 3:
                    removeCarByOwnerName(scanner);
                    break;
                case 4:
                    viewParkedCars();
                    break;
                case 5:
                    searchCar(scanner);
                    break;
                case 6:
                    getEmptySlots();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Vendosni orën e hyrjes (formati HH:mm): ");
            String oraHyrje = scanner.next();

            System.out.print("Vendosni orën e daljes (formati HH:mm): ");
            String oraDalje = scanner.next();

            Qmimorja qmimorja = new Qmimorja(oraHyrje);
            double qmimi = qmimorja.llogaritQmimin(oraDalje);
            System.out.println("Qmimi total është: " + qmimi + " Euro ");

            MetodaPageses metodaPageses = new MetodaPageses();

            // Konfirmoni pagesën
            metodaPageses.konfirmoPagesen(qmimi);
        }


    }

    // Park a car by entering license plate number and owner name
    private static void parkCar(Scanner scanner) {
        if (availableSlots == 0) {
            System.out.println("Sorry, there are no available parking slots.");
            return;
        }

        System.out.println("Enter the license plate number of the car:");
        String licensePlate = scanner.next();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the car owner's name:");
        String ownerName = scanner.nextLine();

        parkedCars.put(licensePlate, ownerName);
        availableSlots--;
        System.out.println("Car parked successfully. Available slots: " + availableSlots);
    }

    // Remove a car by entering the license plate number
    private static void removeCarByLicensePlate(Scanner scanner) {
        if (availableSlots == totalSlots) {
            System.out.println("There are no parked cars.");
            return;
        }

        System.out.println("Enter the license plate number of the car to be removed:");
        String licensePlate = scanner.next();
        if (parkedCars.containsKey(licensePlate)) {
            String ownerName = parkedCars.remove(licensePlate);
            availableSlots++;
            System.out.println("Car owned by " + ownerName + " and with license plate " + licensePlate +
                    " removed successfully. Available slots: " + availableSlots);
        } else {
            System.out.println("The car is not parked here.");
        }
    }

    // Remove a car by entering the owner's name
    private static void removeCarByOwnerName(Scanner scanner) {
        if (availableSlots == totalSlots) {
            System.out.println("There are no parked cars.");
            return;
        }

        System.out.println("Enter the owner's name of the car to be removed:");
        String ownerName = scanner.nextLine();
        List<String> carsToRemove = new ArrayList<>();

        for (Map.Entry<String, String> entry : parkedCars.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(ownerName)) {
                carsToRemove.add(entry.getKey());
            }
        }

        if (!carsToRemove.isEmpty()) {
            for (String licensePlate : carsToRemove) {
                parkedCars.remove(licensePlate);
                availableSlots++;
            }
            System.out.println("Cars owned by " + ownerName + " removed successfully. Available slots: " + availableSlots);
        } else {
            System.out.println("No cars owned by " + ownerName + " are parked here.");
        }
    }

    // View all parked cars (license plate number and owner name)
    private static void viewParkedCars() {
        if (availableSlots == totalSlots) {
            System.out.println("There are no parked cars.");
            return;
        }

        System.out.println("Parked cars:");
        for (Map.Entry<String, String> entry : parkedCars.entrySet()) {
            String licensePlate = entry.getKey();
            String ownerName = entry.getValue();
            System.out.println("License Plate: " + licensePlate + ", Owner: " + ownerName);
        }
    }

    // Search for a car by entering the license plate number or owner's name
    private static void searchCar(Scanner scanner) {
        System.out.println("Enter the license plate number or owner's name of the car to search:");
        String searchQuery = scanner.next();
        boolean found = false;

        for (Map.Entry<String, String> entry : parkedCars.entrySet()) {
            String licensePlate = entry.getKey();
            String ownerName = entry.getValue();
            if (licensePlate.equalsIgnoreCase(searchQuery) || ownerName.equalsIgnoreCase(searchQuery)) {
                System.out.println("The car is parked here. License Plate: " + licensePlate + ", Owner: " + ownerName);
                found = true;
            }
        }


        if (!found) {
            System.out.println("The car is not parked here.");
        }
    }

    // Get information about the number of empty slots in the parking system
    private static void getEmptySlots() {
        int emptySlots = totalSlots - parkedCars.size();
        System.out.println("Total empty slots: " + emptySlots);
    }


}