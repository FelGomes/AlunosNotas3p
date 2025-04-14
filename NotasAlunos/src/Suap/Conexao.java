/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap;

/**
 *
 * @author felipe
 * @since 13-04 at 10:45
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    
    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/Suap";
    public static final String USUARIO = "root";
    public static final String SENHA = "123456789";
    
    
    public Connection getConexao() {
        try {
            return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Erro ao fazer conexao com o banco de dados!");
        }
        return null;
    }

}
