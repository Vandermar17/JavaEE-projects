package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private  BookRepository bookRepository;


    @RequestMapping({"/",""})
    public String index(Model model){
        model.addAttribute("isbn_search",null);
        model.addAttribute("name_search",null);
        return "index";
    }



    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String booksList( Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }



    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String addNewBook(
            @PathVariable("id") Integer id,
            Model model
    ) {
        model.addAttribute("book",bookRepository.findById(id));
        return "book-description";
    }


    @RequestMapping(value = "/search-book-by-isbn", method = RequestMethod.POST)
    public String searchBookByIsbn( String isbn,Model model) {
        model.addAttribute("isbn_search",bookRepository.findBookByIsbn(isbn));
        return "index";
    }


    @RequestMapping(value = "/search-book-by-name", method = RequestMethod.POST)
    public String searchBookByName(String name, Model model) {
        model.addAttribute("name_search",bookRepository.findBookByName(name));
        return "index";
    }
}
