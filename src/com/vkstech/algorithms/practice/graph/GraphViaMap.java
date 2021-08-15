package com.vkstech.algorithms.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://github.com/eugenp/tutorials/tree/master/data-structures/src/main/java/com/baeldung/graph
 */
public class GraphViaMap<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public class Vertex<E> {
        E data;

        Vertex(E data) {
            this.data = data;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex<E> v = (Vertex<E>) obj;
            if (!getOuterType().equals(v.getOuterType()))
                return false;
            if (data == null) {
                return v.data == null;
            } else {
                return data.equals(v.data);
            }
        }

        @Override
        public String toString() {
            return data.toString();
        }

        private GraphViaMap<E> getOuterType() {
            return (GraphViaMap<E>) GraphViaMap.this;
        }
    }

    public GraphViaMap() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(T data) {
        adjVertices.putIfAbsent(new Vertex<>(data), new ArrayList<>());
    }

    public void removeVertex(T data) {
        Vertex<T> v = new Vertex<>(data);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<>(data));
    }

    public void addEdge(T uData, T vData) {
        Vertex<T> u = new Vertex<>(uData);
        Vertex<T> v = new Vertex<>(vData);
        adjVertices.get(u).add(v);
        adjVertices.get(v).add(u);
    }

    public void removeEdge(T uData, T vData) {
        Vertex<T> u = new Vertex<>(uData);
        Vertex<T> v = new Vertex<>(vData);

        List<Vertex<T>> uvEdge = adjVertices.get(u);
        List<Vertex<T>> vuEdge = adjVertices.get(v);

        if (uvEdge != null)
            uvEdge.remove(v);

        if (vuEdge != null)
            vuEdge.remove(u);
    }

    public List<Vertex<T>> getAdjVertices(T data) {
        return adjVertices.get(new Vertex<>(data));
    }

    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<T> v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        GraphViaMap<Integer> graph = new GraphViaMap<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.printGraph();
    }

}
