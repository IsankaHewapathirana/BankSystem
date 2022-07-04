package com.example.BankingApp.Controller;

import com.example.BankingApp.DTO.CustomerDTO;
import com.example.BankingApp.Entity.Customer;
import com.example.BankingApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
public class CustomerController {

    private CustomerService customerSer;

    @Autowired
    public CustomerController(CustomerService customerSer) {
        this.customerSer = customerSer;
    }

    //save customer
    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerSer.addCustomer(customerDTO);
    }

    //find all customers
    @GetMapping("/getCustomers")
    public List<CustomerDTO> findAllCustomers(){
        return customerSer.getAllCustomers();
    }

    //update customer
    @PutMapping("/updateCustomer/{customerId}")
    public void updateCustomers(@RequestBody CustomerDTO customerDTO, @PathVariable Integer customerId){
        customerSer.updateCustomer(customerDTO,customerId);
    }

    //delete Customer
    @DeleteMapping("/delete/{customerId}")
    public String  deleteCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Integer customerId){
        return customerSer.deleteCustomer(customerDTO,customerId);
    }


    //search Customer
    @GetMapping("/search/{customerId}")
    public Customer searchCustomer(@PathVariable Integer customerId){
        return customerSer.searchCustomer(customerId);
    }

}
