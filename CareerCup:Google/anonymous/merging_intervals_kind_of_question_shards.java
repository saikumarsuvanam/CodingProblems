

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class merging_intervals_kind_of_question_shards {

    static class Shard {
        int start;
        int end;

        public Shard(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Key {
        int start;
        int end;

        public Key(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static List<Range> getRanges(List<Shard> shards, List<Key> keys) {
        List<Range> result = new LinkedList<Range>();
        int i = 0;
        Key curKey;
        for (Shard shard : shards) {
            if (i >= keys.size()) {
                break;
            }
            curKey = keys.get(i);
            Integer rangeStart = null, rangeEnd = null;
            while (overlapping(shard, curKey)) {
                if (rangeStart == null) {
                    rangeStart = Math.max(shard.start, curKey.start);
                }
                rangeEnd = Math.min(shard.end, curKey.end);
                if (curKey.end < shard.end) {
                    // another key potentially overlaps with shard
                    i++;
                    if (i < keys.size()) {
                        curKey = keys.get(i);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (rangeStart != null) {
                result.add(new Range(rangeStart, rangeEnd));
            }
        }
        return result;
    }

    private static boolean overlapping(Shard shard, Key curKey) {
        return (curKey.start >= shard.start && curKey.start < shard.end) || (curKey.end > shard.start && curKey.end <= shard.end);
    }

    public static void main(String[] args) {
        Shard shard2 = new Shard(1, 9);
        Shard shard1 = new Shard(12, 59);
        Shard shard3 = new Shard(100, 999);
        List<Shard> shards = new LinkedList<Shard>();
        Collections.addAll(shards, shard1, shard2, shard3);
        System.out.println(shards);

        Key key3 = new Key(2, 3);
        Key key1 = new Key(6, 8);
        Key key2 = new Key(11, 20);
        Key key4 = new Key(200, 220);
        List<Key> keys = new ArrayList<Key>();
        Collections.addAll(keys, key1, key2, key3, key4);

        List<Range> ranges = getRanges(shards, keys);
        for (Range range : ranges) {
            System.out.println(range.start + "," + range.end);
        }
    }
}