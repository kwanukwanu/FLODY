package com.ssafy.flody.domain.dmessages;

import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dmNo;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name="useNo")
    private Long sender;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "useNo")
    private Long receiver;

    @NotNull
    private Boolean type;

    @NotNull
    private String content;

    @NotNull
    private Date time;

    @NotNull
    private Boolean like;

    @NotNull
    private Boolean check;
}
