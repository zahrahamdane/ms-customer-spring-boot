package com.ensa.mscustomer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("customer")
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
}
