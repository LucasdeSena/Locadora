/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import modelo.Usuario;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO {
    
    public static void inserir(Usuario u) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO usuarios (login, senha) " +
                                     "VALUES (?, ?)";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getSenha());        
      
        // Executa no BD        
        preparedStatement.executeUpdate();  
        
        // Fechar conexao
        conn.close();
        
    }    
    
    public static boolean buscar(Usuario u) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        boolean existe = false;
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * FROM usuarios " +
                " WHERE login = ? AND senha = ?";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getSenha());
        
                
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
        if (rs.next()) {
            existe = true;            
         } 
        
        // Fechar conexao
        conn.close();
        
        return existe;
    }    
}
