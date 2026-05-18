/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project3;


import project3.Booking;
import project3.Guest;
import project3.Person;
import project3.PremiumBooking;
import project3.Room;
import project3.Staff;
import project3.StandardBooking;
import project3.StandardRoom;
import project3.SuiteRoom;
import java.util.*;
import java.time.LocalDate;

public class Project3 {

    static String main_menu = """

              **Welcome to Our Hotel!!**
            -------------------------------------------
             We are delighted to have you with us and look forward
             to making your stay unforgettable!!.
            -------------------------------------------
             Please choose a number from the list below
             1- Guest SubSystem
             2- Staff SubSystem
             3- Update Contact Details
             4- Exit
            -------------------------------------------
              Your Choice: """;

    static String guest_menu = """
                  **Welcome to Guest Sub_System**
            ----------------------------------------------
            Choose The Service Number from the list below
            ----------------------------------------------
             1- New Guest
             2- I've been here before
             3- Exit
            ----------------------------------------------
               Your Choice:""";

    static String booking_menu = """

            Choose The kind of Booking from the list below
            -----------------------------------------------
             1- Premium Booking
             2- Standard Booking
             3- Cancel Booking 
             4- Show My Details
             5- Exit                
            -----------------------------------------------
             Your Choice:""";


    static String premium_Booking = """

            Choose A Service Number from below
            Note: The Premium Booking Includes The Breakfast Service
            --------------------------------------------------------
             1- Choose The Room Type
             2- Add Service
             3- Cancel Service
             4- Total cost
             5- Display Booking
             6- Exit
            --------------------------------------------------------
             Your Choice:""" ;

    static String standerd_Booking = """
              Choose A Number from below
            --------------------------------
             1- Choose The Room Type
             2- Add Breakfast
             3- Total cost
             4- Display Booking
             5- Exit
            --------------------------------
             Your Choice:""";

    static String roomType_Menu = """
             Choose A Number from below
            --------------------------------
             1- Suite Room
             2- Standard Room
             3- Exit
            --------------------------------
             Your Choice:""";


    static String suitRoom_Menu ="""

            Choose A Number from below
            -----------------------------
             1- With Jacuzzi
             2- Without Jacuzzi
             3- With Balcony
             4- Without Balcony
             5- Total cost
             6- Display Booking
             7- Exit
            -----------------------------
             Your Choice:""";

    static String standerdRoom_Menu ="""

            Choose A Number from below
            -----------------------------
             1- With Jacuzzi
             2- Without Jacuzzi
             3- Choose Number Of Beds
             4- Total cost
             5- Display Room Details
             6- Exit
            -----------------------------
             Your Choice:""";

    static String staff_menu = """
                     **Welcome to Staff Sub_System**
                 ----------------------------------------------
                 Choose The Service Number from the list below
                 1- New Staff
                 2- Show My Details
                 3- Adding an allowance to my salary
                 4- Exit
                 ----------------------------------------------
                  Your Choice:""";


    static Guest g1;
    static Booking b1;
    static Staff staff;

    static Scanner input = new Scanner(System.in);
    static String name;
    static int age;
    static String Id;
    static String job;
    static double salary;
    static String phoneNumber;
    static String email;


    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.print(main_menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.print(main_menu);
            }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    guest_SubSystem();
                    break;

                case 2:
                    staff_SubSystem();
                    break;
                case 3:
                    if (g1 != null) {
                        System.out.println("Enter new phone number: ");
                        String newPhone = input.next();
                        System.out.println("Enter new email: ");
                        String newEmail = input.next();
                        g1.updateContactDetails(newPhone, newEmail);
                        System.out.println("Contact details updated successfully!");
                    } else {
                        System.out.println("No guest found. Please create a guest first.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our system. Goodbye!");
                    break;

                default:
                    System.out.println("Wrong Entry. Please enter a valid option.");
            }

        } while (choice != 4);

    }

    public static void staff_SubSystem() {
        int choice = 0;
        do {
            System.out.println(staff_menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); 
                System.out.println(staff_menu);
            }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    name = input.next();

                    System.out.println("Enter your Age: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer for age.");
                        input.next();
                    }
                    age = input.nextInt();

                    System.out.println("Enter your Id: ");
                    Id = input.next();

                    System.out.println("Enter your Phone Number: ");
                    phoneNumber = input.next();

                    System.out.println("Enter your email");
                    email = input.next();

                    System.out.println("Enter your job");
                    job = input.next();

                    System.out.println("Enter your salary");
                    while (!input.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a number for salary.");
                        input.next();
                    }
                    salary = input.nextDouble();

                    staff = new Staff(name, age, Id, phoneNumber, email, job, salary);
                    System.out.println("Staff created successfully!");
                    break;

                case 2:
                    if (staff != null) {
                        staff.showDetails();
                    } else {
                        System.out.println("No staff found. Please create a staff first.");
                    }
                    break;

                case 3:
                    if (staff != null) {
                        System.out.println("Enter allowance to add to your salary: ");
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a number for allowance.");
                            input.next();
                        }
                        double allowance = input.nextDouble();
                        staff.raiseSalary(allowance);
                        System.out.println("Salary updated successfully!");
                    } else {
                        System.out.println("No staff available. Please create a staff first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Staff SubSystem.");
                    break;
                default:
                    System.out.println("Wrong Entry");
            }

        } while (choice != 4);
    }

    public static void guest_SubSystem() {
        int choice = 0;

        do {
            System.out.println(guest_menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(guest_menu);
            }
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    name = input.next();

                    System.out.println("Enter your Age: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer for age.");
                        input.next();
                    }
                    age = input.nextInt();

                    System.out.println("Enter your Id: ");
                    Id = input.next();

                    System.out.println("Enter your Phone Number: ");
                    phoneNumber = input.next();

                    System.out.println("Enter your email");
                    email = input.next();

                    System.out.println("Enter your room number: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer for room number.");
                        input.next();
                    }
                    int roomNum = input.nextInt();

                    Room selectedRoom = new StandardRoom(roomNum);

                    g1 = new Guest(name, age, Id, phoneNumber, email, selectedRoom);
                    System.out.println("Guest created successfully!");

                    System.out.println("Would you like to create a booking? (yes/no)");
                    String response = input.next().toLowerCase();
                    if (response.equals("yes") || response.equals("y")) {
                        booking_System();
                    }

                    break;
                case 2:
                    if (g1 != null) {
                        g1.showDetails();
                        if (b1 != null) {
                            b1.displayBooking();
                        } else {
                            System.out.println("No booking found.");
                        }
                    } else {
                        System.out.println("No guest found. Please create a guest first.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Guest SubSystem.");
                    break;
                default:
                    System.out.println("Wrong Entry");
            }

        } while (choice != 3);
    }

    public static void booking_System() {
        int choice = 0;
        do {
            System.out.println(booking_menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(booking_menu);
            }
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    // Premium Booking
                    if (g1 == null) {
                        System.out.println("No guest found. Create a guest first.");
                    } else {
                        Room gr = g1.getRoomNumber();
                        LocalDate checkIn = LocalDate.now().plusDays(1);
                        LocalDate checkOut = checkIn.plusDays(3);
                        b1 = new PremiumBooking("PB001", gr, g1, LocalDate.now(), checkIn, checkOut);
                        b1.createBooking();
                        premium_booking();
                    }
                    break;
                case 2:
                    // Standard Booking
                    if (g1 == null) {
                        System.out.println("No guest found. Create a guest first.");
                    } else {
                        Room gr = g1.getRoomNumber();
                        LocalDate checkIn = LocalDate.now().plusDays(1);
                        LocalDate checkOut = checkIn.plusDays(3);
                        b1 = new StandardBooking("SB001", gr, g1, LocalDate.now(), checkIn, checkOut, false);
                        b1.createBooking();
                        standerd_booking();
                    }
                    break;
                case 3:
                    if (b1 != null) {
                        b1.cancelBooking();
                    } else {
                        System.out.println("No booking found to cancel.");
                    }
                    break;
                case 4:
                    if (b1 != null) {
                        b1.displayBooking();
                    } else {
                        System.out.println("No booking found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Booking System.");
                    break;
                default:
                    System.out.println("Wrong Entry");
            }

        } while (choice != 5);
    }

    public static void premium_booking() {
        int choice = 0;
        do {
            System.out.println(premium_Booking);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(premium_Booking);
            }
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    roomType_Menu();
                    break;
                case 2:
                    System.out.println("Enter the Service (e.g., Spa, Gym): ");
                    String service = input.next();
                    if (b1 instanceof PremiumBooking) {
                        PremiumBooking b2 = (PremiumBooking) b1;
                        b2.addService(service);
                    } else {
                        System.out.println("No Premium Booking found. Please create a Premium Booking first.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Service to remove: ");
                    String servi = input.next();
                    if (b1 instanceof PremiumBooking) {
                        PremiumBooking b3 = (PremiumBooking) b1;
                        b3.removeService(servi);
                    } else {
                        System.out.println("No Premium Booking found. Please create a Premium Booking first.");
                    }
                    break;
                case 4:
                    if (b1 instanceof PremiumBooking) {
                        PremiumBooking b4 = (PremiumBooking) b1;
                        double total = b4.calculateTotalCost();
                        System.out.println("The Total Cost = " + total + "$");
                    } else {
                        System.out.println("No Premium Booking found. Please create a Premium Booking first.");
                    }
                    break;
                case 5:
                    if (b1 != null) {
                        b1.displayBooking();
                    } else {
                        System.out.println("No booking found to display.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Premium Booking Menu.");
                    break;
                default:
                    System.out.println("Wrong Entry");
            }

        } while (choice != 6);
    }

    public static void standerd_booking() {
        int choice = 0;
        do {
            System.out.println(standerd_Booking);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(standerd_Booking);
            }
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    roomType_Menu();
                    break;
                case 2:
                    if (b1 instanceof StandardBooking) {
                        StandardBooking b2 = (StandardBooking) b1;
                        b2.setBreakfastIncluded(true);
                        System.out.println("Breakfast is Included");
                    } else {
                        System.out.println("No Standard Booking found. Please create a Standard Booking first.");
                    }
                    break;
                case 3:
                    if (b1 instanceof StandardBooking) {
                        StandardBooking b3 = (StandardBooking) b1;
                        double cost = b3.calculateTotalCost();
                        System.out.println("The Total Cost = " + cost + "$");
                    } else {
                        System.out.println("No Standard Booking found. Please create a Standard Booking first.");
                    }
                    break;
                case 4:
                    if (b1 != null) {
                        b1.displayBooking();
                    } else {
                        System.out.println("No booking found to display.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Standard Booking Menu.");
                    break;

                default:
                    System.out.println("Wrong Entry");
            }

        } while (choice != 5);
    }

    public static void suiteRoom_Menu() {
        System.out.println("Enter Suite Room Number: ");
        int roomNum;
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number for room number.");
            input.next();
        }
        roomNum = input.nextInt();
        SuiteRoom obj = new SuiteRoom(roomNum);

        int choice;
        do {
            System.out.println(suitRoom_Menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(suitRoom_Menu);
            }
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    obj.setHasJacuzzi(true);  
                    System.out.println("Jacuzzi has been added.");
                    break;

                case 2:
                    obj.setHasJacuzzi(false); 
                    System.out.println("Jacuzzi has been removed.");
                    break;

                case 3:
                    obj.setHasBalcony(true); 
                    System.out.println("Balcony has been added.");
                    break;

                case 4:
                    obj.setHasBalcony(false);  
                    System.out.println("Balcony has been removed.");
                    break;

                case 5:
                    System.out.println("Total Cost for the room is: " + obj.calculatePrice() + "$");
                    break;

                case 6:
                    if (b1 != null) {
                        b1.displayBooking();
                    } else {
                        System.out.println("No booking found to display.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting Suite Room Menu.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 7);  
    }

    public static void standardRoom_Menue() {
        System.out.println("Enter Standard Room Number: ");
        int roomNum;
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number for room number.");
            input.next();
        }
        roomNum = input.nextInt();
        StandardRoom obj = new StandardRoom(roomNum);

        int choice;

        do {
            System.out.println(standerdRoom_Menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(standerdRoom_Menu);
            }
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    obj.setHasJacuzzi(true);
                    System.out.println("Jacuzzi has been added.");
                    break;

                case 2:
                    obj.setHasJacuzzi(false);
                    System.out.println("Jacuzzi has been removed.");
                    break;

                case 3:
                    System.out.print("Enter the number of beds (1-4): ");
                    int numberOfBeds;
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer for number of beds.");
                        input.next();
                    }
                    numberOfBeds = input.nextInt();
                    if (obj.setNumberOfBeds(numberOfBeds)) {
                        System.out.println("Number of beds is set to: " + numberOfBeds);
                    } else {
                        System.out.println("Invalid number of beds. Please enter a number between 1 and 4.");
                    }
                    break;
                case 4:
                    System.out.println("Total Cost for the room is: " + obj.calculatePrice() + "$");
                    break;

                case 5:
                    System.out.println("Room Number: " + obj.getRoomNumber());
                    System.out.println("Room Type: Standard Room");
                    System.out.println("Has Jacuzzi: " + obj.getHasJacuzzi());
                    System.out.println("Number of Beds: " + obj.getNumberOfBeds());
                    System.out.println("Total Cost: " + obj.calculatePrice() + "$");
                    break;
                case 6:
                    System.out.println("Exiting Standard Room Menu.");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }
        } while (choice != 6);

    }

    public static void roomType_Menu() {
        int choice;
        do {
            System.out.println(roomType_Menu);
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
                System.out.println(roomType_Menu);
            }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    suiteRoom_Menu();
                    break;
                case 2:
                    standardRoom_Menue();
                    break;
                case 3:
                    System.out.println("Exiting Room Type Menu.");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 3);
    }
}

