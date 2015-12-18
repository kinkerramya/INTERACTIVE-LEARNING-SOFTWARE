import javax.persistence.*;
import java.util.*;

public class StudentService {
	 private EntityManager manager;
	 
	 public StudentService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public Student createStudent(String studentName, String studentId, String dob, int age, int score) {
    	Student student = new Student();
 	    student.setStudentName(studentName);
 	    student.setStudentId(studentId);
 	    student.setDob(dob);
 	    student.setage(age);
 	    student.setScore(score);
 	    manager.persist(student);
 	    return student;
     }
    
    // method to read a record
     public Student readstudent(String studentId) {
    	 Student student = manager.find(Student.class, studentId);
    	 return student;   	 
     }

     // method to read all records
     public List<Student> readAll() {
    	 TypedQuery<Student> query = manager.createQuery("SELECT e FROM student e", Student.class);
    	 List<Student> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public Student updatestudent(String studentName, String studentId, String dob, int age, int score) {
    	 Student student = manager.find(Student.class, studentId);
    	 if (student != null) {
    		 student.setStudentName(studentName);
    	 	 student.setDob(dob);
    	 	 student.setage(age);
    	 	 student.setScore(score);
    	 }
    	 return student;
     }

    // method to delete a record
    public void deletestudent(String studentId) {
    	 Student student = manager.find(Student.class, studentId);
    	 if (student != null) {
    		 manager.remove(student);
    	 }
    }
}
