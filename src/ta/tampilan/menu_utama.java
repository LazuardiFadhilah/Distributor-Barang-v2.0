/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.tampilan;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import ta.koneksi;
import ta.session;
/**
 *
 * @author Lazuardi Fadhilah
 */
public class menu_utama extends javax.swing.JFrame {
    String id_karyawan = session.get_id_karyawan();
    String nama_karyawan = session.get_nama_karyawan();
    String username = session.get_username();
    String password = session.get_password();
    String jabatan = session.get_jabatan();
    int waktumulai = 0;
    int detik, menit, jam, hari, tanggal, bulan, tahun;

    /**
     * Creates new form admin
     */
    public menu_utama() {
        initComponents();
        button();
        

        
       new Thread(){
           @Override
           public void run(){              
               GregorianCalendar date = new GregorianCalendar();
               String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
               String[] hari_hari = new String[] { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };
               hari = date.get(Calendar.DAY_OF_WEEK) - 1;
               tanggal = date.get(Calendar.DAY_OF_MONTH);
               bulan = date.get(Calendar.MONTH);
               tahun = date.get(Calendar.YEAR);
               txt_tanggal.setText(hari_hari[hari] +", "+tanggal + " " + namabulan[bulan]+ " " + tahun);
               System.out.println("Tanggal sekarang: "+hari+" "+namabulan[bulan]+" "+tahun);
               while(waktumulai == 0){
                   Calendar kalender = new GregorianCalendar();
                   int jam = kalender.get(Calendar.HOUR);
                   int menit = kalender.get(Calendar.MINUTE);
                   int detik = kalender.get(Calendar.SECOND);
                   int AM_PM = kalender.get(Calendar.AM_PM);
                   String siang_malam ="";
                   if(AM_PM == 1){
                       siang_malam="PM"; 
                   }else{
                       siang_malam = "AM";   
                   }
                   String waktu = jam + ":" + menit + ":" + detik + " " + siang_malam;
                   txt_jam.setText(waktu);               
                }  
           }
       }.start();
       setExtendedState(menu_utama.MAXIMIZED_BOTH);
    }
    
    public void button(){
    if(jabatan.equals("Sales")){
        btn_supplier.setEnabled(false);
        btn_gudang.setEnabled(false);
        btn_barang.setEnabled(false);
        
    } else if(jabatan.equals("Purchasing")){
        btn_pelanggan.setEnabled(false);
        btn_gudang.setEnabled(false);
        btn_pesanan.setEnabled(false);
        
    } else if(jabatan.equals("Admin")){
        btn_pelanggan.setEnabled(false);
        btn_supplier.setEnabled(false);
        btn_pesanan.setEnabled(false);
        btn_barang.setEnabled(false);
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

        dekstop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_tanggal = new javax.swing.JLabel();
        txt_jam = new javax.swing.JLabel();
        txt_tanggal2 = new javax.swing.JLabel();
        btn_pelanggan = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        txt_tanggal3 = new javax.swing.JLabel();
        btn_pesanan = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_reimbursement = new javax.swing.JButton();
        txt_tanggal4 = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JButton();
        btn_gudang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        dekstop.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("di Sistem Informasi Distributor Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PT Pandu Biosains");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ta/img/Logo PBS.png"))); // NOI18N

        dekstop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dekstop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dekstop.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dekstop.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dekstopLayout = new javax.swing.GroupLayout(dekstop);
        dekstop.setLayout(dekstopLayout);
        dekstopLayout.setHorizontalGroup(
            dekstopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dekstopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dekstopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dekstopLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        dekstopLayout.setVerticalGroup(
            dekstopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dekstopLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_tanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_tanggal.setText("Senin, 14 April 2021");

        txt_jam.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txt_jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_jam.setText("12:01:30");

        txt_tanggal2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tanggal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_tanggal2.setText("Master");

        btn_pelanggan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pelanggan.setText("Pelanggan");
        btn_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pelangganActionPerformed(evt);
            }
        });

        btn_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_supplier.setText("Supplier");
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });

        txt_tanggal3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tanggal3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_tanggal3.setText("Transaksi");

        btn_pesanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pesanan.setText("Pesanan");
        btn_pesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesananActionPerformed(evt);
            }
        });

        btn_barang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_barang.setText("Barang");
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });

        btn_reimbursement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_reimbursement.setText("Reimbursement");
        btn_reimbursement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reimbursementActionPerformed(evt);
            }
        });

        txt_tanggal4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tanggal4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_tanggal4.setText("Menu");

        btn_keluar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        btn_gudang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_gudang.setText("Gudang");
        btn_gudang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gudangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_jam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tanggal2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tanggal3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reimbursement, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txt_tanggal4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_gudang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_tanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_gudang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_tanggal3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reimbursement, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_tanggal4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dekstop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dekstop)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pelangganActionPerformed
        // TODO add your handling code here:
        pelanggan plg = new pelanggan();
        dekstop.add(plg);
        plg.setVisible(true);
    }//GEN-LAST:event_btn_pelangganActionPerformed

    private void btn_pesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesananActionPerformed
        // TODO add your handling code here:
       pesanan psn = new pesanan();
       dekstop.add(psn);
       psn.setVisible(true);
    }//GEN-LAST:event_btn_pesananActionPerformed

    private void btn_reimbursementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reimbursementActionPerformed
        // TODO add your handling code here:
        reimbursement rmb = new reimbursement();
        dekstop.add(rmb);
        rmb.setVisible(true);
    }//GEN-LAST:event_btn_reimbursementActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        // TODO add your handling code here:
        supplier spl = new supplier();
        dekstop.add(spl);
        spl.setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        // TODO add your handling code here:
        barang brg = new barang();
        dekstop.add(brg);
        brg.setVisible(true);
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_gudangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gudangActionPerformed
        // TODO add your handling code here:
        gudang gd = new gudang();
        dekstop.add(gd);
        gd.setVisible(true);
    }//GEN-LAST:event_btn_gudangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_gudang;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_pelanggan;
    private javax.swing.JButton btn_pesanan;
    private javax.swing.JButton btn_reimbursement;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JDesktopPane dekstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_jam;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JLabel txt_tanggal2;
    private javax.swing.JLabel txt_tanggal3;
    private javax.swing.JLabel txt_tanggal4;
    // End of variables declaration//GEN-END:variables
}
