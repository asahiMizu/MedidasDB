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
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

import java.util.List;

import DB_Access.DataAccess;
import TableModels.medidasModel;

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
    private medidasModel mm;
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

        
        mm = new medidasModel();
        medicionesData = mm.getMedicionesData();
        tm = mm;
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
                
                    if(row > 0 && row < medicionesData.size())
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

    public void addMedicion(Object[] dates) {
        mm.addRow(dates);
    }
    public void updateTable(TableModelEvent e) {
        TableModel model = jt.getModel();

        if (model instanceof DefaultTableModel) {
            DefaultTableModel tableModel = (DefaultTableModel) model;
            tableModel.fireTableChanged(e);
        }
    
        // Notificar a la tabla que los datos han cambiado
        ((AbstractTableModel) model).fireTableDataChanged();
    }

    public void deleteSelectedRow() {
        deleteMode = true;
        int row = jt.getSelectedRow();
        mm.removeRow(row);
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
