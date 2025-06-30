package Controller;

import Model.ClienteModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class ClienteController {
        public boolean cadastrarCliente(ClienteModel cliente) {
        String sql = "INSERT INTO CLIENTES (nomeCliente, emailCliente, cpfCliente, telefoneCliente, enderecoCliente, PLANOS_idPLANOS) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getEmailCliente());
            ps.setString(3, cliente.getCpfCliente());
            ps.setString(4, cliente.getTelefoneCliente());
            ps.setString(5, cliente.getEnderecoCliente());
            ps.setInt(6, cliente.getPLANOS_IdPLANOS());
            ps.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso.");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

   public boolean editarCliente(ClienteModel cliente) {
        String sql = "UPDATE CLIENTES SET nomeCliente "
                + "= ?, emailCliente"
                + " = ?, cpfCliente"
                + " = ?, telefoneCliente "
                + "= ?, enderecoCliente = ?, PLANOS_idPLANOS "
                + "= ? WHERE idCLIENTES = ?";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getEmailCliente());
            ps.setString(3, cliente.getCpfCliente());
            ps.setString(4, cliente.getTelefoneCliente());
            ps.setString(5, cliente.getEnderecoCliente());
            ps.setInt(6, cliente.getPLANOS_IdPLANOS());
            ps.setInt(7, cliente.getIdCLIENTES());

            ps.executeUpdate();
            System.out.println("Cliente atualizado com sucesso.");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao editar cliente: " + e.getMessage());
            return false;
        }
    }
       
       public boolean excluirCliente(int idCliente) {
        String sql = "DELETE FROM CLIENTES WHERE idCLIENTES = ?";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
       
       public List<ClienteModel> listarClientes() {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "SELECT clt.*, pl.nomePlano "
                + "FROM CLIENTES clt "
                + "INNER JOIN PLANOS pl ON clt.PLANOS_idPLANOS = pl.idPLANOS";

        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCLIENTES(rs.getInt("idCLIENTES"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setEmailCliente(rs.getString("emailCliente"));
                cliente.setCpfCliente(rs.getString("cpfCliente"));
                cliente.setTelefoneCliente(rs.getString("telefoneCliente"));
                cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                cliente.setPLANOS_IdPLANOS(rs.getInt("PLANOS_idPLANOS"));
                cliente.setNomePlano(rs.getString("nomePlano")); // Campo para exibição

                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
       
       public ClienteModel buscarClientePorId(int id) {
        String sql = "SELECT * FROM CLIENTES WHERE idCLIENTES = ?";
        try (Connection conn = ConexaoComBancoDados.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCLIENTES(rs.getInt("idCLIENTES"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setEmailCliente(rs.getString("emailCliente"));
                cliente.setCpfCliente(rs.getString("cpfCliente"));
                cliente.setTelefoneCliente(rs.getString("telefoneCliente"));
                cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                cliente.setPLANOS_IdPLANOS(rs.getInt("PLANOS_idPLANOS"));
                cliente.setNomePlano(rs.getString("nomePlano"));

                return cliente;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
       
       public List<ClienteModel> pesquisar(String termo) {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "SELECT c.*, p.nomePlano as plano "
                + "FROM CLIENTES c "
                + "Inner JOIN PLANOS p ON c.PLANOS_idPLANOS = p.idPLANOS "
                + "WHERE c.nomeCliente LIKE ? OR c.cpfCliente LIKE ?";

        try (Connection con = ConexaoComBancoDados.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

            String valorBusca = "%" + termo + "%";
            stmt.setString(1, valorBusca);
            stmt.setString(2, valorBusca);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteModel modelo = new ClienteModel();
                modelo.setIdCLIENTES(rs.getInt("idCLIENTES"));
                modelo.setNomeCliente(rs.getString("nomeCliente"));
                modelo.setEmailCliente(rs.getString("emailCliente"));
                modelo.setCpfCliente(rs.getString("cpfCliente"));
                modelo.setTelefoneCliente(rs.getString("telefoneCliente"));
                modelo.setEnderecoCliente(rs.getString("enderecoCliente"));
                modelo.setPLANOS_IdPLANOS(rs.getInt("PLANOS_idPLANOS"));
                modelo.setNomePlano(rs.getString("plano")); // Campo para exibição

                lista.add(modelo);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar: " + e.getMessage());
        }

        return lista;
    }
       
}