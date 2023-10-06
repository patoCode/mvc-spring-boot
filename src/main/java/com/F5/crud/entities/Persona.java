package com.F5.crud.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 150)
    @NotEmpty
    private String name;

    @Column(length = 250)
    @NotEmpty
    private String lastname;

    @Column(length = 250)
    @NotEmpty
    @Email
    private String email;

}
