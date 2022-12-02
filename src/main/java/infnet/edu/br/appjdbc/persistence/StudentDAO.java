package infnet.edu.br.appjdbc.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import infnet.edu.br.appjdbc.entity.Student;


public class StudentDAO extends JdbcDAO<Student> {

    private static Logger logger = LoggerFactory.getLogger(StudentDAO.class);

    public StudentDAO(){
    
    }
    
    @Override
    public Boolean save(Student student) {
        String sql = "INSERT INTO STUDENT(ID, NAME, EMAIL) VALUES (?, ?, ?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, student.getId());
            pstm.setString(2, student.getName());
            pstm.setString(3, student.getEmail());
            logger.info("student saved successfully");
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public Boolean update(Student student) {
        String sql = "UPDATE STUDENT SET NAME = ? WHERE ID = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, student.getName()); 
            pstm.setLong(2, student.getId());
            logger.info("student up-to-date successfully"); 
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public Boolean delete(Student student){
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, student.getId());
            logger.info("student deleted successfully");  
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

    @Override
    public Student get(Integer id){
        String sql = "SELECT * FROM STUDENT WHERE ID = ?";
        Student student = new Student();
        try {
            pstm = con.prepareStatement(sql); 
            pstm.setInt(1, id); 
            rs = pstm.executeQuery();
            if(rs.next()) {
                Integer idDb = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                student = new Student(idDb, name);
                student.setEmail(email);
                logger.info("student retrieved successfully");  
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public List<Student> getAll(){
        String sql = "SELECT * FROM STUDENT";
        List<Student> students = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                String name = rs.getString("name");
                Integer id = rs.getInt("id");
                Student student = new Student(id, name);
                students.add(student);
        }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
}
