package id.ac.ui.cs.advprog.eshop.controller;


import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ReadService<Product> readService;
    @Autowired
    private CreateService<Product> createService;
    @Autowired
    private UpdateService<Product> updateService;
    @Autowired
    private DeleteService<Product> deleteService;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        createService.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = readService.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = readService.findById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        System.out.println(product.getProductId());
        updateService.update(product.getProductId(), product);
        return "redirect:list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId) {
        deleteService.deleteById(productId);
        return "redirect:list";
    }
}

@Controller
@RequestMapping("/car")
class CarController{

    @Autowired
    private CreateService<Car> createService;
    @Autowired
    private ReadService<Car> readService;
    @Autowired
    private UpdateService<Car> updateService;
    @Autowired
    private DeleteService<Car> deleteService;

    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        createService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model) {
        List<Car> allCars = readService.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = readService.findById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        System.out.println(car.getCarId());
        updateService.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId) {
        deleteService.deleteById(carId);
        return "redirect:listCar";
    }
}




