package com.ssafy.flody.domain.posts.coverages;

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
public class Coverages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long covNo;
    @Column(nullable = false)
    private String name;
}
