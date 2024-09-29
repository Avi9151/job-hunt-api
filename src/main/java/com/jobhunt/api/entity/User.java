package com.jobhunt.api.entity;


import com.jobhunt.api.converter.SkillsConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String emailId;
    private String password;
    private LocalDate dateOfBirth; // Optional
    private String linkedin; // Optional
    private String address;

    @Convert(converter = SkillsConverter.class)
    private List<String> skills;
}
