/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Articulo;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.ArticuloFacadeLocal;

/**
 *
 * @author osvaldo
 */
@Named(value = "bean")
@RequestScoped
public class ArtBean {
    
        


    @EJB
    private ArticuloFacadeLocal articuloFacade;

    public int getCodigo() {
        return codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getPrecio() {
        return precio;
    }

    
    private int codigo;
    private String detalle;
    private int precio;
    
    public ArticuloFacadeLocal getArticuloFacade() {
        return articuloFacade;
    }

    public void setArticuloFacade(ArticuloFacadeLocal articuloFacade) {
        this.articuloFacade = articuloFacade;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArtBean() {
    }
    
    public List<Articulo> getArticulos(){
        return articuloFacade.findAll();
    }
    
    public void crear(){
        
        Articulo articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setDetalle(detalle);
        articulo.setPrecio(precio);
        
        articuloFacade.create(articulo);
    }

    
}
