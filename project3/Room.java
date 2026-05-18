/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project3;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    protected int roomNumber;
    protected boolean isBooked;
    protected boolean jacuzzi;
    protected List<BookingPeriod> bookingHistory;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.jacuzzi = false;
        this.bookingHistory = new ArrayList<>();
    }

    public boolean checkAvailability(LocalDate checkIn, LocalDate checkOut) {
        for (BookingPeriod period : bookingHistory) {
            if (period.overlapsWith(checkIn, checkOut)) {
                return false;
            }
        }
        return true;
    }

    public void addBooking(LocalDate checkIn, LocalDate checkOut) {
        bookingHistory.add(new BookingPeriod(checkIn, checkOut));
        isBooked = true;
    }

    public void cancelBooking(LocalDate checkIn, LocalDate checkOut) {
        for (int i = 0; i < bookingHistory.size(); i++) {
            BookingPeriod period = bookingHistory.get(i);
            if (period.getCheckIn().equals(checkIn) && period.getCheckOut().equals(checkOut)) {
                bookingHistory.remove(i);
                break;
            }
        }
        if (bookingHistory.isEmpty()) {
            isBooked = false;
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setHasJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public boolean getHasJacuzzi() {
        return jacuzzi;
    }

    public double calculatePrice() {
        double basePrice = 1000; 
        if (jacuzzi) {
            basePrice += 350; 
        }
        return basePrice;
    }

    private class BookingPeriod {
        private LocalDate checkIn;
        private LocalDate checkOut;

        public BookingPeriod(LocalDate checkIn, LocalDate checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public boolean overlapsWith(LocalDate otherCheckIn, LocalDate otherCheckOut) {
            return !(otherCheckOut.isBefore(checkIn) || otherCheckIn.isAfter(checkOut));
        }

        public LocalDate getCheckIn() {
            return checkIn;
        }

        public LocalDate getCheckOut() {
            return checkOut;
        }
    }
}

class StandardRoom extends Room {
    private int numberOfBeds;

    public StandardRoom(int roomNumber) {
        super(roomNumber);
        this.numberOfBeds =1;
    }

    public boolean setNumberOfBeds(int numberOfBeds) {
        if (numberOfBeds >= 1 && numberOfBeds <= 4) {
            this.numberOfBeds = numberOfBeds;
            return true; 
        }
        return false; 
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + (numberOfBeds - 1) * 200; 
    }
}

class SuiteRoom extends Room {
    private boolean balcony;

    public SuiteRoom(int roomNumber) {
        super(roomNumber);
        this.balcony = false;
    }

    public boolean getHasBalcony() {
        return this.balcony;
    }

    public void setHasBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice() + 2000;
        if (balcony) {
            price += 300; 
        }
        return price;
    }
}

