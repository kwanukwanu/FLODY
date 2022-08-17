package com.ssafy.flody.domain.licenses.tjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.fields.Fields;
import com.ssafy.flody.domain.licenses.mfields.MFields;
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
@Table(name = "T_jobs")
@IdClass(TJobsId.class)
public class TJobs {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Fields.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fie_no")
    private Fields field;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MFields.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mf_no")
    private MFields mField;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Departments.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_no")
    private Departments department;
}
