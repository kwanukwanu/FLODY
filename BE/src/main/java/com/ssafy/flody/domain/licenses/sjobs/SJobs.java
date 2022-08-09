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
@IdClass(SJobsId.class)
public class SJobs {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Departments.class)
    @JoinColumn(name = "gep_no")
    private Departments department;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Serieses.class)
    @JoinColumn(name = "ser_no")
    private Serieses series;
}
