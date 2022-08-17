package com.ssafy.flody.domain.flowers.gardens;

import com.ssafy.flody.domain.flowers.Flowers;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gardens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Flowers.class)
    @JoinColumn(name = "flo_no")
    private Flowers flower;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
    @Column(nullable = false, updatable = false)
    private Date startDate;
    @Column
    private Date endDate;
    @Column(nullable = false)
    private int exp;

    public void addExp(int exp) {
        this.exp += exp;
    }

    public void evolve(Flowers flower) {
        this.flower = flower;
    }

    public void bloom() {
        this.exp = 0;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        this.endDate = cal.getTime();
    }
}
