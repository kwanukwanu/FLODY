package com.ssafy.flody.domain.users.schedules;

import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "U_Schedules")
public class USchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Column(nullable = false)
    private String title;
    @Column
    private String detail;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column
    private Boolean done;

    public void update(String title, String detail, Date startDate, Date endDate, Boolean done) {
        if (title != null)
            this.title = title;
        if (detail != null)
            this.detail = detail;
        if (startDate != null)
            this.startDate = startDate;
        if (endDate != null)
            this.endDate = endDate;
        if (done != null)
            this.done = done;
    }
}
