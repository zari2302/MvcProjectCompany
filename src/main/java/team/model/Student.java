package team.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.model.enumFormat.StudentFormat;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudentFormat studentFormat;
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

    public Student(String first_name, String last_name, String email, StudentFormat studentFormat) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.studentFormat = studentFormat;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id: " + id +
                "firstName: " + firstName + '\'' +
                "lastName: " + lastName + '\'' +
                "email: " + email + '\'' +
                "studente: " + "\'"+ studentFormat;
    }
}
