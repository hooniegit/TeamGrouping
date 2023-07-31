package teamgrouping.grouping;

import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import teamgrouping.grouping.grouping;
import teamgrouping.database.query;
import teamgrouping.database.dbcp;

public class thread {
    // 각 클래스에 해당하는 인스턴스 생성
    public grouping groupingInstance = new grouping();
    public query queryInstance = new query();
    public dbcp dbcpInstance = new dbcp();

    public void runTread(String[] args) {
        Runnable task = () -> {
            String tName = Thread.currentThread().getName();

            // Thread 번호 당 시작 - GROUPING
            System.out.println(tName + " : GROUPING : Thread start >>>>>>>>>>>");
            List<List<String>> lists = groupingInstance.make_team(args);
            System.out.println(tName + " : GROUPING : Thread end");

            // DBCP connection 설정
            String url = "";
            String username = "root";
            String password = "1234";
            BasicDataSource bds = dbcpInstance.MakeDataSource(url, usename, password);
            int MaxTotal = 140;
            int InitialSize = 50;
            int MinIdle = 25;
            dbcpInstance.SetDataSource(bds, MaxTotal, InitialSize, MinIdle);

            // Thread 번호 당 시작 - INSERT
            System.out.println(tName + " : INSERT : Thread start >>>>>>>>>>");
            // 반복문
            for (List<String> row : lists) {
                for (String value : row) {
                    String group = value;
                    // QUERY 생성
                    String QUERY = "INSERT INTO grouping (group) VALUES " + group;
                    // DATABASE 업데이트
                    queryInstance.queryUPDATE(bds, QUERY);
                }
            }
            System.out.println(tName + " : INSERT : Thread end <<<<<<<<<<<");
        };

        // THREADS 생성
        List<Thread> threads = new ArrayList<>();

        // threadCount 만큼 반복 수행
        for(int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(task);
            thread.setName("groupingThread-" + i);
            threads.add(thread);
            thread.start();
        }
    }
}
