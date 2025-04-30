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
import Suap.abstractClass.UsuarioAbstract;
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
        Professores professores = new Professores();
        UsuarioAbstract usuario = new UsuarioAbstract();
        
        
        funcao.menuPrincipal();
        try {
            System.out.println("Deseja escolher qual opçao? ");
            escolha = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados! " + e.getMessage());
        }
        while (escolha != 5) {
            switch (escolha) {
                case 1:
                    System.out.println("Deseja inserir valores em alguma tabela? ");
                    opc = scan.nextLine().toLowerCase().trim();
                    while (opc.equals("sim") || opc.equals("s")) {
                        funcao.menuTabelas();
                        System.out.println("informa a tabela: ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                break;
                            case 2:
                                try {
                                    System.out.println("Deseja cadastrar alunos? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while(resposta.equals("sim")||resposta.equals("s")){
                                        System.out.println("Informe o ID do usuario: ");
                                        int id_usu = scan.nextInt(); // vai receber um id e vai verificar se existe para dar procedimento
                                        scan.nextLine();
                                        existe = usuario.verificarUsuarios(id_usu);
                                        if(existe == true){ // se existe, o codigo da andamento
                                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                            System.out.println("         BEM VINDO, ALUNO           ");
                                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                            aluno.setAlunos_matriculados(true);
                                            System.out.println("Informe a sala: ");
                                            aluno.setAlunos_sala(scan.nextLine());
                                            System.out.println("Informe a turma: ");
                                            aluno.setAlunos_turma(scan.nextLine());
                                            System.out.println("Informe a quantidade de disciplina: ");
                                            aluno.setQtd_disciplina(scan.nextInt());
                                            aluno.setId(id_usu);
                                            aluno.inserir();
                                            scan.nextLine();

                                        } else {
                                            System.out.println("Esse ID nao existe");
 
                                        }
                                        System.out.println("Deseja cadastrar outro aluno? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                }catch (Exception e) {
                                    System.out.println("Erro na entrada de dado!" + e.getMessage());
                                }
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println("Deseja prosseguir na inserção de valores de Instituicao? ");
                                resposta = scan.nextLine().toLowerCase().trim();
                                while (resposta.equals("sim") || resposta.equals("s")) {
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("             BEM VINDO              ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
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
                            case 6:
                                break;
                            case 7:
                 Diario diario = new Diario();
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                 System.out.println("          INSERIR DIARIO             ");
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                 resposta = scan.nextLine().toLowerCase().trim();
                 while (resposta.equals("sim") || resposta.equals("s")){
                     System.out.println("Informe o local do diario:");
                     diario.setDiariosLocal(scan.nextLine());
                     
                     System.out.println("Informe as disciplinas:");
                     diario.setDiariosDisciplinas(scan.nextLine());
                     
                     System.out.println("Informe a quantidade de alunos:");
                     diario.setQtdAlunos(scan.nextInt());
                     
                     System.out.println("Informe o ID do professor:");
                     diario.setFkDiariosProfessores(scan.nextInt());
                     
                     System.out.println("Informe o ID do aluno:");
                     diario.setFkDiariosAlunos(scan.nextInt());
                     scan.nextLine();
                     
                     diario.inserir();
                     
                     System.out.println("Deseja inserir outro diario?");
                     resposta = scan.nextLine().toLowerCase().trim();
                }
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                System.out.println("Deseja inserir algum dado na tabela de frequencias? ");
                                resposta = scan.nextLine().toLowerCase().trim();
                                while (resposta.equals("s") || resposta.equals("sim")) {
                                    System.out.println("Digite o ID do professor: ");
                                    int idProfessorInsert = scan.nextInt();
                                    scan.nextLine();
                                    existe = frequencias.verificaIdProfessores(idProfessorInsert);
                                    //método para verificar id professor
                                    //existe = frequencias.verificarIdProfessor(idProfessorInsert);
                                    if (existe == true) {
                                        System.out.println("Digite o id do aluno: ");
                                        int idAlunoInsert = scan.nextInt();
                                        scan.nextLine();
                                        boolean existe1 =  frequencias.verificaIdAlunos(idAlunoInsert);
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
                                    System.out.println("Informe o ID do aluno que deseja fazer alteração: ");
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
                                            scan.nextLine();

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
                                            scan.nextLine();
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
                                            System.out.println("Informe a cidade da instituicao: ");
                                            inst.setInst_cidade(scan.nextLine());
                                            System.out.println("Informe o UF da instituicao: ");
                                            inst.setInst_uf(scan.nextLine());
                                            System.out.println("Informe a escolaridade da instituicao: ");
                                            inst.setInst_escolaridade(scan.nextLine());
                                            System.out.println("Informe o nivel da instituicao: ");
                                            inst.setInst_nivel(scan.nextInt());
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
                 Diario diario = new Diario();
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                 System.out.println("          ATUALIZAR DIARIO             ");
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                 resposta = scan.nextLine().toLowerCase().trim();
                 while (resposta.equals("sim") || resposta.equals("s")){
                     System.out.println("Informe o ID do diario que deseja atualizar:");
                     int id = scan.nextInt();
                     scan.nextLine();
                     
                     if (diario.verificarDiario(id)){
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
                         System.out.println("Diario nao encontrado.");
                     }
                     System.out.println("Deseja atualizar outro diario?");
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
                                System.out.println("Deseja fazer a remoçao de aluno? ");
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
                                System.out.println("Deseja fazer a remocao de instituicao? ");
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
            Diario diario = new Diario();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("             DELETAR DIARIO             ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            resposta = scan.nextLine().toLowerCase().trim();
            while (resposta.equals("sim") || resposta.equals("s")){
                System.out.println("Informe o ID do diario que deseja deletar:");
                int id = scan.nextInt();
                scan.nextLine();
                
                if (diario.verificarDiario(id)){
                    diario.deletar(id);  
                }else{
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
            Diario diario = new Diario();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("             LISTAR DIARIO             ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            resposta = scan.nextLine().toLowerCase().trim();
            if (resposta.equals("sim") || resposta.equals("s")){
                System.out.println("Informe o ID do diario:");
                int id = scan.nextInt();
                scan.nextLine();
                diario.listar(id);
            }else{
                diario.listar(0); // lista todos
                
            }
                            
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
    }
}
