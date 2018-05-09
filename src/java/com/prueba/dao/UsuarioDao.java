package com.prueba.dao;


import com.prueba.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DAO {
    
    public Usuario getId(Usuario usu) throws Exception{
        Usuario pr = null;
        ResultSet rs;
        
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT codigo, nombres, rol, user, pass FROM usuario WHERE user=? AND pass=?");
            st.setString(1, usu.getUser());
            st.setString(2, usu.getPass());
            rs = st.executeQuery();
            
            while(rs.next()){
                pr = new Usuario();
                pr.setCodigo(rs.getInt("codigo"));
                pr.setNombres(rs.getString("nombres"));
                pr.setRol(rs.getString("rol"));
                pr.setUser(rs.getString("user"));
                pr.setPass(rs.getString("pass"));
            }
            
        } catch (SQLException e) {
             System.out.println("Error: "+e.toString());
        }finally{
            this.desconectar();
        }
        return pr;
    }
    
    
}
