package com.prueba.bean;

import com.prueba.dao.ProductoDao;
import com.prueba.model.Producto;
import com.prueba.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class ProductoBean {
    Producto producto = new Producto();
    private List<Producto> lstProducto;
    int permiso;
    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void registrar() throws Exception{
        ProductoDao dao;
        try {
            dao = new ProductoDao();
            dao.registrar(producto);
            lstProducto = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception{
        ProductoDao dao;
        
        try {
            dao = new ProductoDao();
            lstProducto = dao.listar();
                    
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerId(Producto per) throws Exception{
        ProductoDao dao;
        Producto temp;
        try {
            dao = new ProductoDao();
            temp = dao.getId(per);
            if (temp != null) {
                this.producto = temp;
            }
                    
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar() throws Exception{
        ProductoDao dao;
        try {
            dao = new ProductoDao();
            dao.modificar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(Producto producto) throws Exception{
        ProductoDao dao;
        try {
            dao = new ProductoDao();
            dao.eliminar(producto);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Boolean permiso() throws Exception{
        permiso = (int) (Math.random() * 2)+1;
        if(permiso==1){
            return true;
        }else{
            this.listar();
            return false;
        }
        
    }

}
