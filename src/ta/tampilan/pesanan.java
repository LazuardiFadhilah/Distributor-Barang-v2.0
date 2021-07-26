/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.tampilan;

import java.sql.Connection;
import java.sql.SQLException;
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
public class pesanan extends javax.swing.JInternalFrame {

    /**
     * Creates new form pesanan
     */
    public pesanan() {
        initComponents();
        load_tabel_orders();
        load_tabel_details();
        combo_nama_cst();
        combo_nama_spl();
        combo_nama_brg();
        kosong1();
        kosong2();
        autoNumber2();
        autoNumber1();
        total_pembelian();
        
    }
    
    private void ubah_details(){
        id_spl();
        id_brg();
        String id = txt_id_details.getText();
        String qty = txt_qty.getText();
        String harga = txt_harga.getText();
        String id_order = txt_id_order.getText();
        
        try{
            String sql = "UPDATE details SET id_supplier = '"+id_supplier+"', id_barang = '"+id_barang+"', qty = '"+qty+"', total_harga = '"+harga+"' WHERE id_detail='"+id+"' ";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    }
    
    String id1_details;
    private void getId_details(){
        try{
        String sql = "SELECT * FROM details WHERE id_detail = '"+txt_id_details.getText()+"'";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
        id1_details = rs.getString(1);
        }
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    private void hapus_details(){
        getId_details();
        String id = txt_id_details.getText();
        try{
            String sql = "DELETE FROM details WHERE id_detail='"+id+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);

            if(id.equals(id1_details)){
             
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
    
    private void tambah_details(){
        id_spl();
        id_brg();
        String id = txt_id_details.getText();
        String qty = txt_qty.getText();
        String harga = txt_harga.getText();
        String id_order = txt_id_order.getText();
        
        try{
            String sql = "INSERT INTO details VALUES ('"+id+"','"+id_order+"','"+id_supplier+"','"+id_barang+"','"+qty+"','"+harga+"')";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    }
    
    String id1_order;
    private void getId_order(){
        try{
        String sql = "SELECT * FROM orders WHERE no_order = '"+txt_id_order.getText()+"'";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
        id1_order = rs.getString(1);
        }
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    private void hapus_order(){
        getId_order();
        String id = txt_id_order.getText();
        try{
            String sql = "DELETE FROM orders WHERE no_order='"+id+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);

            if(id.equals(id1_order)){
             
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
    
    private void ubah_order(){
        id_cst();
        String no_order = txt_id_order.getText();
        
        try{
            String sql = "UPDATE orders SET id_customer='"+id_customer+"' WHERE no_order='"+no_order+"' ";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    }
    
    private void tambah_order(){
        id_cst();
        String no_order = txt_id_order.getText();
        try{
            String sql = "INSERT INTO orders VALUES ('"+no_order+"','"+id_customer+"')";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error : "+e);
        }
    }
    
    String id_customer;
    private void id_cst(){
        try{
            String sql ="select * from customer WHERE nama_customer = '"+combo_nama_customer.getSelectedItem()+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
            id_customer = res.getString("id_customer");
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void total_pembelian(){
        try{
            String sql ="SELECT COALESCE(sum(total_harga),0) FROM details WHERE no_order = '"+txt_id_order.getText()+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
            txt_total.setText(res.getString("COALESCE(sum(total_harga),0)"));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
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
    
    
    private void harga(){
        id_brg();
        int harga, total_harga;
        int qty = Integer.parseInt(txt_qty.getText());
            
        try{
            String sql ="select * from barang WHERE id_barang = '"+id_barang+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
            harga = res.getInt("harga");
            total_harga = qty * harga;
            txt_harga.setText(Integer.toString(total_harga));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    String id_supplier;
    private void id_spl(){
        try{
            String sql ="select * from supplier WHERE nama_supplier = '"+combo_nama_supplier.getSelectedItem()+"'";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
            id_supplier = res.getString("id_supplier");
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void combo_nama_brg(){
        id_spl();
        try{
            String sql ="select * from barang WHERE id_supplier = '"+id_supplier+"'";
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
    
    private void combo_nama_spl(){
        try{
            String sql ="select * from supplier";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            combo_nama_supplier.removeAllItems();
            while(res.next()){
            

            
            combo_nama_supplier.addItem(res.getString("nama_supplier"));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void combo_nama_cst(){
        try{
            String sql ="select * from customer";
            java.sql.Connection con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            combo_nama_customer.removeAllItems();
            while(res.next()){
            

            
            combo_nama_customer.addItem(res.getString("nama_customer"));
            }
        } catch (SQLException e){
            System.out.println("Error :" +e);
        }
    }
    
    private void load_tabel_details(){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Details");
    model.addColumn("Nama Supplier");
    model.addColumn("Nama Barang");
    model.addColumn("Banyak Barang");
    model.addColumn("Total Harga ");
    
    try{
        String sql = "SELECT details.id_detail, supplier.nama_supplier, barang.nama_barang, details.qty, details.total_harga FROM details JOIN orders ON details.no_order = orders.no_order JOIN supplier ON details.id_supplier = supplier.id_supplier JOIN barang ON details.id_barang = barang.id_barang WHERE orders.no_order = '"+txt_id_order.getText()+"'";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
        }
        tbl_details.setModel(model);
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    private void load_tabel_orders(){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No Order");
    model.addColumn("Nama Customer");
    try{
        String sql = "SELECT orders.no_order, customer.nama_customer FROM orders JOIN customer ON orders.id_customer = customer.id_customer WHERE orders.id_customer like '%"+txt_cari_order.getText()+"%' or customer.nama_customer like '%"+txt_cari_order.getText()+"%'";
        java.sql.Connection con = (Connection)koneksi.koneksidb();
        java.sql.Statement stm = con.createStatement();
        java.sql.ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
        }
        tbl_order.setModel(model);
    } catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error " +e);
    }
    }
    
    public void kosong2(){
        txt_id_details.setEnabled(false);
        txt_harga.setEnabled(false);
        txt_id_details.setText("");
        combo_nama_supplier.setSelectedItem(null);
        combo_nama_barang.setSelectedItem(null);
        txt_qty.setText("");
        txt_harga.setText("");
    }
    
    public void kosong1(){
        txt_id_order.setEnabled(false);
        txt_id_order.setText("");
        combo_nama_customer.setSelectedItem(null);
    }
    
    public void autoNumber2(){
        try{
            java.sql.Connection Con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = Con.createStatement();
            String sql = "SELECT MAX(RIGHT(id_detail,4)) AS nomor1 FROM details";
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            if(res.first() ==  false){
                txt_id_details.setText("DTL0001");
            } else {
                res.last();
                int no = res.getInt(1) + 1;
                String nomor1 = String.valueOf(no);
                int oto = nomor1.length();
                switch(oto){
                    case 1: nomor1 = "000" +nomor1; break;
                    case 2: nomor1 = "00" +nomor1; break;
                    case 3: nomor1 = "0" +nomor1; break;
                    case 4: nomor1 = "" +nomor1; break;
                }
                txt_id_details.setText("DTL" +nomor1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void autoNumber1(){
        try{
            java.sql.Connection Con = (Connection)koneksi.koneksidb();
            java.sql.Statement stm = Con.createStatement();
            String sql = "SELECT MAX(RIGHT(no_order,4)) AS nomor FROM orders";
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            if(res.first() ==  false){
                txt_id_order.setText("INV0001");
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
                txt_id_order.setText("INV" +nomor);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e);
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
        txt_id_order = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo_nama_customer = new javax.swing.JComboBox<>();
        btn_tambah_order = new javax.swing.JButton();
        btn_ubah_order = new javax.swing.JButton();
        btn_hapus_order = new javax.swing.JButton();
        btn_kosong_order = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_cari_order = new javax.swing.JTextField();
        btn_cari_order = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_details = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo_nama_supplier = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        combo_nama_barang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        btn_tambah_details = new javax.swing.JButton();
        btn_ubah_details = new javax.swing.JButton();
        btn_hapus_details = new javax.swing.JButton();
        btn_kosong_details = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_details = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel1.setText("No Order");

        jLabel2.setText("Nama Customer");

        combo_nama_customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_tambah_order.setText("Tambah");
        btn_tambah_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_orderActionPerformed(evt);
            }
        });

        btn_ubah_order.setText("Ubah");
        btn_ubah_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_orderActionPerformed(evt);
            }
        });

        btn_hapus_order.setText("Hapus");
        btn_hapus_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_orderActionPerformed(evt);
            }
        });

        btn_kosong_order.setText("Kosongkan");
        btn_kosong_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kosong_orderActionPerformed(evt);
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
                    .addComponent(txt_id_order)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(combo_nama_customer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambah_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ubah_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hapus_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kosong_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_nama_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tambah_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ubah_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_kosong_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Order", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        btn_cari_order.setText("Cari");
        btn_cari_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_orderActionPerformed(evt);
            }
        });

        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_order);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_cari_order)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cari_order, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari_order, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel3.setText("ID Details");

        jLabel4.setText("Nama Supplier");

        combo_nama_supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_nama_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_nama_supplierMouseClicked(evt);
            }
        });
        combo_nama_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nama_supplierActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Barang");

        combo_nama_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nama_barangActionPerformed(evt);
            }
        });

        jLabel6.setText("Banyak Barang");

        txt_qty.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_qtyInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });
        txt_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_qtyKeyTyped(evt);
            }
        });

        jLabel7.setText("Total Harga");

        btn_tambah_details.setText("Tambah");
        btn_tambah_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_detailsActionPerformed(evt);
            }
        });

        btn_ubah_details.setText("Ubah");
        btn_ubah_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_detailsActionPerformed(evt);
            }
        });

        btn_hapus_details.setText("Hapus");
        btn_hapus_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_detailsActionPerformed(evt);
            }
        });

        btn_kosong_details.setText("Kosongkan");
        btn_kosong_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kosong_detailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id_details)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(combo_nama_supplier, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_nama_barang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_qty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tambah_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ubah_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hapus_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kosong_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id_details, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_tambah_details, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ubah_details, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus_details, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_kosong_details, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        tbl_details.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_details);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Total Pembelian : Rp.");

        txt_total.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_total.setText("20000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderMouseClicked
        // TODO add your handling code here:
        int baris = tbl_order.rowAtPoint(evt.getPoint());
        String id = tbl_order.getValueAt(baris, 0).toString();
        txt_id_order.setText(id);
        String nama = tbl_order.getValueAt(baris, 1).toString();
        combo_nama_customer.setSelectedItem(nama);
        total_pembelian();  
        load_tabel_details();
    }//GEN-LAST:event_tbl_orderMouseClicked

    private void tbl_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsMouseClicked
        // TODO add your handling code here:
        int baris = tbl_details.rowAtPoint(evt.getPoint());
        String id = tbl_details.getValueAt(baris, 0).toString();
        txt_id_details.setText(id);
        String nama_sp = tbl_details.getValueAt(baris, 1).toString();
        combo_nama_supplier.setSelectedItem(nama_sp);
        String nama_br = tbl_details.getValueAt(baris, 2).toString();
        combo_nama_barang.setSelectedItem(nama_br);
        String qty = tbl_details.getValueAt(baris, 3).toString();
        txt_qty.setText(qty);
        String harga = tbl_details.getValueAt(baris, 4).toString();
        txt_harga.setText(harga);
    }//GEN-LAST:event_tbl_detailsMouseClicked

    private void btn_cari_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_orderActionPerformed
        // TODO add your handling code here:
        load_tabel_orders();
    }//GEN-LAST:event_btn_cari_orderActionPerformed

    private void combo_nama_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_nama_supplierMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combo_nama_supplierMouseClicked

    private void combo_nama_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nama_supplierActionPerformed
        // TODO add your handling code here:
     combo_nama_brg();
     txt_qty.setText("");
     txt_harga.setText("");
    }//GEN-LAST:event_combo_nama_supplierActionPerformed

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
        // TODO add your handling code here:
        harga();
    }//GEN-LAST:event_txt_qtyActionPerformed

    private void txt_qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_qtyKeyTyped

    private void txt_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_qtyKeyPressed

    private void btn_tambah_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_orderActionPerformed
        // TODO add your handling code here:
        if(txt_id_order.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        tambah_order();
        kosong1();
        load_tabel_orders();
        autoNumber1();
        }
    }//GEN-LAST:event_btn_tambah_orderActionPerformed

    private void btn_ubah_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_orderActionPerformed
        // TODO add your handling code here:
        if(txt_id_order.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        ubah_order();
        kosong1();
        load_tabel_orders();
        autoNumber1();
        }
    }//GEN-LAST:event_btn_ubah_orderActionPerformed

    private void btn_hapus_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_orderActionPerformed
        // TODO add your handling code here:
        hapus_order();
        kosong1();
        load_tabel_orders();
        autoNumber1();
    }//GEN-LAST:event_btn_hapus_orderActionPerformed

    private void btn_kosong_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kosong_orderActionPerformed
        // TODO add your handling code here:
        kosong1();
        load_tabel_orders();
        load_tabel_details();
        autoNumber1();
        total_pembelian();
    }//GEN-LAST:event_btn_kosong_orderActionPerformed

    private void btn_tambah_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_detailsActionPerformed
        // TODO add your handling code here:
        if(txt_id_details.getText().equals("") || txt_qty.getText().equals("") || txt_harga.getText().equals("")  ){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        tambah_details();
        kosong2();
        load_tabel_details();
        autoNumber2();
        total_pembelian();
        }
    }//GEN-LAST:event_btn_tambah_detailsActionPerformed

    private void btn_ubah_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_detailsActionPerformed
        // TODO add your handling code here:
        if(txt_id_details.getText().equals("") || txt_qty.getText().equals("") || txt_harga.getText().equals("")  ){
           JOptionPane.showMessageDialog(rootPane, "Data tidak boleh ada yang kosong","Pemberitahuan",JOptionPane.WARNING_MESSAGE);
        } else{
        ubah_details();
        kosong2();
        load_tabel_details();
        autoNumber2();
        total_pembelian();
        }
    }//GEN-LAST:event_btn_ubah_detailsActionPerformed

    private void btn_hapus_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_detailsActionPerformed
        // TODO add your handling code here:
        hapus_details();
        kosong2();
        load_tabel_details();
        autoNumber2();
        total_pembelian();
    }//GEN-LAST:event_btn_hapus_detailsActionPerformed

    private void btn_kosong_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kosong_detailsActionPerformed
        // TODO add your handling code here:
        kosong2();
        load_tabel_details();
        autoNumber2();
        total_pembelian();
    }//GEN-LAST:event_btn_kosong_detailsActionPerformed

    private void combo_nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nama_barangActionPerformed
        // TODO add your handling code here:
       txt_qty.setText("1");
       harga();
    }//GEN-LAST:event_combo_nama_barangActionPerformed

    private void txt_qtyInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_qtyInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_qtyInputMethodTextChanged

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {

            String path="src/ta/report/invoice.jasper";      // letak penyimpanan report

            HashMap parameter = new HashMap();

            parameter.put("no_inv",txt_id_order.getText());
            // "no_faktur" => nama parameter yang dibuat
            //jTextFieldnofaktur.getText() ==> disesuaikan dengan jTextField yang digunakan

            JasperPrint print = JasperFillManager.fillReport(path,parameter,koneksi.koneksidb());

            JasperViewer.viewReport(print, false);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane,"Error: "+ex);

        }
    }//GEN-LAST:event_btn_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari_order;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus_details;
    private javax.swing.JButton btn_hapus_order;
    private javax.swing.JButton btn_kosong_details;
    private javax.swing.JButton btn_kosong_order;
    private javax.swing.JButton btn_tambah_details;
    private javax.swing.JButton btn_tambah_order;
    private javax.swing.JButton btn_ubah_details;
    private javax.swing.JButton btn_ubah_order;
    private javax.swing.JComboBox<String> combo_nama_barang;
    private javax.swing.JComboBox<String> combo_nama_customer;
    private javax.swing.JComboBox<String> combo_nama_supplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_details;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTextField txt_cari_order;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id_details;
    private javax.swing.JTextField txt_id_order;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables

    private void setText(int total_harga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
