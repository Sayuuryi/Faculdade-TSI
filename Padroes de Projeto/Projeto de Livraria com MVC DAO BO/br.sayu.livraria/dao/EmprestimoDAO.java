package br.sayu.livraria.dao;

import br.sayu.livraria.model.Emprestimo;
import java.util.List;

public interface EmprestimoDAO {
    void salvar(Emprestimo e);
    List<Emprestimo> listar();
}