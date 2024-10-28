package com.example.Six_Java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Six_Java.Models.Book;
import com.example.Six_Java.Repository.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository books;
	@PostMapping("/books/add")
	public String addBook(Book book)
	{
		books.save(book);
		return "redirect:/books/display";
	}
	
	@GetMapping("/books/display")
	public String displayBook(Model model)
	{
		List<Book> book_list=(List<Book>)books.findAll();
		model.addAttribute("books",book_list);
		return "display";
	}
	
	@GetMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id")Integer id)
	{
		books.deleteById(id);
		return "redirect:/books/display";
	}
	
	@GetMapping("/books/update/{id}")
	public String showBook(@PathVariable("id")Integer id,Model model)
	{
		Book book=books.findById(id).orElse(null);
		model.addAttribute("book",book);
		return "update";
	}
	@PostMapping("/books/update/{id}")
	public String updateBook(@PathVariable("id")Integer id,Book updatedBook)
	{
		updatedBook.setId(id);
		books.save(updatedBook);
		return "redirect:/books/display";
	}
}
