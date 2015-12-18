
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

public class StudentTableModel extends AbstractTableModel {

	  List<Student> studentResultList;   // stores the model data in a List collection of type student
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;		      // JPA 
	  private Student student;// represents the entity student

      // This field contains additional information about the results   
	  private StudentService studentService;
	
	 
	  private int numcols, numrows; // number of rows and columns

	 StudentTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    student = new Student();
	    studentService = new StudentService(manager);
	    
	    // read all the records from student
	    studentResultList = studentService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = studentResultList.size();
	    numcols = student.getNumberOfColumns();
      }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return studentResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return student.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   Student element = studentResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	 
	 public void deleteValuesAt(int row) {
			//data[rowIndex][columnIndex] = (String) aValue;
			try {                  
				fireTableRowsDeleted(row, row);
			} catch(Exception err) {
				err.toString();
			}	
		 }
	
	 public List<Student> getList() {
		 return studentResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public StudentTableModel(List<Student> list, EntityManager em)  {
	    studentResultList = list;
	    numrows = studentResultList.size();
	    student = new Student();
	   	numcols = student.getNumberOfColumns();     
		manager = em;  
		studentService = new StudentService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		 EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			Student newRecord = studentService.createStudent((String) array[0], (String) array[1], (String) array[2], Integer.parseInt((String) array[3]), Integer.parseInt((String) array[4]));
			userTransaction.commit();
	        studentResultList.add(newRecord);
	        int row = studentResultList.size();  
	        int col = 0;
	        // update the data in the model to the entries in array
	         for (Object data : array) {
	          	 setValueAt((String) data, row-1, col++);
	         }	         
	         numrows++;
	}
	 
	 public void deleteRow(int rowNum, Object[] array) {
			 EntityTransaction userTransaction = manager.getTransaction();
			 userTransaction.begin();
			 		studentService.deletestudent((String) array[1]);
			 		userTransaction.commit();
			 		studentResultList = studentService.readAll();
			 		deleteValuesAt(rowNum);
		}	
	 
	 public void updateRow(int rowNum, Object[] array) {

			 EntityTransaction userTransaction = manager.getTransaction();  
			 		userTransaction.begin();
			 		Student updatedRecord = studentService.updatestudent((String) array[0], (String) array[1], (String) array[2], Integer.parseInt((String) array[3]), Integer.parseInt((String) array[4]));;
			 		userTransaction.commit();
			 		studentResultList.set(rowNum,updatedRecord);
			         int col = 0;
			          for (Object data : array) {
			           	 setValueAt((String) data, rowNum, col++);
			          }          
		}
}
