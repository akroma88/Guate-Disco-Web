/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ecys.guate.disco.web.jsf;

import com.usac.ecys.guate.disco.web.dto.Disco;
import com.usac.ecys.guate.disco.web.dto.Propietario;
import com.usac.ecys.guate.disco.web.security.Demo;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akroma
 */
@ManagedBean
@SessionScoped
public class MisDiscosBean {

    private ArrayList<Disco> discos = new ArrayList<Disco>();
    private Disco selectDisco;

    private static int idDisco;
    private String nombre;
    private String direccion;
    private String descripcion;
    private int zona;
    private ArrayList<Integer> zonas = new ArrayList<Integer>();
    private boolean boolenaFB;
    private String paginaFB;
    private String paginaWeb;
    private String paginaTwitter;
    private String altitud;
    private String latitud;
    private int telefono;

    public MisDiscosBean() throws UnsupportedEncodingException, Exception {
        Demo d = new Demo();
        HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        
        discos = d.getDiscos(sessionUsuario.getAttribute("correoElectronico").toString());

        zonas.add(1);
        zonas.add(2);
        zonas.add(3);
        zonas.add(4);
        zonas.add(5);
        zonas.add(6);
        zonas.add(7);
        zonas.add(8);
        zonas.add(9);
        zonas.add(10);
        zonas.add(11);
        zonas.add(12);
        zonas.add(13);
        zonas.add(14);
        zonas.add(15);
    }

    public void editar(ActionEvent actionEvent) throws SQLException, Exception {
        Demo dd = new Demo();

        Disco d = new Disco();
        d.setId(idDisco);
        d.setNombre(getNombre());
        d.setDireccion(getDireccion());
        d.setZona(getZona());
        d.setDescripcion(getDescripcion());
        //d.setImg(geti);
        d.setPaginaWeb(getPaginaWeb());
        d.setPaginaFb(getPaginaFB());
        d.setPaginaTw(getPaginaTwitter());
        d.setTelefono(getTelefono());
        d.setLatitud("" + getLatitud());
        d.setAltitud("" + getAltitud());

        dd.editarDisco(d);

        HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        discos = dd.getDiscos(sessionUsuario.getAttribute("correoElectronico").toString());
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Guate-Disco", "Disco: "+nombre+" editada"));
    }

    public ArrayList<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(ArrayList<Disco> discos) {
        this.discos = discos;
    }

    public Disco getSelectDisco() {
        return selectDisco;
    }

    public void setSelectDisco(Disco selectDisco) {
        System.out.println("id: " + selectDisco.getId()
                + " --- nombre " + selectDisco.getNombre());
        idDisco = selectDisco.getId();
        nombre = selectDisco.getNombre();
        direccion = selectDisco.getDireccion();
        zona = selectDisco.getZona();
        descripcion = selectDisco.getDescripcion();
        paginaWeb = selectDisco.getPaginaWeb();
        paginaFB = selectDisco.getPaginaFb();
        paginaTwitter = selectDisco.getPaginaTw();
        telefono = selectDisco.getTelefono();
        latitud = selectDisco.getLatitud();
        altitud = selectDisco.getAltitud();
        this.selectDisco = selectDisco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public ArrayList<Integer> getZonas() {
        return zonas;
    }

    public void setZonas(ArrayList<Integer> zonas) {
        this.zonas = zonas;
    }

    public boolean isBoolenaFB() {
        return boolenaFB;
    }

    public void setBoolenaFB(boolean boolenaFB) {
        this.boolenaFB = boolenaFB;
    }

    public String getPaginaFB() {
        return paginaFB;
    }

    public void setPaginaFB(String paginaFB) {
        this.paginaFB = paginaFB;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaTwitter() {
        return paginaTwitter;
    }

    public void setPaginaTwitter(String paginaTwitter) {
        this.paginaTwitter = paginaTwitter;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
