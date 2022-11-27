package com.ping.gradlespringbootpractice.entiry;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonalDocument {
    private int id;
    private String path;
    private String title;
    private String comment;
    private Date createDate;
}
