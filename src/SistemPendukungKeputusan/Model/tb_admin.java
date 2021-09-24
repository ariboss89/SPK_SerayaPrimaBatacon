package SistemPendukungKeputusan.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class tb_admin {
    public static String role;
    public static String keepUsername;
    
    
    public String username;
    public String password;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_admin.role = role;
    }

    public static String getKeepUsername() {
        return keepUsername;
    }

    public static void setKeepUsername(String keepUsername) {
        tb_admin.keepUsername = keepUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
}
