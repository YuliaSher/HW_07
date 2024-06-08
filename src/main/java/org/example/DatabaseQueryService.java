package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Database.getConnection;

public class DatabaseQueryService {

    public static void main(String[] args) throws SQLException {
        DatabaseQueryService data = new DatabaseQueryService();
        List<LongestProjectCount> longestProject = data.findLongestProject();
        List<MaxProjectCountClient> maxProjectsClient = data.findMaxProjectsClient();
        List<MaxSalaryCountWorker> maxSalaryWorker = data.findMaxSalaryWorker();
        List<YoungestEldestWorker> youngestEldestWorker = data.findYoungestEldestWorker();
        List<ProjectPrices> projectPrices = data.calculateAllProjectPrices();

        longestProject.forEach(System.out::println);
        System.out.println("________________________________________");
        maxProjectsClient.forEach(System.out::println);
        System.out.println("________________________________________");
        maxSalaryWorker.forEach(System.out::println);
        System.out.println("________________________________________");
        youngestEldestWorker.forEach(System.out::println);
        System.out.println("________________________________________");
        projectPrices.forEach(System.out::println);
        System.out.println("________________________________________");

    }

    public List<LongestProjectCount> findLongestProject() throws SQLException {
        List<LongestProjectCount> result = new ArrayList<>();
        Connection connection = getConnection();
        String fileLongestProjectSQL = "sql/find_longest_project.sql";
        try (InputStream stream = new FileInputStream(fileLongestProjectSQL);
             Scanner scanner = new Scanner(stream)) {

            StringBuilder sql = getStringBuilder(scanner);
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new LongestProjectCount(
                        resultSet.getString("NAME"),
                        resultSet.getInt("MONTH_COUNT")));
            }
            resultSet.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (SQLException e) {
            System.out.println("Some problems in SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Some problems in IO" + e.getMessage());
        }
        connection.close();

        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();
        Connection connection = getConnection();
        String fileMaxProjectClientSQL = "sql/find_max_projects_client.sql";
        try (InputStream stream = new FileInputStream(fileMaxProjectClientSQL);
             Scanner scanner = new Scanner(stream)) {

            StringBuilder sql = getStringBuilder(scanner);
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new MaxProjectCountClient(
                        resultSet.getString("NAME"),
                        resultSet.getInt("PROJECT_COUNT")));
            }
            resultSet.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (SQLException e) {
            System.out.println("Some problems in SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Some problems in IO" + e.getMessage());
        }
        connection.close();

        return result;
    }

    public List<MaxSalaryCountWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryCountWorker> result = new ArrayList<>();
        String maxSalaryWorkerSQL = "sql/find_max_salary_worker.sql";
        Connection connection = getConnection();
        try (InputStream stream = new FileInputStream(maxSalaryWorkerSQL);
             Scanner scanner = new Scanner(stream)) {

            StringBuilder sql = getStringBuilder(scanner);
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new MaxSalaryCountWorker(
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("salary")));
            }
            resultSet.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Some problems in IO" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Some problems in SQL: " + e.getMessage());
        }
        connection.close();
        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() throws SQLException {
        List<YoungestEldestWorker> result = new ArrayList<>();
        String fileYoungestEldestWorkerSQL = "sql/find_youngest_eldest_workers.sql";
        Connection connection = getConnection();
        try (InputStream stream = new FileInputStream(fileYoungestEldestWorkerSQL);
             Scanner scanner = new Scanner(stream)) {
            StringBuilder sql = getStringBuilder(scanner);
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            String type = "";
            String name = "";
            Date rawDate = null;
            LocalDate birthday = null;
            while (resultSet.next()) {
                type = resultSet.getString("type");
                name = resultSet.getString("name");
                rawDate = resultSet.getDate("birthday");
                birthday = rawDate.toLocalDate();
                result.add(new YoungestEldestWorker(type, name, birthday));
            }
            resultSet.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Some problems in IO" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Some problems in SQL: " + e.getMessage());
        }
        connection.close();
        return result;
    }

    public List<ProjectPrices> calculateAllProjectPrices() throws SQLException {
        List<ProjectPrices> result = new ArrayList<>();
        String fileProjectPriceSQL = "sql/print_project_prices.sql";
        Connection connection = getConnection();
        try (InputStream stream = new FileInputStream(fileProjectPriceSQL);
             Scanner scanner = new Scanner(stream)){
            StringBuilder sql = getStringBuilder(scanner);
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new ProjectPrices(
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("PRICE")
                ));
            }
            resultSet.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Some problems in IO" + e.getMessage());
        }catch (SQLException e){
            System.out.println("Some problems in SQL: " + e.getMessage());
        }
        connection.close();
        return result;
    }

    private static StringBuilder getStringBuilder(Scanner scanner) {
        StringBuilder sql = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sql.append(line).append("\n");
        }
        return sql;
    }
}
