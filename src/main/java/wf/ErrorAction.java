package wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ErrorAction {
    public static String[] findUserId(String[][] actions, String str) {
        HashMap<String, String> userMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String action[] : actions) {
            if (!userMap.containsKey(action[1]))
                userMap.put(action[1], action[0]);
            else {
                userMap.put(action[1], userMap.get(action[1]) + action[0]);
            }
        }
        for (String key : userMap.keySet()) {
            int len = 0, i = 0;
            String action = userMap.get(key);
            while (len < str.length() && i < action.length()) {
                if (str.charAt(len) == action.charAt(i)) {
                    len++;
                }
                i++;
            }
            if (len == str.length())
                result.add(key);

        }
        String[] resultArr = result.toArray(String[]::new);
        return resultArr;
    }

    public static void main(String[] args) {
        String[][] actions = {{"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "1"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"},};
        System.out.println(Arrays.toString(findUserId(actions, "ABC")));
        String[][] actions1 = {{"A", "1"},
                {"A", "1"},
                {"A", "1"},
                {"B", "1"},
                {"B", "2"},
                {"C", "2"},
                {"C", "2"},
                {"C", "3"},
                {"A", "2"},
                {"A", "3"},
                {"A", "2"},
                {"B", "2"},
                {"C", "2"}};
        System.out.println(Arrays.toString(findUserId(actions1, "BAC")));

    }
}
