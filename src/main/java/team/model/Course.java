package team.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany( mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Groups> groups;
    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
