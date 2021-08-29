package com.sidneydev.letterstore; // Autor: Sidney Bispo

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sidneydev.letterstore.domain.Categoria;
import com.sidneydev.letterstore.domain.Livro;
import com.sidneydev.letterstore.repositories.CategoriaRepository;
import com.sidneydev.letterstore.repositories.LivroRepository;

@SpringBootApplication
public class LetterstoreApplication implements CommandLineRunner{
	
	@Autowired
    private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(LetterstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
