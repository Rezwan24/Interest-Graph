package com.example.interestgraphassignment.graph;


import com.example.interestgraphassignment.model.Interest;
import com.example.interestgraphassignment.model.Person;

import java.util.*;

public class InterestGraph {
    private Map<Person, List<Interest>> personInterests;
    private Map<Interest, List<Interest>> interestConnections;

    public InterestGraph() {
        personInterests = new HashMap<>();
        interestConnections = new HashMap<>();
    }

    public void addPerson(Person person) {
        personInterests.putIfAbsent(person, new ArrayList<>());
    }

    public void addInterest(Interest interest) {
        interestConnections.putIfAbsent(interest, new ArrayList<>());
    }

    public void addPersonInterest(Person person, Interest interest) {
        personInterests.get(person).add(interest);
        addInterest(interest);
    }

    public void connectInterests(Interest interest1, Interest interest2) {
        interestConnections.get(interest1).add(interest2);
        interestConnections.get(interest2).add(interest1);
    }

    public List<Set<Person>> findClusters(int x) {
        List<Set<Person>> clusters = new ArrayList<>();
        Set<Person> visited = new HashSet<>();

        for (Person person : personInterests.keySet()) {
            if (!visited.contains(person)) {
                Set<Person> cluster = new HashSet<>();
                dfs(person, cluster, visited, x);
                clusters.add(cluster);
            }
        }

        return clusters;
    }

    private void dfs(Person person, Set<Person> cluster, Set<Person> visited, int x) {
        visited.add(person);
        cluster.add(person);

        for (Interest interest : personInterests.get(person)) {
            for (Interest connectedInterest : interestConnections.get(interest)) {
                if (interest.isSimilar(connectedInterest, x)) {
                    for (Person connectedPerson : personInterests.keySet()) {
                        if (!visited.contains(connectedPerson) &&
                                personInterests.get(connectedPerson).contains(connectedInterest)) {
                            dfs(connectedPerson, cluster, visited, x);
                        }
                    }
                }
            }
        }
    }

    public List<Integer> getClusterSizes(int maxX) {
        List<Integer> sizes = new ArrayList<>();
        for (int x = 1; x <= maxX; x++) {
            int totalSize = 0;
            List<Set<Person>> clusters = findClusters(x);
            for (Set<Person> cluster : clusters) {
                totalSize += cluster.size();
            }
            sizes.add(totalSize / clusters.size()); // Average cluster size
        }
        return sizes;
    }

    public List<Integer> getClusterNumbers(int maxX) {
        List<Integer> numbers = new ArrayList<>();
        for (int x = 1; x <= maxX; x++) {
            numbers.add(findClusters(x).size());
        }
        return numbers;
    }
}
