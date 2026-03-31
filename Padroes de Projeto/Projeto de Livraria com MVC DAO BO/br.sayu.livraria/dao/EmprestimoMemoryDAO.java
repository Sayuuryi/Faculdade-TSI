package br.sayu.livraria.dao;

import br.sayu.livraria.model.Emprestimo;
import java.util.*;

public class EmprestimoMemoryDAO implements EmprestimoDAO {

    private static List<Emprestimo> dados = new ArrayList<>();
    private static int sequenciaId = 1;

    @Override
    public void salvar(Emprestimo e) {
        e.setId(sequenciaId++);
        dados.add(e);
    }

    @Override
    public List<Emprestimo> listar() {
        return dados;
    }
}