package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "full_name",nullable = false)
    String fullName;
    Date birthday;
    @Column(name = "class_name",nullable = false)
    String className;
    String major;
    String homeTown;
    String gender;
    @Column(name = "average_mark",nullable = false)
    double averageMark;
}
