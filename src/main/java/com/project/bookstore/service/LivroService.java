package com.project.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.Livro;
import com.project.bookstore.repositories.LivroRepository;
import com.project.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Livro não encontrado! Id:" + id + ", Tipo: " + Livro.class.getName()));

    }
}