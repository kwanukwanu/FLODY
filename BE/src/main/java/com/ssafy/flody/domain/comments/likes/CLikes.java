package com.ssafy.flody.domain.comments.likes;

import com.ssafy.flody.domain.comments.Comments;
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
@Table(name = "C_Likes")
public class CLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Comments.class)
    @JoinColumn(name = "com_no")
    private Comments comment;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
}
