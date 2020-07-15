package D202007;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author UGcris
 * @date 2020/7/15
 **/
public class PeekingIterator implements Iterator<Integer> {
    private List<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (list.size() > 0) {
            Integer ans = list.get(0);
            list.remove(0);
            return ans;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
