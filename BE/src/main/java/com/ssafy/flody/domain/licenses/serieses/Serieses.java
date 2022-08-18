package com.ssafy.flody.domain.licenses.serieses;

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
public class Serieses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serNo;
    @Column(nullable = false)
    private String seriesnm;
    @Column(nullable = false)
    private String seriescd;
}
