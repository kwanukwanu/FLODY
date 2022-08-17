package com.ssafy.flody.domain.licenses.tjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.fields.Fields;
import com.ssafy.flody.domain.licenses.mfields.MFields;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TJobsId implements Serializable {
    private Fields field;
    private MFields mField;
    private Departments department;
}
