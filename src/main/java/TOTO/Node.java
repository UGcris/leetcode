package TOTO;

import java.util.List;

/**
 * @Author UGcris
 * @date 2020/3/11
 **/
public class Node {
    public int val;
    Node next;
    Node random;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
