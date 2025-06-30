/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bitnexus;

import static Controller.ConexaoComBancoDados.conectar;
import java.sql.Connection;

/**
 *
 * @author ALUNO
 */
public class BitNexus {

    public static void main(String[] args) {
        Connection conexao = conectar();
        
        if(conexao != null){
            System.out.println(conexao);
        } // fim do if
    }
}
