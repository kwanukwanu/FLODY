package com.ssafy.flody.domain.groups.roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "G_Roles")
public class GRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grNo;
    @Column(nullable = false)
    private String name;
}
