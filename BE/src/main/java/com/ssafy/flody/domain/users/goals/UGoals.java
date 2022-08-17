package com.ssafy.flody.domain.users.goals;

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
@Table(name = "U_Goals")
public class UGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ugNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Column(nullable = false)
    private String name;
    @CreatedDate
    private Date registDate;
    @Column(nullable = false)
    private Date dueDate;

    public void update(String name, Date registDate, Date dueDate) {
        this.name = name;
        this.registDate = registDate;
        this.dueDate = dueDate;
    }
}
