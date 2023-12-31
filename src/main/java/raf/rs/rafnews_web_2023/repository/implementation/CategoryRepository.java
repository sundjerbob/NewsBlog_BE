package raf.rs.rafnews_web_2023.repository.implementation;


import raf.rs.rafnews_web_2023.model.Category;
import raf.rs.rafnews_web_2023.repository.api.CategoryRepositoryAPI;
import raf.rs.rafnews_web_2023.repository.mysql.MySQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository extends MySQLRepository implements CategoryRepositoryAPI {

    private static final String ENTITY_NAME = "category";

    @Override
    public List<Category> allCategories() {

        List<Category> allCategories = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDB_Connection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from " + ENTITY_NAME);
            while (resultSet.next()) {
                allCategories.add(
                        new Category(
                                resultSet.getInt(ColumnNames.ID.column_name),
                                resultSet.getString(ColumnNames.NAME.column_name),
                                resultSet.getString(ColumnNames.DESCRIPTION.column_name)
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return allCategories;
    }

    @Override
    public List<Category> categoriesForPage(int pageIndex, int pageSize) {
        List<Category> categoriesForPage = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDB_Connection();
            statement = connection.createStatement();
            int startIndex = pageIndex * pageSize;
            String sqlQuery = "SELECT * FROM " + ENTITY_NAME + " LIMIT " + startIndex + ", " + pageSize;
            resultSet = statement.executeQuery(sqlQuery);
            categoriesForPage = new ArrayList<>();
            while (resultSet.next()) {
                categoriesForPage.add(
                        new Category(
                                resultSet.getInt(ColumnNames.ID.column_name),
                                resultSet.getString(ColumnNames.NAME.column_name),
                                resultSet.getString(ColumnNames.DESCRIPTION.column_name)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return categoriesForPage;
    }


    @Override
    public Category addCategory(Category category) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getDB_Connection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + ENTITY_NAME + " " + CategoryRepositoryAPI.ColumnNames.buildColumnsInsertQuery() + " VALUES(?, ?)",
                    generatedColumns);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                category.setId(resultSet.getInt(CategoryRepositoryAPI.ColumnNames.ID.column_index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return category;
    }

    @Override
    public void deleteCategory(Category category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getDB_Connection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM " + ENTITY_NAME + " WHERE " + ColumnNames.ID.column_name + " = ?");
            preparedStatement.setInt(1, category.getId());
            int rows_changed = preparedStatement.executeUpdate();
            if (rows_changed < 1)
                throw new SQLException("delete category failed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeConnection(connection);
        }
    }

    @Override
    public Category searchCategoryByName(String name) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        try {
            connection = this.getDB_Connection();

            preparedStatement = connection.prepareStatement("SELECT * FROM " + ENTITY_NAME + " WHERE "
                    + ColumnNames.NAME + " = ?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                category = new Category(
                        resultSet.getInt(ColumnNames.ID.column_index),
                        resultSet.getString(ColumnNames.NAME.column_name),
                        resultSet.getString(ColumnNames.DESCRIPTION.column_name)
                );


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }

        return category;
    }

    @Override
    public Category searchCategoryById(int categoryId) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        try {
            connection = this.getDB_Connection();

            preparedStatement = connection.prepareStatement("SELECT * FROM " + ENTITY_NAME + " WHERE "
                    + ColumnNames.ID + " = ?");
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                category = new Category(
                        resultSet.getInt(ColumnNames.ID.column_index),
                        resultSet.getString(ColumnNames.NAME.column_name),
                        resultSet.getString(ColumnNames.DESCRIPTION.column_name)
                );


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }

        return category;
    }
}
