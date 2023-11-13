package net.tklearn;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    private int[][] a;

    public Model(int[][] a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Arrays.deepEquals(a, model.a);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(a);
    }

    String solution(String currMonth) {
        List<Integer> c = Stream.of(currMonth.split("-")).map(Integer::parseInt).collect(Collectors.toList());

        Calendar cal = Calendar.getInstance();
        cal.set(c.get(1),c.get(0)-1,1);

        do {
            cal.add(Calendar.MONTH, 1);
        } while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY);

        return String.format("%01d-%s", cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }
}
