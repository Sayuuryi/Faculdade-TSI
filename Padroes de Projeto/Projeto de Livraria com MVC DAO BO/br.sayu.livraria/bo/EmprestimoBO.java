package br.sayu.livraria.bo;

import br.sayu.livraria.dao.*;
import br.sayu.livraria.model.*;

public class EmprestimoBO {

    private LivroDAO livroDAO = new LivroMemoryDAO();
    private EmprestimoDAO emprestimoDAO = new EmprestimoMemoryDAO();

    public void realizarEmprestimo(int idLivro, String leitor) throws Exception {
        Livro livro = livroDAO.buscarPorId(idLivro);

        if (livro == null)
            throw new Exception("Livro não encontrado");

        if (!livro.isDisponivel())
            throw new Exception("Livro já está emprestado");

        livro.setDisponivel(false);
        livroDAO.atualizar(livro);

        Emprestimo e = new Emprestimo(idLivro, leitor);
        emprestimoDAO.salvar(e);
    }

    public void devolverLivro(int idLivro) throws Exception {
        Livro livro = livroDAO.buscarPorId(idLivro);

        if (livro == null)
            throw new Exception("Livro não encontrado");

        if (livro.isDisponivel())
            throw new Exception("Livro já está disponível");

        livro.setDisponivel(true);
        livroDAO.atualizar(livro);
    }
}