/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cadastrodeplano;
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
public class CadastrodeplanoController {
    

    public boolean inserir(Cadastrodeplano plano) {
        String sql = "INSERT INTO PLANOS (nomePlano, descricaoPlano, valorPlano, taxaPlano, statusPlano) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoComBancoDados.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
          
            stmt.setString(1, plano.getNomePlano());
            stmt.setString(2, plano.getDescricaoPlano());
            stmt.setDouble(3, plano.getValorPlano());
            stmt.setDouble(4, plano.getTaxaPlano());
            stmt.setString(5, plano.getStatusPlano());
            
            
            stmt.executeUpdate();
            
           return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar "+e);
        }
        return false;
}
    
  public List<Cadastrodeplano> listarTodos() {
        List<Cadastrodeplano> planos = new ArrayList<>();
        String sql = "SELECT * FROM PLANOS";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cadastrodeplano plano = new Cadastrodeplano(
                        rs.getInt("idPLANOS"),
                        rs.getString("nomePlano"),
                        rs.getString("descricaoPlano"),
                        rs.getFloat("valorPlano"),
                        rs.getFloat("taxaPlano"),
                        rs.getString("statusPlano")
                );
                planos.add(plano);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planos;
    }

 public List<Cadastrodeplano> buscarPorNome(String nome) {
         List<Cadastrodeplano> planos = new ArrayList<>();
        String sql = "SELECT * FROM PLANOS WHERE nomePlano LIKE ?";
        Cadastrodeplano plano = null;

        try (Connection conn = ConexaoComBancoDados.conectar(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            
            stmt.setString(1, "%"+ nome +"%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                plano= new Cadastrodeplano(
                        rs.getInt("idPLANOS"),
                        rs.getString("nomePlano"),
                        rs.getString("descricaoPlano"),
                        rs.getFloat("valorPlano"),
                        rs.getFloat("taxaPlano"),
                        rs.getString("statusPlano")
                );
                planos.add(plano);
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planos;
    }
 
public boolean atualizar(Cadastrodeplano plano) {
        String sql = "UPDATE PLANOS SET nomePlano=?, descricaoPlano=?, valorPlano=?, taxaPlano=?, statusPlano=? WHERE idPLANOS=?";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plano.getNomePlano());
            stmt.setString(2, plano.getDescricaoPlano());
            stmt.setDouble(3, plano.getValorPlano());
            stmt.setDouble(4, plano.getTaxaPlano());
            stmt.setString(5, plano.getStatusPlano());
            stmt.setInt(6, plano.getIdPLANOS());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro "+e);
             return false;
        }
       
    }

public boolean excluir(int idPLANOS) {
        String sql = "DELETE FROM PLANOS WHERE idPLANOS=?";

        try (Connection conn = ConexaoComBancoDados.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPLANOS);
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println("Erro "+ e);
            return false;
        }
        
    }

 public List<String> listarClientesComPlanos() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT c.nomeCliente, p.nomePlano FROM CLIENTES c INNER JOIN PLANOS p ON c.PLANOS_idPLANOS = p.idPLANOS ";

    try (Connection conn = ConexaoComBancoDados.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String linha = "Cliente: " + rs.getString("nomeCliente") + " | Plano: " + rs.getString("nomePlano");
                lista.add(linha);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
  } 
}