/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap;

/**
 *
 * @author felipe 
 * @since 18-04 at 10:57
 */

//Classe criada apenas para fazer funçoes adicionais, tanto para limpar a tela, quanto para criar um menu
public class Funcoes {
    
    public void limparTela() {
        try {
            String comando;
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                comando = "cls";
            } else {
                comando = "clear";
            }
            Runtime.getRuntime().exec(comando).waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void menuPrincipal(){
        System.out.println("==================================");
        System.out.println("             BEM VINDO"            );
        System.out.println("==================================");
        System.out.println("1) INSERIR VALORES    ");
        System.out.println("2) ATUALIZAR VALORES  ");
        System.out.println("3) DELETAR VALORES    ");
        System.out.println("4) LISTAR VALORES     ");
        System.out.println("5) SAIR               ");
        System.out.println("==================================");
        
    }
    
    public void menuTabelas(){
        System.out.println("==================================");
        System.out.println("1) USUARIOS    ");
        System.out.println("2) ALUNOS      ");
        System.out.println("3) PROFESSOR   ");
        System.out.println("4) INSTITUICAO ");
        System.out.println("5) MATRICULA   ");
        System.out.println("6) BOLETIM     ");
        System.out.println("7) NOTAS       ");
        System.out.println("8) FREQUENCIA  ");
        System.out.println("9) DIARIO      ");
        System.out.println("==================================");

    
    }
    
    
    
    public void menuTabelasInserir(){
        System.out.println("==================================");
        System.out.println("1) USUARIOS    ");
        System.out.println("2) Alunos ");
        System.out.println("3) Professor   ");
        System.out.println("4) Instituicao    ");
        System.out.println("5) Matricula     ");
        System.out.println("6) Notas  ");
        System.out.println("7) frequencia      ");
        System.out.println("8) Diario");
        System.out.println("==================================");
    }
}
