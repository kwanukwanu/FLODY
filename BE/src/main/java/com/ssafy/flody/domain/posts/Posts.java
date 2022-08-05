package com.ssafy.flody.domain.posts;

import com.ssafy.flody.domain.posts.categories.Categories;
import com.ssafy.flody.domain.posts.coverages.Coverages;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_no")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Categories.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_no")
    private Categories category;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Coverages.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cov_no")
    private Coverages coverage;
    @Column
    private String title;
    @Column
    private String content;
    @Column(nullable = false)
    private String hashtag;
    @Column(nullable = false)
    private int likeCnt;
    @Column(nullable = false)
    private int commentCnt;
    @CreatedDate
    private Date postDate;
}
