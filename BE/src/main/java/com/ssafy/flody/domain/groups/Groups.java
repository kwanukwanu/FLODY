package com.ssafy.flody.domain.groups;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "s_groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groNo;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date foundDate;

    public void update(String name) {
        this.name = name;
    }
}
