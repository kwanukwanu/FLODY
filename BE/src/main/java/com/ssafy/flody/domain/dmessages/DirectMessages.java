package com.ssafy.flody.domain.dmessages;

import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "D_Messages")
public class DirectMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dmNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "sender")
    private Users sender;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "receiver")
    private Users receiver;
    @Column(nullable = false)
    private Boolean type;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Date time;
    @Column(nullable = false)
    private Boolean like;
    @Column(nullable = false)
    private Boolean check;
}
