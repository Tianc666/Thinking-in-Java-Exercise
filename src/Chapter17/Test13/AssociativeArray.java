package Chapter17.Test13;//: containers/AssociativeArray.java
// Associates keys with values.

import net.mindview.util.TextFile;

import java.util.LinkedHashMap;
import java.util.List;

import static net.mindview.util.Print.print;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null; // Did not find key
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> words = new TextFile("G:\\Java编程思想的一些练习\\Exercise\\src\\Chapter17\\Test13\\AssociativeArray.java", "\\W+");
        AssociativeArray<String, Integer> map = new AssociativeArray<String, Integer>(words.size());
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        print(map);
    }
}