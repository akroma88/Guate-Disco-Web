/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ecys.guate.disco.web.jsf;

import com.usac.ecys.guate.disco.web.dto.Disco;
import com.usac.ecys.guate.disco.web.security.Demo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author akroma
 */
@ManagedBean
@SessionScoped
public class RegistrarDiscoBean {
    private String nombre;
    private String direccion;
    private int zona;
    private ArrayList<Integer> zonas = new ArrayList<Integer>();
    private boolean boolenaFB;
    private String paginaFB;
    private String paginaWeb;
    private String paginaTwitter;
    private String altitud;
    private String latitud;
    private int telefono;
    private String descripcion;
    private UploadedFile uploadedFile;

    /**
     * Creates a new instance of RegistrarDisco
     */
    public RegistrarDiscoBean() {
        boolenaFB=true;
        zonas.add(1); zonas.add(2); zonas.add(3);
        zonas.add(4); zonas.add(5); zonas.add(6);
        zonas.add(7); zonas.add(8); zonas.add(9);
        zonas.add(10); zonas.add(11); zonas.add(12);
        zonas.add(13); zonas.add(14); zonas.add(15);
    }
    
    
    
    public void existePagina() {
        boolean summary = isBoolenaFB() ? true : false;
        setBoolenaFB(summary);
        setPaginaFB("null");
    }
    
    public void registrar() throws SQLException{
        
        if(paginaFB.isEmpty())
            paginaFB = "null";

        if(paginaTwitter.isEmpty())
            paginaTwitter = "null";
        
        if(paginaWeb.isEmpty())
            paginaWeb = "null";
        
        Disco d = new Disco();
        d.setNombre(getNombre());
        d.setDireccion(getDireccion());
        d.setZona(getZona());
        d.setRank((float) 2.5);
        d.setDescripcion(getDescripcion());
        //d.setImg(geti);
        d.setPaginaWeb(getPaginaWeb());
        d.setPaginaFb(getPaginaFB());
        d.setPaginaTw(getPaginaTwitter());
        d.setTelefono(getTelefono());
        d.setLatitud(""+getLatitud());
        d.setAltitud(""+getAltitud());
        
        
        Demo de = new Demo();
        FacesContext context = FacesContext.getCurrentInstance();

            boolean success = de.insertDisco(d);
            if(!success){
                context.addMessage(null, new FacesMessage("Error",  "Ocurrio un error"));
            }else{
                context.addMessage(null, new FacesMessage("Exito",  "Discoteca guardada"));
                
            }
    }
    public void uploada(){}
    
    public void upload() {
       // FacesMessage msg = new FacesMessage("Ok! ", event.getFile().getFileName() + " archivo subido con éxito.");
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //String fileName = uploadedFile.getFileName();
      //  try {
            //System.out.println("aaaaa  "+getUploadedFile().getFileName());

           //copyFile(uploadedFile.getFileName(), uploadedFile.getInputstream(), uploadedFile.getContentType());

       // } catch (IOException e) {
        //    e.printStackTrace();

       // }
    }

    public void copyFile(String fileName, InputStream in, String contentType) {
    	
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String destino=(String) servletContext.getRealPath("/upload/");
        destino=destino+"/";
        System.out.println("destino:::::: "+destino);
        
    	
    	String prefijo="__";
        try {
        	
            OutputStream out = new FileOutputStream(new File(destino + prefijo+"disc06.jpg"));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the zona
     */
    public int getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(int zona) {
        this.zona = zona;
    }

    /**
     * @return the zonas
     */
    public ArrayList<Integer> getZonas() {
        return zonas;
    }

    /**
     * @param zonas the zonas to set
     */
    public void setZonas(ArrayList<Integer> zonas) {
        this.zonas = zonas;
    }

    /**
     * @return the boolenaFB
     */
    public boolean isBoolenaFB() {
        return boolenaFB;
    }

    /**
     * @param boolenaFB the boolenaFB to set
     */
    public void setBoolenaFB(boolean boolenaFB) {
        this.boolenaFB = boolenaFB;
    }

    /**
     * @return the paginaFB
     */
    public String getPaginaFB() {
        return paginaFB;
    }

    /**
     * @param paginaFB the paginaFB to set
     */
    public void setPaginaFB(String paginaFB) {
        this.paginaFB = paginaFB;
    }

    /**
     * @return the paginaWeb
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }

    /**
     * @param paginaWeb the paginaWeb to set
     */
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    /**
     * @return the paginaTwitter
     */
    public String getPaginaTwitter() {
        return paginaTwitter;
    }

    /**
     * @param paginaTwitter the paginaTwitter to set
     */
    public void setPaginaTwitter(String paginaTwitter) {
        this.paginaTwitter = paginaTwitter;
    }

    /**
     * @return the altitud
     */
    public String getAltitud() {
        return altitud;
    }

    /**
     * @param altitud the altitud to set
     */
    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
}
