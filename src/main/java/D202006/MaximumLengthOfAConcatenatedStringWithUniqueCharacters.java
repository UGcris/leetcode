package D202006;

import java.util.Arrays;
import java.util.List;

/**
 * @Author UGcris
 * @date 2020/6/13
 **/
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    int ans = 0;

    public int maxLength(List<String> arr) {
        find("", arr, 0);
        return ans;
    }

    private void find(String str, List<String> arr, int index) {
        ans = Math.max(ans, str.length());
        for (int i = index; i < arr.size(); i++) {
            String subString = arr.get(i);
            if (subString.isEmpty()) {
                continue;
            }
            subString += str;
            char[] chars = subString.toCharArray();
            Arrays.sort(chars);
            boolean isOverlap = false;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == chars[j - 1]) {
                    isOverlap = true;
                    break;
                }
            }
            if (isOverlap) {
                continue;
            }
            find(subString, arr, i);
        }
    }
}
