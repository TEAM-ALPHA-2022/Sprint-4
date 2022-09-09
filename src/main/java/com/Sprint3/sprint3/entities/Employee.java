package com.Sprint3.sprint3.entities;

import com.Sprint3.sprint3.enums.Enum_RoleName;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String profile;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "enum_role_name_id")
    private Enum_RoleName enum_roleName;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany
    @JoinColumn(name = "transactions_id")
    private List<Transaction> transactions;

    private Date createdAtEmpleado;

    private Date updatedAtEmpleado;

}
