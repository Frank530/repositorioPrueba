package com.prueba.dao;

import com.prueba.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao extends DAO {
    
    public void registrar(Producto producto) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO producto(nombre, valor) values(?,?)");
            st.setString(1, producto.getNombre());
            st.setString(2, producto.getValor());
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Error: "+e.toString());
        }finally{
            this.desconectar();
        }
    }
    
    
    public List <Producto> listar() throws Exception{
        List <Producto> lista;
        ResultSet rs;
        lista = new ArrayList();
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT codigo,nombre,valor FROM producto");
            rs = st.executeQuery();
            
            while (rs.next()) {                
                Producto pr = new Producto();
                pr.setCodigo(rs.getInt("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setValor(rs.getString("valor"));
                
                lista.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e.toString());
        } finally{
            this.desconectar();
        }
        return lista;
    }
    
    public Producto getId(Producto producto) throws Exception{
        Producto pr = null;
        ResultSet rs;
        
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT codigo, nombre, valor FROM producto WHERE codigo = ?");
            st.setInt(1, producto.getCodigo());
            rs = st.executeQuery();
            
            while(rs.next()){
                pr = new Producto();
                pr.setCodigo(rs.getInt("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setValor(rs.getString("valor"));
            }
            
        } catch (SQLException e) {
             System.out.println("Error: "+e.toString());
        }finally{
            this.desconectar();
        }
        return pr;
    }
    
     public void modificar(Producto per) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE producto SET nombre = ?, valor = ? WHERE codigo = ? ");
            st.setString(1, per.getNombre());
            st.setString(2, per.getValor());
            st.setInt(3, per.getCodigo());
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Error: "+e.toString());
        }finally{
            this.desconectar();
        }
    }
     
    public void eliminar(Producto per) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM producto WHERE codigo = ? ");
            st.setInt(1, per.getCodigo());
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Error: "+e.toString());
        }finally{
            this.desconectar();
        }
    }
}
