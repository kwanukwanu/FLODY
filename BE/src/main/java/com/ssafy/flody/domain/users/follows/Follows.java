package com.ssafy.flody.domain.users.follows;

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
public class Follows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "follower")
    private Users follower;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "following")
    private Users following;
}
