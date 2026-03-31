package br.sayu.livraria.controller;

import br.sayu.livraria.bo.*;
import br.sayu.livraria.model.Livro;
import java.util.List;

public class BibliotecaController {

    private LivroBO livroBO = new LivroBO();
    private EmprestimoBO emprestimoBO = new EmprestimoBO();

    public String cadastrarLivro(String titulo, String autor) {
        try {
            livroBO.cadastrar(titulo, autor);
            return "Livro cadastrado com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Livro> listarDisponiveis() {
        return livroBO.listarDisponiveis();
    }

    public String emprestarLivro(int id, String leitor) {
        try {
            emprestimoBO.realizarEmprestimo(id, leitor);
            return "Empréstimo realizado com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String devolverLivro(int id) {
        try {
            emprestimoBO.devolverLivro(id);
            return "Livro devolvido com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}