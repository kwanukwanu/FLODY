package com.ssafy.flody.domain.posts.pictures;

import com.ssafy.flody.domain.posts.Posts;
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
public class Pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long picNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class)
    @JoinColumn(name = "pos_no")
    private Posts post;
    @Column(nullable = false)
    private int order;
    @Column(nullable = false)
    private String url;
}
