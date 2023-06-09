package com.ssafy.flody.domain.dmessages.likes;

import com.ssafy.flody.domain.dmessages.DirectMessages;
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
@Table(name = "D_Likes")
@IdClass(DLikesId.class)
public class DLikes {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DirectMessages.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dm_no")
    private DirectMessages directMessage;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
}
