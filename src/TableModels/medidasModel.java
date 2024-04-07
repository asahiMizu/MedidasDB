package TableModels;
import DB_Access.*;

import java.util.Date;
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

    public void addRow(Object[] dates) {
        //Añadir fila a la lista y la base de datos
        if (dates.length == encabezados.length) {
            Date   FECHA         = (Date)dates[1];
            double PESO          = (double)dates[2];
            int    CINTURA       = (int)dates[3];
            double GRASACORPORAL = (double)dates[4];
            int    IDPERSONA     = (int)dates[5];

            int generatedID = dataAccess.addMedida(FECHA, PESO, CINTURA, GRASACORPORAL, IDPERSONA);

            if(generatedID != -1) {
                dates[0] = generatedID;
                medicionesData.add(dates);
                int row = medicionesData.size() - 1;
                fireTableRowsInserted(row, row);
            }
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { 
            // Actualizar el valor en el modelo de la tabla
            medicionesData.get(rowIndex)[columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex); 
            updateCellData(rowIndex, columnIndex, aValue);
    }

    private void updateCellData(int row, int column, Object value) {
        if(row >= 0 && row < medicionesData.size()) {
            String newValue = (String)value;
            int id = getID(row);
            dataAccess.updateMedida(encabezados, id, column, newValue);
            fireTableCellUpdated(row, column);
        }
    }
    public void removeRow(int row) {
        if(row >= 0 && row < medicionesData.size()) {
            int id = getID(row);
            dataAccess.deleteMedida(id);
            medicionesData.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }
    public int getID(int row) {
        if(row >= 0 && row < medicionesData.size()) {
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
    
    public List<Object[]> getMedicionesData() {
        return medicionesData;
    }
}

