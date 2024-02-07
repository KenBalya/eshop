package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return "redirect:list";
    }
    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product, Model model) {
        Product existingProduct = service.findById(id);
        if (existingProduct != null) {
            service.updateProduct(id, product);
        }
        // handle the case where the product does not exist
        return "redirect:/product/list";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = service.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "updateProduct";
        } else {
            // Product not found, redirect to error page with a message
            redirectAttributes.addAttribute("message", "Product not found for ID: " + id);
            return "redirect:/error";
        }
    }

}
