package com.example.interestgraphassignment.model;


import java.util.Arrays;
import java.util.Objects;

public class Interest {
    private String name;
    private String[] requirements;

    public Interest(String name, String[] requirements) {
        this.name = name;
        this.requirements = requirements;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String[] getRequirements() { return requirements; }
    public void setRequirements(String[] requirements) { this.requirements = requirements; }

    public boolean isSimilar(Interest other, int x) {
        int matchingRequirements = 0;
        for (String req : this.requirements) {
            if (Arrays.asList(other.requirements).contains(req)) {
                matchingRequirements++;
            }
        }
        return matchingRequirements >= x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return Objects.equals(name, interest.name) && Arrays.equals(requirements, interest.requirements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(requirements);
        return result;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "name='" + name + '\'' +
                ", requirements=" + Arrays.toString(requirements) +
                '}';
    }
}