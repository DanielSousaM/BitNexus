/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author ALUNO
 */
public class MonitoramentoModel {
    private int idMAQUINAS;
    private String nomeMaquina, tipoMaquina;
   
    public MonitoramentoModel(int idMAQUINAS, String nomeMaquina, String tipoMaquina) {
        this.idMAQUINAS = idMAQUINAS;
        this.nomeMaquina = nomeMaquina;
        this.tipoMaquina = tipoMaquina;      
    }

    public MonitoramentoModel(String nomeMaquina, String tipoMaquina){
        this.nomeMaquina = nomeMaquina;
        this.tipoMaquina = tipoMaquina;
    }
    
     public MonitoramentoModel() {
         
     }  
     // método getter e setter
     // getter serve para visualizar dados
     // setter serve para inserir dados

    public int getIdMAQUINAS() {
        return idMAQUINAS;
    }

    public void setIdMAQUINAS(int idMAQUINAS) {
        this.idMAQUINAS = idMAQUINAS;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }
}