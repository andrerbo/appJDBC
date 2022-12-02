package infnet.edu.br.appjdbc.persistence;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import infnet.edu.br.appjdbc.entity.Student;


public class StudentDAOTest {


    @Test
    public void aStudentTestSave() {
        IDAO studentDAO = new StudentDAO();
        Student student = new Student(1, "André Ribeiro");
        student.setEmail("ribeirolimand@gmail.com"); 
        boolean validation = studentDAO.save(student);
        Assert.assertTrue(validation);
    }


    @Test
    public void bStudentTestGet() {
        IDAO studentDAO = new StudentDAO();
        Student student = (Student) studentDAO.get(1); 
        Assert.assertNotNull(student);
    }


    @Test
    public void cStudentTestUpdate() {
        IDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAll();
        Student student = new Student(students.get(0).getId(), "Anderson Ribeiro");
        student.setEmail("ribeirolimand@gmail.com"); 
        boolean validation = studentDAO.update(student);
        Assert.assertTrue(validation);
    }


    @Test
    public void dStudentTestDelete(){
        IDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAll();
        Student student = new Student(students.get(0).getId(), "Anderson Ribeiro");
        student.setEmail("ribeirolimand@gmail.com"); 
        boolean validation = studentDAO.delete(student);
        Assert.assertTrue(validation);
    }
    

}