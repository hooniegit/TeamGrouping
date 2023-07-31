package teamgrouping.database;

import org.apache.commons.dbcp2.BasicDataSource;

public class dbcp {
    /* datasource 생성 */
    public static BasicDataSource MakeDataSource(String url, String username, String password) {
        // 변수 초기화
        BasicDataSource dataSource = new BasicDataSource();

        // 변수 내부값 설정
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 반환
        return dataSource;
    }

    /* datasource 특성치 설정 */
    public static void SetDataSource(BasicDataSource dataSource, int MaxTotal, int InitialSize, int MinIdle) {
        dataSource.setMaxTotal(MaxTotal); // MAX CONNECTIONS COUNT
        dataSource.setInitialSize(InitialSize);
        // dataSource.setMaxIdle(MaxIdle); // MAX MAINTAIN CONNECTIONS COUNT
        dataSource.setMinIdle(MinIdle); // MIN MAINTAIN CONNECTIONS COUNT
        // dataSource.setMaxWaitMillis(MaxWaitMillis); // MAX TRIAL MILLISECONDS to get CONNECTION
    }

    /* datasource connection 반환 */
    // public static Connection getConnection(BasicDataSource dataSource) throws SQLException {
    //     return dataSource.getConnection();
    // }

}
