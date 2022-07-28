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

    @NotNull
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name="use_no")
    private Long sender;

    @NotNull
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "use_no")
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
