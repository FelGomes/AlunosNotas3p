/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moodle;

import Suap.Funcoes;
import Suap.Instituicao;
import Suap.abstractClass.Alunos;
import Suap.abstractClass.Diario;

import Suap.abstractClass.Frequencias;
import Suap.abstractClass.Matricula;
import Suap.abstractClass.Professores;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author felipe
 * @since 18-04 at 10:49 am
 */
public class MoodleApp {

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();
        String resposta, opc, opc1;
        int tabela;
        boolean existe;
        int idUsu = 0;
        int escolha = 0;
        Alunos aluno = new Alunos();
        Instituicao inst = new Instituicao();
        Frequencias frequencias = new Frequencias();

        funcao.menuPrincipal();
        try {
            System.out.println("Deseja escolher qual opçao? ");
            escolha = scan.nextInt();
            scan.nextLine();


            while (escolha <= 6) {
                switch (escolha) {
                    case 1:
                        System.out.println("Deseja inserir valores em alguma tabela? ");
                        opc = scan.nextLine().toLowerCase().trim();
                        while (opc.equals("sim") || opc.equals("s")) {
                            funcao.menuTabelasInserir();
                            System.out.println("informa a tabela: ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1:
                                    System.out.println("Deseja inserir valores na tabela usuarios? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals("s")) {
                                        System.out.println("Digite 1 para usuario Aluno e 2 para Usuario professor: ");
                                        int usuEscolha = scan.nextInt();
                                        scan.nextLine();
                                        switch (usuEscolha) {
                                            case 1:
                                                try {
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
                                                    if (matriculado.equals("sim") || matriculado.equals("s")) {
                                                        aluno.setAlunos_matriculados(true);

                                                    } else if (matriculado.equals("nao") || matriculado.equals("n")) {
                                                        aluno.setAlunos_matriculados(false);

                                                    } else {
                                                        System.out.println("Resposta invalida");
                                                    }
                                                    if (aluno.isAlunos_matriculados() == true) {
                                                        System.out.println("Informe sua sala: ");
                                                        aluno.setAlunos_sala(scan.nextLine());
                                                        System.out.println("Informe sua turma: ");
                                                        aluno.setAlunos_turma(scan.nextLine());
                                                        System.out.println("Informe a quantidade de disciplinas que possui: ");
                                                        aluno.setQtd_disciplina(scan.nextInt());
                                                        scan.nextLine();
                                                        idUsu += 1;
                                                        aluno.setId(idUsu);
                                                        aluno.inserir();

                                                    } else {
                                                        aluno.setAlunos_sala(null);
                                                        aluno.setAlunos_turma(null);
                                                        aluno.setQtd_disciplina(0);
                                                        idUsu += 1;
                                                        aluno.setId(idUsu);
                                                        aluno.inserir();
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Erros na entrada de dados");
                                                }

                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Valor errado!");
                                                break;
                                        }

                                        System.out.println("Deseja cadastrar outro usuario? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                case 2:
                                    System.out.println("Deseja prosseguir na inserção de valores de Instituicao? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals('s')) {
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
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    Matricula mat = new Matricula();
                                    System.out.println("Deseja prosseguir na insercao de matrícula?");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals("s")) {
                                        System.out.println("======================================");
                                        System.out.println("           INSERCAO DE MATRICULA        ");
                                        System.out.println("======================================");

                                        System.out.println("Informe o ID do aluno: ");
                                        mat.setAlunoId(scan.nextInt());
                                        scan.nextLine();
                                        System.out.println("Informe o ID do curso: ");
                                        mat.setCursoId(scan.nextInt());
                                        scan.nextLine();
                                        System.out.println("Informe o ID da instituiçao: ");
                                        mat.setInstituicaoId(scan.nextInt());
                                        scan.nextLine();
                                        System.out.println("Informe a data da matrícula (formato: YYYY-MM-DD): "); // YEAR - MONTH - DAY
                                        String dataInput = scan.nextLine();
                                        try {
                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                            sdf.setLenient(false);
                                            sdf.parse(dataInput); // Se for inválida, lança exceção
                                            mat.setDataMatricula(dataInput);
                                        } catch (Exception e) {
                                            System.out.println("Data invalida! Use o formato YYYY-MM-DD.");
                                            return; // ou repita a leitura
                                        }

                                        mat.inserir();
                                        System.out.println("\n Matricula realizada com sucesso!");
                                        System.out.println(" Bem-vindo(a), aluno(a) de ID: " + mat.getAlunoId() + "!");
                                        System.out.println("️ Data da matricula: " + mat.getDataMatricula());
                                        System.out.println(" Instituiçao ID: " + mat.getInstituicaoId());
                                        System.out.println(" Curso ID: " + mat.getCursoId());
                                        System.out.println("=======================================\n");

                                        System.out.println("Deseja cadastrar uma nova matricula?");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    break;
                                case 6:
                                    break;
                                    
                                case 7:
                    Diario diario = new Diario();
            System.out.println("======================================");
            System.out.println("           INSERCAO DE DIARIO       ");
            System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
                while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID do diário:");
                diario.setDiariosId(scan.nextInt());
                scan.nextLine(); // limpar buffer

                System.out.println("Informe o local do diário:");
                diario.setDiariosLocal(scan.nextLine());

                System.out.println("Informe a disciplina do diário:");
                diario.setDiariosDisciplinas(scan.nextLine());

                System.out.println("Informe a quantidade de alunos:");
                diario.setQtdAlunos(scan.nextInt());

                System.out.println("Informe o ID do professor:");
                diario.setFkDiariosProfessores(scan.nextInt());

                System.out.println("Informe o ID do aluno:");
                diario.setFkDiariosAlunos(scan.nextInt());
                scan.nextLine(); // limpar buffer

                diario.inserir();

                System.out.println("Deseja cadastrar um novo diário?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
            break;
                                    
                                default:

                                    System.out.println("Nao existe esse campo!");
                                    break;

                            }
                            System.out.println("Deseja inserir outro valor? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                            }
                            break;

                        
                    case 2:
                        System.out.println("Deseja fazer atualizaçao de algum dado? ");
                        opc = scan.nextLine().toLowerCase().trim();
                        while (opc.equals("sim") || (opc.equals("s"))) {
                            funcao.menuTabelas();
                            System.out.println("Deseja atualizar qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Deseja fazer a atualizacao da tabela aluno? ");
                                    opc1 = scan.nextLine();
                                    while (opc1.equals("sim") || opc.equals("s")) {
                                        aluno.listar(0);
                                        System.out.println("Informe o ID do usuario que deseja fazer alteração: ");
                                        aluno.setId(scan.nextInt());
                                        scan.nextLine();
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
                                            if (resposta.equals("matricula")) {
                                                System.out.println("Esse aluno esta matriculado? [true/false]");
                                                aluno.setAlunos_matriculados(scan.nextBoolean());
                                                aluno.alterar(aluno.getId(), resposta);

                                            } else if (resposta.equals("sala")) {
                                                System.out.println("Informe a sala do aluno: ");
                                                aluno.setAlunos_sala(scan.nextLine());
                                                aluno.alterar(aluno.getId(), resposta);

                                            } else if (resposta.equals("turma")) {
                                                System.out.println("Informe a turma do aluno: ");
                                                aluno.setAlunos_turma(scan.nextLine());
                                                aluno.alterar(aluno.getId(), resposta);

                                            } else if (resposta.equals("materias")) {
                                                System.out.println("Informe a quantidade de disciplinas: ");
                                                aluno.setQtd_disciplina(scan.nextInt());
                                                aluno.alterar(aluno.getId(), resposta);

                                            } else if (resposta.equals("tudo")) {
                                                System.out.println("Esse aluno esta matriculado? [true/false]");
                                                aluno.setAlunos_matriculados(scan.nextBoolean());
                                                System.out.println("Informe a sala do aluno: ");
                                                aluno.setAlunos_sala(scan.nextLine());
                                                System.out.println("Informe a turma do aluno: ");
                                                aluno.setAlunos_turma(scan.nextLine());
                                                System.out.println("Informe a quantidade de disciplinas: ");
                                                aluno.setQtd_disciplina(scan.nextInt());
                                                aluno.alterar(aluno.getId(), resposta);

                                            } else {
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
                                    System.out.println("Deseja fazer alteracao na tabela Instituicao? ");
                                    opc1 = scan.nextLine().toLowerCase().trim();
                                    while(opc1.equals("sim")||opc1.equals("s")){
                                        inst.listar(0);
                                        System.out.println("Informe o ID desejado: ");
                                        int idInst = scan.nextInt();
                                        scan.nextLine();
                                        existe = inst.verificarInstituicao(idInst);
                                        if(existe == true){
                                            System.out.println("=========================");
                                            System.out.println("Nome                     ");
                                            System.out.println("Cidade                   ");
                                            System.out.println("Endereco                 ");
                                            System.out.println("UF                       ");
                                            System.out.println("Escolaridade             ");
                                            System.out.println("Nivel                    ");
                                            System.out.println("Tudo                     ");
                                            System.out.println("=========================");
                                            System.out.println("Escolha o campo: ");
                                            resposta = scan.nextLine().toLowerCase().trim();
                                            if(resposta.equals("nome")){
                                                System.out.println("Informe o nome da Instituicao: ");
                                                inst.setInst_nome(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if(resposta.equals("cidade")){
                                                System.out.println("Informe a cidade da Instituicao: ");
                                                inst.setInst_cidade(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if (resposta.equals("endereco")){
                                                System.out.println("Informe o endereco da instituicao: ");
                                                inst.setInst_endereco(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if(resposta.equals("uf")){
                                                System.out.println("Informe o UF da instituicao: ");
                                                inst.setInst_uf(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if (resposta.equals("escolaridade")){
                                                System.out.println("Informe a escolaridade da instituicao: ");
                                                inst.setInst_escolaridade(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if (resposta.equals("nivel")){
                                                System.out.println("Informe o nivel da instituicao: ");
                                                inst.setInst_nivel(scan.nextFloat());
                                                inst.alterar(idInst, resposta);
                                                
                                            } else if(resposta.equals("tudo")){
                                                System.out.println("Informe o nome da Instituicao: ");
                                                inst.setInst_nome(scan.nextLine());
                                                System.out.println("Informe o endereco da instituicao: ");
                                                inst.setInst_endereco(scan.nextLine());
                                                System.out.println("Informe o UF da instituicao: ");
                                                inst.setInst_uf(scan.nextLine());
                                                System.out.println("Informe a escolaridade da instituicao: ");
                                                inst.setInst_escolaridade(scan.nextLine());
                                                System.out.println("Informe a escolaridade da instituicao: ");
                                                inst.setInst_escolaridade(scan.nextLine());
                                                inst.alterar(idInst, resposta);
                                                
                                            }else {
                                                System.out.println("Nao existe esse campo!");
                                            }
                                            
                                        } else{
                                            System.out.println("ID errado!");
                                        }
                                         System.out.println("Deseja alterar outro campo de Instituicao? ");
                                        opc1 = scan.nextLine().toLowerCase().trim();
                                    }
                                    break;
                                case 5:
                         Matricula mat = new Matricula();
                              System.out.println("======================================");
                              System.out.println("           ATUALIZAR MATRICULA       ");
                              System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID da matricula que deseja atualizar:");
                int id = scan.nextInt();
                scan.nextLine(); 

                if (mat.verificarMatricula(id)) {
                    mat.setId(id);

                    System.out.println("Informe a nova data da matricula:");
                    mat.setDataMatricula(scan.nextLine());

                    System.out.println("Informe o novo ID do aluno:");
                    mat.setAlunoId(scan.nextInt());

                    System.out.println("Informe o novo ID da instituicao:");
                    mat.setInstituicaoId(scan.nextInt());

                    System.out.println("Informe o novo ID do curso:");
                    mat.setCursoId(scan.nextInt());
                    scan.nextLine(); 
                    mat.alterar(id);
                } else {
                    System.out.println("Matricula nao encontrada.");
                }

                System.out.println("Deseja atualizar outra matricula?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
            break;
                                    
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                            Diario diario = new Diario();
                         System.out.println("======================================");
                         System.out.println("           ATUALIZAR DIARIO       ");
                         System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID do diário que deseja atualizar:");
                int id = scan.nextInt();
                scan.nextLine(); 

                if (diario.verificarDiario(id)) {
                    diario.setDiariosId(id);

                    System.out.println("Informe o novo local:");
                    diario.setDiariosLocal(scan.nextLine());

                    System.out.println("Informe as novas disciplinas:");
                    diario.setDiariosDisciplinas(scan.nextLine());

                    System.out.println("Informe a nova quantidade de alunos:");
                    diario.setQtdAlunos(scan.nextInt());

                    System.out.println("Informe o novo ID do professor:");
                    diario.setFkDiariosProfessores(scan.nextInt());

                    System.out.println("Informe o novo ID do aluno:");
                    diario.setFkDiariosAlunos(scan.nextInt());
                    scan.nextLine(); 

                    diario.alterar(id);
                } else {
                    System.out.println("Diário não encontrado.");
                }

                System.out.println("Deseja atualizar outro diário?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
            break;
                                    
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                            }
                            
                            System.out.println("Deseja fazer atualizaçao de outra tabela? ");
                            opc = scan.nextLine().toLowerCase().trim();

                        }
                        break;
                    case 3:
                        System.out.println("Deseja remover valores de alguma tabela? ");
                        resposta = scan.nextLine();
                        while (resposta.equals("sim") || resposta.equals("s")) {
                            funcao.menuTabelas();
                            System.out.println("Deseja escolher qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Deseja fazer a remoçao de alguma campo? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    while (opc.equals("sim") || opc.equals("s")) {
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
                                    System.out.println("Deseja fazer a remocao de alguma campo? ");
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
                                Matricula mat = new Matricula();
                              System.out.println("======================================");
                              System.out.println("           DELETAR MATRICULA       ");
                              System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID da matrícula que deseja deletar:");
                int id = scan.nextInt();
                scan.nextLine(); 

                if (mat.verificarMatricula(id)) {
                    mat.deletar(id);
                } else {
                    System.out.println("Matricula não encontrada.");
                }

                System.out.println("Deseja deletar outra matricula?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
            break;
                                    
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                                Diario diario = new Diario();
                            System.out.println("======================================");
                            System.out.println("           DELETAR DIARIO       ");
                            System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID do diario que deseja deletar:");
                int id = scan.nextInt();
                scan.nextLine(); 

                if (diario.verificarDiario(id)) {
                    diario.deletar(id);
                } else {
                    System.out.println("Diario nao encontrado.");
                }

                System.out.println("Deseja deletar outro diario?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
                                    break;
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                            }
                            System.out.println("Deseja remover valores de outra tabela? ");
                            opc = scan.nextLine().toLowerCase().trim();
                        }
                        break;
                    case 4:
                        System.out.println("Deseja listar alguma tabela? ");
                        resposta = scan.nextLine().toLowerCase().trim();
                        while (resposta.equals("sim") || resposta.equals("s")) {
                            funcao.menuTabelas();
                            System.out.println("Deseja escolher qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1:
                                    break;
                                case 2:
                                    System.out.println("Deseja listar todos os alunos? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        aluno.listar(0);
                                    } else {
                                        System.out.println("Informe o ID de aluno que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        if (idlistar == 0) {
                                            aluno.listar(0);
                                        } else {
                                            existe = aluno.verificarAlunos(idlistar);
                                            if (existe == true) {
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
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        inst.listar(0);
                                    } else {
                                        System.out.println("Informe o ID da instituicao que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        if (idlistar == 0) {
                                            inst.listar(0);
                                        } else {
                                            existe = aluno.verificarAlunos(idlistar);
                                            if (existe == true) {
                                                inst.listar(idlistar);

                                            } else {
                                                System.out.println("Nao existe instituicao com esse ID!");
                                            }
                                        }
                                    }
                                    break;

                                case 5:
                                 Matricula mat = new Matricula();
                              System.out.println("======================================");
                              System.out.println("          LISTAR MATRICULA       ");
                              System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            if (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID da matrícula:");
                int id = scan.nextInt();
                scan.nextLine(); 
                mat.listar(id);
            } else {
                mat.listar(0); // 0 = lista todas
            }
            break;
                                   
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;

                                    
                                case 9: 
                                Diario diario = new Diario();
                            System.out.println("======================================");
                            System.out.println("           LISTAR DIARIO       ");
                            System.out.println("======================================");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")) {
                System.out.println("Informe o ID do diário que deseja deletar:");
                int id = scan.nextInt();
                scan.nextLine(); 

                if (diario.verificarDiario(id)) {
                    diario.deletar(id);
                } else {
                    System.out.println("Diario nao encontrado.");
                }

                System.out.println("Deseja deletar outro diario?");
                resposta = scan.nextLine().toLowerCase().trim();
            }
            break;
        
               
        }
        while (escolha != 5) {
            switch (escolha) {
                case 1:
                    System.out.println("Deseja inserir valores em alguma tabela? ");
                    opc = scan.nextLine().toLowerCase().trim();
                    while (opc.equals("sim") || opc.equals("s")) {
                        funcao.menuTabelasInserir();
                        System.out.println("informa a tabela: ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                System.out.println("Deseja inserir valores na tabela usuarios? ");
                                resposta = scan.nextLine().toLowerCase().trim();
                                while (resposta.equals("sim") || resposta.equals("s")) {
                                    System.out.println("Digite 1 para usuario Aluno e 2 para Usuario professor: ");
                                    int usuEscolha = scan.nextInt();
                                    scan.nextLine();
                                    switch (usuEscolha) {
                                        case 1:
                                            try {
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
                                                if (matriculado.equals("sim") || matriculado.equals("s")) {
                                                    aluno.setAlunos_matriculados(true);

                                                } else if (matriculado.equals("nao") || matriculado.equals("n")) {
                                                    aluno.setAlunos_matriculados(false);

                                                } else {
                                                    System.out.println("Resposta invalida");
                                                }
                                                if (aluno.isAlunos_matriculados() == true) {
                                                    System.out.println("Informe sua sala: ");
                                                    aluno.setAlunos_sala(scan.nextLine());
                                                    System.out.println("Informe sua turma: ");
                                                    aluno.setAlunos_turma(scan.nextLine());
                                                    System.out.println("Informe a quantidade de disciplinas que possui: ");
                                                    aluno.setQtd_disciplina(scan.nextInt());
                                                    scan.nextLine();
                                                    idUsu += 1;
                                                    aluno.setId(idUsu);
                                                    aluno.inserir();

                                                } else {
                                                    aluno.setAlunos_sala(null);
                                                    aluno.setAlunos_turma(null);
                                                    aluno.setQtd_disciplina(0);
                                                    idUsu += 1;
                                                    aluno.setId(idUsu);
                                                    aluno.inserir();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Erros na entrada de dados");
                                            }

                                            break;
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("Valor errado!");
                                            break;
                                    }

                                    System.out.println("Deseja cadastrar outro usuario? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                }
                            case 2:
                                System.out.println("Deseja prosseguir na inserção de valores de Instituicao? ");
                                resposta = scan.nextLine().toLowerCase().trim();
                                while (resposta.equals("sim") || resposta.equals('s')) {
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
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
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
                                }
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                System.out.println("Deseja inserir algum dado na tabela de frequencias? ");
                                resposta = scan.nextLine().toLowerCase().trim();
                                while (resposta.equals("s") || resposta.equals("sim")) {
                                    System.out.println("Digite o ID do professor: ");
                                    int idProfessorInsert = scan.nextInt();
                                    scan.nextLine();
                                    //método para verificar id professor
                                    //existe = frequencias.verificarIdProfessor(idProfessorInsert);
                                    if (existe == true) {
                                        System.out.println("Digite o id do aluno: ");
                                        int idAlunoInsert = scan.nextInt();
                                        scan.nextLine();
                                        //método para verificar o id de aluno
                                        //existe1 =  frequencias.verificarIdAluno(idAlunoInsert);
                                        if (existe1 == true) {
                                            System.out.println("Digite a quantidade de aulas que a disciplina possui: ");
                                            frequencias.setTotal_aulas(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("Digite o nome da disciplina: ");
                                            frequencias.setFrequencias_disciplinas(scan.nextLine());
                                            scan.nextLine();
                                            System.out.println("Digite a quantidade de aulas de hoje: ");
                                            frequencias.setAulas_ministradas(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("O aluno(a) compareceu a aula? ");
                                            String opcFrequencia = scan.nextLine().toLowerCase().trim();
                                            if (opcFrequencia.equals("sim") || opcFrequencia.equals("s")) {
                                                frequencias.setFrequencias_faltas(0);
                                                frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas());
                                                frequencias.setPrctg_presenca(frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas()));
                                            } else {
                                                frequencias.setFrequencias_faltas(frequencias.getAulas_ministradas());
                                                frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas());
                                                frequencias.setPrctg_presenca(frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas()));
                                            }
                                        }
                                    }
                                }
                                break;
                            case 9:
                                break;
                            default:

                                System.out.println("Nao existe esse campo!");
                                break;

                        }
                        System.out.println("Deseja inserir outro valor? ");
                        opc = scan.nextLine().toLowerCase().trim();
                    }
                    break;

                case 2:
                    System.out.println("Deseja fazer atualizaçao de algum dado? ");
                    opc = scan.nextLine().toLowerCase().trim();
                    while (opc.equals("sim") || (opc.equals("s"))) {
                        funcao.menuTabelas();
                        System.out.println("Deseja atualizar qual tabela? ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                break;
                            case 2:
                                System.out.println("Deseja fazer a atualizacao da tabela aluno? ");
                                opc1 = scan.nextLine();
                                while (opc1.equals("sim") || opc.equals("s")) {
                                    aluno.listar(0);
                                    System.out.println("Informe o ID do usuario que deseja fazer alteração: ");
                                    aluno.setId(scan.nextInt());
                                    scan.nextLine();
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
                                        if (resposta.equals("matricula")) {
                                            System.out.println("Esse aluno esta matriculado? [true/false]");
                                            aluno.setAlunos_matriculados(scan.nextBoolean());
                                            aluno.alterar(aluno.getId(), resposta);

                                        } else if (resposta.equals("sala")) {
                                            System.out.println("Informe a sala do aluno: ");
                                            aluno.setAlunos_sala(scan.nextLine());
                                            aluno.alterar(aluno.getId(), resposta);

                                        } else if (resposta.equals("turma")) {
                                            System.out.println("Informe a turma do aluno: ");
                                            aluno.setAlunos_turma(scan.nextLine());
                                            aluno.alterar(aluno.getId(), resposta);

                                        } else if (resposta.equals("materias")) {
                                            System.out.println("Informe a quantidade de disciplinas: ");
                                            aluno.setQtd_disciplina(scan.nextInt());
                                            aluno.alterar(aluno.getId(), resposta);

                                        } else if (resposta.equals("tudo")) {
                                            System.out.println("Esse aluno esta matriculado? [true/false]");
                                            aluno.setAlunos_matriculados(scan.nextBoolean());
                                            System.out.println("Informe a sala do aluno: ");
                                            aluno.setAlunos_sala(scan.nextLine());
                                            System.out.println("Informe a turma do aluno: ");
                                            aluno.setAlunos_turma(scan.nextLine());
                                            System.out.println("Informe a quantidade de disciplinas: ");
                                            aluno.setQtd_disciplina(scan.nextInt());
                                            aluno.alterar(aluno.getId(), resposta);

                                        } else {
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
                                System.out.println("Deseja fazer alteracao na tabela Instituicao? ");
                                opc1 = scan.nextLine().toLowerCase().trim();
                                while (opc1.equals("sim") || opc1.equals("s")) {
                                    inst.listar(0);
                                    System.out.println("Informe o ID desejado: ");
                                    int idInst = scan.nextInt();
                                    scan.nextLine();
                                    existe = inst.verificarInstituicao(idInst);
                                    if (existe == true) {
                                        System.out.println("=========================");
                                        System.out.println("Nome                     ");
                                        System.out.println("Cidade                   ");
                                        System.out.println("Endereco                 ");
                                        System.out.println("UF                       ");
                                        System.out.println("Escolaridade             ");
                                        System.out.println("Nivel                    ");
                                        System.out.println("Tudo                     ");
                                        System.out.println("=========================");
                                        System.out.println("Escolha o campo: ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                        if (resposta.equals("nome")) {
                                            System.out.println("Informe o nome da Instituicao: ");
                                            inst.setInst_nome(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("cidade")) {
                                            System.out.println("Informe a cidade da Instituicao: ");
                                            inst.setInst_cidade(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("endereco")) {
                                            System.out.println("Informe o endereco da instituicao: ");
                                            inst.setInst_endereco(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("uf")) {
                                            System.out.println("Informe o UF da instituicao: ");
                                            inst.setInst_uf(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("escolaridade")) {
                                            System.out.println("Informe a escolaridade da instituicao: ");
                                            inst.setInst_escolaridade(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("nivel")) {
                                            System.out.println("Informe o nivel da instituicao: ");
                                            inst.setInst_nivel(scan.nextFloat());
                                            inst.alterar(idInst, resposta);

                                        } else if (resposta.equals("tudo")) {
                                            System.out.println("Informe o nome da Instituicao: ");
                                            inst.setInst_nome(scan.nextLine());
                                            System.out.println("Informe o endereco da instituicao: ");
                                            inst.setInst_endereco(scan.nextLine());
                                            System.out.println("Informe o UF da instituicao: ");
                                            inst.setInst_uf(scan.nextLine());
                                            System.out.println("Informe a escolaridade da instituicao: ");
                                            inst.setInst_escolaridade(scan.nextLine());
                                            System.out.println("Informe a escolaridade da instituicao: ");
                                            inst.setInst_escolaridade(scan.nextLine());
                                            inst.alterar(idInst, resposta);

                                        } else {
                                            System.out.println("Nao existe esse campo!");
                                        }

                                    } else {
                                        System.out.println("ID errado!");
                                    }
                                    System.out.println("Deseja alterar outro campo de Instituicao? ");
                                    opc1 = scan.nextLine().toLowerCase().trim();
                                }
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                System.out.println("Deseja atualizar algum dado na tabela de frequencias?");
                                opc1 = scan.nextLine().toLowerCase().trim();
                                while (opc.equals("s") || opc.equals("sim")) {
                                    System.out.println("Digite o id da frequência:");
                                    int idUpdate = scan.nextInt();
                                    scan.nextLine();
                                    existe = frequencias.verificaIdFrequencia(idUpdate);
                                    if (existe == true) {
                                        System.out.println("O aluno(a) faltou a aula?");
                                        String opcUpdate = scan.nextLine().toLowerCase().trim();
                                        if (opcUpdate.equals("s") || opcUpdate.equals("sim")) {
                                            frequencias.setFrequencias_faltas(frequencias.getAulas_ministradas());
                                        } else {
                                            frequencias.setFrequencias_faltas(0);
                                        }
                                        System.out.println("Deseja alterar outro campo de Instituicao? ");
                                        opc1 = scan.nextLine().toLowerCase().trim();
                                    }
                                }
                                break;
                            case 9:
                                break;

                            default:
                                System.out.println("Tabela errada! ");
                                break;
                        }

                        System.out.println("Deseja fazer atualizaçao de outra tabela? ");
                        opc = scan.nextLine().toLowerCase().trim();

                    }
                    break;

                case 3:
                    System.out.println("Deseja remover valores de alguma tabela? ");
                    resposta = scan.nextLine();
                    while (resposta.equals("sim") || resposta.equals("s")) {
                        funcao.menuTabelas();
                        System.out.println("Deseja escolher qual tabela? ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                break;
                            case 2:
                                System.out.println("Deseja fazer a remoçao de alguma campo? ");
                                opc = scan.nextLine().toLowerCase().trim();
                                while (opc.equals("sim") || opc.equals("s")) {
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
                                System.out.println("Deseja fazer a remocao de algum campo? ");
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
                                try {
                                    System.out.println("Deseja fazer a remocao de algum campo");
                                    opc = scan.nextLine().toLowerCase().toLowerCase().trim();
                                    while (opc.equals("s") || opc.equals("sim")) {
                                        frequencias.listarFrequencias(0);
                                        System.out.println("Informe o ID de frequencia:");
                                        int idDelete = scan.nextInt();
                                        scan.nextLine();
                                        existe = frequencias.verificaIdFrequencia(idDelete);
                                        if (existe == true) {
                                            frequencias.deletarFrequencia(idDelete);
                                        } else {
                                            System.out.println("ID de frequencia nao encontrado:");
                                        }
                                        System.out.println("Deseja fazer outra remocao? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro na remocao dos dados " + e.getMessage());
                                }
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Tabela errada! ");
                                break;
                        }
                        System.out.println("Deseja remover valores de outra tabela? ");
                        opc = scan.nextLine().toLowerCase().trim();
                    }
                    break;
                case 4:
                    System.out.println("Deseja listar alguma tabela? ");
                    resposta = scan.nextLine().toLowerCase().trim();
                    while (resposta.equals("sim") || resposta.equals("s")) {
                        funcao.menuTabelas();
                        System.out.println("Deseja escolher qual tabela? ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                break;
                            case 2:
                                System.out.println("Deseja listar todos os alunos? ");
                                opc = scan.nextLine().toLowerCase().trim();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    aluno.listar(0);
                                } else {
                                    System.out.println("Informe o ID de aluno que deseja listar: ");
                                    int idlistar = scan.nextInt();
                                    if (idlistar == 0) {
                                        aluno.listar(0);
                                    } else {
                                        existe = aluno.verificarAlunos(idlistar);
                                        if (existe == true) {
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
                                if (opc.equals("sim") || opc.equals("s")) {
                                    inst.listar(0);
                                } else {
                                    System.out.println("Informe o ID da instituicao que deseja listar: ");
                                    int idlistar = scan.nextInt();
                                    if (idlistar == 0) {
                                        inst.listar(0);
                                    } else {
                                        existe = aluno.verificarAlunos(idlistar);
                                        if (existe == true) {
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
                                try {
                                    System.out.println("Deseja listar todas as frequências");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("s") || opc.equals("sim")) {
                                        frequencias.listarFrequencias(0);
                                    } else {
                                        System.out.println("Digite o ID de frequencias: ");
                                        int idListar = scan.nextInt();
                                        if (idListar == 0) {
                                            frequencias.listarFrequencias(0);
                                        } else {
                                            existe = frequencias.verificaIdFrequencia(idListar);
                                            if (existe == true) {
                                                frequencias.listarFrequencias(idListar);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro ao listar dados da tabela de frequencias" + e.getMessage());
                                }
                                break;
                            case 9:
                                System.out.println("Deseja prosseguir na inserção ou gerenciamento de diário?");
                                opc = scan.nextLine().toLowerCase().trim();
                                while (opc.equals("sim") || opc.equals("s")) {
                                    System.out.println("======================================");
                                    System.out.println("           PÁGINA DE DIÁRIO           ");
                                    System.out.println("======================================");
                                    System.out.println("Escolha uma opção: ");
                                    System.out.println("1. Inserir Diário");
                                    System.out.println("2. Listar Diários");
                                    System.out.println("3. Atualizar Diário");
                                    System.out.println("4. Remover Diário");
                                    System.out.println("Digite a opção desejada: ");
                                    int escolhaDiario = scan.nextInt();
                                    scan.nextLine();

                                    Diario diario = new Diario();  // Criar objeto Diario
                                    switch (escolhaDiario) {
                                        case 1:

                                            System.out.println("====================================");
                                            System.out.println("     INSERIR DADOS NO DIÁRIO       ");
                                            System.out.println("====================================");

                                            System.out.println("Informe o local do diário: ");
                                            diario.setDiariosLocal(scan.nextLine());
                                            System.out.println("Informe as disciplinas do diário: ");
                                            diario.setDiariosDisciplinas(scan.nextLine());
                                            System.out.println("Informe a quantidade de alunos: ");
                                            diario.setQtdAlunos(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("Informe o ID do professor: ");
                                            diario.setFkDiariosProfessores(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("Informe o ID do aluno: ");
                                            diario.setFkDiariosAlunos(scan.nextInt());
                                            scan.nextLine();

                                            diario.inserir();  // Inserir no banco de dados
                                            System.out.println("Diário inserido com sucesso!");
                                            System.out.println("\n Diário cadastrado com sucesso!");
                                            System.out.println(" Local: " + diario.getDiariosLocal());
                                            System.out.println(" Disciplinas: " + diario.getDiariosDisciplinas());
                                            System.out.println(" Quantidade de alunos: " + diario.getQtdAlunos());
                                            System.out.println(" Professor ID: " + diario.getFkDiariosProfessores());
                                            System.out.println(" Aluno ID: " + diario.getFkDiariosAlunos());
                                            System.out.println("=======================================\n");

                                            System.out.println("Deseja cadastrar um novo diário?");
                                            resposta = scan.nextLine().toLowerCase().trim();

                                            break;

                                        case 2:
                                            System.out.println("====================================");
                                            System.out.println("          LISTAR DIÁRIOS            ");
                                            System.out.println("====================================");
                                            System.out.println("Deseja listar um diário específico? (sim/não)");
                                            String listarOpcao = scan.nextLine().toLowerCase().trim();

                                            if (listarOpcao.equals("sim") || listarOpcao.equals("s")) {
                                                System.out.println("Informe o ID do Diário: ");
                                                int idListar = scan.nextInt();
                                                scan.nextLine();
                                                diario.listar(idListar);
                                            } else {
                                                diario.listar(0); // Listar todos se passar 0
                                            }
                                            break;

                                        case 3:
                                            System.out.println("====================================");
                                            System.out.println("          ATUALIZAR DIÁRIO          ");
                                            System.out.println("====================================");
                                            System.out.println("Informe o ID do Diário que deseja atualizar: ");
                                            int idAtualizar = scan.nextInt();
                                            scan.nextLine();

                                            System.out.println("Informe o novo local do diário: ");
                                            diario.setDiariosLocal(scan.nextLine());
                                            System.out.println("Informe as novas disciplinas do diário: ");
                                            diario.setDiariosDisciplinas(scan.nextLine());
                                            System.out.println("Informe a nova quantidade de alunos: ");
                                            diario.setQtdAlunos(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("Informe o novo ID do professor: ");
                                            diario.setFkDiariosProfessores(scan.nextInt());
                                            scan.nextLine();
                                            System.out.println("Informe o novo ID do aluno: ");
                                            diario.setFkDiariosAlunos(scan.nextInt());
                                            scan.nextLine();

                                            diario.alterar(idAtualizar);
                                            break;

                                        case 4:
                                            System.out.println("====================================");
                                            System.out.println("          REMOVER DIÁRIO            ");
                                            System.out.println("====================================");
                                            System.out.println("Informe o ID do Diário que deseja remover: ");
                                            int idRemover = scan.nextInt();
                                            scan.nextLine();

                                            diario.deletar(idRemover);
                                            break;

                                        default:
                                            System.out.println("️Opção inválida! Tente Novamente.");
                                            break;
                                    }

                                    System.out.println("\nDeseja realizar outra operação em diário?");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                }
                                break;
                            default:
                                System.out.println("Tabela errada! ");
                                break;
                        }

                    }
                    break;
                case 5:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("Opçao errada!");
                    break;
            }

            funcao.menuPrincipal();
            try {
                System.out.println("Deseja escolher qual opçao? ");
                escolha = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! " + e.getMessage());
            }

        }
    }
}




