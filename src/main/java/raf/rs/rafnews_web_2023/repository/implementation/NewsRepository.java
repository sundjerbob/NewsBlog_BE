package raf.rs.rafnews_web_2023.repository.implementation;


import raf.rs.rafnews_web_2023.model.News;
import raf.rs.rafnews_web_2023.repository.api.NewsRepositoryAPI;
import raf.rs.rafnews_web_2023.repository.mysql.MySQLRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NewsRepository extends MySQLRepository implements NewsRepositoryAPI {


    private static final String ENTITY_NAME = "news";


    @Override
    public List<News> allNews() {

        List<News> allNews = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDB_Connection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + ENTITY_NAME);
            allNews = new ArrayList<>();
            while (resultSet.next()) {
                News news = new News(
                        resultSet.getInt(ColumnNames.ID.column_index),
                        resultSet.getString(ColumnNames.TITLE.column_name),
                        resultSet.getString(ColumnNames.CONTENT.column_name),
                        resultSet.getInt(ColumnNames.VISITED.column_name),
                        resultSet.getTimestamp(ColumnNames.CREATION_TIME.column_name),
                        resultSet.getInt(ColumnNames.AUTHOR_ID.column_name),
                        resultSet.getInt(ColumnNames.CATEGORY_ID.column_name)
                );
                allNews.add(news);
                System.out.println(news.getCreationTime());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return allNews;
    }

    @Override
    public List<News> newsForPage(int pageIndex, int pageSize) {
        List<News> newsForPage = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDB_Connection();
            statement = connection.createStatement();
            int startIndex = pageIndex * pageSize;
            String sqlQuery = "SELECT * FROM " + ENTITY_NAME + " LIMIT " + startIndex + ", " + pageSize;
            resultSet = statement.executeQuery(sqlQuery);
            newsForPage = new ArrayList<>();
            while (resultSet.next()) {
                newsForPage.add(
                        new News(
                                resultSet.getInt(ColumnNames.ID.column_index),
                                resultSet.getString(ColumnNames.TITLE.column_name),
                                resultSet.getString(ColumnNames.CONTENT.column_name),
                                resultSet.getInt(ColumnNames.VISITED.column_name),
                                resultSet.getTimestamp(ColumnNames.CREATION_TIME.column_name),
                                resultSet.getInt(ColumnNames.AUTHOR_ID.column_name),
                                resultSet.getInt(ColumnNames.CATEGORY_ID.column_name)
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
        return newsForPage;
    }

    @Override
    public List<News> newsInCategory(int categoryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<News> newsInCategory = null;
        try {
            connection = this.getDB_Connection();

            preparedStatement = connection.prepareStatement("SELECT * FROM " + ENTITY_NAME + " WHERE " + ColumnNames.CATEGORY_ID + " = ?");
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();
            newsInCategory = new ArrayList<>();

            while (resultSet.next()) {
                newsInCategory.add(
                        new News(
                                resultSet.getInt(ColumnNames.ID.column_index),
                                resultSet.getString(ColumnNames.TITLE.column_name),
                                resultSet.getString(ColumnNames.CONTENT.column_name),
                                resultSet.getInt(ColumnNames.VISITED.column_name),
                                Timestamp.valueOf(resultSet.getString(ColumnNames.CREATION_TIME.column_name)),
                                resultSet.getInt(ColumnNames.AUTHOR_ID.column_name),
                                resultSet.getInt(ColumnNames.CATEGORY_ID.column_name)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }

        return newsInCategory;
    }


    @Override
    public News addNews(News news) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getDB_Connection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + ENTITY_NAME + "  " + ColumnNames.buildColumnsInsertQuery() + " VALUES(?, ?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setInt(3, news.getAuthorId());
            preparedStatement.setInt(4, news.getCategoryId());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                news.setId(resultSet.getInt(ColumnNames.ID.column_index));
            } else
                throw new RuntimeException("adding user failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(preparedStatement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return news;
    }

    @Override
    public News findById(int newsId) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getDB_Connection();
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM " + ENTITY_NAME + " WHERE " + ColumnNames.ID + " = " + newsId;

            resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {

                return new News(
                        resultSet.getInt(ColumnNames.ID.column_index),
                        resultSet.getString(ColumnNames.TITLE.column_name),
                        resultSet.getString(ColumnNames.CONTENT.column_name),
                        resultSet.getInt(ColumnNames.VISITED.column_name),
                        resultSet.getTimestamp(ColumnNames.CREATION_TIME.column_name),
                        resultSet.getInt(ColumnNames.AUTHOR_ID.column_name),
                        resultSet.getInt(ColumnNames.CATEGORY_ID.column_name)

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
            closeConnection(connection);
        }
        return null;
    }


}