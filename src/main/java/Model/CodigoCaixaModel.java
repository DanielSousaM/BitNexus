/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ALUNO
 */
public class CodigoCaixaModel {
    
   private int idCAIXA;
    private String tipoServico;
    private Double valor;
    private String formadepagamento;
    private String dataUso;
    private String tempo;
    private int clientes_idclientes;
    private int planos_idplanos;
    private int maquinas_idmaquinas;
    private int funcionarios_idfuncionarios;
    
    private String nomeCliente;
    private String nomePlano;
    private String nomeMaquina;
    private String nomeFuncionario;

    public CodigoCaixaModel(String nomeCliente, String nomePlano, String nomeMaquina, String nomeFuncionario) {
        this.nomeCliente = nomeCliente;
        this.nomePlano = nomePlano;
        this.nomeMaquina = nomeMaquina;
        this.nomeFuncionario = nomeFuncionario;
    }

    public CodigoCaixaModel(int idCAIXA, String tipoServico, Double valor, String formadepagamento, String dataUso, String tempo, int clientes_idclientes, int planos_idplanos, int maquinas_idmaquinas, int funcionarios_idfuncionarios) {
        this.idCAIXA = idCAIXA;
        this.tipoServico = tipoServico;
        this.valor = valor;
        this.formadepagamento = formadepagamento;
        this.dataUso = dataUso;
        this.tempo = tempo;
        this.clientes_idclientes = clientes_idclientes;
        this.planos_idplanos = planos_idplanos;
        this.maquinas_idmaquinas = maquinas_idmaquinas;
        this.funcionarios_idfuncionarios = funcionarios_idfuncionarios;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public CodigoCaixaModel() {
    }   

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    } 
    
    // metodos getter e setter

    // metodo com retorno do tipo String
    
    // metodo com parametro e sem retorno

    public int getIdCAIXA() {
        return idCAIXA;
    }

    public void setIdCAIXA(int idCAIXA) {
        this.idCAIXA = idCAIXA;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(String formadepagamento) {
        this.formadepagamento = formadepagamento;
    }

    public String getDataUso() {
        return dataUso;
    }

    public void setDataUso(String dataUso) {
        this.dataUso = dataUso;
    }

    public int getClientes_idclientes() {
        return clientes_idclientes;
    }

    public void setClientes_idclientes(int clientes_idclientes) {
        this.clientes_idclientes = clientes_idclientes;
    }

    public int getPlanos_idplanos() {
        return planos_idplanos;
    }

    public void setPlanos_idplanos(int planos_idplanos) {
        this.planos_idplanos = planos_idplanos;
    }

    public int getMaquinas_idmaquinas() {
        return maquinas_idmaquinas;
    }

    public void setMaquinas_idmaquinas(int maquinas_idmaquinas) {
        this.maquinas_idmaquinas = maquinas_idmaquinas;
    }

    public int getFuncionarios_idfuncionarios() {
        return funcionarios_idfuncionarios;
    }

    public void setFuncionarios_idfuncionarios(int funcionarios_idfuncionarios) {
        this.funcionarios_idfuncionarios = funcionarios_idfuncionarios;
    }
}