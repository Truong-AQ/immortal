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
import java.util.ArrayList;
import java.util.List;

class AcessDatabase {

    public static Connection collectionDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datatudien?useSSL=false", "root", "020206");
        return con;
    }
    
   public static List<Dictionary> readDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Dictionary> listDict = new ArrayList<>();
        Statement state = collectionDatabase().createStatement();
        String sql = "select * from tbl_edict;";
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()) {
                String wordDetail = rs.getString(3);
                String var1 = wordDetail.replaceAll("<C><F><I><N><Q>", "\n     ");
                String var2 = var1.replaceAll("<br />", "\n     ");
                String var3 = var2.replaceAll("</Q></N></I></F></C>", "");
            Dictionary dict = new Dictionary(rs.getInt(1), rs.getString(2), var3);
            listDict.add(dict);
        }
        return listDict;
    }
}
