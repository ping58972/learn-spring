package com.ping.gradlespringbootpractice.entiry;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    private int id;

    private String firstName;

    private String lastName;

    private String cellPhone;

    private String alternatePhone;

    private String email;

    private String relationship;

    private String type;


}
