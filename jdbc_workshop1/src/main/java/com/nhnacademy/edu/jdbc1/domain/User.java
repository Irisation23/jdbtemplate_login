package com.nhnacademy.edu.jdbc1.domain;



import lombok.Value;

import java.util.Date;

@Value
public class User {
    private long id;
    private String name;
    private String password;
    private Date date;

}
