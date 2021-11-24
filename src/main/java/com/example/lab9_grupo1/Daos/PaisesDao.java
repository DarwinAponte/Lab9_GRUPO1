package com.example.lab9_grupo1.Daos;

import com.example.lab9_grupo1.Beans.*;

import java.sql.*;
import java.util.ArrayList;

public class PaisesDao extends BaseDao {

    public ArrayList<Paises> listaPaisesContinente(int idPais, String nombre, String continente, double poblacion, double tamano) {

        ArrayList<Paises> listaPaisesPorContinente = new ArrayList<>();

        String sql = ""; // query que permita filtrar paises x continente

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paises pais = new Paises();
                pais.setIdPais(rs.getInt(1));
                pais.setNombre_pais(rs.getString(2));
                pais.setNombre_pais(rs.getString(3));
                pais.setPoblacion(rs.getDouble(4));
                pais.setTamano_pais(rs.getDouble(5));
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

            pstmt.setInt(1, pais.getIdPais());
            pstmt.setString(2, pais.getNombre_pais());
            pstmt.setString(3, pais.getContinente());
            pstmt.setDouble(4, pais.getPoblacion());
            pstmt.setDouble(5, pais.getTamano_pais());
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

            pstmt.setInt(1, pais.getIdPais());
            pstmt.setString(2, pais.getNombre_pais());
            pstmt.setString(3, pais.getContinente());
            pstmt.setDouble(4, pais.getPoblacion());
            pstmt.setDouble(5, pais.getTamano_pais());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void eliminarPaises(int idPais) {
        String sql = ""; // query respectivo, se usa delete from y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idPais);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
