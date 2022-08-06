package com.ssafy.flody.domain.licenses.fields;

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
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieNo;
    @Column(nullable = false)
    private String obligfldnm;
    @Column(nullable = false)
    private int obligfldcd;
}
