package TableModels;
import DB_Access.*;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class medidasModel extends AbstractTableModel{
    private List<Object[]> medicionesData;
    private DataAccess dataAccess = new DataAccess();

    private String[] encabezados = new String[] {
        "IDMEDIDAS",
        "FECHA",
        "PESO",
        "CINTURA",
        "GRASACORPORAL",
        "IDPERSONA"
    };

    public medidasModel() {
        super();
        String consulta = "SELECT * FROM ROOT.MEDIDAS";
        medicionesData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_MEDIDAS);
    }

    
    public int getRowCount()    { return medicionesData.size(); }
    public int getColumnCount() { return encabezados.length; }
    public Object getValueAt(int r, int c) { 
        return medicionesData.get(r)[c];
    }
    public String getColumnName(int c) { return encabezados[c]; }
    public boolean isCellEditable(int r, int c) { return true; }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { 
            // Actualizar el valor en el modelo de la tabla
            medicionesData.get(rowIndex)[columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex); 
            updateCellData(rowIndex, columnIndex, aValue);
    }

    private void updateCellData(int row, int column, Object value) {
        
        String newValue = (String)value;
        String id  = (String)getValueAt((row ), 0);
        if(column == 2) {
            newValue = "'"+value+"'";
        }
        String update = "UPDATE ROOT.MEDIDAS SET " 
            + encabezados[column] 
            + " = " 
            + newValue 
            + " WHERE IDMEDIDAS = " 
            + id ;

        System.out.println(update);
        dataAccess.insertData(update);
    }
}

