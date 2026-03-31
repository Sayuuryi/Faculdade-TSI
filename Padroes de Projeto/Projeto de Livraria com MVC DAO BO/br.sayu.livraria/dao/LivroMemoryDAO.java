package br.sayu.livraria.dao;

import br.sayu.livraria.model.Livro;
import java.util.*;

public class LivroMemoryDAO implements LivroDAO {

    private static List<Livro> dados = new ArrayList<>();
    private static int sequenciaId = 1;

    @Override
    public void salvar(Livro livro) {
        livro.setId(sequenciaId++);
        dados.add(livro);
    }

    @Override
    public Livro buscarPorId(int id) {
        return dados.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Livro> listar() {
        return dados;
    }

    @Override
    public void atualizar(Livro livro) {
        // Como é memória, o objeto já está atualizado por referência
    }

    @Override
    public void excluir(int id) {
        dados.removeIf(l -> l.getId() == id);
    }
}