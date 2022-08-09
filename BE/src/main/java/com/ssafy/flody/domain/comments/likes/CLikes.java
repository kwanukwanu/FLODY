package com.ssafy.flody.domain.comments.likes;

import com.ssafy.flody.domain.comments.Comments;
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
@Table(name = "C_Likes")
@IdClass(CLikesId.class)
public class CLikes {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Comments.class)
    @JoinColumn(name = "com_no")
    private Comments comment;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
}
