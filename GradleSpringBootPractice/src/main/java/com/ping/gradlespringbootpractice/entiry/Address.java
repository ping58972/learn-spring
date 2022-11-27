package com.ping.gradlespringbootpractice.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private int id;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String zipCode;

}
