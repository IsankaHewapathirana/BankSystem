package com.example.BankingApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @NotBlank(message = "name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "NIC is mandatory")
    @Column(name = "nic")
    private String nic;

    @NotBlank(message = "Gender is mandatory")
    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @NotBlank(message = "address is mandatory")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "contact number is mandatory")
    @Column(name = "mobile")
    private String mobile;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    @Email( regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotBlank(message = "marital status is mandatory")
    @Column(name = "marital_status")
    private String maritalStatus;

    @NotBlank(message = "occupation is mandatory")
    @Column(name = "occupation")
    private String occupation;

}
