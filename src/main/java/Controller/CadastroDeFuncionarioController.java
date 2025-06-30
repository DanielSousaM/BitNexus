/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CadastroDeFuncionarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class CadastroDeFuncionarioController {

    public boolean CadastroDeFuncionario(CadastroDeFuncionarioModel e) {
        String sql = "INSERT INTO FUNCIONARIOS (nomeFuncionario, datanascimentoFuncionario, telefoneFuncionario, cpfFuncionario, emailFuncionario, senhaFuncionario) VALUES (?,?,?,?,?,?)";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNomeFuncionario());
            ps.setString(2, e.getDatanascimentoFuncionario());
            ps.setString(3, e.getTelefoneFuncionario());
            ps.setString(4, e.getCpfFuncionario());
            ps.setString(5, e.getEmailFuncionario());
            ps.setString(6, e.getSenhaFuncionario());

            int retorno = ps.executeUpdate();
            return true;
        } catch (SQLException er) {
            er.getStackTrace();
            return false;
        }
    }

    public List<CadastroDeFuncionarioModel> listar() {
        List<CadastroDeFuncionarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM FUNCIONARIOS";

        try (Connection con = ConexaoComBancoDados.conectar(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CadastroDeFuncionarioModel modelo = new CadastroDeFuncionarioModel();
                modelo.setIdFUNCIONARIOS(rs.getInt("idFUNCIONARIOS"));
                modelo.setNomeFuncionario(rs.getString("nomeFuncionario"));
                modelo.setDatanascimentoFuncionario(rs.getString("datanascimentoFuncionario"));
                modelo.setTelefoneFuncionario(rs.getString("telefoneFuncionario"));
                modelo.setCpfFuncionario(rs.getString("cpfFuncionario"));
                modelo.setEmailFuncionario(rs.getString("emailFuncionario"));
                modelo.setSenhaFuncionario(rs.getString("senhaFuncionario"));

                lista.add(modelo);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e);
        }

        return lista;
    }

    public boolean excluirCadastroDeFuncionario(int idFUNCIONARIOS) {
        Connection conectado = ConexaoComBancoDados.conectar();
        String sql = "Delete From FUNCIONARIOS Where idFUNCIONARIOS =?";
        try {
            PreparedStatement declaração = conectado.prepareStatement(sql);
            declaração.setInt(1, idFUNCIONARIOS);
            declaração.execute();
            return true;
        } catch (SQLException er) {
            System.out.println("Erro ao excluir: " + er.getMessage());
            return false;
        }// fim do catch
    }

    public boolean editarCadastroDeFuncionario(CadastroDeFuncionarioModel cdf) {
        Connection Conectado = ConexaoComBancoDados.conectar();
        String sql = "UPDATE FUNCIONARIOS SET nomeFuncionario= ?,datanascimentoFuncionario= ?,telefoneFuncionario= ?,"
                + "cpfFuncionario= ?,emailFuncionario= ?,senhaFuncionario= ? WHERE idFUNCIONARIOS = ?";

        try {
            PreparedStatement preparadaEditar = Conectado.prepareStatement(sql);
            preparadaEditar.setString(1, cdf.getNomeFuncionario());
            preparadaEditar.setString(2, cdf.getDatanascimentoFuncionario());
            preparadaEditar.setString(3, cdf.getTelefoneFuncionario());
            preparadaEditar.setString(4, cdf.getCpfFuncionario());
            preparadaEditar.setString(5, cdf.getEmailFuncionario());
            preparadaEditar.setString(6, cdf.getSenhaFuncionario());

            preparadaEditar.setInt(7, cdf.getIdFUNCIONARIOS());
            preparadaEditar.execute();

            return true;
        }// fim do try 
        catch (SQLException er) {
            System.out.println("Erro ao editar: " + er.getMessage());
            return false;
        }

    }

    public CadastroDeFuncionarioModel realizarLogin(String cpfFuncionario, String senhaFuncionario) {
        
        String sql = "select * from FUNCIONARIOS where cpfFuncionario = ? and senhaFuncionario = ?";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpfFuncionario);
            stmt.setString(2, senhaFuncionario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Dados válidos, longin permitido
                CadastroDeFuncionarioModel funcionariologin = new CadastroDeFuncionarioModel();
                funcionariologin.setIdFUNCIONARIOS(rs.getInt("IdFUNCIONARIOS"));
                funcionariologin.setNomeFuncionario(rs.getString("nomeFuncionario"));
                funcionariologin.setDatanascimentoFuncionario(rs.getString("datanascimentoFuncionario"));
                funcionariologin.setTelefoneFuncionario(rs.getString("telefoneFuncionario"));
                funcionariologin.setCpfFuncionario(rs.getString("cpfFuncionario"));
                funcionariologin.setEmailFuncionario(rs.getString("emailFuncionario"));
                funcionariologin.setSenhaFuncionario(rs.getString("senhaFuncionario"));             
                return funcionariologin;
            }// fim da if
        }//fim da try
        catch (SQLException e) {
            System.out.print("Erro no login: " + e);
        }
         return null; 
    }

    public List<CadastroDeFuncionarioModel> pesquisar(String termo) {
        List<CadastroDeFuncionarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM FUNCIONARIOS WHERE nomeFuncionario LIKE ? OR cpfFuncionario LIKE ?";

        try (Connection con = ConexaoComBancoDados.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

            String valorBusca = "%" + termo + "%";
            stmt.setString(1, valorBusca);
            stmt.setString(2, valorBusca);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CadastroDeFuncionarioModel modelo = new CadastroDeFuncionarioModel();
                modelo.setIdFUNCIONARIOS(rs.getInt("idFUNCIONARIOS"));
                modelo.setNomeFuncionario(rs.getString("nomeFuncionario"));
                modelo.setCpfFuncionario(rs.getString("cpfFuncionario"));
               
                modelo.setDatanascimentoFuncionario(rs.getString("datanascimentoFuncionario"));
                modelo.setTelefoneFuncionario(rs.getString("telefoneFuncionario"));
               
                modelo.setEmailFuncionario(rs.getString("emailFuncionario"));
                modelo.setSenhaFuncionario(rs.getString("senhaFuncionario"));

                lista.add(modelo);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar: " + e.getMessage());
        }

        return lista;
    }
}
