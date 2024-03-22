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
import TableModels.personaModel;
/**
 *
 * @author asahi
 */
public class JTablaPersona extends JPanel{
    private DataAccess dataAccess = new DataAccess();

    private Font cellFont = new Font("Century Gothic", Font.PLAIN, 18);
    private Color cellBackground = new Color(239, 253, 255);
    private Color cellForeground = new Color(45, 168, 190 );
    private int width = 970;
    private int height = 600;
    private JTable jt;
    private List<Object[]> personasData;
    private JScrollPane jsp;
    private TableModel tm;
    private boolean deleteMode = false;

    public JTablaPersona() {
        super();
        setPreferredSize(new Dimension(width, height));

        
        String consulta = "SELECT * FROM ROOT.PERSONA";
        personasData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_PERSONA);

        tm = new personaModel();
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
                if(SwingUtilities.isRightMouseButton(e)) {
                    jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                }else if(e.getClickCount() == 2) {
                    deleteMode = false;
                    int row    = jt.rowAtPoint(e.getPoint());
                    int column =jt.columnAtPoint(e.getPoint());
                    
                    if(column != 0 && row > 0 && row < personasData.size()) {
                        jt.editCellAt(row, column);
                    }
                        
                }
                
            }
        });

        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER && !deleteMode){
                    int row = jt.getSelectedRow();
                    int column = jt.getSelectedColumn();
                    if(row != -1 && row != 0 && column != -1) {
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

        jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(width, height));
        super.add(jsp);

    }

    public List<Object[]> getPersonasData() {
        return personasData;
    }
    public void updateTable() {
        String consulta = "SELECT * FROM ROOT.PERSONA";
        personasData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_PERSONA);
    
        // Obtener el modelo de tabla existente
        TableModel model = jt.getModel();
    
        // Actualizar los datos en el modelo de tabla
        if (model instanceof DefaultTableModel) {
            DefaultTableModel tableModel = (DefaultTableModel) model;
            // Limpiar las filas existentes
            tableModel.setRowCount(0);
            // Llenar la tabla con los nuevos datos de la base de datos
            for (Object[] rowData : personasData) {
                tableModel.addRow(rowData);
            }
        }
    
        // Notificar a la tabla que los datos han cambiado
        ((AbstractTableModel) model).fireTableDataChanged();
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


    public void deleteSelectedRow() {
        deleteMode = true;
        int row = jt.getSelectedRow();
        if (row >= 0 && row < personasData.size()) {
            jt.clearSelection();
            jt.getCellEditor().stopCellEditing();
            String id = (String) jt.getValueAt(row, 0);
            String deleteQuery = "DELETE FROM ROOT.PERSONA WHERE IDPERSONA = " + id;
            System.out.print(deleteQuery);
            dataAccess.insertData(deleteQuery); // Asume que esto elimina correctamente el dato de la DB
    
            // Ahora, elimina el dato de personasData
            personasData.remove(row);
    
            // Notifica al modelo de la tabla que los datos han cambiado
            ((AbstractTableModel) jt.getModel()).fireTableDataChanged();
        }
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
