/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author felipe
 */
public class Conexao {
    private static String status = "Não conectou!";
    
    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/Notas";
    public static final String USUARIO = "root";
    public static final String SENHA = "123456789";
    
    
    public static Connection obterConexaoMySQL() {

        Connection conexao = null;

        try {

            conexao = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);

            if (conexao != null) {
                status = "Conectado!";
            }

            return conexao;

        } catch (Exception e) {

            System.out.println("Driver não foi encontrado.");

            return null;

        }

    }// fim do método de conexão

    public static String retornaStatusConexao() {
        return status;
    }

    public static boolean fecharConexao() {

        try {

            Conexao.obterConexaoMySQL().close();

            return true;

        } catch (java.sql.SQLException e) {

            return false;

        }

    }
    
}
