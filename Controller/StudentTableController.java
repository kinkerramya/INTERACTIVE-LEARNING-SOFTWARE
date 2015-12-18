import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
*/
public class StudentTableController implements ListSelectionListener,TableModelListener{
	private StudentTableModel tableModel;
	private StudentGUI gui;
	
	public StudentTableController(StudentGUI gui) {
		this.gui = gui; 
         // create the tableModel using the data in the cachedRowSet
    		tableModel = new StudentTableModel();
    		tableModel.addTableModelListener(this);
	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		gui.setstudentNameTextField( (String) tableModel.getValueAt(firstIndex, 0));
		gui.setstudentIdTextField( (String) tableModel.getValueAt(firstIndex, 1));
		gui.setdobTextField( (String) tableModel.getValueAt(firstIndex, 2));
		gui.setageTextField( (String) tableModel.getValueAt(firstIndex, 3));
		gui.setscoreTextField( (String) tableModel.getValueAt(firstIndex, 4));
	}
	
	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}
	
	public void deleteRow(int rowNum,String[] array) {
		tableModel.deleteRow(rowNum,array);
		
	}
	public void updateRow(int rowNum, String[] array) {
		tableModel.updateRow(rowNum,array);	
	}

	public void tableChanged(TableModelEvent e)
	{
	   try {
	        tableModel = new StudentTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	    	if(e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.UPDATE ) {	
	    	int firstIndex =  e.getFirstRow();
			gui.setstudentNameTextField( (String) tableModel.getValueAt(firstIndex, 0));
			gui.setstudentIdTextField( (String) tableModel.getValueAt(firstIndex, 1));
			gui.setdobTextField( (String) tableModel.getValueAt(firstIndex, 2));
			gui.setageTextField( (String) tableModel.getValueAt(firstIndex, 3));
			gui.setscoreTextField( (String) tableModel.getValueAt(firstIndex, 4));			
	    	}
		   else if (e.getType() == TableModelEvent.DELETE)
		   {
				gui.setstudentNameTextField("");
				gui.setstudentIdTextField("");
				gui.setdobTextField("");
				gui.setageTextField("");
				gui.setscoreTextField("");
		   }
	    	gui.updateTable();
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}

}

