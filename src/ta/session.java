/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

/**
 *
 * @author Lazuardi Fadhilah
 */
public class session {
     private static String id_karyawan, nama_karyawan, username, password, jabatan;
     
    public static String get_id_karyawan(){
        return id_karyawan;
    }
    public static void set_id_karyawan(String id_karyawan){
    session.id_karyawan = id_karyawan;
    }
    
    public static String get_nama_karyawan(){
        return nama_karyawan;
    }
    public static void set_nama_karyawan(String nama_karyawan){
    session.nama_karyawan = nama_karyawan;
    }
    
    public static String get_username(){
        return username;
    }
    public static void set_username(String username){
    session.username = username;
    }
    
    public static String get_password(){
        return password;
    }
    public static void set_password(String password){
    session.password = password;
    }
    
    public static String get_jabatan(){
        return jabatan;
    }
    public static void set_jabatan(String jabatan){
    session.jabatan = jabatan;
    }
}
