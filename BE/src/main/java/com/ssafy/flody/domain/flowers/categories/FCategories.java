package com.ssafy.flody.domain.flowers.categories;

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
@Table(name = "F_categories")
public class FCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fcNo;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String period;
}
