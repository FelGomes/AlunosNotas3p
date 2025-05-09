/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moodle;

import Suap.Funcoes;
import Suap.Instituicao;
import Suap.abstractClass.Alunos;
import Suap.abstractClass.Boletim;
import Suap.abstractClass.Diario;

import Suap.abstractClass.Frequencias;
import Suap.abstractClass.Matricula;
import Suap.abstractClass.Notas;
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
        Boletim boletim = new Boletim();
        Notas notas = new Notas();
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
                        funcao.menuTabelasInserir();
                        System.out.println("informa a tabela: ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1:
                                try {
                                    System.out.println("Deseja cadastrar um usuario?");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while(resposta.equals("sim") || resposta.equals("s")){
                                        System.out.println("=============================================");
                                        System.out.println("      Bem vindo ao cadastro de Usuarios ");
                                        System.out.println("=============================================");
                                        System.out.println("Digite o nome do Usuario");
                                        usuario.setNome(scan.nextLine());
                                        System.out.println("Digite o sexo do usuario(m) para Masculino e (f) para feminino");
                                        usuario.setSexo(scan.nextLine());
                                        System.out.println("Digite o endereço do usuario, ex: Rua 000 Num 000 Bairo xxxxxx");
                                        usuario.setEndereco(scan.nextLine());
                                        System.out.println("Digite o CPF do usuario (000.000.000-00");
                                        usuario.setCpf(scan.nextLine());
                                        System.out.println("Digite a data de nascimento do usuario, Ex: 00/00/0000");
                                        usuario.setDataNascimento(scan.nextLine());
                                        usuario.inserir();
                                        System.out.println("Usuario inserido com sucesso!");
                                        usuario.mostrarId();

                                        System.out.println("Deseja cadastrar outro usuario?");
                                        resposta = scan.nextLine().toLowerCase().trim();

                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                                break;
                                
                            case 2:
                                try {
                                    System.out.println("Deseja cadastrar alunos? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals("s")) {
                                        usuario.listar(0);
                                        System.out.println("Informe o ID do usuario: ");
                                        int id_usu = scan.nextInt(); // vai receber um id e vai verificar se existe para dar procedimento
                                        scan.nextLine();
                                        existe = usuario.verificarUsuarios(id_usu);
                                        if (existe == true) { // se existe, o codigo da andamento
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
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dado!" + e.getMessage());
                                }
                                break;
                            case 3: // inserir professor
                                try {
                                    System.out.println("Deseja cadastrar professores? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals("s")) {
                                        usuario.listar(0);
                                        System.out.println("Informe o ID do usuario: ");
                                        int id_usu = scan.nextInt(); // vai receber um id e vai verificar se existe para dar procedimento
                                        scan.nextLine();
                                        existe = usuario.verificarUsuarios(id_usu);
                                        if (existe == true) { // se existe, o codigo da andamento
                                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                            System.out.println("         BEM VINDO, PROFESSOR           ");
                                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                            System.out.println("Informe a disciplina que vai ministrar: ");
                                            professores.setDisciplinaMinistrada(scan.nextLine());
                                            System.out.println("Informe a turma que será trabalhada: ");
                                            professores.setTurmaEnsinada(scan.nextLine());
                                            System.out.println("Informe a sua titularidade: ");
                                            professores.setGrauTitularidade(scan.nextLine());
                                            professores.setIdUsuario(id_usu);
                                            professores.inserirProfessor();
                                            //scan.nextLine();

                                        } else {
                                            System.out.println("Esse ID nao existe");

                                        }
                                        System.out.println("Deseja cadastrar outro professor? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dado!" + e.getMessage());
                                }
                                break;
                            case 4:
                                try {
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
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }

                                break;

                            case 5:
                                try {
                                    Matricula matricula = new Matricula();
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          INSERIR MATRICULA             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja cadastrar uma matricula? ");
                                    String respostaMatricula = scan.nextLine().toLowerCase().trim();

                                    while (respostaMatricula.equals("sim") || respostaMatricula.equals("s")) {
                                        System.out.println("Informe a data de inicio da matricula (ANO - MES - DIA) ");
                                        matricula.setMatriculasDataInicio(scan.nextLine());

                                        System.out.println("Informe a data de termino da matricula: ");
                                        matricula.setMatriculaDataFim(scan.nextLine());

                                        System.out.println("Informe a quantidade de tempo (em meses): ");
                                        matricula.setQtdTempo(scan.nextInt());
                                            
                                         inst.listar(0);
                                        System.out.println("\nInforme o ID da instituicao: ");
                                        matricula.setFkinstituicaoId(scan.nextInt()); scan.nextLine();
                                        existe = inst.verificarInstituicao(matricula.getFkInstituicaoId());
                                        if(!existe){
                                            System.out.println("Este ID não existe! ");
                                            break; 
                                        } else {
                                            aluno.listar(0);
                                            System.out.println("\nInforme o ID do aluno: ");
                                            matricula.setFkAlunoId(scan.nextInt()); scan.nextLine();
                                            existe = aluno.verificarAlunos(matricula.getFkAlunoId());
                                            if (!existe){
                                                System.out.println("Esse ID não existe!");
                                                break;
                                            } else {
                                                scan.nextLine();
                                                matricula.inserir();
                                            
                                            }
                                        }

                                        System.out.println("Deseja cadastrar uma nova matricula? (s/n): ");
                                        respostaMatricula = scan.nextLine().toLowerCase().trim();
                                    }
                                } catch(Exception e){
                                    System.out.println("Erro ao inserir os dados!");
                                    
                                }

                                break;
                            case 6: // inserir notas
                                try{
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          INSERIR NOTAS            ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja inserir algum dado na tabela de notas? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while(resposta.equals("s") || resposta.equals("sim")){
                                        professores.listarProfessores();
                                        System.out.println("Digite o ID do professor: ");
                                        notas.setProfessor_id(scan.nextInt());
                                        scan.nextLine();
                                        existe = professores.verificarIdProfessor(notas.getProfessor_id());
                                        if(existe == true){
                                            aluno.listar(0);
                                            System.out.println("Digite o ID do aluno: ");
                                            notas.setAluno_id(scan.nextInt());
                                            scan.nextLine();
                                            boolean existe1 = aluno.verificarAlunos(notas.getAluno_id());
                                            if(existe1 == true){
                                                System.out.println("Digite a primeira nota: ");
                                                notas.setNota_um(scan.nextDouble());
                                                scan.nextLine();
                                                System.out.println("Digite a segunda nota: ");
                                                notas.setNota_dois(scan.nextDouble());
                                                scan.nextLine();
                                                System.out.println("Digite a terceira nota: ");
                                                notas.setNota_tres(scan.nextDouble());
                                                scan.nextLine();
                                                System.out.println("Digite a quarta nota: ");
                                                notas.setNota_quatro(scan.nextDouble());
                                                scan.nextLine();
                                                System.out.println("Digite a materia relacionada a essas notas: ");
                                                notas.setNota_disciplina(scan.nextLine());
                                                notas.inserirNotas();
                                            } else {
                                                System.out.println("Não existe aluno com esse ID!");
                                            }
                                        } else {
                                            System.out.println("Não existe professor com esse ID!");
                                        }
                                        System.out.println("Deseja inserir outro valor tabela de notas? ");
                                            resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                } catch(Exception e) {
                                    System.out.println("Erro na entrada de dados!" + e.getLocalizedMessage());
                                }
                                break;
                            case 7: // Inserir frequencias
                                try {
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          INSERIR FREQUENCIA             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja inserir algum dado na tabela de frequencias? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("s") || resposta.equals("sim")) {
                                        professores.listarProfessores();
                                        System.out.println("Digite o ID do professor: ");
                                        //int idProfessorInsert = scan.nextInt();
                                        frequencias.setProfessores_id(scan.nextInt());
                                        scan.nextLine();
                                        existe = frequencias.verificaIdProfessores(frequencias.getProfessores_id());
                                        if (existe == true) {
                                            aluno.listar(0);
                                            System.out.println("Digite o id do aluno: ");
                                            //int idAlunoInsert = scan.nextInt();
                                            frequencias.setAlunos_id(scan.nextInt());
                                            scan.nextLine();
                                            boolean existe1 = frequencias.verificaIdAlunos(frequencias.getAlunos_id());
                                            if (existe1 == true) {
                                                System.out.println("Digite a quantidade de aulas que a disciplina possui: ");
                                                frequencias.setTotal_aulas(scan.nextInt());
                                                scan.nextLine();
                                                System.out.println("Digite o nome da disciplina: ");
                                                frequencias.setFrequencias_disciplinas(scan.nextLine());
                                                System.out.println("Digite a quantidade de aulas de hoje: ");
                                                frequencias.setAulas_ministradas(scan.nextInt());
                                                scan.nextLine();
                                                System.out.println("O aluno(a) compareceu a aula? ");
                                                String opcFrequencia = scan.nextLine().toLowerCase().trim();
                                                if (opcFrequencia.equals("sim") || opcFrequencia.equals("s")) {
                                                    frequencias.setFrequencias_faltas(0);
                                                    frequencias.setPrctg_presenca(frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas()));
                                                } else {
                                                    frequencias.setFrequencias_faltas(frequencias.getAulas_ministradas());
                                                    frequencias.setPrctg_presenca(frequencias.calculaPrctgFrequencia(frequencias.getTotal_aulas(), frequencias.getFrequencias_faltas()));
                                                }
                                                frequencias.inserirFrequencia();
                                            }else {
                                                System.out.println("Nao existe aluno com esse ID!");
                                            }
                                        } else {
                                            System.out.println("Nao existe professor com esse ID!");
                                        }
                                        System.out.println("Deseja inserir outro valor tabela de frequencias? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!" + e.getLocalizedMessage());
                                    
                                }
                                break;
                            case 8: // inserir diario
                                try {
                                    Diario diario = new Diario();
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          INSERIR DIARIO             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja inserir dados em diario?");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    while (resposta.equals("sim") || resposta.equals("s")) {
                                        System.out.println("Informe o local do diario:");
                                        diario.setDiariosLocal(scan.nextLine());

                                        System.out.println("Informe as disciplinas:");
                                        diario.setDiariosDisciplinas(scan.nextLine());

                                        System.out.println("Informe a quantidade de alunos:");
                                        diario.setQtdAlunos(scan.nextInt());
                                        professores.listarProfessores();

                                        System.out.println("Informe o ID do professor:");
                                        diario.setFkDiariosProfessores(scan.nextInt());
                                        
                                        aluno.listar(0);
                                        System.out.println("Informe o ID do aluno:");
                                        diario.setFkDiariosAlunos(scan.nextInt());
                                        scan.nextLine();

                                        diario.inserir();

                                        System.out.println("Deseja inserir outro diario?");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
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
                    try {
                        System.out.println("Deseja fazer atualizaçao de algum dado? ");
                        opc = scan.nextLine().toLowerCase().trim();
                        while (opc.equals("sim") || (opc.equals("s"))) {
                            funcao.menuTabelasInserir();
                            System.out.println("Deseja atualizar qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1: // alterar tabela usuarios
                                    try {
                                        System.out.println("Deseja fazer a atualizacao da tabela usuarios? ");
                                        opc1 = scan.nextLine();
                                        while (opc1.equals("sim") || opc.equals("s")){
                                            usuario.listar(0);
                                            System.out.println("Informe o ID do usuario que deseja alterar!");
                                            usuario.setId(scan.nextInt());
                                            scan.nextLine();
                                            existe = usuario.verificarUsuarios(usuario.getId());
                                            if(existe){
                                                System.out.println("=========================");
                                                System.out.println("nome");
                                                System.out.println("endereco");
                                                System.out.println("cpf");
                                                System.out.println("sexo");
                                                System.out.println("nascimento");
                                                System.out.println("tudo");
                                                System.out.println("=========================");
                                                System.out.println("Deseja alterar qual coluna?");
                                                resposta = scan.nextLine().toLowerCase().trim();
                                                if(resposta.equals("nome")){
                                                    System.out.println("Informe o novo nome do usuario");
                                                    usuario.setNome(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else if(resposta.equals("endereco")){
                                                    System.out.println("Informe o novo endereco do usuario");
                                                    usuario.setEndereco(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else if(resposta.equals("cpf")){
                                                    System.out.println("Informe o novo CPF do usuario");
                                                    usuario.setCpf(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else if(resposta.equals("sexo")){
                                                    System.out.println("Informe o novo sexo do usuario");
                                                    usuario.setSexo(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else if(resposta.equals("nascimento")){
                                                    System.out.println("Informe a nova data de nascimento do usuario");
                                                    usuario.setDataNascimento(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else if(resposta.equals("tudo")){
                                                    System.out.println("Digite o nome do Usuario");
                                                    usuario.setNome(scan.nextLine());
                                                    System.out.println("Digite o sexo do usuario(m) para Masculino e (f) para feminino");
                                                    usuario.setSexo(scan.nextLine());
                                                    System.out.println("Digite o endereço do usuario, ex: Rua 000 Num 000 Bairo xxxxxx");
                                                    usuario.setEndereco(scan.nextLine());
                                                    System.out.println("Digite o CPF do usuario (000.000.000-00");
                                                    usuario.setCpf(scan.nextLine());
                                                    System.out.println("Digite a data de nascimento do usuario, Ex: 00/00/0000");
                                                    usuario.setDataNascimento(scan.nextLine());
                                                    usuario.alterar(usuario.getId(), resposta);
                                                }else{
                                                    System.out.println("Erro de digitação tente novamente!");
                                                }


                                            }else{
                                                System.out.println("Usuario não existe");
                                            }
                                            System.out.println("Deseja fazer outra alteração na tabela usuarios?");
                                            opc1 = scan.nextLine();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 2: // alterar tabela aluno
                                    try {
                                        
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
                                                    scan.nextLine();

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
                                                    scan.nextLine();

                                                } else {
                                                    System.out.println("Nao existe esse campo!");
                                                }

                                            } else {
                                                System.out.println("Nao existe aluno com esse ID!");
                                            }
                                            System.out.println("Deseja Atualizar novamente?  ");
                                            opc1 = scan.nextLine().toLowerCase().trim();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 3: // alterar tabela professor
                                    try {
                                        
                                        System.out.println("Deseja alterar a tabela professor?");
                                        opc1 = scan.nextLine();
                                        while (opc1.equals("sim") || opc1.equals("s")){
                                            professores.listarProfessores();
                                            System.out.println("Informe o ID do professor que deseja alterar: ");
                                            professores.setId(scan.nextInt());
                                            scan.nextLine();
                                            existe = professores.verificarIdProfessor(professores.getId());

                                            if(existe){
                                                System.out.println("==========================");
                                                System.out.println("Disciplina          ");
                                                System.out.println("Turma               ");
                                                System.out.println("Titularidade        ");
                                                System.out.println("Tudo                ");
                                                System.out.println("==========================");

                                                System.out.println("Deseja alterar qual campo? ");
                                                resposta = scan.nextLine().toLowerCase().trim();

                                                if (resposta.equals("disciplina")){
                                                    System.out.println("Insira a nova disciplina dada pelo professor: ");
                                                    professores.setDisciplinaMinistrada(scan.nextLine());
                                                    professores.alterar(professores.getIdProfessor(), resposta);
                                                } else if (resposta.equals("turma")){
                                                    System.out.println("Insira a nova turma a ser ensinada: ");
                                                    professores.setTurmaEnsinada(scan.nextLine());
                                                    professores.alterar(professores.getIdProfessor(), resposta);
                                                } else if (resposta.equals("titularidade")){
                                                    System.out.println("Insira a nova titularidade do professor: ");
                                                    professores.setGrauTitularidade(scan.nextLine());
                                                    professores.alterar(professores.getIdProfessor(), resposta);
                                                } else if (resposta.equals("tudo")){
                                                    System.out.println("Insira a nova disciplina dada pelo professor: ");
                                                    professores.setDisciplinaMinistrada(scan.nextLine());
                                                    System.out.println("Insira a nova turma a ser ensinada: ");
                                                    professores.setTurmaEnsinada(scan.nextLine());
                                                    System.out.println("Insira a nova titularidade do professor: ");
                                                    professores.setGrauTitularidade(scan.nextLine());
                                                    professores.alterar(professores.getId(), resposta);
                                                } else {
                                                    System.out.println("Confira se o campo foi digitado corretamente.");
                                                }
                                            } else {
                                                System.out.println("Não foi encontrado professor com esse ID.");
                                            }
                                            System.out.println("Deseja fazer outra alteração? ");
                                            opc1 = scan.nextLine().toLowerCase().trim();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!" + e.getLocalizedMessage());
                                    }
                                    break;
                                case 4:
                                    try {
                                        
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
                                                    scan.nextLine();

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
                                                    scan.nextLine();
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
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 5: // alterar tabela matricula
                                    try {
                                        Matricula matricula = new Matricula();
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("          ATUALIZAR MATRICULA             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja alterar matriculas? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                        while (resposta.equals("sim") || resposta.equals("s")) {
                                            matricula.listar(0);
                                            System.out.println("Informe o ID da matricula que deseja atualizar:");
                                            matricula.setMatriculasId(scan.nextInt());
                                            scan.nextLine();

                                            if (matricula.verificarMatricula(matricula.getMatriculaId())) {
                                                System.out.println("Informe a nova data de inicio: ");
                                                matricula.setMatriculasDataInicio(scan.nextLine());

                                                System.out.println("Informe a nova data da matricula:");
                                                matricula.setMatriculaDataFim(scan.nextLine()); scan.nextLine();

                                                System.out.println("Informe a nova quantidade de tempo: ");
                                                matricula.setQtdTempo(scan.nextInt()); scan.nextLine();

                                                System.out.println("Informe o novo ID da instituicao: ");
                                                matricula.setFkinstituicaoId(scan.nextInt()); scan.nextLine();

                                                System.out.println("Informe o novo ID do aluno: ");
                                                matricula.setFkAlunoId(scan.nextInt());

                                                scan.nextLine();

                                                matricula.alterar(matricula.getMatriculaId());

                                            } else {
                                                System.out.println("ID de matricula nao encontrada.");
                                            }
                                            System.out.println("Deseja atualizar outra matricula? (s/n): ");
                                            resposta = scan.nextLine().toLowerCase().trim();
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 6: // alterar tabela notas
                                    try {
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("          ATUALIZAR NOTAS             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja alterar algo na tabela notas? ");
                                        opc1 = scan.nextLine();
                                        while (opc1.equals("sim") || opc.equals("s")){
                                            notas.listarNotas(0);
                                            System.out.println("Informe o ID da nota que deseja alterar!");
                                            notas.setNota_id(scan.nextInt());
                                            scan.nextLine();
                                            existe = notas.verificarNota(notas.getNota_id());
                                            if(existe){
                                                System.out.println("=========================");
                                                System.out.println("Nota um");
                                                System.out.println("Nota dois");
                                                System.out.println("Nota tres");
                                                System.out.println("Nota quatro");
                                                System.out.println("Disciplina");
                                                System.out.println("Tudo");
                                                System.out.println("=========================");
                                                System.out.println("Deseja alterar qual coluna?");
                                                resposta = scan.nextLine().toLowerCase().trim();
                                                if(resposta.equals("Nota um") || resposta.equals("nota um")){
                                                    System.out.println("Informe a nova nota um: ");
                                                    notas.setNota_um(scan.nextDouble());
                                                    notas.alterarNota(notas.getNota_id(), resposta);
                                                }else if(resposta.equals("Nota dois") || resposta.equals("nota dois")){
                                                    System.out.println("Informe a nova nota dois: ");
                                                    notas.setNota_dois(scan.nextDouble());
                                                    notas.alterarNota(notas.getNota_id(), resposta);
                                                }else if(resposta.equals("Nota tres") || resposta.equals("nota tres")){
                                                    System.out.println("Informe a nova nota tres: ");
                                                    notas.setNota_tres(scan.nextDouble());
                                                    notas.alterarNota(notas.getNota_id(), resposta);
                                                }else if(resposta.equals("Nota quatro") || resposta.equals("nota quatro")){
                                                    System.out.println("Informe a nova nota quatro: ");
                                                    notas.setNota_quatro(scan.nextDouble());
                                                    notas.alterarNota(notas.getNota_id(), resposta);    
                                                }else if(resposta.equals("Disciplina") || resposta.equals("disciplina")){
                                                    System.out.println("Informe a nova disciplina : ");
                                                    notas.setNota_disciplina(scan.nextLine());
                                                    notas.alterarNota(notas.getNota_id(), resposta);    
                                                }else if(resposta.equals("tudo")){
                                                    System.out.println("Informe a nova nota um: ");
                                                    notas.setNota_um(scan.nextDouble());
                                                    System.out.println("Informe a nova nota dois: ");
                                                    notas.setNota_dois(scan.nextDouble());
                                                    System.out.println("Informe a nova nota tres: ");
                                                    notas.setNota_tres(scan.nextDouble());
                                                    System.out.println("Informe a nova nota quatro: ");
                                                    notas.setNota_quatro(scan.nextDouble());
                                                    System.out.println("Informe a nova disciplina : ");
                                                    notas.setNota_disciplina(scan.nextLine());
                                                    notas.alterarNota(notas.getNota_id(), resposta);
                                                }else{
                                                    System.out.println("Erro de digitação tente novamente!");
                                                }
                                            }
                                            System.out.println("Deseja fazer outra alteração na tabela usuarios?");
                                            opc1 = scan.nextLine();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    
                                    
                                    
                                    break;
                                case 7: // alterar tabelas frequencias
                                    try {
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("          ATUALIZAR FREQUENCIA             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja atualizar algum dado na tabela de frequencias?");
                                        opc = scan.nextLine().toLowerCase().trim();
                                        while (opc.equals("s") || opc.equals("sim")) {
                                            frequencias.listarFrequencias(0);
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
                                                opc = scan.nextLine().toLowerCase().trim();
                                            }
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 8: //alterar tabela diario
                                    try {
                                        Diario diario = new Diario();
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("          ATUALIZAR DIARIO             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja alterar valores em diario? ");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                        while (resposta.equals("sim") || resposta.equals("s")) {
                                            diario.listar(0);
                                            System.out.println("Informe o ID do diario que deseja atualizar:");
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
                                                professores.listarProfessores();
                                                System.out.println("Informe o novo ID do professor:");
                                                diario.setFkDiariosProfessores(scan.nextInt());
                                                aluno.listar(0);
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
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;

                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                            }

                            System.out.println("Deseja fazer atualizaçao de outra tabela? ");
                            opc = scan.nextLine().toLowerCase().trim();

                        }
                    } catch (Exception e) {
                        System.out.println("Erro na entrada de dados!");
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Deseja remover valores de alguma tabela? ");
                        resposta = scan.nextLine();
                        while (resposta.equals("sim") || resposta.equals("s")) {
                            funcao.menuTabelas();
                            System.out.println("Deseja escolher qual tabela? ");
                            tabela = scan.nextInt();
                            scan.nextLine();
                            switch (tabela) {
                                case 1: // remover tabela usuario
                                    try {
                                        System.out.println("Deseja fazer a remoçao de Usuario? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                        while (opc.equals("sim") || opc.equals("s")) {
                                            usuario.listar(0);
                                            System.out.println("Informe o ID do usuario que deseja remover: ");
                                            int idDeletar = scan.nextInt();
                                            scan.nextLine();
                                            existe = usuario.verificarUsuarios(idDeletar);
                                            if (existe == true) {
                                                usuario.deletar(idDeletar);

                                            } else {
                                                System.out.println("Esse ID nao existe em Usuarios! ");
                                            }
                                            System.out.println("Deseja fazer outra remocao? ");
                                            opc = scan.nextLine().toLowerCase().trim();
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 2: // remover tabela aluno
                                    try {
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
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 3: // emover tabela professor
                                    try {
                                        System.out.println("Deseja fazer a remoção do professor? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                        while(opc.equals("sim") || opc.equals("s")){
                                            professores.listarProfessores();
                                            System.out.println("Informe o ID do professor que deseja remover: ");
                                            int idDeletar = scan.nextInt();
                                            scan.nextLine();
                                            professores.deletar(idDeletar);

                                            System.out.println("Deseja fazer outra remocao? ");
                                            opc = scan.nextLine().toLowerCase().trim();
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                case 4: // remover tabela instituicao
                                    try {
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
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }

                                    break;
                                case 5: // remover tabela matricula
                                    try {
                                        Matricula matricula = new Matricula();
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("         DELETAR MATRICULA             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja deletar valores de matricula?");
                                        resposta = scan.nextLine().toLowerCase().trim();

                                        while (resposta.equals("sim") || resposta.equals("s")) {
                                            matricula.listar(0);
                                            System.out.println("Informe o ID da matricula que deseja deletar: ");
                                            matricula.setMatriculasId(scan.nextInt());
                                            scan.nextLine();

                                            if (matricula.verificarMatricula(matricula.getMatriculaId())) {
                                                matricula.deletar(matricula.getMatriculaId());
                                            } else {
                                                System.out.println("ID de matricula nao encontrada.");
                                            }

                                            System.out.println("Deseja deletar outra matricula? (s/n): ");
                                            resposta = scan.nextLine().toLowerCase().trim();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                /*case 6: // remover tabela boletim (boletim vai entrar no case de remover e de listar somente)
                                    try {
                                        System.out.println("Deseja fazer a remoção do boletim? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                        while(opc.equals("sim") || opc.equals("s")){
                                            System.out.println("Informe o ID do boletim que deseja remover: ");
                                            int idDeletar = scan.nextInt();
                                            scan.nextLine();
                                            boletim.deletarBoletim(idDeletar);

                                            System.out.println("Deseja fazer outra remocao? ");
                                            opc = scan.nextLine().toLowerCase().trim();
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;*/
                                case 6: // remover tabela notas
                                    try{
                                        System.out.println("Deseja fazer a remoção das notas? ");
                                        opc = scan.nextLine().toLowerCase().trim();
                                        while (opc.equals("sim") || opc.equals("s")) {
                                            notas.listarNotas(0);
                                            System.out.println("Informe o ID da nota que deseja remover: ");
                                            int idDelete = scan.nextInt();
                                            scan.nextLine();
                                            existe = notas.verificarNota(idDelete);
                                            if (existe == true) {
                                                notas.deletarNotas(idDelete);

                                            } else {
                                                System.out.println("Esse ID nao existe em notas! ");
                                            }
                                            System.out.println("Deseja fazer outra remocao? ");
                                            opc = scan.nextLine().toLowerCase().trim();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                   
                                    break;
                                case 7: // remover tabelas frequencias
                                    try {
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("          DELETAR FREQUENCIA             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
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
                                case 8: // remover tabela diario
                                    try {
                                        Diario diario = new Diario();
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("             DELETAR DIARIO             ");
                                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                        System.out.println("Deseja deletar valores em Diario?");
                                        resposta = scan.nextLine().toLowerCase().trim();
                                        while (resposta.equals("sim") || resposta.equals("s")) {
                                            diario.listar(0);
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
                                        
                                    } catch (Exception e) {
                                        System.out.println("Erro na entrada de dados!");
                                    }
                                    break;
                                default:
                                    System.out.println("Tabela errada! ");
                                    break;
                            }
                            System.out.println("Deseja remover valores de outra tabela? ");
                            resposta = scan.nextLine().toLowerCase().trim();
                        }
                    } catch (Exception e) {
                        System.out.println("Erro na entrada de dados!");
                    }
                    break;
                case 4: // case para listar
                    System.out.println("Deseja listar alguma tabela? ");
                    resposta = scan.nextLine().toLowerCase().trim();
                    while (resposta.equals("sim") || resposta.equals("s")) {
                        funcao.menuTabelas();
                        System.out.println("Deseja escolher qual tabela? ");
                        tabela = scan.nextInt();
                        scan.nextLine();
                        switch (tabela) {
                            case 1: // listar usuario
                                try {
                                    System.out.println("Deseja listar todos os usuario?");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        usuario.listar(0);
                                    }else{
                                        System.out.println("Digite o id do usuario a ser listado");
                                        int idListado = scan.nextInt();
                                        scan.nextLine();
                                        if(idListado == 0){
                                            System.out.println("id 0 é inexistente");
                                        }else{
                                            existe = usuario.verificarUsuarios(idListado);
                                            if (existe == true) {
                                                usuario.listar(idListado);

                                            } else {
                                                System.out.println("Nao existe usuario com esse ID!");
                                            }
                                        }
                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                                break;
                            case 2: // listar alunos
                                try {
                                    System.out.println("Deseja listar todos os alunos? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        aluno.listar(0);
                                    } else {
                                        System.out.println("Informe o ID de aluno que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        scan.nextLine();
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
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                                break;
                            case 3: // listar professor
                                try {
                                    System.out.println("Deseja listar todos os professores? ");
                                    opc = scan.nextLine().toLowerCase().trim();

                                    if (opc.equals("sim") || opc.equals("s")){
                                        professores.listarProfessores();
                                    } else {
                                        System.out.println("Informe o ID de professor que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        scan.nextLine();
                                        professores.listar(idlistar);
                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                                break;
                            case 4: // listar instituicao
                                try {
                                    System.out.println("Deseja listar todas as instituicoes? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        inst.listar(0);
                                    } else {
                                        System.out.println("Informe o ID da instituicao que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        scan.nextLine();
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
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                                break;
                            case 5: // listar matricula
                                try {
                                    Matricula matricula = new Matricula();
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          LISTAR MATRICULA             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja listar matriculas? ");
                                    resposta = scan.nextLine().toLowerCase().trim();

                                    if (resposta.equals("sim") || resposta.equals("s")) {
                                        System.out.println("Informe o ID da matricula: ");
                                        matricula.setMatriculasId(scan.nextInt());
                                        scan.nextLine();

                                        if (matricula.verificarMatricula(matricula.getMatriculaId())) {
                                            matricula.listar(matricula.getMatriculaId());
                                        } else {
                                            System.out.println("ID de matricula nao encontrada.");
                                        }
                                    } else {
                                        matricula.listar(0); // listar todas
                                    }
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }

                                break;
                            case 6: // listar boletim
                                try {
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          LISTAR BOLETIM            ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja listar boletins? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    while(opc.equals("sim")||opc.equals("s")){
                                        aluno.listarAlunos();
                                        System.out.println("Deseja ver boletim de qual aluno? ");
                                        aluno.setId(scan.nextInt());
                                        scan.nextLine();
                                        existe = aluno.verificarAlunos(aluno.getId());
                                        if(existe == true){
                                            boletim.listarBoletim(aluno.getId());
                                            
                                        } else {
                                            System.out.println("Nao existe aluno com esse id!");
                                        }
                                        System.out.println("Deseja listar outro aluno? ");
                                        opc = scan.nextLine().toLowerCase().trim();

                                    }

                                } catch (Exception e) {

                                }
                                break;
                            case 7: // listar notas
                                try {
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          LISTAR NOTAS             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja listar todas as notas? ");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("sim") || opc.equals("s")) {
                                        notas.listarNotas(0);
                                    } else {
                                        System.out.println("Informe o ID de professor que deseja listar: ");
                                        int idlistar = scan.nextInt();
                                        scan.nextLine();
                                        notas.listarNotas(idlistar);
                                    }

                                } catch (Exception e) {

                                }
                                break;
                            case 8: // listar frequencias
                                try {
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("          LISTAR FREQUENCIA             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja listar todas as frequências");
                                    opc = scan.nextLine().toLowerCase().trim();
                                    if (opc.equals("s") || opc.equals("sim")) {
                                        frequencias.listarFrequencias(0);
                                    } else {
                                        System.out.println("Digite o ID de frequencias: ");
                                        int idListar = scan.nextInt();
                                        scan.nextLine();
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
                            case 9: // listar diario
                                try {
                                    Diario diario = new Diario();
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("             LISTAR DIARIO             ");
                                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                    System.out.println("Deseja listar diario? ");
                                    resposta = scan.nextLine().toLowerCase().trim();
                                    if (resposta.equals("sim") || resposta.equals("s")) {
                                        System.out.println("Informe o ID do diario:");
                                        int id = scan.nextInt();
                                        scan.nextLine();
                                        diario.listar(id);
                                    } else {
                                        diario.listar(0); // lista todos

                                    }

                                    break;
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro na entrada de dados!");
                                }
                        }
                        System.out.println("Deseja listar outra tabela? ");
                        resposta = scan.nextLine().toLowerCase().trim();

                    }
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
