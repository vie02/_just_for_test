package net.tklearn;

import java.net.ServerSocket;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Seq<Integer> s = List.of(1,2,3)::forEach;
        Seq<Integer> z = c -> List.of(1,2,3).forEach(c);
        Seq<Integer> a = Seq.unit(1);

    }
}
