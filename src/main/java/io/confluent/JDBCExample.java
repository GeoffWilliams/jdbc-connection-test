package io.confluent;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCExample implements  JdbcConnectionExample{
    @Override
    public Connection getConnection(String jdbcUrl) throws Exception {
        DriverManager.registerDriver(new SQLServerDriver());
        return DriverManager.getConnection(jdbcUrl);

    }
}
