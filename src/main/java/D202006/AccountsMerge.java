package D202006;

import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * <p>
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * <p>
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * <p>
 * 例子 1:
 * <p>
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * 第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 * 我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 * <p>
 * 注意：
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/11
 **/
public class AccountsMerge {

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    /**
     * 20200628
     *
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int size = accounts.size();
        if (size > 0) {
            Map<String, Integer> mailMap = new HashMap<>();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
                List<String> list = accounts.get(i);
                for (int j = 1; j < list.size(); j++) {
                    String email = list.get(j);
                    if (mailMap.containsKey(email)) {
                        union(arr, mailMap.get(email), i);
                    }
                    mailMap.put(email, i);
                }
            }
            for (int i = 0; i < size; i++) {
                if (arr[i] == i) {
                    continue;
                }
                List<String> source = accounts.get(arr[i]);
                List<String> target = accounts.get(i);
                for (int j = 1; j < target.size(); j++) {
                    source.add(target.get(j));
                }
            }
            for (int i = 0; i < size; i++) {
                if (arr[i] != i) {
                    continue;
                }
                List<String> list = accounts.get(i);
                String name = list.remove(0);
                Collections.sort(list);
                for (int j = 1; j < list.size(); ) {
                    if (list.get(j).equals(list.get(j - 1))) {
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
                list.add(0, name);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AccountsMerge a=new AccountsMerge();
        List<List<String>> accounts=new ArrayList<>();
        accounts.add(Arrays.asList("Hanzo","Hanzo2@m.co","Hanzo3@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo4@m.co","Hanzo5@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo4@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo7@m.co","Hanzo8@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo1@m.co","Hanzo2@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo6@m.co","Hanzo7@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo5@m.co","Hanzo6@m.co"));
        List<List<String>> ans = a.accountsMerge(accounts);
    }
}
