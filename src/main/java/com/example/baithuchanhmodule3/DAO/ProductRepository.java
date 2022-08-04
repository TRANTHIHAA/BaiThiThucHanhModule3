package com.example.baithuchanhmodule3.DAO;

import com.example.baithuchanhmodule3.connection.MyConnection;
import com.example.baithuchanhmodule3.model.Category;
import com.example.baithuchanhmodule3.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    private final MyConnection myConnection = new MyConnection();
    CategoryRepository categoryRepository = new CategoryRepository();
    private final String SELECT_PRODUCT_BY_NAME = "select * from product where name_p like ?" ;
    private final  String SELECT_ALL_PRODUCT = "select * from product";
    private final  String INSERT_PRODUCT = "insert into product(name_p,price,amount,color,describe_p,id_c) values (?,?,?,?,?,?)";
    private final  String UPDATE_PRODUCT = "update product set name_p = ?, price = ?, amount = ?,color = ?, describe_p = ?,id_c = ? " +
            "where id_p = ?";
    private final  String DELETE_PRODUCT_BY_ID = "delete from PRODUCT where id_p = ?";
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_p");
                String name_p = resultSet.getString("name_p");
               Double price = resultSet.getDouble("price");
               int amount = resultSet.getInt("amount");
               String color = resultSet.getString("color");
               String describe_p = resultSet.getString("describe_p");
               int id_c = resultSet.getInt("id_c");
                Category  category = categoryRepository.findById(id_c);
                Product product = new Product(id,name_p,price,amount,color,describe_p,category);
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
        return products;
    }

    public void create(Product product) {
        try {

            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6,product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }
    public ArrayList<Product> searchByLikeName(String name){
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_p");
                String name_book = resultSet.getString("name_p");
                String describe_book = resultSet.getString("describe_book");
                Double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
               String color = resultSet.getString("color");
                int id_c = resultSet.getInt("id_c");
                Category category = categoryRepository.findById(id_c);
               Product product = new Product(id,name,price,amount,color,describe_book,category);
               products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return products;
    }


    public void update(Product product) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6,product.getCategory().getId());
            preparedStatement.setInt(7,product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }
    }


}
