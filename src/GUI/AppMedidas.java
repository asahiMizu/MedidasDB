/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Tables.*;

/**
 *
 * @author asahi
 */
public class AppMedidas extends javax.swing.JFrame {

    /**
     * Creates new form AppMedidas
     */
    public AppMedidas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTablaPersona1 = new Tables.JTablaPersona();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombrefield = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        label1 = new java.awt.Label();
        deletePersonaButton = new javax.swing.JButton();
        addPersonaButton = new javax.swing.JButton();
        addMedidasButton = new javax.swing.JButton();
        updateTableButton = new javax.swing.JButton();
        jTablaPersona2 = new Tables.JTablaPersona();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        IDComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        updateTableButton2 = new javax.swing.JButton();
        addMedidaButton2 = new javax.swing.JButton();
        deleteMedidaButton = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jTablaMedidas1 = new Tables.JTablaMedidas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 223, 252));

        jTabbedPane2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jTabbedPane2.setName(""); // NOI18N
        jTabbedPane2.setRequestFocusEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proporciona los datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Palatino Linotype", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Nombre: ");

        nombrefield.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nombrefield.setText("Inserta tu nombre");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Sexo: ");

        jDateChooser1.setDateFormatString("YYYY-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(1104562873000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-315593927000L));

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino" }));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de nacimiento: ");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Estatura [cm]");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(140, 140, 210, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(nombrefield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        label1.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        label1.setText("Manipulación de datos de personas");

        deletePersonaButton.setBackground(new java.awt.Color(204, 255, 255));
        deletePersonaButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        deletePersonaButton.setForeground(new java.awt.Color(0, 51, 204));
        deletePersonaButton.setText("Eliminar reg. seleccionado");
        deletePersonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePersonaButtonActionPerformed(evt);
            }
        });

        addPersonaButton.setBackground(new java.awt.Color(204, 255, 255));
        addPersonaButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        addPersonaButton.setForeground(new java.awt.Color(0, 51, 204));
        addPersonaButton.setText("Agregar Registro");
        addPersonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonaButtonActionPerformed(evt);
            }
        });

        addMedidasButton.setBackground(new java.awt.Color(204, 255, 255));
        addMedidasButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        addMedidasButton.setForeground(new java.awt.Color(0, 51, 204));
        addMedidasButton.setText("Agregar medidas");
        addMedidasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedidasButtonActionPerformed(evt);
            }
        });

        updateTableButton.setBackground(new java.awt.Color(204, 255, 255));
        updateTableButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        updateTableButton.setForeground(new java.awt.Color(0, 51, 204));
        updateTableButton.setText("Actualizar");
        updateTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTablaPersona2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(addPersonaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletePersonaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMedidasButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateTableButton)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPersonaButton)
                    .addComponent(deletePersonaButton)
                    .addComponent(addMedidasButton)
                    .addComponent(updateTableButton))
                .addGap(28, 28, 28)
                .addComponent(jTablaPersona2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1549, 1549, 1549))
        );

        jTabbedPane2.addTab("Personas", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proporciona los datos ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("ID Persona");

        IDComboBox.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        IDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(getIDsModel()));
        IDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Peso");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setText("Grasa Corporal");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Cintura");

        jDateChooser2.setDateFormatString("YYYY-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jDateChooser2.setMaxSelectableDate(new java.util.Date(1104562873000L));
        jDateChooser2.setMinSelectableDate(new java.util.Date(-315593927000L));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(140, 140, 210, 1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(140.0d, 140.0d, 210.0d, 1.0d));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(140.0d, 140.0d, 210.0d, 1.0d));

        updateTableButton2.setBackground(new java.awt.Color(204, 255, 255));
        updateTableButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        updateTableButton2.setForeground(new java.awt.Color(0, 51, 204));
        updateTableButton2.setText("Actualizar tabla");
        updateTableButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTableButton2ActionPerformed(evt);
            }
        });

        addMedidaButton2.setBackground(new java.awt.Color(204, 255, 255));
        addMedidaButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        addMedidaButton2.setForeground(new java.awt.Color(0, 51, 204));
        addMedidaButton2.setText("Agregar Medida");
        addMedidaButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedidaButton2ActionPerformed(evt);
            }
        });

        deleteMedidaButton.setBackground(new java.awt.Color(204, 255, 255));
        deleteMedidaButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        deleteMedidaButton.setForeground(new java.awt.Color(0, 51, 204));
        deleteMedidaButton.setText("Eliminar medida");
        deleteMedidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMedidaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner2)))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateTableButton2)
                    .addComponent(deleteMedidaButton))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(518, Short.MAX_VALUE)
                    .addComponent(addMedidaButton2)
                    .addGap(168, 168, 168)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteMedidaButton)
                .addGap(27, 27, 27)
                .addComponent(updateTableButton2)
                .addGap(86, 86, 86))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(addMedidaButton2)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );

        label2.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        label2.setText("Manipulación de datos de medidas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTablaMedidas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTablaMedidas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Medidas", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("Personas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deletePersonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePersonaButtonActionPerformed
        jTablaPersona2.deleteSelectedRow();
    }//GEN-LAST:event_deletePersonaButtonActionPerformed

    //Agregar Registro
    private void addPersonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonaButtonActionPerformed
        // Obtener los valores ingresados por el usuario
        String nombre = nombrefield.getText();
        Date fechaNacimiento = jDateChooser1.getDate();
        Character sexo = ((String) jComboBox1.getSelectedItem()).charAt(0);
        int estatura = (Integer) jSpinner1.getValue();

        // Validacion de datos
        if (!nombre.matches("[a-zA-Z\\s]+")) { // Verificar si el nombre contiene solo letras y espacios
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Intentar convertir la estatura a entero
        try {
            Integer.parseInt(jSpinner1.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La estatura debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todos los datos son válidos, crear el objeto dates y agregar la persona
        Object[] dates = new Object[]{
            -1, // ID aún no generado
            nombre, // Nombre del campo
            fechaNacimiento, // Fecha de nacimiento seleccionada
            sexo, // Sexo seleccionado
            estatura // Estatura seleccionada
        };
        
        for(int i = 0; i < dates.length; i++) System.out.println("[" + i + "] "+ dates[i] + " " + dates[i].getClass().getName());
        jTablaPersona2.addPersona(dates);

    }//GEN-LAST:event_addPersonaButtonActionPerformed

    private void addMedidasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedidasButtonActionPerformed
        //

    }//GEN-LAST:event_addMedidasButtonActionPerformed

    private void IDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDComboBoxActionPerformed
        IDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(getIDsModel()));
    }//GEN-LAST:event_IDComboBoxActionPerformed
    private void updateTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jTablaPersona2.updateTable(null);
    }
    private void updateTableButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jTablaMedidas1.updateTable(null);
    }
    private void addMedidaButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Date fecha   = jDateChooser2.getDate();
        double peso  = (double)jSpinner3.getValue();
        int cintura  = (int)jSpinner2.getValue();
        double grasa = (double)jSpinner4.getValue();
        int idPersona = -1;

        //Validacion
        try {
            Double.parseDouble(jSpinner3.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El peso debe ser un valor numerico decimal.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Integer.parseInt(jSpinner2.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La medida de la cintura debe ser un numero entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Double.parseDouble(jSpinner4.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La medida de la grasa debe ser un valor numerico decimal.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String[] idNombre = IDComboBox.getSelectedItem().toString().split(",");
            idPersona = Integer.parseInt(idNombre[0]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID de persona incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object[] dates = new Object[]{
            -1, // ID aún no generado
            fecha,
            peso,
            cintura,
            grasa,
            idPersona
        };
        for(int i = 0; i < dates.length; i++) System.out.println("[" + i + "] "+ dates[i] + " " + dates[i].getClass().getName());
        jTablaMedidas1.addMedicion(dates);
    }
    private void deleteMedidaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jTablaMedidas1.deleteSelectedRow();
    }

    private String[] getIDsModel() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) IDComboBox.getModel();

        int rowCount = jTablaPersona2.getRowCount();
        String[] values = new String[rowCount];
        for (int i = 0 ; i < rowCount; i ++) {
            Object id     = jTablaPersona2.getValueAt(i, 0);
            Object nombre = jTablaPersona2.getValueAt(i, 1);
            if (id != null && nombre != null) {
                String item = (id.toString()) + ", " + (nombre.toString());
                if(model.getIndexOf(item) == -1) {
                    model.addElement(item);
                    values[i] = item;
                }
            }
        }
        return values;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AppMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AppMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AppMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AppMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppMedidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IDComboBox;
    private javax.swing.JButton addMedidaButton2;
    private javax.swing.JButton addMedidasButton;
    private javax.swing.JButton addPersonaButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton deleteMedidaButton;
    private javax.swing.JButton deletePersonaButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private Tables.JTablaMedidas jTablaMedidas1;
    private Tables.JTablaPersona jTablaPersona1;
    private Tables.JTablaPersona jTablaPersona2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField nombrefield;
    private javax.swing.JButton updateTableButton;
    private javax.swing.JButton updateTableButton2;
    // End of variables declaration//GEN-END:variables
}
