package com.ssafy.flody.domain.comments;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_no")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_no")
    private Posts post;
    //    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Comments.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "comments_upper_comments_comno")
//    private Comments upperParent;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "upperParent")
//    private List<Comments> upperChildren;
    @Column
    private Long upper;
    @Column(nullable = false)
    private String content;
    @CreatedDate
    private Date postDate;
    @Column(nullable = false)
    private int kids;
}
