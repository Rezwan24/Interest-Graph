package com.example.interestgraphassignment;

import com.example.interestgraphassignment.graph.InterestGraph;
import com.example.interestgraphassignment.model.Interest;
import com.example.interestgraphassignment.model.Person;
import com.example.interestgraphassignment.util.Plotter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterestGraph graph = new InterestGraph();

        // Create sample data
        Person p1 = new Person("Alice", 1, 25, "Engineer");
        Person p2 = new Person("Bob", 2, 30, "Designer");
        Person p3 = new Person("Charlie", 3, 35, "Manager");
        Person p4 = new Person("David", 4, 28, "Developer");

        Interest i1 = new Interest("Programming", new String[]{"Java", "Python", "Algorithms"});
        Interest i2 = new Interest("Design", new String[]{"UI", "UX", "Photoshop"});
        Interest i3 = new Interest("Management", new String[]{"Leadership", "Communication", "Planning"});
        Interest i4 = new Interest("Web Development", new String[]{"HTML", "CSS", "JavaScript"});

        graph.addPerson(p1);
        graph.addPerson(p2);
        graph.addPerson(p3);
        graph.addPerson(p4);

        graph.addPersonInterest(p1, i1);
        graph.addPersonInterest(p1, i4);
        graph.addPersonInterest(p2, i2);
        graph.addPersonInterest(p2, i4);
        graph.addPersonInterest(p3, i3);
        graph.addPersonInterest(p4, i1);
        graph.addPersonInterest(p4, i4);

        graph.connectInterests(i1, i4);
        graph.connectInterests(i2, i4);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum value of x for similarity: ");
        int maxX = scanner.nextInt();

        List<Integer> xValues = new ArrayList<>();
        for (int i = 1; i <= maxX; i++) {
            xValues.add(i);
        }

        List<Integer> clusterSizes = graph.getClusterSizes(maxX);
        List<Integer> clusterNumbers = graph.getClusterNumbers(maxX);

        Plotter.createPlots(xValues, clusterSizes, clusterNumbers);
    }
}