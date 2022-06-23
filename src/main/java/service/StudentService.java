package service;

import entity.Student;
import repository.StudentDAO;

import java.util.List;

public class StudentService {
    public boolean addStudent(Student student) {
        return StudentDAO.add(student);
    }

    public boolean deleteStudent(int id) {
        return StudentDAO.removeById(id);
    }

    public Student getById(int id) {
        return StudentDAO.findById(id);
    }

    public List<Student> getAll() {
        return (List<Student>) StudentDAO.getAll();
    }

    public List<Student> getBirthday() {
        return StudentDAO.getBirthday();
    }
    public boolean updateStudent(Student student) {
        return StudentDAO.update(student);
    }
}
