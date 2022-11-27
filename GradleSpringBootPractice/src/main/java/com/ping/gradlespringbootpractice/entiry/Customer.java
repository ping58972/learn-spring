package com.ping.gradlespringbootpractice.entiry;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Customer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    private String id;

    //@NotNull(message = "UserId must not be null")
    @Indexed(unique = true)
    private int userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    private String email;
    private String cellPhone;
    private String alternatePhone;
    private String gender;
    private String ssn;
    private String dob;
    private String startDate;
    private String endDate;
    private String driverLicense;
    private String driverLicenseExpiration;

    private int houseId;

//    private List<Address> address = new ArrayList<>();
//
//    private List<Contact> contact = new ArrayList<>();
//
//    private List<VisaStatus> visaStatus = new ArrayList<>();
//
//    private List<PersonalDocument> personalDocument = new ArrayList<>();
}
