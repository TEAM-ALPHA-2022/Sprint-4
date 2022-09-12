package com.Sprint3.sprint3.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concept;

    private float amount;

    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "Enterprise_id")
    private Enterprise enterprise;


}
