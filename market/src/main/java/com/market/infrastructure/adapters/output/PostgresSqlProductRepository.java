package com.market.infrastructure.adapters.output;

import com.market.infrastructure.LogSystem.Log;
import com.market.infrastructure.models.ProductDAO;
import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostgresSqlProductRepository implements ProductRepository {
    private final DataSource dataSource;

    public PostgresSqlProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void store(Product product) {
        String sql = "INSERT INTO product (name,description,price) values (?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName().getValue().trim());
            preparedStatement.setString(2,product.getDescription().getValue().trim());
            preparedStatement.setInt(3,product.getPrice().getValue().intValue());
            preparedStatement.execute();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error in the query ",ex);
        }
    }

    @Override
    public Optional<Product> get(ProductId productId) {
        String sql = "select * from product where id = ? ";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,productId.getValue().intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                ProductDAO productDAO = ProductDAO.fromResulSet(resultSet);
                Product product = productDAO.toDomain();
                return Optional.of(product);
            }
            else{
                return Optional.of(null);
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error in the query ",ex);
        }
    }

    @Override
    public List<ProductDTO> queryAll() {
        String sql = "select * from product ";
        try(Connection connection = dataSource.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            if(resultSet.next()){
                while (resultSet.next()){
                    ProductDAO productDAO = ProductDAO.fromResulSet(resultSet);
                    products.add(productDAO.toDomain());
                }
                List<ProductDTO> productDTOList = products.stream().map((prod)-> ProductDTO.fromDomain(prod)).toList();
                return productDTOList;
            }
            else{
                return new ArrayList<>();
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error in the query ",ex);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product set name = ?, price= ?,  description = ? where product.id = ?";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName().getValue());
            preparedStatement.setInt(2, product.getPrice().getValue().intValue());
            preparedStatement.setString(3, product.getDescription().getValue());
            preparedStatement.setInt(4, product.getId().getValue().intValue());
            preparedStatement.execute();

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error in the query ",ex);
        }
        catch (Exception e){
            Log log = new Log(e.getMessage(),"Error in the query");
            log.logger();
            throw new RuntimeException("Error in the query database ",e);
        }
    }

    @Override
    public Boolean delete(ProductId productId) {
        System.out.println(productId.getValue());
        String sql = "DELETE FROM product where product.id = ?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,productId.getValue().intValue());
            preparedStatement.execute();
            return true;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error in the query ",ex);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error in the query ",e);
        }
    }
}
