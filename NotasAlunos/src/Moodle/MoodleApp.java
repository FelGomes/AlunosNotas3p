/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moodle;
import Suap.Funcoes;
import Suap.Instituicao;
import Suap.abstractClass.Alunos;
import java.util.Scanner;

/**
 *
 * @author felipe
 * @since 18-04 at 10:49 am
 */
public class MoodleApp {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();
        String resposta;
        
        funcao.menuPrincipal();
        try {
            System.out.println("Deseja escolher qual opçao? ");
            int escolha = scan.nextInt();
            funcao.limparTela();
            
            while(escolha <= 6){
                switch(escolha){
                    case 1:
                        funcao.menuTabelas();
                        System.out.println("Deseja inserir valor em qual tabela? ");
                        int tabela = scan.nextInt();
                        scan.nextLine();
                        while (tabela <= 10){
                            switch(tabela){
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Para criar aluno, é necessario que tenha cadastrado usuario. Deseja prosseguir? ");
                                    resposta = scan.nextLine().toLowerCase().trim();   
                                    while(resposta.equals("sim")|| resposta.equals("s")){
                                        Alunos aluno = new Alunos();
                                        System.out.println("Digite o ID do usuario: ");
                                        aluno.setId(scan.nextInt());                                     
                                        aluno.verificarAlunos(aluno.getId());
                                        boolean existe = aluno.verificarAlunos(aluno.getId());
                                        if(existe == true){
                                            System.out.println("O aluno esta matriculado [true/false] ");
                                            aluno.setAlunos_matriculados(scan.nextBoolean());
                                            System.out.println("Informe a sala do aluno: ");
                                            aluno.setAlunos_sala(scan.nextLine());
                                            System.out.println("Informe a turma do aluno: ");
                                            aluno.setAlunos_turma(scan.nextLine());
                                            System.out.println("Informe as disciplinas do aluno: ");
                                            aluno.setQtd_disciplina(scan.nextInt());
                                            scan.nextLine();
                                            aluno.inserir();
                                            
                                            
                                        }else {
                                            System.out.println("Nao existe esse usuario! ");
                                        }
                                        
                                        System.out.println("Deseja cadastrar outro aluno? ");
                                        resposta = scan.nextLine().toLowerCase().trim(); 
                                    } 
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    Instituicao inst = new Instituicao();
                                    System.out.println("Deseja prosseguir na inserção de valores de Instituicao? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while(resposta.equals("sim")||resposta.equals('s')){
                                        System.out.println("Informe o nome: ");
                                        inst.setInst_nome(scan.nextLine());
                                        System.out.println("Informe o endereco: ");
                                        inst.setInst_endereco(scan.nextLine());
                                        System.out.println("Informe a cidade: ");
                                        inst.setInst_cidade(scan.nextLine());
                                        System.out.println("Informe o UF: ");
                                        inst.setInst_uf(scan.nextLine().toUpperCase());
                                        System.out.println("Informe a escolaridade: ");
                                        inst.setInst_escolaridade(scan.nextLine());
                                        System.out.println("Informe o nivel da escola: ");
                                        inst.setInst_nivel(scan.nextFloat());
                                        inst.inserir();
                                        
                                        
                                        System.out.println("Deseja cadastrar uma nova instituicao? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    
                                    break;
                                case 5:
                                    break;
                                
                            }
                        }
                        break;
                    
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados! ");
        }
        
        
        
        
    }


    
}
