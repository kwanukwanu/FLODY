package com.ssafy.flody.domain.groups.goals;

import com.ssafy.flody.domain.groups.Groups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "G_Goals")
public class GGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ggNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Groups.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gro_no")
    private Groups group;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date registDate;
    @Column(nullable = false)
    private Date dueDate;
}
