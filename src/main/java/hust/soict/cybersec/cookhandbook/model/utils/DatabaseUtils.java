package hust.soict.cybersec.cookhandbook.model.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private Connection connection;

    public DatabaseUtils(String dbUrl, String username, String password) throws SQLException {
        // Connect to the database using JDBC
        this.connection = DriverManager.getConnection(dbUrl, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    private ResultSet executeQuery(String query, Object[] params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);

        // Set parameters for prepared statement
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
        }

        return stmt.executeQuery();
    }

    private int executeUpdate(String query, Object[] params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);

        // Set parameters for the prepared statement
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
        }

        return stmt.executeUpdate();
    }

    public List<List<Object>> selectAll(String table) throws SQLException {
        String query = "SELECT * FROM " + table;
        ResultSet rs = executeQuery(query, null);

        List<List<Object>> result = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            List<Object> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            result.add(row);
        }

        return result;
    }

    public List<Object> selectOne(String table, int id) throws SQLException {
        String query = "SELECT * FROM " + table + " WHERE id = ?";
        ResultSet rs = executeQuery(query, new Object[]{id});

        if (rs.next()) {
            List<Object> row = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            return row;
        }

        return null;
    }

    public void insert(String table, String[] columns, Object[] values) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO " + table + " (");
        for (String column : columns) {
            query.append(column).append(", ");
        }
        query.setLength(query.length() - 2); // Remove last comma
        query.append(") VALUES (");
        for (int i = 0; i < values.length; i++) {
            query.append("?, ");
        }
        query.setLength(query.length() - 2); // Remove last comma
        query.append(")");

        executeUpdate(query.toString(), values);
    }

    public void update(String table, int id, String[] columns, Object[] values) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE " + table + " SET ");
        for (String column : columns) {
            query.append(column).append(" = ?, ");
        }
        query.setLength(query.length() - 2); // Remove last comma
        query.append(" WHERE id = ?");

        Object[] updatedValues = new Object[values.length + 1];
        System.arraycopy(values, 0, updatedValues, 0, values.length);
        updatedValues[values.length] = id;

        executeUpdate(query.toString(), updatedValues);
    }

    public void delete(String table, int id) throws SQLException {
        String query = "DELETE FROM " + table + " WHERE id = ?";
        executeUpdate(query, new Object[]{id});
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
