package teamgrouping.grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class grouping {
    /* 랜덤 조 편성 결과 리스트 반환 */
    public List<List<String>> make_team(String args[]) {
        // args 반환
        String listString = args[0];
        String groupSizeString = args[1];

        // parameter 가공
        String[] listStringSplit = listString.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(listStringSplit));
        int groupSize = Integer.parseInt(groupSizeString);

        // 리스트 셔플
        Collections.shuffle(list);

        // parameter 가공
        int membersCnt = list.size();
        int groupCnt = (int) Math.ceil((double) membersCnt / groupSize);

        // 랜덤 조 편성 및 결과 list 생성
        List<List<String>> groupList = new ArrayList<>();
        for (int i = 0; i < groupCnt; i++) {
            List<String> group = list.subList(i * groupSize, Math.min((i + 1) * groupSize, membersCnt));
            Collections.sort(group);
            groupList.add(group);
        }

        // 반환
        return groupList;
    }

}
