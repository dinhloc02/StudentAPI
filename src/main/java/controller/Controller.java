package controller;

import entity.Student;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
public class Controller {
    StudentService studentService = new StudentService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getAll();
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String upDateStudent(Student student) {
        return studentService.updateStudent(student) ? "update thành công" : "update thất bại";
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String addStudent(Student student) {
        return studentService.addStudent(student) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteStudent(@PathParam("id") int id) {
        return studentService.deleteStudent(id) ? "Xóa thành công" : "Xóa thất bại";
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id) {
        return studentService.getById(id);
    }
}
