package io.confluent;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionTest {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java -jar JdbcConnectionTest.jar CLASSNAME JDBCURL");
            System.exit(1);
        }
        String className = args[0];
        String jdbcUrl = args[1];
        System.out.println("className:" + className);
        System.out.println("jdbcUrl: " + jdbcUrl);
        Class<JdbcConnectionExample> klass = null;
        try {
            klass = (Class<JdbcConnectionExample>) Class.forName(className);
            JdbcConnectionExample jdbcConnectionExample = klass.getDeclaredConstructor().newInstance();
            Connection connection = jdbcConnectionExample.getConnection(jdbcUrl);
            Statement stmt = connection.createStatement();
            boolean ok = stmt.execute("SELECT 1;");
            if (ok) {
              System.out.println("CONNECTION OK!");
            };
        } catch (ClassNotFoundException|InvocationTargetException|InstantiationException|IllegalAccessException|NoSuchMethodException e) {
            System.err.println("Instantiation error: " + className);
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("createStatement() error: " + e.getMessage());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("General Exception: " + e.getMessage());
            System.exit(1);
        }
    }
}
