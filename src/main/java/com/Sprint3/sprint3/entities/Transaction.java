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
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 60)
    private String concept;

    @Column(nullable = false)
    private float amount;

    @ManyToOne
    @JoinColumn(name = "empleado_id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "empresa_id_enterprise")
    private Enterprise enterprise;

    private Date createdAt;

    private Date updatedAt;

}
