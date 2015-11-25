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

/**
 *
 * @author akroma
 */
@ManagedBean
@SessionScoped
public class loginBean {

    private String userName;
    private String password;

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
    }
    
    public String authenticUser() throws UnsupportedEncodingException, Exception {
        if ((getUserName() == null || getUserName().length() == 0) || (getPassword() == null || getPassword().length() == 0)) {
            JSFUtils.addWarningMessage("Debe ingresar un usuario y password válido");
            return "login";
        }
        boolean success = authenticationService(getUserName(), getPassword());
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    private boolean authenticationService(String userName, String password) throws UnsupportedEncodingException, Exception {
        Demo d = new Demo();
        d.getPropietarios(userName);
        if (password.equals(Propietario.getPassword())) {
            return true;
        }
        return false;
    }
}
