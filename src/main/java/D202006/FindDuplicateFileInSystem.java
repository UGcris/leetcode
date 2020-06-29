package D202006;

import java.util.*;

/**
 * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件。
 * <p>
 * 输入列表中的单个目录信息字符串的格式如下：
 * <p>
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * <p>
 * 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
 * <p>
 * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
 * <p>
 * "directory_path/file_name.txt"
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * 输出：
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *  
 * <p>
 * 注：
 * <p>
 * 最终输出不需要顺序。
 * 您可以假设目录名、文件名和文件内容只有字母和数字，并且文件内容的长度在 [1，50] 的范围内。
 * 给定的文件数量在 [1，20000] 个范围内。
 * 您可以假设在同一目录中没有任何文件或目录共享相同的名称。
 * 您可以假设每个给定的目录信息代表一个唯一的目录。目录路径和文件信息用一个空格分隔。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-file-in-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/29
 **/
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        if (paths.length > 0) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < paths.length; i++) {
                String[] split = paths[i].split(" ");
                String path = split[0];
                for (int j = 1; j < split.length; j++) {
                    String value = split[j];
                    String fileName = value.substring(0, value.indexOf("("));
                    String fileValue = value.substring(value.indexOf("(") + 1, value.lastIndexOf(")"));
                    if (map.containsKey(fileValue)) {
                        ans.get(map.get(fileValue)).add(path + "/" + fileName);
                    } else {
                        map.put(fileValue, ans.size());
                        List<String> list = new ArrayList<>();
                        list.add(path + "/" + fileName);
                        ans.add(list);
                    }
                }
            }
        }
        for (int i = 0; i < ans.size(); ) {
            if (ans.get(i).size() < 2) {
                ans.remove(i);
                continue;
            }
            i++;
        }
        return ans;
    }
}
