package io.confluent;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;

import java.sql.Connection;

public interface JdbcConnectionExample {
    Connection getConnection(String jdbcUrl) throws Exception;
}
