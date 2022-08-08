package com.ssafy.flody.domain.licenses.departments;

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
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depNo;
    @Column(nullable = false)
    private String udeptnm;
    @Column(nullable = false)
    private int udeptcd;
}
