import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        // 인트배열을 가진 리스트를 생성
        List<int[]> list = new ArrayList<int[]>();

        // list를 초기화 - 0번째 인덱스는 우선순위, 1번째 인덱스는 위치
        for(int i = 0; i < priorities.length; i++) {
            list.add(new int[] {priorities[i], i});
        }

        int t = 1;
        while(true) {
            boolean chk = false;
            int[] tmp = list.get(0);
            // tmp[0] : 우선순위
            // tmp[1] : 인덱스
            list.remove(0);

            // 리스트의 0번째 인덱스보다 큰값이 존재하는지 확인
            for(int i = 0; i < list.size(); i++) {
                if(tmp[0] < list.get(i)[0]) {
                    list.add(tmp);      // 0번째 인덱스보다 우선순위가 높은 값이 있을경우 다시 add
                    chk = true;
                    break;
                }
            }

            // chk가 false일 경우 즉, tmp의 값이 우선순위가 가장 높을 때, location과 인덱스를 비교
            if(!chk) {
                if(tmp[1] == location) {
                    answer = t;
                    break;
                }
                t++;
            }
        }

        return answer;
    }
}
