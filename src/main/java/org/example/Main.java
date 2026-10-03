package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Java Collections", "Write List Interface", "Ann", Status.IN_QUEUE, Priority.LOW);
        Task t2 = new Task("Java Collections", "Write Set Interface", "Ann", Status.ASSIGNED, Priority.MED);
        Task t3 = new Task("Java Collections", "Write Map Interface", "Bob", Status.IN_QUEUE, Priority.HIGH);
        Task t4 = new Task("Java Collections", "Write Queue Interface", "Carol", Status.IN_PROGRESS, Priority.MED);
        Task t5 = new Task("Java Generics", "Write Generic Methods", null, Status.IN_QUEUE, Priority.LOW);

        Set<Task> ann = new HashSet<>(Set.of(t1, t2));
        Set<Task> bob = new HashSet<>(Set.of(t3, t2));
        Set<Task> carol = new HashSet<>(Set.of(t4));
        Set<Task> unassigned = new HashSet<>(Set.of(t5));

        TaskData data = new TaskData(ann, bob, carol, unassigned);

        System.out.println("Tüm tasklar: " + data.getTasks("all"));
        System.out.println("Ann: " + data.getTasks("ann"));
        System.out.println("Bob: " + data.getTasks("bob"));
        System.out.println("Carol: " + data.getTasks("carol"));
        System.out.println("Atanmamış: " + data.getDifferences(unassigned, data.getTasks("all")));
        System.out.println("Birden fazla kişiye atanmış: " + data.getUnion(
                data.getIntersection(ann, bob),
                data.getIntersection(ann, carol),
                data.getIntersection(bob, carol)));

        System.out.println(StringSet.findUniqueWords().size() + " unique kelime: " + StringSet.findUniqueWords());
    }
}
