package com.prueba.bean;

import com.prueba.dao.UsuarioDao;
import com.prueba.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean() {
        
    }
    
    public String login() throws Exception{
        UsuarioDao dao;
        Usuario temp;
        String logueado;
        try {
            dao = new UsuarioDao();
            temp = dao.getId(usuario);
            
            if(temp != null){
                logueado = "producto?faces-redirect=true";
            }else{
                logueado = "";
            }                
        } catch (Exception e) {
            throw e;
        }
            
        return logueado;
    }
  
    
}
