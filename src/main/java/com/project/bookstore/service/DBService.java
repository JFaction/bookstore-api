package com.project.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.Categoria;
import com.project.bookstore.domain.Livro;
import com.project.bookstore.repositories.CategoriaRepository;
import com.project.bookstore.repositories.LivroRepository;

@Service
public class DBService {

    @Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

    
    public void instaciaBaseDeDados(){
        
        Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivro().addAll(Arrays.asList(l1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
    }
}
