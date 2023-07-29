package com.jspider.springApp.HomeController;



import com.jspider.springApp.domain.Book;
import com.jspider.springApp.domain.Laptop;
import com.jspider.springApp.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    List<Book>  bookList=new ArrayList<>();

    {
        bookList.add(new Book(101,"Java",2000.0));
        bookList.add(new Book(102,"J2EE",3000.0));
        bookList.add(new Book(103,"Spring",4000.0));
        bookList.add(new Book(104,"Spring",4000.0));
        bookList.add(new Book(105,"lenovo",400.0));
    }

    List<Stock>  stockList=new ArrayList<>();

    {
        stockList.add(new Stock(101,"TATA",2000.0,2200.0));
        stockList.add(new Stock(102,"J2EE",3000.0,2000.0));
        stockList.add(new Stock(103,"Spring",4000.0,5000.0));
        stockList.add(new Stock(103,"lenovo",4000.0,3000.0));
        stockList.add(new Stock(103,"HP",6000.0,5000.0));
    }

    @GetMapping("/welcome")
    public  String getMessage(){
        return "welcome";
    }

    @GetMapping("/laptop")
    public String getLaptops(Model model) {
      Laptop l1=new Laptop("Hp",200000.0);
      model.addAttribute("laptops",l1);
      return "laptop";
    }

    @GetMapping("/book")
     public String getBooks(Model model)
     {
      model.addAttribute("books",bookList);
         return "book";
     }

     @GetMapping("/stock")
    public String getStock(Model model)
     {
         model.addAttribute("stocks",stockList);
         return "stock";
     }
     //show stock form
     @GetMapping("/stockform")
     public String showStockFrom(Model model)
     {
         model.addAttribute("stock",new Stock());
         return "stockform";
     }

     //add stock into list
    @PostMapping("/savestock")
    public String addStock(Stock stock)
    {
        stockList.add(stock);
        return "redirect:/stock";
    }

    @GetMapping("/bookform")
    public String showBookFrom(Model model){
        model.addAttribute("book",new Book());
        return "bookform";
    }

    @PostMapping("/savebook")
    public  String addBook(Book book){
        bookList.add(book);
        return "redirect:/book";
    }
}
