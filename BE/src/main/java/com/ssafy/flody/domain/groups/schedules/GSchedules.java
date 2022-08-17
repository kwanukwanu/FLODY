package com.ssafy.flody.domain.groups.schedules;

import com.ssafy.flody.domain.groups.Groups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "g_schedules")
public class GSchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gsNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Groups.class)
    @JoinColumn(name = "gro_no")
    private Groups group;
    @Column(nullable = false)
    private String title;
    @Column
    private String detail;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column
    private Boolean done;

    public void update(String title, String detail, Date startDate, Date endDate, Boolean done) {
        this.title = title;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.done = done;
    }
}
