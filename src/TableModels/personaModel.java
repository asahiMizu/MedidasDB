package TableModels;
import DB_Access.*;

import java.util.List;
import java.util.Date;

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

    public void addRow(Object[] dates) {
        //Añadir fila a la lista y la base de datos
        if (dates.length == encabezados.length) {
            String NOMBRE   = dates[1].toString();
            Date   FECHANAC = (Date)dates[2];
            char   SEXO     = (Character)dates[3];
            int    ESTATURA = (int)dates[4];

            int generatedID = dataAccess.addPersona(NOMBRE, FECHANAC, SEXO, ESTATURA);
            
            if (generatedID != -1) {
                dates[0] = generatedID; 
                personasData.add(dates); 
                int row = personasData.size() - 1;
                fireTableRowsInserted(row, row);
            }
        }
    }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { 
            // Actualizar el valor en el modelo de la tabla
            if(rowIndex >= 0 && rowIndex < personasData.size()) {
                personasData.get(rowIndex)[columnIndex] = aValue;
                updateCellData(rowIndex, columnIndex, aValue);
                fireTableCellUpdated(rowIndex, columnIndex); 
            }
    }

    private void updateCellData(int row, int column, Object value) {
        if(row >= 0 && row < personasData.size()) {
            String newValue = (String)value;
            int id  = getID(row);
            dataAccess.updatePersona(encabezados, id, column, newValue);
            fireTableCellUpdated(row, column);
        }
    }
    public void removeRow(int row) {
        if(row >= 0 && row < personasData.size()) {
            int id = getID(row);
            dataAccess.deletePersona(id);
            personasData.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    public int getID(int row) {
        if(row >= 0 && row < personasData.size()) {
            getValueAt(row, 0);
            Object id = getValueAt(row, 0);
            if(id instanceof Integer) {
                return (int)id;
            } else if(id instanceof String) {
                try {
                    return Integer.parseInt((String) id);
                } catch (NumberFormatException e) {
                    System.err.println(id + " no es un entero : " + e.getMessage());
                }
            } else if (id == null) {
                System.err.println("id es un valor nulo");
            } else {
                System.err.println("id es un valor valido");
            }

        } 
        return -1;
    }

    public List<Object[]> getPersonasData() {
        return personasData;
    }
        
}
