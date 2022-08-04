package com.example.baithuchanhmodule3.DAO;

import com.example.baithuchanhmodule3.connection.MyConnection;
import com.example.baithuchanhmodule3.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryRepository {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL_CATEGORY="select*from category ";
    private final  String SELECT_CATEGORY_BY_ID = "select * from category where id_c = ?";
    public Category findById(int id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String category = resultSet.getString("name_c");

                return new Category(id,category);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public ArrayList<Category> findAll(){
        ArrayList<Category> categories = new ArrayList<>();
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String category_name = resultSet.getString("nameCategory");
                Category category = new Category(id,category_name);
                categories.add(category);

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return categories;
    }
}
