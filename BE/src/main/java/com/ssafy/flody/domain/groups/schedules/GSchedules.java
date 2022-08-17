package com.ssafy.flody.domain.groups.schedules;

import com.ssafy.flody.domain.groups.Groups;
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
public class GSchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gsNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Groups.class, cascade = CascadeType.ALL)
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
    @Column(nullable = false)
    private Boolean done;
}
