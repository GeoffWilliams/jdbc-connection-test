package io.confluent;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.util.Properties;

public class MyExample implements JdbcConnectionExample {
    @Override
    public Connection getConnection(String jdbcUrl) throws Exception {
        Properties properties = new Properties();
        SQLServerDriver driver = new SQLServerDriver();
        return driver.connect(jdbcUrl, properties);
    }
}
