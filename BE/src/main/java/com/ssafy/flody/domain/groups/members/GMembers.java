package com.ssafy.flody.domain.groups.members;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "G_Members")
public class GMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gmNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
    @JoinColumn(name = "use_email")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Groups.class)
    @JoinColumn(name = "gro_no")
    private Groups group;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GRoles.class)
    @JoinColumn(name = "gr_no")
    private GRoles role;

    public void update(GRoles role) {
        this.role = role;
    }
}
