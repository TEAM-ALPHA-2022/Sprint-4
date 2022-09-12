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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee")
    private Long id;

    @Column(unique = true)
    private String email;

    private String profile;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "enum_role")
    private Enum_RoleName enum_roleName;

    @ManyToOne
    @JoinColumn(name = "idEnterprise")
    private Enterprise enterprise;



}
