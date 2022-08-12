package com.ssafy.flody.domain.dmessages.likes;

import com.ssafy.flody.domain.dmessages.DirectMessages;
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
@Table(name = "D_Likes")
public class DLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dlNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DirectMessages.class)
    @JoinColumn(name = "dm_no")
    private DirectMessages directMessage;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
}
