/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dohoa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class AcessDatabase {

    public static Connection collectionDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datatudien?useSSL=false", "root", "020206");
        return con;
    }
    
    public String readDatabase(String word) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Statement state = collectionDatabase().createStatement();
        String sql = "select * from tbl_edict where word LIKE "+"'"+word+"'"+";";
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()) {
             String wor=rs.getString(3);
                String var1 = wor.replaceAll("<C><F><I><N><Q>", "\n    ");
                String var2 = var1.replaceAll("<br />", "\n    ");
                word = var2.replaceAll("</Q></N></I></F></C>", "");
 
        }
        return word;
    }
}
