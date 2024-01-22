package io.confluent;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;

// https://learn.microsoft.com/en-us/azure/app-service/tutorial-connect-msi-azure-database?tabs=sqldatabase-sc%2Cuserassigned-sc%2Cjava%2Cdotnet-mysql-mi%2Cdotnet-postgres-mi%2Cwindowsclient
public class MicrosoftExample implements JdbcConnectionExample{
    public Connection getConnection(String jdbcUrl) throws Exception {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setURL(jdbcUrl);
        return ds.getConnection();
    }
}
