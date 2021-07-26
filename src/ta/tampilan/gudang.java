/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.tampilan;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import ta.koneksi;

/**
 *
 * @author Lazuardi Fadhilah
 */
public class gudang extends javax.swing.JInternalFrame {

    /**
     * Creates new form gudang
     */
    public gudang() {
        initComponents();
        load_table_gudang();
        no_ord();
        nama_brg();
        tanggal();
        kosong();
        autoNumber();
    }
    
    String id1;
    private void getId(){
        try{
        String sql = "SELECT * FROM gudang WHERE id_gudang = '"+txt_id.getText()+"'";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
        id1 = rs.getString(1);
        }
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    
    private void hapus(){
        getId();
        String id = txt_id.getText();
        try{
            String sql = "DELETE FROM gudang WHERE id_gudang ='"+id+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);

            if(id.equals(id1)){
             
            int hapus = JOptionPane.showOptionDialog(this, "Apakah anda yakin ingin menghapus data ini ?","Hapus",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
            null, null);
            if (hapus == JOptionPane.YES_OPTION) {
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
         }    
         } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    private void ubah(){
        tanggal();
        id_brg();
        String id = txt_id.getText();
        Object order = combo_no_order.getSelectedItem();
        Object barang = combo_nama_barang.getSelectedItem();
        String qty = txt_qty.getText();
        
        try{
            String sql = "UPDATE gudang SET id_barang = '"+id_barang+"', no_order ='"+order+"', qty='"+qty+"', tgl_expired='"+tgl+"' WHERE id_gudang='"+id+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    
    }
    
    private void tambah(){
        tanggal();
        id_brg();
        String id = txt_id.getText();
        Object order = combo_no_order.getSelectedItem();
        Object barang = combo_nama_barang.getSelectedItem();
        String qty = txt_qty.getText();
        
        
        try{
            String sql = "INSERT INTO gudang VALUES ('"+id+"','"+id_barang+"','"+order+"','"+qty+"','"+tgl+"')";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    
    }
    
    String id_barang;
    private void id_brg(){
         try{
            String sql ="select * from barang WHERE nama_barang = '"+combo_nama_barang.getSelectedItem()+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                id_barang = res.getString("id_barang");
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void load_table_gudang(){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Gudang");
    model.addColumn("No Order");
    model.addColumn("Nama Barang");
    model.addColumn("Banyak Barang");
    model.addColumn("Tanggal Expired");
    try{
        String sql = "SELECT gudang.id_gudang, orders.no_order, barang.nama_barang, gudang.qty, gudang.tgl_expired FROM gudang JOIN orders ON gudang.no_order = orders.no_order JOIN barang ON gudang.id_barang = barang.id_barang WHERE gudang.id_gudang like '%"+txt_cari.getText()+"%' OR barang.nama_barang like '%"+txt_cari.getText()+"%' ORDER BY orders.no_order ASC";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
        }
        tbl_gudang.setModel(model);
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    private void nama_brg(){
        try{
            String sql ="select barang.nama_barang FROM barang JOIN details ON details.id_barang = barang.id_barang WHERE details.no_order = '"+combo_no_order.getSelectedItem()+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            combo_nama_barang.removeAllItems();
            while(res.next()){
            

            
            combo_nama_barang.addItem(res.getString("nama_barang"));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void no_ord(){
        try{
            String sql ="select * from orders";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            combo_no_order.removeAllItems();
            while(res.next()){
            

            
            combo_no_order.addItem(res.getString("no_order"));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    String tgl;
    private void tanggal(){
        if(exp_date.getDate() != null){
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            tgl = String.valueOf(format.format(exp_date.getDate()));
        }
    }
    
    public void kosong(){
        txt_id.setEnabled(false);
        combo_nama_barang.setSelectedItem(null);
        combo_no_order.setSelectedItem(null);
        txt_qty.setText("");
        txt_cari.setText("");
        exp_date.setDate(null);
    }
    
    public void autoNumber(){
        try{
            java.sql.Connection Con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = Con.createStatement();
            String sql = "SELECT MAX(RIGHT(id_gudang,4)) AS nomor FROM gudang";
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            if(res.first() ==  false){
                txt_id.setText("GD0001");
            } else {
                res.last();
                int no = res.getInt(1) + 1;
                String nomor = String.valueOf(no);
                int oto = nomor.length();
                switch(oto){
                    case 1: nomor = "000" +nomor; break;
                    case 2: nomor = "00" +nomor; break;
                    case 3: nomor = "0" +nomor; break;
                    case 4: nomor = "" +nomor; break;
                }
                txt_id.setText("GD" +nomor);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo_no_order = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_nama_barang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exp_date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_gudang = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gudang", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel1.setText("ID Gudang");

        jLabel2.setText("No Order");

        combo_no_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_no_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_no_orderActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Barang");

        combo_nama_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Banyak Barang");

        jLabel5.setText("Tanggal Expired");

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Kosongkan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(combo_no_order, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(combo_nama_barang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txt_qty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(exp_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_no_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Gudang", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        tbl_gudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_gudang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_gudangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_gudang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_no_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_no_orderActionPerformed
        // TODO add your handling code here:
        nama_brg();
    }//GEN-LAST:event_combo_no_orderActionPerformed

    private void tbl_gudangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_gudangMouseClicked
        // TODO add your handling code here:
        int baris = tbl_gudang.rowAtPoint(evt.getPoint());
        String id = tbl_gudang.getValueAt(baris, 0).toString();
        txt_id.setText(id);
        String no_order = tbl_gudang.getValueAt(baris, 1).toString();
        combo_no_order.setSelectedItem(no_order);
        String nama_barang = tbl_gudang.getValueAt(baris, 2).toString();
        combo_nama_barang.setSelectedItem(nama_barang);
        String qty = tbl_gudang.getValueAt(baris, 3).toString();
        txt_qty.setText(qty);
        try{
        String tgl = tbl_gudang.getValueAt(baris, 4).toString();
        java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
        exp_date.setDate(date2);
        }
        catch(Exception e){
        System.out.print("error "+e);
        }
    }//GEN-LAST:event_tbl_gudangMouseClicked

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        load_table_gudang();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txt_id.getText().equals("") || txt_qty.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        tambah();
        kosong();
        autoNumber();
        load_table_gudang();
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        kosong();
        autoNumber();
        load_table_gudang();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txt_id.getText().equals("") || txt_qty.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        ubah();
        kosong();
        autoNumber();
        load_table_gudang();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        hapus();
        kosong();
        autoNumber();
        load_table_gudang();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {

            String path="src/ta/report/DO.jasper";      // letak penyimpanan report

            HashMap parameter = new HashMap();

            parameter.put("no_order",combo_no_order.getSelectedItem());
            // "no_faktur" => nama parameter yang dibuat
            //jTextFieldnofaktur.getText() ==> disesuaikan dengan jTextField yang digunakan

            JasperPrint print = JasperFillManager.fillReport(path,parameter,koneksi.koneksidb());

            JasperViewer.viewReport(print, false);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane,"Error: "+ex);

        }
    }//GEN-LAST:event_btn_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JComboBox<String> combo_nama_barang;
    private javax.swing.JComboBox<String> combo_no_order;
    private com.toedter.calendar.JDateChooser exp_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_gudang;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_qty;
    // End of variables declaration//GEN-END:variables
}
