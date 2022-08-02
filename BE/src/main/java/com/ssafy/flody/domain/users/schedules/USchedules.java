package com.ssafy.flody.domain.users.schedules;

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
@Table(name = "u_schedules")
public class USchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_no")
    private Long useNo;

    @NotNull
    private String title;

    private String detail;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Boolean done;

    public void update(String title, String detail, Date startDate, Date endDate, Boolean done) {
        this.title = title;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.done = done;
    }
}
