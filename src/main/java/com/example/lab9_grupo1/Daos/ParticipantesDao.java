package com.example.lab9_grupo1.Daos;

import com.example.lab9_grupo1.Beans.*;

import java.sql.*;
import java.util.ArrayList;

public class ParticipantesDao extends BaseDao{

    public ArrayList<Participantes> listaParticipantes(String nombre, String apellido, int edad, String nacionalidad, String gender) {

        ArrayList<Participantes> listaParticipantes = new ArrayList<>();

        String sql = ""; // query que permita mostrar participantes

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Participantes participantes = new Participantes();
                participantes.setIdParticipante(rs.getInt(1));
                participantes.setNombre(rs.getString(2));
                participantes.setApellido(rs.getString(3));
                participantes.setEdad(rs.getInt(4));
                participantes.setNacionalidad(rs.getString(5));
                participantes.setGender(rs.getString(6));
                listaParticipantes.add(participantes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaParticipantes;
    }

    public boolean agregarParticipantes(Participantes participantes) { //retorna falso si surge una excepcion

        String sql = ""; // query respectivo, es con insert into y values

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, participantes.getIdParticipante());
            pstmt.setString(2, participantes.getNombre());
            pstmt.setString(3, participantes.getApellido());
            pstmt.setInt(4, participantes.getEdad());
            pstmt.setString(5, participantes.getNacionalidad());
            pstmt.setString(6, participantes.getGender());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean editarParticipantes(Participantes participantes) {
        String sql = ""; // query respectivo, es con update, set y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, participantes.getIdParticipante());
            pstmt.setString(2, participantes.getNombre());
            pstmt.setString(3, participantes.getApellido());
            pstmt.setInt(4, participantes.getEdad());
            pstmt.setString(5, participantes.getNacionalidad());
            pstmt.setString(6, participantes.getGender());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void eliminarParticipantes(int idParticipante) {
        String sql = ""; // query respectivo, se usa delete from y where

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idParticipante);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
