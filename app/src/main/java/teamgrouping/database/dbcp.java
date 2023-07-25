package teamgrouping.database;

// MODULE import
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

// DATABASE CONNECTION POOL setting
public class dbcp {

    // assume DATABASE is MYSQL on docker container
    // make DATASOURCE
    public static void MakeDataSource(String url, String username, String password) {
        BasicDataSource dataSource;

        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    // set DATASOURCE
    public static void SetDataSource(int MaxTotal, int MaxIdle, int MinIdle, int MaxWaitMillis) {
        dataSource.setMaxTotal(MaxTotal); // MAX CONNECTIONS COUNT
        dataSource.setMaxIdle(MaxIdle); // MAX MAINTAIN CONNECTIONS COUNT
        dataSource.setMinIdle(MinIdle); // MIN MAINTAIN CONNECTIONS COUNT
        dataSource.setMaxWaitMillis(MaxWaitMillis); // MAX TRIAL MILLISECONDS to get CONNECTION
    }

    // get CONNECTION
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
