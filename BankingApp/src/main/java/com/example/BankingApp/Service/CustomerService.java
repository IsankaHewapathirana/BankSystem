package com.example.BankingApp.Service;

import com.example.BankingApp.DTO.CustomerDTO;
import com.example.BankingApp.Entity.Customer;
import com.example.BankingApp.Repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Log4j2
@Service
@Transactional
public class CustomerService {


    private CustomerRepository customerRepo;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    //add customer
    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        Customer customer= customerRepo.findByCustomerId(customerDTO.getCustomerId());
        if (customer==null){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            log.info("add new customer to the system");
            return customerDTO;
        }
        else {
            log.error("Error creating this customer");
            throw new NoSuchElementException("No customer found");
        }
    }

    //find all customers
    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customerList=customerRepo.findAll();
        return modelMapper.map(customerList,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    //update customer
    public String updateCustomer(CustomerDTO customerDTO,Integer customerId){
        CustomerDTO cdto=modelMapper.map(customerRepo.findByCustomerId(customerId),CustomerDTO.class);
        if (cdto==null){
            throw new NoSuchElementException("Not found customer with this id :"+customerDTO.getCustomerId());
        }
        else {
            cdto.setName(customerDTO.getName());
            cdto.setNic(customerDTO.getNic());
            cdto.setGender(customerDTO.getGender());
            cdto.setDob(customerDTO.getDob());
            cdto.setAddress(customerDTO.getAddress());
            cdto.setMobile(customerDTO.getMobile());
            cdto.setEmail(customerDTO.getEmail());
            cdto.setMaritalStatus(customerDTO.getMaritalStatus());
            cdto.setOccupation(customerDTO.getOccupation());
            customerRepo.save(modelMapper.map(cdto,Customer.class));
            return "Customer Updated successfully";
        }

    }

    //Delete Customer
    public String deleteCustomer(CustomerDTO customerDTO,Integer customerId){
        CustomerDTO cdto=modelMapper.map(customerRepo.findByCustomerId(customerId),CustomerDTO.class);
        if (cdto==null){
            log.error("error deleting customer");
            throw new NoSuchElementException("Not found customer with this id :"+customerDTO.getCustomerId());
        }
        else {
            customerRepo.save(modelMapper.map(cdto,Customer.class));
            log.info("Customer deleted");
            return "Customer deleted successfully";
        }

    }
    //Search Customer
    public Customer searchCustomer(Integer customerId){
       Customer customer=customerRepo.findByCustomerId(customerId);
       if (customer==null){
           log.error("searching invalid customer");
           throw new NoSuchElementException("Not found customer with this id :"+customerId);
       }
       else {
           log.info("Search customer");
           return modelMapper.map(customer,Customer.class);
       }

    }



}
