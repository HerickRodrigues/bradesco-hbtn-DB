package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        // Teste do ProdutoModel
        ProdutoModel produtoModel = new ProdutoModel();

        // 1. Criando produtos
        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);
        produtoModel.create(p1);

        Produto p2 = new Produto();
        p2.setNome("Smartphone");
        p2.setPreco(1200.0);
        p2.setQuantidade(50);
        p2.setStatus(true);
        produtoModel.create(p2);

        // 2. Buscando todos os produtos
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados: " + produtos.size());

        // 3. Buscando produto por ID
        if (!produtos.isEmpty()) {
            Produto primeiroProduto = produtos.get(0);
            Produto produtoEncontrado = produtoModel.findById(primeiroProduto.getId());
            System.out.println("Produto encontrado: " + produtoEncontrado.getNome());

            // 4. Atualizando produto
            produtoEncontrado.setPreco(350.0);
            produtoModel.update(produtoEncontrado);

            // 5. Deletando produto
            produtoModel.delete(produtos.get(1));
        }

        // Teste do PessoaModel
        PessoaModel pessoaModel = new PessoaModel();

        // 1. Criando pessoas
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João Silva");
        pessoa1.setEmail("joao@email.com");
        pessoa1.setIdade(30);
        pessoa1.setCpf("123.456.789-00");
        pessoa1.setDataNascimento(new Date());
        pessoaModel.create(pessoa1);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria Santos");
        pessoa2.setEmail("maria@email.com");
        pessoa2.setIdade(25);
        pessoa2.setCpf("987.654.321-00");
        pessoa2.setDataNascimento(new Date());
        pessoaModel.create(pessoa2);

        // 2. Buscando todas as pessoas
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas: " + pessoas.size());

        // 3. Buscando pessoa por ID
        if (!pessoas.isEmpty()) {
            Pessoa primeiraPessoa = pessoas.get(0);
            Pessoa pessoaEncontrada = pessoaModel.findById(primeiraPessoa.getId());
            System.out.println("Pessoa encontrada: " + pessoaEncontrada.getNome());

            // 4. Atualizando pessoa
            pessoaEncontrada.setIdade(31);
            pessoaModel.update(pessoaEncontrada);

            // 5. Deletando pessoa
            pessoaModel.delete(pessoas.get(1));
        }
    }
}