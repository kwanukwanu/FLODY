package com.ssafy.flody.domain.licenses.mfields;

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
@Table(name = "M_Fields")
public class MFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mfNo;
    @Column(nullable = false)
    private String mobligfldnm;
    @Column(nullable = false)
    private String mobligfldcd;
}
