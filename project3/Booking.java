/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project3;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Booking {
    protected double serviceCost = 500;
    protected String bookingId;
    protected Room room;//  protected build building
    protected Guest customer;
    protected LocalDate bookingDate;
    protected String status;
    protected LocalDate checkInTime;
    protected LocalDate checkOutTime;

    public static final String AVAILABLE = "Available";
    public static final String NOTAVAILABLE = "NotAvailable";

    public Booking(String bookingId, Room room, Guest customer, LocalDate bookingDate, LocalDate checkInTime, LocalDate checkOutTime) {
        this.bookingId = bookingId;
        this.room = room;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;

        if (room.checkAvailability(checkInTime, checkOutTime)) {
            this.status = AVAILABLE;   
        } else {
            this.status = NOTAVAILABLE;
        }
    }

    public boolean createBooking() {
        if (room.checkAvailability(checkInTime, checkOutTime)) {
            room.addBooking(checkInTime, checkOutTime);
            status = "Confirmed"; 
            System.out.println("Booking created successfully for Room " + room.getRoomNumber() +
             " from " + checkInTime + " to " + checkOutTime);
            return true;
        } else {
            System.out.println("Failed to create booking. Room " + room.getRoomNumber() +
                    " not available from " + checkInTime + " to " + checkOutTime);
            return false;
        }
    }

    public void cancelBooking() {
        if (status.equals("Confirmed")) {
            room.cancelBooking(checkInTime, checkOutTime);
            this.status = "Cancelled";
            System.out.println("The booking has been cancelled for Room " + room.getRoomNumber() 
                               + " from " + checkInTime + " to " + checkOutTime);
        } else {
            System.out.println("The booking cannot be cancelled because it is not confirmed");
        }
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId 
                + ", Room: " + room.getRoomNumber() 
                + ", Customer name: " + customer.getName()
                + ", Date: " + bookingDate 
                + ", Status: " + status);
    }

    public abstract double calculateTotalCost();
}

class PremiumBooking extends Booking {
    private List<String> additionalServices;

    public PremiumBooking(String bookingId, Room room, Guest customer, LocalDate bookingDate, LocalDate checkInTime, LocalDate checkOutTime) {
        super(bookingId, room, customer, bookingDate, checkInTime, checkOutTime);
        this.additionalServices = new ArrayList<>();
    }

    public void addService(String service) {
        additionalServices.add(service);
        System.out.println("Service added: " + service);
    }

    public void removeService(String service) {
        if (additionalServices.remove(service)) {
            System.out.println("Service removed: " + service);
        } else {
            System.out.println("Service not found: " + service);
        }
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = room.calculatePrice() + (additionalServices.size() * serviceCost);
        // Premium includes breakfast by note, but let's assume it's part of the premium price.
        return totalCost;
    }

    @Override
    public void displayBooking() {
        super.displayBooking();
        System.out.println("Additional Services: " + additionalServices);
    }
}


class StandardBooking extends Booking {
    private boolean breakfastIncluded;

    public StandardBooking(String bookingId, Room room, Guest customer, LocalDate bookingDate, LocalDate checkInTime, LocalDate checkOutTime, boolean breakfastIncluded) {
        super(bookingId, room, customer, bookingDate, checkInTime, checkOutTime);
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = room.calculatePrice();
        if (breakfastIncluded) {
            totalCost += 100; 
        }
        return totalCost;
    }

    @Override
    public void displayBooking() {
        super.displayBooking();
        System.out.println("Breakfast Included: " + (breakfastIncluded ? "Yes" : "No"));
    }
}

