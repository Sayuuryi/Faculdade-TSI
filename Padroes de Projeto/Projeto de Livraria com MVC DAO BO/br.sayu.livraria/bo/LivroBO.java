package br.sayu.livraria.bo;

import br.sayu.livraria.dao.*;
import br.sayu.livraria.model.Livro;
import java.util.List;

public class LivroBO {

    private LivroDAO livroDAO = new LivroMemoryDAO();

    public void cadastrar(String titulo, String autor) throws Exception {
        if (titulo == null || titulo.isBlank())
            throw new Exception("Título não pode ser vazio");

        livroDAO.salvar(new Livro(titulo, autor));
    }

    public List<Livro> listarDisponiveis() {
        return livroDAO.listar()
                .stream()
                .filter(Livro::isDisponivel)
                .toList();
    }

    public void excluir(int id) throws Exception {
        Livro livro = livroDAO.buscarPorId(id);

        if (livro == null)
            throw new Exception("Livro não encontrado");

        if (!livro.isDisponivel())
            throw new Exception("Livro emprestado não pode ser excluído");

        livroDAO.excluir(id);
    }
}