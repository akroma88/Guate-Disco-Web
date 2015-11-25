package com.usac.ecys.guate.disco.web.security;

import com.usac.ecys.guate.disco.web.dto.Disco;
import com.usac.ecys.guate.disco.web.dto.Propietario;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author www.luv2code.com
 */
@SessionScoped
public class Demo {

    Statement myStmt = null;
    ResultSet myRs = null;
    Connection c = null;

    public void getPropietarios(String username) throws SQLException, UnsupportedEncodingException, Exception {

        c = DBClass.getConnection();
        myStmt = c.createStatement();
        String sql;
            sql = "SELECT* FROM guateDiscoBD.Propietario where usuario = \"" + username + "\"";
        myRs = myStmt.executeQuery(sql);
        while (myRs.next()) {
            Propietario.setPassword(myRs.getString("password"));
            Propietario.setId(myRs.getInt("idPropietario"));
        }
    }

        public boolean insertDisco(Disco d) throws SQLException {

        boolean resultadoInser = false;
        String insert = "INSERT INTO `guateDiscoBD`.`Discoteca`\n" +
        "(`nombre`,`direccion`,`zona`,`rank`,`descripcion`,`img`,\n" +
        "`paginaWeb`,`facebook`,`twitter`,`telefono`,`idPropietario`,`latitud`,`altitud`)\n" +
        "VALUES\n" +
        "(\""+d.getNombre()+"\",\""+d.getDireccion()+"\","+d.getZona()+","+d.getRank()+",\""+d.getDescripcion()+"\""
                + ",\"img.png\",\""+d.getPaginaWeb()+"\",\""+d.getPaginaFb()+"\",\""+d.getPaginaTw()+"\""
                + ","+d.getTelefono()+","+""+Propietario.getId()+","+d.getLatitud()+","+d.getAltitud()+");";
        System.err.println("" + insert);

        try {
            c = DBClass.getConnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(insert);
            resultadoInser = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultadoInser;
    }
        
        public boolean editarDisco(Disco d) throws SQLException {
        boolean resultadoInser = false;
        String insert = "UPDATE `guateDiscoBD`.`Discoteca` SET\n" +
        "`nombre`= \""+d.getNombre()+"\""+
        ",`direccion`=\""+d.getDireccion()+"\""+
        ",`zona`="+d.getZona()+
        ",`descripcion`=\""+d.getDescripcion()+"\""+
        ",`paginaWeb`=\""+d.getPaginaWeb()+"\""+
        ",`facebook`=\""+d.getPaginaFb()+"\""+
        ",`twitter`=\""+d.getPaginaTw()+"\""+
        ",`telefono`="+d.getTelefono()+
        ",`latitud`=\""+d.getLatitud()+"\""+
        ",`altitud`=\""+d.getAltitud()+"\""+
            "WHERE `idDiscoteca`="+d.getId()+";";
        
        System.err.println("" + insert);

        try {
            c = DBClass.getConnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(insert);
            resultadoInser = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultadoInser;
        }
        
        
        public boolean insertPropietario(String nombres, String apellidos, String userName,
                String pass, String correo) throws SQLException {

        boolean resultadoInser = false;
        String insert = "INSERT INTO `guateDiscoBD`.`Propietario`\n" +
        "(`nombres`,`apellidos`,`usuario`,\n" +
        "`password`,`correo`)\n" +
        "VALUES\n" +
        "(\""+nombres+"\",\""+apellidos+"\",\""+userName+"\",\""+pass+"\",\""+correo+"\");";
        System.err.println("" + insert);

        try {
            c = DBClass.getConnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(insert);
            resultadoInser = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultadoInser;
    }
        

        
    public String exiteCorreo(String correo) throws SQLException, UnsupportedEncodingException, Exception {

        c = DBClass.getConnection();
        myStmt = c.createStatement();
        String sql;
            sql = "Select correo from guateDiscoBD.Propietario where correo = \"" + correo + "\"";
        myRs = myStmt.executeQuery(sql);
        while (myRs.next()) {
            Propietario.setPassword(myRs.getString("correo"));
            return myRs.getString("correo");
        }
        return "";
    }
        
    
    public ArrayList getDiscos(int idPropietario) throws SQLException, UnsupportedEncodingException, Exception {
        ArrayList<Disco> discos = new ArrayList<Disco>();
        c = DBClass.getConnection();
        myStmt = c.createStatement();
            String sql = "select * from guateDiscoBD.Discoteca where idPropietario = " + idPropietario + "";
        System.out.println(""+sql);

        myRs = myStmt.executeQuery(sql);
        while (myRs.next()) {
            Disco d  = new Disco();
            d.setId(myRs.getInt("idDiscoteca"));
            d.setNombre(myRs.getString("nombre"));
            d.setDireccion(myRs.getString("direccion"));
            d.setZona(myRs.getInt("zona"));
            d.setRank(myRs.getFloat("rank"));
            d.setDescripcion(myRs.getString("descripcion"));
            d.setPaginaWeb(myRs.getString("paginaWeb"));
            d.setPaginaFb(myRs.getString("facebook"));
            d.setPaginaTw(myRs.getString("twitter"));
            d.setTelefono(myRs.getInt("telefono"));
            d.setLatitud(myRs.getString("latitud"));
            d.setAltitud(myRs.getString("altitud"));
            discos.add(d);
        }
        return discos;
    }
}
