/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CodigoCaixaModel;
import Model.MonitoramentoModel;
/*import java.lang.ModuleLayer.Controller;*/
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
public class CodigoCaixaController {
   public boolean cadastrarCaixa(CodigoCaixaModel caixa) {
        String sql = "INSERT INTO CAIXA (tipoServico, valor, formadepagamento, dataUso, tempo, "
                + "CLIENTES_idCLIENTES, PLANOS_idPLANOS, MAQUINAS_idMAQUINAS, FUNCIONARIOS_idFUNCIONARIOS) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, caixa.getTipoServico());
            ps.setDouble(2, caixa.getValor());
            ps.setString(3, caixa.getFormadepagamento());
            ps.setString(4, caixa.getDataUso());
            ps.setString(5, caixa.getTempo());
            ps.setInt(6, caixa.getClientes_idclientes());
            ps.setInt(7, caixa.getPlanos_idplanos());
            ps.setInt(8, caixa.getMaquinas_idmaquinas());
            ps.setInt(9, caixa.getFuncionarios_idfuncionarios());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public List<CodigoCaixaModel> listarCaixa() {
        List<CodigoCaixaModel> lista = new ArrayList<>();

        String sql = "SELECT cx.*, cl.nomeCliente, pl.nomePlano, mq.nomeMaquina, f.nomeFuncionario "
                + "FROM CAIXA cx "
                + "INNER JOIN CLIENTES cl ON cl.idCLIENTES = cx.CLIENTES_idCLIENTES "
                + "INNER JOIN PLANOS pl ON pl.idPLANOS = cx.PLANOS_idPLANOS "
                + "INNER JOIN MAQUINAS mq ON mq.idMAQUINAS = cx.MAQUINAS_idMAQUINAS "
                + "INNER JOIN FUNCIONARIOS f ON f.idFUNCIONARIOS = cx.FUNCIONARIOS_idFUNCIONARIOS";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CodigoCaixaModel caixa = new CodigoCaixaModel();
                caixa.setIdCAIXA(rs.getInt("idCAIXA"));
                caixa.setTipoServico(rs.getString("tipoServico"));
                caixa.setValor(rs.getDouble("valor"));
                caixa.setFormadepagamento(rs.getString("formadepagamento"));
                caixa.setDataUso(rs.getString("dataUso"));
                caixa.setTempo(rs.getString("tempo"));
                caixa.setClientes_idclientes(rs.getInt("CLIENTES_idCLIENTES"));
                caixa.setPlanos_idplanos(rs.getInt("PLANOS_idPLANOS"));
                caixa.setMaquinas_idmaquinas(rs.getInt("MAQUINAS_idMAQUINAS"));
                caixa.setFuncionarios_idfuncionarios(rs.getInt("FUNCIONARIOS_idFUNCIONARIOS"));
                caixa.setNomeCliente(rs.getString("nomeCliente"));
                caixa.setNomePlano(rs.getString("nomePlano"));
                caixa.setNomeMaquina(rs.getString("nomeMaquina"));
                caixa.setNomeFuncionario(rs.getString("nomeFuncionario"));
                lista.add(caixa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    public boolean atualizarCaixa(CodigoCaixaModel caixa) {
        String sql = "UPDATE CAIXA SET tipoServico = ?, valor = ?, formadepagamento = ?, "
                + "dataUso = ?, tempo = ?, CLIENTES_idCLIENTES = ?, PLANOS_idPLANOS = ?, "
                + "MAQUINAS_idMAQUINAS = ?, FUNCIONARIOS_idFUNCIONARIOS = ? WHERE idCAIXA = ?";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, caixa.getTipoServico());
            ps.setDouble(2, caixa.getValor());
            ps.setString(3, caixa.getFormadepagamento());
            ps.setString(4, caixa.getDataUso());
            ps.setString(5, caixa.getTempo());
            ps.setInt(6, caixa.getClientes_idclientes());
            ps.setInt(7, caixa.getPlanos_idplanos());
            ps.setInt(8, caixa.getMaquinas_idmaquinas());
            ps.setInt(9, caixa.getFuncionarios_idfuncionarios());
            ps.setInt(10, caixa.getIdCAIXA());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirCaixa(int id) {
        String sql = "DELETE FROM CAIXA WHERE idCAIXA = ?";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        }
    }

    public List<CodigoCaixaModel> pesquisarCaixa(String termo) {
        List<CodigoCaixaModel> lista = new ArrayList<>();

        String sql = "SELECT cx.*, cl.nomeCliente, pl.nomePlano, mq.nomeMaquina, f.nomeFuncionario "
                + "FROM CAIXA cx "
                + "INNER JOIN CLIENTES cl ON cl.idCLIENTES = cx.CLIENTES_idCLIENTES "
                + "INNER JOIN PLANOS pl ON pl.idPLANOS = cx.PLANOS_idPLANOS "
                + "INNER JOIN MAQUINAS mq ON mq.idMAQUINAS = cx.MAQUINAS_idMAQUINAS "
                + "INNER JOIN FUNCIONARIOS f ON f.idFUNCIONARIOS = cx.FUNCIONARIOS_idFUNCIONARIOS "
                + "WHERE cl.nomeCliente LIKE ? or mq.nomeMaquina LIKE ?";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            String valorBusca = "%" + termo + "%";
            ps.setString(1, valorBusca);
            ps.setString(2, valorBusca);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CodigoCaixaModel caixa = new CodigoCaixaModel();
                caixa.setIdCAIXA(rs.getInt("idCAIXA"));
                caixa.setTipoServico(rs.getString("tipoServico"));
                caixa.setValor(rs.getDouble("valor"));
                caixa.setFormadepagamento(rs.getString("formadepagamento"));
                caixa.setDataUso(rs.getString("dataUso"));
                caixa.setTempo(rs.getString("tempo"));
                caixa.setClientes_idclientes(rs.getInt("CLIENTES_idCLIENTES"));
                caixa.setPlanos_idplanos(rs.getInt("PLANOS_idPLANOS"));
                caixa.setMaquinas_idmaquinas(rs.getInt("MAQUINAS_idMAQUINAS"));
                caixa.setFuncionarios_idfuncionarios(rs.getInt("FUNCIONARIOS_idFUNCIONARIOS"));
                caixa.setNomeCliente(rs.getString("nomeCliente"));
                caixa.setNomePlano(rs.getString("nomePlano"));
                caixa.setNomeMaquina(rs.getString("nomeMaquina"));
                caixa.setNomeFuncionario(rs.getString("nomeFuncionario"));
                lista.add(caixa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar: " + e.getMessage());
        }

        return lista;
    }

    public int buscarIdClientePorNome(String nome) {
        String sql = "SELECT idCLIENTES FROM CLIENTES WHERE nomeCliente = ?";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idCLIENTES");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ID do cliente: " + e.getMessage());
        }
        return -1;
    }

    public int buscarIdMaquinaPorNome(String nome) {
        String sql = "SELECT idMAQUINAS FROM MAQUINAS WHERE nomeMaquina = ?";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idMAQUINAS");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ID da máquina: " + e.getMessage());
        }
        return -1;
    }
}
