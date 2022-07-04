package com.example.BankingApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Log4j2
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beneficiary")
public class BeneficiaryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beneficiaryId;

    @Column(name = " name")
    @NotBlank(message = "name is mandatory")
    private String name;

    @Column(name = "nic")
    @NotBlank(message = "nic is mandatory")

    private String nic;
    @Pattern(regexp = "/^\\d{9}[vVxX]$/")
    @Column(name = "gender")
    @NotBlank(message = "gender is mandatory")
    private String gender;

    @Column(name = "dob")
    @NotBlank(message = "dob is mandatory")
    private Date dob;

    @Column(name = "address")
    @NotBlank(message = "address is mandatory")
    private String address;

    @Column(name = "mobile")
    @NotBlank(message = "mobile is mandatory ")
    @Pattern(regexp = "(\\\\+94|0)\\d{9}")
    private String mobile;

    @Column(name = "email")
    @NotBlank(message = "email is mandatory")
    @Email( regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @Column(name = "relationship")
    @NotBlank(message = "relationship is mandatory")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotBlank(message = "customer id is mandatory")
    private Integer customerId;

}
