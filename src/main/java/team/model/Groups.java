package team.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String dateStart;
    private String dateFinish;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(mappedBy = "groups", cascade = CascadeType.ALL)
    private Teacher teacher;
    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToMany
    @JoinTable(name = "course_groups",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Groups(String groupName, String dataStart, String dataFinish) {
        this.groupName = groupName;
        this.dateStart = dataStart;
        this.dateFinish = dataFinish;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateFinish='" + dateFinish + '\'' +
                '}';
    }
}
