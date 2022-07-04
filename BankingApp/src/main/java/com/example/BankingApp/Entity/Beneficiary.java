package com.example.BankingApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beneficiary")
public class Beneficiary {
    @Id
    private int beneficiaryId;
    private String name;
    private String nic;
    private String gender;
    private Date dob;
    private String address;
    private String mobile;
    private String email;
    private String relationship;
    private Integer customerId;

}
