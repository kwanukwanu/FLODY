package com.ssafy.flody.domain.posts.reports;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
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
@Table(name = "P_reports")
@IdClass(PReportsId.class)
public class PReports {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_no")
    private Posts post;
//    @Column(nullable = false)
//    private int type;
    @Column
    private String content;
}
