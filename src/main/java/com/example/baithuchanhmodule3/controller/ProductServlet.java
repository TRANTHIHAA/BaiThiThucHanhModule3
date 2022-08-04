package com.example.baithuchanhmodule3.controller;

import com.example.baithuchanhmodule3.DAO.CategoryRepository;
import com.example.baithuchanhmodule3.model.Category;
import com.example.baithuchanhmodule3.model.Product;
import com.example.baithuchanhmodule3.service.CategoryService;
import com.example.baithuchanhmodule3.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProductGet(request,response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
//            case "update":

//                break;

            default:
                ArrayList<Product> products = productService.findAll();
                displayAllBook(products,request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBookPost(request,response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
//            case "update":

//                break;
            case "searchProductByName":
                searchProductByName(request,response);
                break;
        }
    }

    private void displayAllBook(ArrayList<Product> products,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        productService.deleteById(id);
        response.sendRedirect("/productServlet?action=");

    }
    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        String likeName = "%"+name+"%";
        ArrayList<Product> products =  productService.findBookByName(likeName);
        if (products.isEmpty()){
            request.setAttribute("messager","Khong co thong tin!");
            ArrayList<Product> products1 = productService.findAll();
            displayAllBook(products1,request,response);
        }else {
            displayAllBook(products,request,response);
        }
    }
    private void createProductGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        ArrayList<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        requestDispatcher.forward(request, response);
    }
    private void createBookPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        int id_c = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.findById(id_c);
        Product product = new Product(name,price,amount,color,describe,category);
        productService.create(product);
        response.sendRedirect("/productServlet?action=");
    }

}
