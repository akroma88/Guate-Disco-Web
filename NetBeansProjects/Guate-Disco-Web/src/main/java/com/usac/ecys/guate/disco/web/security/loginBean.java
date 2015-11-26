/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ecys.guate.disco.web.security;

import com.usac.ecys.guate.disco.web.dto.Propietario;
import com.usac.ecys.guate.disco.web.util.JSFUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author akroma
 */
@ManagedBean
@SessionScoped
public class loginBean {

    private String password;
    private String correo;


    public loginBean() {
        HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);
    }
    
    public String authenticUser() throws UnsupportedEncodingException, Exception {
        if ((getCorreo()== null || getCorreo().length() == 0) || (getPassword() == null || getPassword().length() == 0)) {
            JSFUtils.addWarningMessage("Debe ingresar un usuario y password válido");
            return "login";
        }
        boolean success = authenticationService(getCorreo(), getPassword());
        if (!success) {
            JSFUtils.addErrorMessage("Username o password incorrecto");
            return "login";
        }
         return "home";
    }

    public String logout() {
        /*authenticationService.logout();
         username="";
         password="";
         token="";
         user=null;
         menuUser=null;*/
        return "login";
    }

    
    public String registrar(){
        return "registrarPropietario";
    }
    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private boolean authenticationService(String correo, String password) throws UnsupportedEncodingException, Exception {
        Demo d = new Demo();
        Propietario pr = new Propietario();
        pr = d.getPropietarios(correo);
        if (password.equals(pr.getPassword())) {
            
            HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("correoElectronico", this.correo);
            
            return true;
        }
        return false;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
