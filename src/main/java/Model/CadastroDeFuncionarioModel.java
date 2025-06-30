/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ALUNO
 */
public class CadastroDeFuncionarioModel {
   //cadeia -> string
   //interio-> int
   // real -> doublo ou float
   // logico -> boolean
   // datas -> Date
   
    private int idFUNCIONARIOS;
    private String nomeFuncionario;
    private String datanascimentoFuncionario;
    private String telefoneFuncionario;
    private String cpfFuncionario;
    private String emailFuncionario;
    private String senhaFuncionario;


     public CadastroDeFuncionarioModel(int  idFUNCIONARIOS, String nomeFuncionario, String datanascimentoFuncionario, String telefoneFuncionario, String cpfFuncionario, String emailFuncionario, String senhaFuncionario) {
        this.idFUNCIONARIOS = idFUNCIONARIOS;
        this.nomeFuncionario = nomeFuncionario;
        this.datanascimentoFuncionario = datanascimentoFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
     
    }
 
    public CadastroDeFuncionarioModel() {
    }
       // metados getter e setter

       //gertter serve para visualizar os dados

     public int getIdFUNCIONARIOS() {
        return idFUNCIONARIOS;
    }

    public void setIdFUNCIONARIOS(int idFUNCIONARIOS) {
        this.idFUNCIONARIOS = idFUNCIONARIOS;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDatanascimentoFuncionario() {
        return datanascimentoFuncionario;
    }

    public void setDatanascimentoFuncionario(String datanascimentoFuncionario) {
        this.datanascimentoFuncionario = datanascimentoFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    } 
} 