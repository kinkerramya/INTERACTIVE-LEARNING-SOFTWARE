import javax.persistence.*;
import java.io.*;

@Entity(name = "student")
public class Student implements Serializable {

  @Column(name = "student_name")
  private String student_name;
  
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column
  private String student_id;
  
  @Column
  private String dob;
  
  @Column
  private int age;
  
  @Column
  private int score;
  
  @Column
  private int flag;
  
  public String getStudentName() {
    return student_name;
  }

  public void setStudentName(String name) {
    this.student_name = name;
  }

  public String getStudentId() {
    return student_id;
  }

  public void setStudentId(String id) {
    this.student_id = id;
  }
  
  public int getage() {
	    return age;
   }

   public void setage(int num) {
	    this.age = num;
	}
   
   public String getDob() {
	    return dob;
	}
   
   public void setDob(String date) {
	    this.dob = date;
	}

   public int getScore() {
	    return score;
	}
   
   public int getFlag() {
	    return flag;
	  }
   
   public void setFlag(int num) {
	    this.flag = num;
	}
   public void setScore(int num) {
	    this.score = num;
	}
   
   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 5;
   }
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getStudentName();
	   else if (i == 1)
		   return getStudentId();
	   else if (i == 2) 
		   return getDob();
	   else if (i == 3)
		   return Integer.toString(getage());
	   else if (i == 4)
		   return Integer.toString(getScore());
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "Student Name";
	   else if (i == 1)
		   colName = "Student Id";
	   else if (i == 2)
		   colName = "DOB";
	   else if (i == 3)
		   colName = "Age";
	   else if (i == 4)
		   colName = "Score";
	   else 
		   throw new Exception("Access to invalid column number in student table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   student_name = (String) value;
	   else if (i == 1) 
		   student_id = (String) value;
	   else if (i == 2) 
		   dob = (String) value;
	   else if (i == 3)
		   age =  Integer.parseInt((String) value);
		   
	   else if (i == 4)
		  score =Integer.parseInt((String)value);
	   else
		   throw new Exception("Error: invalid column index in student table");    
   }
   
  @Override
  public String toString() {
    return "Student [Student Name =" + student_name + ", "
    	    + " Student Id =" + student_id + ","
    	    + " age =" + age + ","
    	    + " DOB =" + dob + ","
    	    + " Score =" + score + ","
        + "]";
  }

}
