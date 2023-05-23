import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MyMap<K, V> {
    private ArrayList<MyMap.Entry<K, V>> entries;

    MyMap() {
        entries = new ArrayList<>();
    }

    void put(K key, V value) {
        for (MyMap.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        entries.add(new MyMap.Entry<>(key, value));
    }

    V get(K key) {
        for (MyMap.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    boolean containsKey(K key) {
        for (MyMap.Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    Set<MyMap.Entry<K, V>> entrySet() {
        return new HashSet<>(entries);
    }

    static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyMap.Entry<?, ?> entry = (MyMap.Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}