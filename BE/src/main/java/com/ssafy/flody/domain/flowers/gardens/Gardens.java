package com.ssafy.flody.domain.flowers.gardens;

import com.ssafy.flody.domain.flowers.Flowers;
import com.ssafy.flody.domain.users.Users;
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
public class Gardens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Flowers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flo_no")
    private Flowers flower;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @CreatedDate
    private Date startDate;
    @Column
    private Date endDate;
    @Column(nullable = false)
    private int exp;
}
