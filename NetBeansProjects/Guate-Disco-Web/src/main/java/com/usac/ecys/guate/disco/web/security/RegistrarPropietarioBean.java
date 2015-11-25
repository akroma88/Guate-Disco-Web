/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ecys.guate.disco.web.security;

import com.usac.ecys.guate.disco.web.util.JSFUtils;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author akroma
 */
@ManagedBean
@SessionScoped
public class RegistrarPropietarioBean {

    private String nombres;
    private String apellidos;
    private String userName;
    private String password;
    private String repPassword;
    private String correo;
    
    public RegistrarPropietarioBean() {
    }

    
    public String registrar() throws SQLException, Exception{
        FacesContext context = FacesContext.getCurrentInstance();
        if(getPassword().equals(getRepPassword())){
            if(!exiteCorreo()){
                insertPropietario();
                context.addMessage(null, new FacesMessage("Exito",  "Ya tienes una cuenta!"));
                return "login"; 
            }else{
                context.addMessage(null, new FacesMessage("Error",  "Este correo ya existe"));
                //JSFUtils.addWarningMessage("Este correo ya existe");
            }
        }else{
            context.addMessage(null, new FacesMessage("Error",  "La clave de acceso no es igual"));
           /// JSFUtils.addWarningMessage("La clave de acceso no es igual");
        }
        return "registrarPropietario";
    }
    
    public String cancelar(){
        return "home";
    }
    
    
    public boolean exiteCorreo() throws UnsupportedEncodingException, Exception{
        Demo d = new Demo();
        if(d.exiteCorreo(correo).equals(correo)){
            return true;
        }
        return false;
    }
    
    public boolean insertPropietario() throws SQLException{
        Demo d = new Demo();
        return d.insertPropietario(nombres, apellidos, userName, password, correo);
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepPassword() {
        return repPassword;
    }

    public void setRepPassword(String repPassword) {
        this.repPassword = repPassword;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    
}
