package com.ssafy.flody.domain.groups.members;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "G_Members")
@IdClass(GMembersId.class)
public class GMembers {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_email")
    private Users user;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Groups.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gro_no")
    private Groups group;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GRoles.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gr_no")
    private GRoles role;
}
