package br.sayu.livraria.dao;

import br.sayu.livraria.model.Livro;
import java.util.List;

public interface LivroDAO {
    void salvar(Livro livro);
    Livro buscarPorId(int id);
    List<Livro> listar();
    void atualizar(Livro livro);
    void excluir(int id);
}