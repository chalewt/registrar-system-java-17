/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarui;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import registrarlib.CurrentUser;
import registrarlib.DbConnection;

/**
 *
 * @author ChalewT
 */
public class FacultyList extends javax.swing.JInternalFrame {

    /**
     * Creates new form FacultyList
     */
    public FacultyList() {
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

        pmnuFacultyList = new javax.swing.JPopupMenu();
        pmniEdit = new javax.swing.JMenuItem();
        pmnuiDelete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacultyList = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        pmniEdit.setText("Update");
        pmniEdit.setActionCommand("Update");
        pmniEdit.setName("Edit"); // NOI18N
        pmniEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmniEditActionPerformed(evt);
            }
        });
        pmnuFacultyList.add(pmniEdit);

        pmnuiDelete.setText("Delete");
        pmnuiDelete.setName("Delete"); // NOI18N
        pmnuiDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuiDeleteActionPerformed(evt);
            }
        });
        pmnuFacultyList.add(pmnuiDelete);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Faculty List");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblFacultyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Code", "Faculty/College", "Phone", "Fax", "Email", "Building", "Office"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFacultyList.setComponentPopupMenu(pmnuFacultyList);
        tblFacultyList.setGridColor(new java.awt.Color(204, 102, 255));
        tblFacultyList.setName("Faculty List"); // NOI18N
        jScrollPane1.setViewportView(tblFacultyList);
        if (tblFacultyList.getColumnModel().getColumnCount() > 0) {
            tblFacultyList.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblFacultyList.getColumnModel().getColumn(0).setMaxWidth(80);
            tblFacultyList.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblFacultyList.getColumnModel().getColumn(1).setMaxWidth(80);
            tblFacultyList.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblFacultyList.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnUpdate.setText("Update");
        btnUpdate.setFocusable(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUpdate);

        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnRefresh.setText("Refresh");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefresh);

        btnPrint.setText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateFaculty();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteFaculty();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        getFacultyList();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        getFacultyList();
        if (CurrentUser.hasRole("dean")) {
            btnUpdate.setVisible(true);
            btnDelete.setVisible(true);
        } else {
            btnUpdate.setVisible(false);
            btnDelete.setVisible(false);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        loadFacultyReport();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void pmniEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmniEditActionPerformed
        // TODO add your handling code here:
        updateFaculty();
    }//GEN-LAST:event_pmniEditActionPerformed

    private void pmnuiDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuiDeleteActionPerformed
        // TODO add your handling code here:
        deleteFaculty();
    }//GEN-LAST:event_pmnuiDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem pmniEdit;
    private javax.swing.JPopupMenu pmnuFacultyList;
    private javax.swing.JMenuItem pmnuiDelete;
    private javax.swing.JTable tblFacultyList;
    // End of variables declaration//GEN-END:variables
private void getFacultyList() {
        //Create objects
        Connection conn = null;
        Statement stmtFaculty = null;
        ResultSet rstFacultyList = null;
        DefaultTableModel tblModelFaculty = (DefaultTableModel) tblFacultyList.getModel();
        tblModelFaculty.setRowCount(0);//remove content if any
        String sql = "Select * From Faculty order by Faculty_Name ASC";
        try {
            conn = DbConnection.getConn();
            stmtFaculty = conn.createStatement();
            rstFacultyList = stmtFaculty.executeQuery(sql);
            while (rstFacultyList.next()) {
                tblModelFaculty.addRow(new Object[]{
                    tblModelFaculty.getRowCount() + 1,
                    rstFacultyList.getString("Faculty_Code"),
                    rstFacultyList.getString("Faculty_Name"),
                    rstFacultyList.getString("Faculty_Phone"),
                    rstFacultyList.getString("Faculty_Fax"),
                    rstFacultyList.getString("Faculty_Email"),
                    rstFacultyList.getString("Faculty_Building"),
                    rstFacultyList.getString("Faculty_Office")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database server error:\n " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error occurred:\n" + e.getMessage());
        } // <editor-fold defaultstate="collapsed" desc="Reccommended to close/release resources"> 
        finally {
            if (rstFacultyList != null) {
                try {
                    rstFacultyList.close();
                } catch (SQLException sqlEx) {
                }
                rstFacultyList = null;
            }
            if (stmtFaculty != null) {
                try {
                    stmtFaculty.close();
                } catch (SQLException sqlEx) {
                }
                stmtFaculty = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                }
                conn = null;
            }
        }
        // </editor-fold> 
    }

    private void deleteFaculty() {
        DefaultTableModel tblModelf = (DefaultTableModel) tblFacultyList.getModel();
        if (tblModelf.getRowCount() > 0) {
            int rep = JOptionPane.showConfirmDialog(tblFacultyList, "The operation is not reversable. \nAre you sure you want to delete?", "Student Information System", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (rep == JOptionPane.YES_OPTION) {
                int facultyCode = Integer.parseInt(tblModelf.getValueAt(tblFacultyList.getSelectedRow(), 1).toString());
                String sql = "Delete FROM Faculty WHERE Faculty_Code = ?";
                try {
                    int aRow;
                    try (Connection conn = DbConnection.getConn()) {
                        PreparedStatement pstFaculty = conn.prepareStatement(sql);
                        pstFaculty.setInt(1, facultyCode);
                        aRow = pstFaculty.executeUpdate();
                    }
                    if (aRow > 0) {
                        JOptionPane.showMessageDialog(tblFacultyList, "Faculty record deleted successfully.", "Student Information System", JOptionPane.INFORMATION_MESSAGE);
                        getFacultyList();
                    } else {
                        JOptionPane.showMessageDialog(tblFacultyList, "Operation faild. Try again.", "Student Information System", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    // e.printStackTrace();
                    JOptionPane.showMessageDialog(tblFacultyList, "Error occurred. \n" + e.getMessage(), "Student Information System", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void updateFaculty() {
        //this is how to use parametrized query with prepared statement 
        DefaultTableModel tblModelFaculty = (DefaultTableModel) tblFacultyList.getModel();
        int rep = JOptionPane.showConfirmDialog(tblFacultyList, "Are you sure you want to update?", "Student Information System", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            //update faculty
            PreparedStatement pst = null;
            String sql = "UPDATE Faculty SET Faculty_Name = ?, Faculty_Phone=?, Faculty_Fax=?, Faculty_Email=?, Faculty_Building =?, Faculty_Office=? WHERE Faculty_Code = ?";
            try {
                int aRow;
                try (Connection conn = DbConnection.getConn()) {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 2).toString());
                    pst.setString(2, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 3).toString());
                    pst.setString(3, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 4).toString());
                    pst.setString(4, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 5).toString());
                    pst.setString(5, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 6).toString());
                    pst.setString(6, tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 7).toString());
                    pst.setInt(7, Integer.parseInt(tblModelFaculty.getValueAt(tblFacultyList.getSelectedRow(), 1).toString()));
                    aRow = pst.executeUpdate();
                    if (aRow > 0) {
                        JOptionPane.showMessageDialog(tblFacultyList, "Faculty record updated successfully.");
                        getFacultyList();
                    } else {
                        JOptionPane.showMessageDialog(tblFacultyList, "Operation faild. Try again.");
                    }
                }
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(tblFacultyList, "Error occurred. \n" + e.getMessage());
            }
        }
    }

    private void loadFacultyReport() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            Connection conn = DbConnection.getConn();
            //String facultyReport = "src\\report\\FacultyList.jrxml";
            //variable path, work in all OS
            String facultyReport = getClass().getResource("/report/FacultyList.jrxml").getFile();
            JasperReport jspReport = JasperCompileManager.compileReport(facultyReport);
            JasperPrint jspPrint = JasperFillManager.fillReport(jspReport, null, conn);
            JasperViewer vr = new JasperViewer(jspPrint, false);
            vr.setTitle("Faculty List");

            vr.setVisible(true);
        } catch (SQLException | JRException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

}
