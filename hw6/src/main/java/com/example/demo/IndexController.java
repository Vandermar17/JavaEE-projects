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
    private  BookService bookService;




    @RequestMapping({"/",""})
    public String index(){
        return "index";
    }



    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String booksList( Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }



    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book) {
       bookService.createBook(book.getName(),book.getIsbn(),book.getAuthor());
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String addNewBook(
            @PathVariable("id") Integer id,
            Model model
    ) {
        model.addAttribute("book",bookService.findByID(id));
        return "book-description";
    }
}
