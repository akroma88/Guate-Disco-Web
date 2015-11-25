/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ecys.guate.disco.web.dto;

/**
 *
 * @author akroma
 */
public class Propietario {
    private static String nombres;
    private static String apellidos;
    private static String usuario;
    private static String password;
    private static String correo;
    private static int id;

    public static String getNombres() {
        return nombres;
    }

    public static void setNombres(String aNombres) {
        nombres = aNombres;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static void setApellidos(String aApellidos) {
        apellidos = aApellidos;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String aCorreo) {
        correo = aCorreo;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int aId) {
        id = aId;
    }
}