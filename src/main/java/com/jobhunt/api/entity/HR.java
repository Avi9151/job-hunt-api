package com.jobhunt.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "hr")
public class HR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hrId;
    private String hrName;
    private String emailId;
    private String password;
    private String companyName;
    private Long companyId;
}
