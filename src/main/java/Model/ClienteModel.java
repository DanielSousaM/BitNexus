package Model;

public class ClienteModel {
    private int idCLIENTES;
    private String nomeCliente;
    private String emailCliente;
    private String cpfCliente;
    private String telefoneCliente;
    private String enderecoCliente;
    private int PLANOS_IdPLANOS;
    private String nomePlano;

    public ClienteModel(int idCLIENTES, int PLANOS_IdPLANOS, String nomeCliente, String emailCliente, String cpfCliente, String telefoneCliente, String enderecoCliente) {
        this.idCLIENTES = idCLIENTES;
        this.PLANOS_IdPLANOS = PLANOS_IdPLANOS;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }
public ClienteModel( int PLANOS_IdPLANOS, String nomeCliente, String emailCliente, String cpfCliente, String telefoneCliente, String enderecoCliente) {
      
        this.PLANOS_IdPLANOS = PLANOS_IdPLANOS;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }

public ClienteModel(){
    
}
    // Getters e Setters

    public int getPLANOS_IdPLANOS() {
        return PLANOS_IdPLANOS;
    }

    public void setPLANOS_IdPLANOS(int PLANOS_IdPLANOS) {
        this.PLANOS_IdPLANOS = PLANOS_IdPLANOS;
    }

    public int getIdCLIENTES() {
        return idCLIENTES;
    }

    public void setIdCLIENTES(int idCLIENTES) {
        this.idCLIENTES = idCLIENTES;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }
    
    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }
}