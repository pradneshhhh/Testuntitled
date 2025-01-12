package org.practice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NumberKill {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for(int i=1; i<=10; i++) {
            list.add(i);
        }
        boolean isKill = false;
        function(list, isKill);
    }

    private static void function(List<Integer> list, boolean isKill) {
        if(list.size()==1) {
            return;
        }
        CopyOnWriteArrayList<Integer> listNew = new CopyOnWriteArrayList<>();
        for(Integer i: list) {
            if(!isKill) {
                System.out.print(i);
                listNew.add(i);
                isKill=true;
            } else {
                list.remove(i);
                isKill=false;
            }
        }
        System.out.println("");
        function(listNew, isKill);
    }


}
