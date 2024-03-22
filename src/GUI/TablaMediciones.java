package medicionesdb;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.*;

import java.util.List;

public class TablaMediciones extends JFrame {

    private DataAccess dataAccess = new DataAccess();

    private Font cellFont = new Font("Century Gothic", Font.PLAIN, 18);
    private Color cellBackground = new Color(239, 253, 255);
    private Color cellForeground = new Color(45, 168, 190 );

    private String[] encabezados = new String[] {
        "IDMEDIDAS",
        "FECHA",
        "PESO",
        "CINTURA",
        "GRASACORPORAL",
        "IDPERSONA"
    };

    public TablaMediciones() {
        super("Tabla Mediciones");
        setSize(970, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        String consulta = "SELECT * FROM ROOT.MEDIDAS";
        List<Object[]> medicionesData = dataAccess.conexionConsultaDatos(consulta, DataAccess.TABLA_MEDIDAS);

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
        final JTable jt = new JTable(tm);
        jt.setFillsViewportHeight(true);

        jt.setDefaultRenderer(Object.class, new customCell());
        jt.setRowHeight(30);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jt.doLayout();

        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row    = jt.rowAtPoint(e.getPoint());
                    int column =jt.columnAtPoint(e.getPoint());
                
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
                    if(row != -1 && column != -1) {
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

        JScrollPane jsp = new JScrollPane(jt);
        getContentPane().add(jsp, BorderLayout.CENTER);

    }

    private void updateCellData(int row, int column, Object value) {
        
        String newValue = (String)value;
        if(column == 2) {
            newValue = "'"+value+"'";
        }
        String update = "UPDATE ROOT.MEDIDAS SET " 
            + encabezados[column] 
            + " = " 
            + newValue 
            + " WHERE IDPERSONA = " 
            + (row + 1) ;

        System.out.println(update);
        dataAccess.insertData(update);
    }

    public static void main(String args[]) {
        TablaMediciones se = new TablaMediciones();
        se.setVisible(true);
    }
    

    private class customCell extends JTextField implements TableCellRenderer {
        public customCell() {
            setOpaque(true);
            setFont(cellFont);
            setForeground(cellForeground);
            setBackground(cellBackground);
            setHorizontalAlignment(SwingConstants.CENTER);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value != null) ? value.toString() : ""); // Establecer el texto de la celda
            return this; // Devolver el componente
        }
    }
}
