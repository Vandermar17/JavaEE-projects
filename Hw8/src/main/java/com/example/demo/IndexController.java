package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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



//    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
//    public String booksList( Model model) {
//        model.addAttribute("books", bookRepository.findAll());
//        return "index";
//    }



    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public ResponseEntity<String> addNewBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String addNewBook(
            @PathVariable("id") Integer id,
            Model model
    ) {
        model.addAttribute("book",bookRepository.findById(id));
        return "book-description";
    }


    @ResponseBody
    @RequestMapping(value = "/search-book-by-isbn", method = RequestMethod.POST)
    public List<Book> searchBookByIsbn( @RequestBody Book book) {
        return bookRepository.findAllByIsbn(book.getIsbn());
    }


    @ResponseBody
    @RequestMapping(value = "/search-book-by-name", method = RequestMethod.POST)
    public List<Book> searchBookByName(@RequestBody Book book) {
        return bookRepository.findAllByName(book.getName());
    }

    @ResponseBody
    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
   public List<Book> booksList() {
        return bookRepository.findAll();
    }
}
