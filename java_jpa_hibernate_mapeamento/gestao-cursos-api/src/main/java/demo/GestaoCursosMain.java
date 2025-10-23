package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Gestão de Cursos ===");

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        try {
            System.out.println("\n--- Criando Aluno ---");
            Aluno aluno = new Aluno();
            aluno.setNomeCompleto("João Silva");
            aluno.setEmail("joao.silva@email.com");

            Telefone telefone = new Telefone();
            telefone.setNumero("(11) 99999-9999");
            telefone.setAluno(aluno);

            Endereco endereco = new Endereco();
            endereco.setLogradouro("Rua das Flores, 123");
            endereco.setCidade("São Paulo");
            endereco.setEstado("SP");
            endereco.setCep(01234567);
            endereco.setAluno(aluno);

            aluno.setTelefones(List.of(telefone));
            aluno.setEndereco(endereco);

            alunoModel.create(aluno);

            System.out.println("\n--- Criando Professor ---");
            Professor professor = new Professor();
            professor.setNomeCompleto("Dr. Maria Santos");
            professor.setEmail("maria.santos@universidade.com");
            professor.setMatricula("123456");

            System.out.println("\n--- Criando Curso ---");
            Curso curso = new Curso();
            curso.setNome("Programação Java Avançada");
            curso.setSigla("JAVA");
            curso.setProfessor(professor);
            curso.setAlunos(List.of(aluno));
            professor.setCursos(List.of(curso));

            cursoModel.create(curso);

            System.out.println("\n--- Criando Material do Curso ---");
            MaterialCurso material = new MaterialCurso();
            material.setUrl("https://materiais.com/java-jpa.pdf");
            material.setCurso(curso);

            curso.setMateriais(List.of(material));

            cursoModel.update(curso);

            System.out.println("\n--- Testando Consultas ---");

            Aluno alunoEncontrado = alunoModel.findById(aluno.getId());
            if (alunoEncontrado != null) {
                System.out.println("Aluno encontrado: " + alunoEncontrado.getNomeCompleto());
            }

            System.out.println("Total de alunos: " + alunoModel.findAll().size());

            Curso cursoEncontrado = cursoModel.findById(curso.getId());
            if (cursoEncontrado != null) {
                System.out.println("Curso encontrado: " + cursoEncontrado.getNome());
                System.out.println("Professor: " + cursoEncontrado.getProfessor().getNomeCompleto());
                System.out.println("Alunos matriculados: " + cursoEncontrado.getAlunos().size());
                System.out.println("Materiais disponíveis: " + cursoEncontrado.getMateriais().size());
            }

            System.out.println("Total de cursos: " + cursoModel.findAll().size());

            System.out.println("\n--- Testando Atualização ---");
            alunoEncontrado.setEmail("joao.silva.novo@email.com");
            alunoModel.update(alunoEncontrado);

            System.out.println("\n--- Operações CRUD Concluídas ---");
            System.out.println("Dados populados com sucesso no banco SQLite!");

        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n=== Finalizando Gestão de Cursos ===");
        }
    }
}
