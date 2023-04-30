package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.Categoria;
import com.project.bookstore.dtos.CategoriaDTO;
import com.project.bookstore.repositories.CategoriaRepository;
import com.project.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null); //setar o Id como nulo para não ter problema na hora de fazer a inserção no BD
        return repository.save(obj);
    }


    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.project.bookstore.service.exceptions
            .DataIntegrityViolationException("Categoria não pode ser deletada! Possuí livros vinculados");        }
    }

}
