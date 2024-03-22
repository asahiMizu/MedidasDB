package TableModels;
import DB_Access.*;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class personaModel extends AbstractTableModel{
    private List<Object[]> personasData;
    private DataAccess dataAccess = new DataAccess();

    private String[] encabezados = new String[] {
        "IDPERSONA",
        "NOMBRE",
        "FECHANAC",
        "SEXO",
        "ESTATURA"
    };

    public personaModel() {
        super();
        String consulta = "SELECT * FROM ROOT.PERSONA";
        personasData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_PERSONA);
    }

    
    public int getRowCount()    { return personasData.size(); }
    public int getColumnCount() { return encabezados.length; }
    public Object getValueAt(int r, int c) { 
        return personasData.get(r)[c];
    }
    public String getColumnName(int c) { return encabezados[c]; }
    public boolean isCellEditable(int r, int c) { return true; }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { 
            // Actualizar el valor en el modelo de la tabla
            if(rowIndex > 0 && rowIndex < personasData.size()) {
                personasData.get(rowIndex)[columnIndex] = aValue;
                fireTableCellUpdated(rowIndex, columnIndex); 
                updateCellData(rowIndex, columnIndex, aValue);
            }
    }

    private void updateCellData(int row, int column, Object value) {
        
        String newValue = (String)value;
        String id  = (String)getValueAt((row ), 0);
        if(column == 1 || column == 2 || column == 3) {
            newValue = "'"+value+"'";
        }
        String update = "UPDATE ROOT.PERSONA SET " 
            + encabezados[column] 
            + " = " 
            + newValue 
            + " WHERE IDPERSONA = " 
            + id ;

        System.out.println(update);
        dataAccess.insertData(update);
    }
}
