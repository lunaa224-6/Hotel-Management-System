/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project3;



public class Person {
    protected String name;
    protected int age;
    protected String Id;
    protected String email;
    protected String phoneNumber;

    public Person(String name , int age , String Id , String phoneNumber , String email ){
        this.name = name;
        this.age = age;  
        this.Id = Id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Id: " + Id);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public void updateContactDetails(String phoneNumber , String email ){
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

class Staff extends Person{     
    public String jobTitle;
    public double salary;     

    public Staff(String name, int age, String Id ,String phoneNumber, String email, String jobTitle, double salary){ 
        super(name, age, Id ,phoneNumber, email);
        this.jobTitle = jobTitle;       
        this.salary = salary;
    }

    public void raiseSalary(double amount){      
        this.salary += amount;
        System.out.println("Salary after raise: " + salary);          
    }         

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Job Title: " + jobTitle);        
        System.out.println("Salary: " + salary);
    }      
            
}  

class Guest extends Person {    
    protected Room roomNumber;

    Guest(String name, int age, String Id ,String phoneNumber, String email, Room roomNumber){ 
        super(name, age, Id ,phoneNumber, email); 
        this.roomNumber = roomNumber;
    }

    public Room getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        if (roomNumber != null) {
            System.out.println("Room Number: " + roomNumber.getRoomNumber());
        } else {
            System.out.println("No room assigned.");
        }
    }    
}

