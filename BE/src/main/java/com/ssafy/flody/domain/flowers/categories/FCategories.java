package com.ssafy.flody.domain.flowers.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fcNo;

    @NotNull
    private String name;

    private String period;
}
