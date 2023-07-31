package teamgrouping.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Database 연결 후 Query 작업 수행
 */

public class query {
    /*  */
    public void doQuery() {
    }

    /* INSERT, DELETE query 수행 */
    public void queryUPDATE(BasicDataSource dataSource, String query) {
        try {
            // connection 설정
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            // query 작업 수행 & 업데이트된 레코드 수 계산
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("업데이트된 레코드 수: " + rowsAffected);
            pstmt.close();
        
        // 예외 처리
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /* SELECT query 수행 */
    public ResultSet querySELECT(BasicDataSource dataSource, String query) {
        // 변수 초기화
        ResultSet resultSet = null;
        try {
            // connection 설정
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            // query 작업 수행
            resultSet = pstmt.executeQuery();

        // 예외 처리
        } catch (SQLException exception) {
            exception.printStackTrace();   
        }

        // 반환
        return resultSet;
    }
}
