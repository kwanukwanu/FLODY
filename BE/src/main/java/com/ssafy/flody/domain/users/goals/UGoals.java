package com.ssafy.flody.domain.users.goals;

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

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "U_Goals")
public class UGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ugNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private Date registDate;
    @Column(nullable = false)
    private Date dueDate;

    public void update(String name, Date dueDate) {
        if (name != null)
            this.name = name;
        Calendar cal = Calendar.getInstance();
        if (dueDate != null) {
            cal.setTime(this.dueDate);
            cal.add(Calendar.DATE, 1);
            this.dueDate = dueDate;
        }
    }
}
