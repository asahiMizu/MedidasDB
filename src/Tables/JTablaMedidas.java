/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.*;

import java.util.List;

import DB_Access.DataAccess;

/**
 *
 * @author asahi
 */
public class JTablaMedidas extends JPanel{
        private DataAccess dataAccess = new DataAccess();

    private Font cellFont = new Font("Century Gothic", Font.PLAIN, 18);
    private Color cellBackground = new Color(239, 253, 255);
    private Color cellForeground = new Color(45, 168, 190 );
    private int width = 970;
    private int height = 600;
    private JTable jt;
    private List<Object[]> medicionesData;
    private JScrollPane jsp;
    private TableModel tm;
    private boolean deleteMode = false;


    private String[] encabezados = new String[] {
        "IDMEDIDAS",
        "FECHA",
        "PESO",
        "CINTURA",
        "GRASACORPORAL",
        "IDPERSONA"
    };

    public JTablaMedidas() {
        super();
        setPreferredSize(new Dimension(width, height));

        
        String consulta = "SELECT * FROM ROOT.MEDIDAS";
        medicionesData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_MEDIDAS);

        TableModel tm = new AbstractTableModel() {
            //tabla con varias columnas

            public int getRowCount()    { return medicionesData.size(); }
            public int getColumnCount() { return 6; }
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

        };
        jt = new JTable(tm);
        
        jt.setDefaultRenderer(Object.class, new customCell());
        jt.setRowHeight(30);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jt.setPreferredSize(new Dimension(width, height));
        jt.setFillsViewportHeight(true);

        jt.doLayout();
        

        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    deleteMode = false;
                    int row    = jt.rowAtPoint(e.getPoint());
                    int column =jt.columnAtPoint(e.getPoint());
                
                    if(column != 0)
                        jt.editCellAt(row, column);
                }
            }
        });

        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    int row = jt.getSelectedRow();
                    int column = jt.getSelectedColumn();
                    if(row != -1 && column != -1 && !deleteMode) {
                        TableCellEditor editor = jt.getCellEditor();
                        if(editor != null) {
                            editor.stopCellEditing();
                        }
                        // Actualizar el dato de la celda en el modelo de la tabla y en la base de datos
                        
                        tm.setValueAt(jt.getValueAt(row, column), row, column);
                    }
                }

            }
        });
        jt.setLayout(new GridLayout());

        jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(width, height));
        super.add(jsp);

    }

    public void deleteSelectedRow() {
        int row = jt.getSelectedRow();
        if (row >= 0 && row < medicionesData.size()) {
            String id = (String) jt.getValueAt(row, 0);
            String deleteQuery = "DELETE FROM ROOT.MEDIDAS WHERE IDPERSONA = " + id;
            System.out.print(deleteQuery);
            dataAccess.insertData(deleteQuery); // Asume que esto elimina correctamente el dato de la DB
    
            // Ahora, elimina el dato de medicionesData
            medicionesData.remove(row);
    
            // Notifica al modelo de la tabla que los datos han cambiado
            ((AbstractTableModel) jt.getModel()).fireTableDataChanged();
        }
    }
    public int getSelectedRow(){
        return jt.getSelectedRow();
    }
    public TableColumnModel getColumnModel(){
        return jt.getColumnModel();
    }
    public Object getValueAt(int row, int column){
        return jt.getValueAt(row, column);
    }

    public List<Object[]> getPersonasData() {
        return medicionesData;
    }
    public void updateTable() {
        String consulta = "SELECT * FROM ROOT.MEDIDAS";
        medicionesData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_PERSONA);

        jt = new JTable(tm);

        jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(width, height));
        super.add(jsp);
        ((AbstractTableModel) jt.getModel()).fireTableDataChanged();
    }

    private void updateCellData(int row, int column, Object value) {
        
        String newValue = (String)value;
        String id  = (String)jt.getValueAt((row ), 0);
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


    private class customCell extends JTextField implements TableCellRenderer {
        public customCell() {
            setOpaque(true);
            setFont(cellFont);
            setForeground(cellForeground);
            setBackground(cellBackground);
            setHorizontalAlignment(SwingConstants.CENTER);
            setPreferredSize(new Dimension(120, 15));
            setMaximumSize(new Dimension(200, 15));
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value != null) ? value.toString() : ""); // Establecer el texto de la celda
            return this; // Devolver el componente
        }
    }
}
