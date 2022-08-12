package com.ssafy.flody.domain.licenses.sjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.serieses.Serieses;
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
@Table(name = "S_jobs")
public class SJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sjNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Departments.class)
    @JoinColumn(name = "dep_no")
    private Departments department;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Serieses.class)
    @JoinColumn(name = "ser_no")
    private Serieses series;
}
