/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpage;

import hr.ejb.CustomerService;
import hr.model.entity.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 吕杨
 */
@Named(value="RegCustomer")
@SessionScoped
public class RegCustomer implements Serializable{
    @Inject
    private CustomerService customerService;
    private Customer customer;

    private String phone;
    private String address;
    
    //login
    private String userIdentity;
    private String userName;
    private String email;
    private String password;
    
    //reservation
    private String departure;
    private String arrival;
    private String passengers;
    private String departureTime;
    
    
    
    public String makeReservation(){
        
        return null;
    }
    
    public String saveRegInfo() {
        customer = customerService.findCustomerByEmail(email);
        if (customer == null){
          //this is  new user -- do a create
          System.out.println("Registration Managed Bean creating new user ");
          customer = new Customer();
          customer.setEmail(email);
          customerService.create(customer);
      }
      else {
          //this user already exists so they can not register again
           FacesMessage facesMessage = new FacesMessage("Registration Failed - user already exists");
       facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
          System.out.println("Registration failed - user exists: "+customer.toString());
          
      }
      return "login";
      // return "lastpage";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    
    
}
