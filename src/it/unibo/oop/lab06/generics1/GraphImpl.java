package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GraphImpl<N> implements Graph<N> {

    private Map<N, Set<N>> graph = new HashMap<>();

    private Map<N, Boolean> visited = new HashMap<>();

    @Override
    public void addNode(N node) {
        if (node != null && !graph.containsKey(node)) {
            graph.put(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            graph.get(source).add(target);
        }

    }

    @Override
    public Set<N> nodeSet() {
        return graph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return graph.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {

        return DFS(source, target);

    }

    private List<N> DFS(N source, N target) {
        List<N> listToReturn = new ArrayList<>();
        Stack<N> pila = new Stack<>();
        for (N n : graph.keySet()) {
            visited.put(n, false);
        }

        visited.put(source, true);
        pila.push(source);

        while (!pila.isEmpty()) {
            N u = pila.pop();
            listToReturn.add(u); //la visita è in profondità, aggiungo i nodi appena li tolgo dalla pila
            if (u.equals(target)) {
                return listToReturn;
            }
            for (N nodeAdj : graph.get(u)) {
                if (!visited.get(nodeAdj)) {
                    visited.put(nodeAdj, true);
                    pila.push(nodeAdj);
                }
            }
        }

        return null;
    }

    /*
     * public List<N> printAllPaths(N s, N d) {
     * 
     * for (N n : graph.keySet()) { visited.put(n, false); }
     * 
     * List<N> pathList = new ArrayList<>();
     * 
     * pathList.add(s);
     * 
     * DFS(s, d, pathList);
     * 
     * return pathList; }
     * 
     * // A recursive function to print // all paths from 'u' to 'd'. // isVisited[]
     * keeps track of // vertices in current path. // localPathList<> stores actual
     * // vertices in the current path private void DFS(N source, N target, List<N>
     * localPathList) {
     * 
     * 
     * if (source.equals(target)) { return; // if match found then no need to
     * traverse more till depth } else { // Mark the current node
     * visited.put(source, true);
     * 
     * // Recur for all the vertices // adjacent to current vertex for (N node :
     * graph.get(source)) { if (!visited.get(node)) { // store current node // in
     * path[] localPathList.add(node); DFS(node, target, localPathList);
     * 
     * // remove current node // in path[] localPathList.remove(node); } }
     * 
     * // Mark the current node visited.put(source, false); }
     * 
     * }
     */

}
