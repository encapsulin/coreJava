package designPattern.structural.composit;

import java.util.ArrayList;
import java.util.List;

public class Composit {
    String title;
    List<Composit> list = new ArrayList<>();

    public Composit(String title) {
        this.title = title;
    }

    public void print(String tab) {
        tab = tab != null ? tab : "";
        System.out.println(tab + "C: " + title);
        for (Composit composit : list) {
            composit.print(tab + "  ");
        }
    }

    public void add(Composit c) {
        list.add(c);
    }
}
