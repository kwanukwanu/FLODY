package com.ssafy.flody.domain.flowers;

import com.ssafy.flody.domain.flowers.categories.FCategories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long floNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FCategories.class)
    @JoinColumn(name = "fc_no")
    private FCategories fcNo;
    @Column(nullable = false)
    private String name;
    @Column
    private String content;
    @Column(nullable = false)
    private String url;
}
