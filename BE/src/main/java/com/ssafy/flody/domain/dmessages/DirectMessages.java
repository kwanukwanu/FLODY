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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender")
    private Users sender;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver")
    private Users receiver;
    @Column
    private boolean type;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Date time;
    @Column
    private boolean like;
    @Column
    private boolean check;
}
