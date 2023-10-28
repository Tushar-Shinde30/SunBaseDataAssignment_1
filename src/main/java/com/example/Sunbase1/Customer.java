package com.example.Sunbase1;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {


    @Id
    @GeneratedValue

    UUID id;

    String firstName;
    String lastName;
    String street;
    String address;
    String city;
    String state;
    String email;
    String phone;

    public Customer(UUID id) {
        this.id = id;
    }




}
