import java.util.Map;
import java.util.TreeMap;

/**
 * 作者：chenZY
 * 时间：2018/5/31 11:03
 * 描述：
 */
public class CodeMain {

    public static class Us implements Comparable<Us>{

        private String name;

        private int anInt;

        public Us(String name, int anInt) {
            this.name = name;
            this.anInt = anInt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Us)) return false;

            Us us = (Us) o;

            if (anInt != us.anInt) return false;
            return name.equals(us.name);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + anInt;
            return result;
        }

        @Override
        public int compareTo(Us o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Map<Us, String> map = new TreeMap<>();
        Us u1 = new Us("ss", 12);
        Us u2 = new Us("ss", 12);
        map.put(u1, "1");
        map.put(u2, "2");
        System.out.println(map.get(u1));
        System.out.println(map.get(u2));
    }

}
