package hellojpa;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Team team;

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
