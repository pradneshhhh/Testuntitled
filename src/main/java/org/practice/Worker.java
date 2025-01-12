package org.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Worker {
    private int id;
    private String name;

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;
        return id == worker.id && name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Map<Worker, Object> map = new HashMap<>();
//        map.put(new Worker(1, "A"), new Object());
//        map.put(new Worker(1, "A"), new Object());

        Worker w1 = new Worker(1, "A");
        Worker w2 = new Worker(1, "A");
        HashSet<Worker> set = new HashSet<>();
        map.put(w1, new Object());
        map.put(w2, new Object());
        System.out.println(map.size());
        set.add(w1);
        set.add(w2);
        System.out.println(set.size());

    }
}
