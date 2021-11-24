package com.example.lab9_grupo1.Daos;

import com.example.lab9_grupo1.Beans.*;

import java.sql.*;
import java.util.ArrayList;

public class PaisesDao extends BaseDao {

    public ArrayList<Paises> listaPaisesContinente(String nombre, String continente, double poblacion, double tamano) {

        ArrayList<Paises> listaPaisesPorContinente = new ArrayList<>();

        String sql = ""; // query que permita filtrar paises x continente

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paises pais = new Paises();
                pais.setNombre_pais(rs.getString(1));
                pais.setNombre_pais(rs.getString(2));
                pais.setPoblacion(rs.getDouble(3));
                pais.setTamano_pais(rs.getDouble(4));
                listaPaisesPorContinente.add(pais);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPaisesPorContinente;
    }

    public boolean agregarPaises(Paises pais) { //retorna falso si surge una excepcion

        String sql = ""; // query respectivo, es con insert into y values

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, pais.getNombre_pais());
            pstmt.setString(2, pais.getContinente());
            pstmt.setDouble(3, pais.getPoblacion());
            pstmt.setDouble(4, pais.getTamano_pais());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean editarPaises(Paises pais) {
        String sql = ""; // query respectivo, es con update, set y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, pais.getNombre_pais());
            pstmt.setString(2, pais.getContinente());
            pstmt.setDouble(3, pais.getPoblacion());
            pstmt.setDouble(4, pais.getTamano_pais());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void eliminarPaises(String nombrePais) {
        String sql = ""; // query respectivo, se usa delete from y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, nombrePais);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
