package org.javaacademy.dto;

import lombok.Data;

@Data
public class SignUpRq {
    private String email;
    private String password;
    private String name;
}
