package com.Sprint3.sprint3.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String document;

    private String phone;

    private String address;

    private String users;

    private String transactions;

    private Date createdAt;

    private Date updatedAt;

}
