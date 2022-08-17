package com.ssafy.flody.domain.licenses;

import com.ssafy.flody.domain.licenses.fields.Fields;
import com.ssafy.flody.domain.licenses.mfields.MFields;
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
public class Licenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lisNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Fields.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fie_no")
    private Fields field;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MFields.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mf_no")
    private MFields mfield;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Serieses.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ser_no")
    private Serieses series;
    @Column(nullable = false)
    private int jmcd;
    @Column(nullable = false)
    private String jmfldnm;
    @Column(nullable = false)
    private String qualgbcd;
}
