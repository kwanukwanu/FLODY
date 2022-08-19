package com.ssafy.flody.domain.groups;

import com.ssafy.flody.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groNo;
    @Column(nullable = false)
    private String name;
    @Column
    private String introduction;
    @Column(nullable = false, updatable = false)
    private Date foundDate;

    @OneToMany(mappedBy = "groNo", cascade = CascadeType.ALL)
    private List<Groups> children;
    public void update(String name, String introduction) {
        if (name != null)
            this.name = name;
        if (introduction != null)
            this.introduction = introduction;
    }
}
