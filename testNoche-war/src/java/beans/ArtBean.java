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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ArticuloFacadeLocal;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author osvaldo
 */
@Named(value = "bean")
@RequestScoped
public class ArtBean {
    
    private int codigo;
    private String detalle;
    private int precio;
    private Articulo arSelected;
    private Articulo arActualizar;


    @EJB
    private ArticuloFacadeLocal articuloFacade;

    public ArticuloFacadeLocal getArticuloFacade() {
        return articuloFacade;
    }
    
    public Articulo getArSelected() {
        return arSelected;
    }

    public void setArSelected(Articulo arSelected) {
        this.arSelected = arSelected;
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
    
    public int getCodigo() {
        return codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getPrecio() {
        return precio;
    }


    public void eliminar(){
        articuloFacade.remove(arSelected);
    }
    
    public void onRowSelect(SelectEvent event){
        
    }
    
    public void cancelar(RowEditEvent event){
        
    }
    
    public void onCellEdit(CellEditEvent event){
        
    }


    public void crear(){
        
        Articulo articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setDetalle(detalle);
        articulo.setPrecio(precio);
        
        articuloFacade.create(articulo);
    }

    
}
