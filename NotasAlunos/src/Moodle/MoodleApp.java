/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moodle;
import Suap.Funcoes;
import java.sql.PreparedStatement;
import Suap.Instituicao;
import Suap.abstractClass.Alunos;
import Suap.abstractClass.Professores;
import java.util.Scanner;
import Suap.abstractClass.Matricula;
import java.sql.Date;
import java.text.SimpleDateFormat;







/**
 *
 * @author felipe
 * @since 18-04 at 10:49 am
 */
public class MoodleApp {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();
        String resposta, opc, opc1;
        int tabela;
        boolean existe;
        int idUsu = 0;
        Alunos aluno = new Alunos();
        Instituicao inst = new Instituicao();
        
        funcao.menuPrincipal();
        try {
            System.out.println("Deseja escolher qual opçao? ");
            int escolha = scan.nextInt();
            scan.nextLine();
            
            while(escolha <= 6){
                switch(escolha){
                    case 1:
                        System.out.println("Deseja inserir em alguma tabela? ");
                        opc = scan.nextLine().toLowerCase().trim();
                        while (opc.equals("sim") || opc.equals("s")) {
                            funcao.menuTabelas();
                            System.out.println("informa a tabela: ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1:

                                    Matricula mat = new Matricula();
    System.out.println("Deseja prosseguir na inserção de matrícula?");
    resposta = scan.nextLine().toLowerCase().trim();
    while (resposta.equals("sim") || resposta.equals("s")) {
        System.out.println("======================================");
     System.out.println("           PÁGINA DE MATRÍCULA        ");
        System.out.println("======================================");
        
        System.out.println("Informe o ID do aluno: ");
        mat.setAlunoId(scan.nextInt());
        scan.nextLine();
        System.out.println("Informe o ID do curso: ");
        mat.setCursoId(scan.nextInt());
        scan.nextLine();
        System.out.println("Informe o ID da instituição: ");
        mat.setInstituicaoId(scan.nextInt());
        scan.nextLine();
        System.out.println("Informe a data da matrícula (formato: YYYY-MM-DD): "); // YEAR - MONTH - DAY
String dataInput = scan.nextLine();

// Validação opcional
try {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    sdf.parse(dataInput); // Se for inválida, lança exceção
    mat.setDataMatricula(dataInput);
} catch (Exception e) {
    System.out.println("Data inválida! Use o formato YYYY-MM-DD."); 
    return; // ou repita a leitura
}

        mat.inserir();
      System.out.println("\n Matrícula realizada com sucesso!");
System.out.println(" Bem-vindo(a), aluno(a) de ID: " + mat.getAlunoId() + "!");
System.out.println("️ Data da matrícula: " + mat.getDataMatricula());
System.out.println(" Instituição ID: " + mat.getInstituicaoId());
System.out.println(" Curso ID: " + mat.getCursoId());
System.out.println("=======================================\n");

        System.out.println("Deseja cadastrar uma nova matrícula?");
        resposta = scan.nextLine().toLowerCase().trim();
                                    break;
                                case 2:
                                    System.out.println("Para criar aluno, é necessario que tenha cadastrado usuario. Deseja prosseguir? ");
                                    resposta = scan.nextLine().toLowerCase().trim();   
                                    while(resposta.equals("sim")|| resposta.equals("s")){
                                        Alunos aluno = new Alunos();
                                        System.out.println("Digite o ID do usuario: ");
                                        aluno.setId(scan.nextInt());                                     
                                        aluno.verificarUsuarios(aluno.getId());
                                        existe = aluno.verificarUsuarios(aluno.getId());
                                        if(existe == true){
                                            System.out.println("O aluno esta matriculado? [true/false] ");
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

                                    System.out.println("Deseja inserir valores na tabela usuarios? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while(resposta.equals("sim")||resposta.equals("s")){
                                        System.out.println("Digite 1 para usuario Aluno e 2 para Usuario professor: ");
                                        int usuEscolha = scan.nextInt();
                                        switch(usuEscolha){
                                            case 1:
                                                System.out.println("======================================");
                                                System.out.println("         SEJA BEM VINDO, Aluno        ");
                                                System.out.println("======================================");
                                                System.out.println("Informe seu nome: ");
                                                aluno.setNome(scan.nextLine());
                                                System.out.println("Informe seu sexo [M ou F] ");
                                                aluno.setSexo(scan.nextLine());
                                                System.out.println("Informe seu endereco: ");
                                                aluno.setEndereco(scan.nextLine());
                                                System.out.println("Informe CPF: ");
                                                aluno.setCpf(scan.nextLine());
                                                System.out.println("Informe sua data de nascimento: ");
                                                aluno.setDataNascimento(scan.nextLine());
                                                System.out.println("Esta matriculado? ");
                                                String matriculado = scan.nextLine().toLowerCase().trim();
                                                if (matriculado.equals("sim") || matriculado.equals("s")){
                                                    aluno.setAlunos_matriculados(true);
                                                    
                                                }else if(matriculado.equals("nao")||matriculado.equals("n")){
                                                    aluno.setAlunos_matriculados(false);
                                                    
                                                } else{
                                                    System.out.println("Resposta invalida");
                                                }
                                                if(aluno.isAlunos_matriculados() == true){
                                                    System.out.println("Informe sua sala: ");
                                                    aluno.setAlunos_sala(scan.nextLine());
                                                    System.out.println("Informe sua turma: ");
                                                    aluno.setAlunos_turma(scan.nextLine());
                                                    System.out.println("Informe a quantidade de disciplinas que possui: ");
                                                    aluno.setQtd_disciplina(scan.nextInt());
                                                    idUsu += 1;
                                                    aluno.setId(idUsu);
                                                    aluno.inserir();
                                                    
                                                }else {
                                                    aluno.setAlunos_sala(null);
                                                    aluno.setAlunos_turma(null);
                                                    aluno.setQtd_disciplina(0);
                                                    idUsu += 1;
                                                    aluno.setId(idUsu);
                                                    aluno.inserir();
                                                }
                                                
                                               
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                break;

                                        }
                                        
                                        System.out.println("Deseja cadastrar outro usuario? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    break;
                                case 2:
                                    
                                    break;
                                case 3:
                                    break;
                                case 4:
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
                                        scan.nextLine();
                                        
                                        
                                        System.out.println("Deseja cadastrar uma nova instituicao? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Nao existe esse campo!");
                                    break;
                                
                            }
                            System.out.println("Deseja inserir outro valor? ");
                            opc = scan.nextLine().toLowerCase().trim();
                        }
                        
                    case 2:
                        System.out.println("Deseja fazer atualizaçao de algum dado? ");
                        opc = scan.nextLine().toLowerCase().trim();
                        while(opc.equals("sim")||(opc.equals("s"))){
                            funcao.menuTabelas();
                            System.out.println("Deseja atualizar qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch(tabela){
                                case 1:
                                    
                                    break;
                                case 2:
                                    System.out.println("Deseja fazer a atualizacao dessa tabela? ");
                                    opc1 = scan.nextLine();
                                    while(opc1.equals("sim") || opc.equals("s")){
                                        aluno.listar(0);
                                        System.out.println("Informe o ID do usuario que deseja fazer alteração: ");
                                        aluno.setId(scan.nextInt());
                                        existe = aluno.verificarAlunos(aluno.getId());
                                        if (existe == true) {
                                            System.out.println("=========================");
                                            System.out.println("Matricula   ");
                                            System.out.println("Sala        ");
                                            System.out.println("Turma       ");
                                            System.out.println("Materias    ");
                                            System.out.println("tudo         ");
                                            System.out.println("=========================");
                                            System.out.println("Deseja alterar qual campo de ALUNO? ");
                                            resposta = scan.nextLine().toLowerCase().trim();
                                            if(resposta.equals("matricula")){
                                                System.out.println("Esse aluno esta matriculado? [true/false]");
                                                aluno.setAlunos_matriculados(scan.nextBoolean());
                                                aluno.alterar(aluno.getId(), resposta);
                                                
                                            } else if(resposta.equals("sala")){
                                                System.out.println("Informe a sala do aluno: ");
                                                aluno.setAlunos_sala(scan.nextLine());
                                                aluno.alterar(aluno.getId(), resposta);
                                                
                                            } else if(resposta.equals("turma")){
                                                System.out.println("Informe a turma do aluno: ");
                                                aluno.setAlunos_turma(scan.nextLine());
                                                aluno.alterar(aluno.getId(), resposta);
                                                
                                            } else if (resposta.equals("materias")){
                                                System.out.println("Informe a quantidade de disciplinas: ");
                                                aluno.setQtd_disciplina(scan.nextInt());
                                                aluno.alterar(aluno.getId(), resposta);
                                                
                                            } else if (resposta.equals("tudo")){
                                                System.out.println("Esse aluno esta matriculado? [true/false]");
                                                aluno.setAlunos_matriculados(scan.nextBoolean());
                                                System.out.println("Informe a sala do aluno: ");
                                                aluno.setAlunos_sala(scan.nextLine());
                                                System.out.println("Informe a turma do aluno: ");
                                                aluno.setAlunos_turma(scan.nextLine());
                                                System.out.println("Informe a quantidade de disciplinas: ");
                                                aluno.setQtd_disciplina(scan.nextInt());
                                                aluno.alterar(aluno.getId(), resposta);
                                                
                                            } else{
                                                System.out.println("Nao existe esse campo!");
                                            }

                                        } else {
                                            System.out.println("Nao existe aluno com esse ID!");
                                        }
                                        System.out.println("Deseja Atualizar novamente?  ");
                                        opc1 = scan.nextLine().toLowerCase().trim();
                                    }
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                                    break;
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                            }
                            
                        }
                        break;
                        
                    case 3:
                        System.out.println("Deseja remover valores de alguma tabela? ");
                        resposta = scan.nextLine();
                        while(resposta.equals("sim")||resposta.equals("s")){
                            funcao.menuTabelas();
                            System.out.println("Deseja escolher qual tabela? ");
                            tabela = scan.nextInt();
                            switch(tabela){
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Deseja fazer a remoçao de alguma campo? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    while(opc.equals("sim")||opc.equals("s")){
                                        aluno.listar(0);
                                        System.out.println("Informe o ID do usuario que deseja remover: ");
                                        int idDelete = scan.nextInt();
                                        scan.nextLine();
                                        existe = aluno.verificarAlunos(idDelete);
                                        if (existe == true) {
                                            aluno.deletar(idDelete);

                                        } else {
                                            System.out.println("Esse ID nao existe em aluno! ");
                                        }
                                        System.out.println("Deseja fazer outra remocao? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                    }
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    System.out.println("Deseja fazer a remoçao de alguma campo? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    while (opc.equals("sim") || opc.equals("s")) {
                                        inst.listar(0);
                                        System.out.println("Informe o ID da instituicao que deseja remover: ");
                                        int idDelete = scan.nextInt();
                                        scan.nextLine();
                                        existe = inst.verificarInstituicao(idDelete);
                                        if (existe == true) {
                                            inst.deletar(idDelete);

                                        } else {
                                            System.out.println("Esse ID nao existe em instituicao! ");
                                        }
                                        System.out.println("Deseja fazer outra remocao? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                    }
                                    
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                                    break;
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                                    
                            }
                            
                        }
                        break;
                    case 4:
                        
                        System.out.println("Deseja listar alguma tabela? ");
                        resposta = scan.nextLine().toLowerCase().trim();
                        while(resposta.equals("sim")||resposta.equals("s")){
                            funcao.menuTabelas();
                            System.out.println("Deseja escolher qual tabela? ");
                            tabela = scan.nextInt();
                            switch(tabela){
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Deseja listar todos os alunos? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if(opc.equals("sim")||opc.equals("s")){
                                        aluno.listar(0);
                                    } else{
                                        System.out.println("Informe o ID de aluno que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        if(idlistar == 0){
                                            aluno.listar(0);
                                        } else {
                                            existe = aluno.verificarAlunos(idlistar);
                                            if(existe == true){
                                                aluno.listar(idlistar);
                                                
                                            } else {
                                                System.out.println("Nao existe usuario com esse ID!");
                                            }
                                        }
                                    }
                                    
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    System.out.println("Deseja listar todas as instituicoes? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if(opc.equals("sim")||opc.equals("s")){
                                        inst.listar(0);
                                    } else{
                                        System.out.println("Informe o ID da instituicao que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        if(idlistar == 0){
                                            inst.listar(0);
                                        } else {
                                            existe = aluno.verificarAlunos(idlistar);
                                            if(existe == true){
                                                inst.listar(idlistar);
                                                
                                            } else {
                                                System.out.println("Nao existe instituicao com esse ID!");
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                                    break;
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;

                                
                            }
                            System.out.println("Deseja listar alguma outra tabela? ");
                            resposta = scan.nextLine().toLowerCase().trim();
                        }
                        
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opçao errada!");
                        break;
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados! ");
        }
        
        
        
        
    }


    
}
