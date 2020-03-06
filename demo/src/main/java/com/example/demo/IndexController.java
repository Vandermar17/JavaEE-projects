package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private  List<Book> books;

    IndexController(){
        books=new ArrayList<>();
    }



    @RequestMapping({"/",""})
    public String index(){
        return "index";
    }



    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String booksList( Model model) {
        model.addAttribute("books", books);
        return "index";
    }



    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addNewBook(
                             @ModelAttribute Book book
    ) {
        System.out.println(book.toString());
       books.add(book);
        return "redirect:/books-list";
    }
}
