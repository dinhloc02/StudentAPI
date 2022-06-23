package repository;

import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class StudentDAO {
    public static Student getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student ").getResultList();
            return (Student) students;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Student findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.beginTransaction().commit();
            return student;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean removeById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.beginTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean add(Student student) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.beginTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.beginTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<Student> getBirthday() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student s where s.birthday = current_date ").getResultList();
            return students;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
