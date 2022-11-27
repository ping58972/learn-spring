package com.ping.gradlespringbootpractice.entiry;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisaStatus {

    private int id;

    private String visaType;

    private boolean activeFlag;

    private String startDate;

    private String endDate;

    private Date lastModificationDate;


}
