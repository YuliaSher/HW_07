package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.SQLException;

@UtilityClass
public class Database {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5437/";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "Julia";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(DATABASE_URL);
        config.setUsername(DATABASE_USER);
        config.setPassword(DATABASE_PASSWORD);
        ds = new HikariDataSource(config);
    }

        public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
