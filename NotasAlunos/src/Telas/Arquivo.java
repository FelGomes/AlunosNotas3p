/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

/**
 *
 * @author felipe
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Arquivo {
    

	public static void gerarArquivoTabela
	 (String caminho, ArrayList<EUsuario> listaUsuario) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
		
		String linha = "";
		
		for (EUsuario usuario : listaUsuario) {
			buffWrite.append(linha + usuario.getNome() + " | " + usuario.getSexo() + " | " + usuario.getCpf() + " | " + usuario.getEndereco() + " | " + usuario.getDataNasc() + " \n"); 

		}

		buffWrite.close();
	}

}
    