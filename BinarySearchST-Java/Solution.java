import java.util.ArrayList;
import java.util.List;

class BinarySearchST<Key extends Comparable<Key>, Value> {
    private List<Key> keys;
    private List<Value> values;

    public BinarySearchST() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public int size() {
        return keys.size();
    }

    public void put(Key key, Value value) {
        int index = rank(key);
        if (index < keys.size() && keys.get(index).compareTo(key) == 0) {
            values.set(index, value); 
        } else {
            keys.add(index, key);
            values.add(index, value);
        }
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int index = rank(key);
        if (index < keys.size() && keys.get(index).compareTo(key) == 0) {
            return values.get(index);
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        int index = rank(key);
        if (index < keys.size() && keys.get(index).compareTo(key) == 0) {
            keys.remove(index);
            values.remove(index);
        }
    }

    public Key min() {
        if (isEmpty()) return null;
        return keys.get(0);
    }

    public Key max() {
        if (isEmpty()) return null;
        return keys.get(keys.size() - 1);
    }

    public Key floor(Key key) {
        int index = rank(key);
        if (index < keys.size() && keys.get(index).compareTo(key) == 0) {
            return keys.get(index);
        }
        if (index == 0) return null;
        return keys.get(index - 1);
    }

    public Key ceiling(Key key) {
        int index = rank(key);
        if (index < keys.size()) {
            return keys.get(index);
        }
        return null;
    }

    public int rank(Key key) {
        int lo = 0, hi = keys.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = keys.get(mid).compareTo(key);
            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= keys.size()) return null;
        return keys.get(rank);
    }

    public void deleteMin() {
        if (!isEmpty()) {
            keys.remove(0);
            values.remove(0);
        }
    }

    public void deleteMax() {
        if (!isEmpty()) {
            keys.remove(keys.size() - 1);
            values.remove(values.size() - 1);
        }
    }

    public int size(Key lo, Key hi) {
        if (isEmpty()) return 0;
        int start = rank(lo);
        int end = rank(hi);
        if (end < keys.size() && keys.get(end).compareTo(hi) == 0) {
            end++;
        }
        return end - start;
    }

    public List<Key> keys() {
        return new ArrayList<>(keys);
    }

    public List<Key> keys(Key lo, Key hi) {
        if (isEmpty()) return new ArrayList<>();
        int start = rank(lo);
        int end = rank(hi);
        if (end < keys.size() && keys.get(end).compareTo(hi) == 0) {
            end++;
        }
        return new ArrayList<>(keys.subList(start, end));
    }
}