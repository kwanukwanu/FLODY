package com.ssafy.flody.domain.licenses.sjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.serieses.Serieses;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SJobsId implements Serializable {
    private Departments department;
    private Serieses series;
}
