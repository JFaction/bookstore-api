package com.project.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.bookstore.domain.Categoria;
import com.project.bookstore.domain.Livro;
import com.project.bookstore.repositories.CategoriaRepository;
import com.project.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}