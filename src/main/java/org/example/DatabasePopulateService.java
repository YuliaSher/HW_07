package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static org.example.Database.getConnection;

public class DatabasePopulateService {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        try (InputStream stream = new FileInputStream("sql/populate_db.sql");
             Scanner scanner = new Scanner(stream)) {

            StringBuilder sql = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sql.append(line).append("\n");
                if (line.trim().endsWith(";")) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
                    preparedStatement.executeUpdate();
                    sql = new StringBuilder();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }
}
