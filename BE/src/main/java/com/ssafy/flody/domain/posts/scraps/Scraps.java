package com.ssafy.flody.domain.posts.scraps;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
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
@IdClass(ScrapsId.class)
public class Scraps {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Posts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_no")
    private Posts post;
}
