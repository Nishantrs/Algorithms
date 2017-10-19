package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphAdjacencyList
{
  Map<Vertex,LinkedList<Vertex>> adjList; // Adjacency list for each vertices in graph
                                          // Memory efficient and better than Adjacency Matrix
  ArrayList<Vertex> visitTracker; // For simplicity of executing

  public GraphAdjacencyList()
  {
    adjList = new HashMap<>();
    visitTracker = new ArrayList();
  }

  // It can be custom object as well depending on Vertex definition
  public void addEdge(Vertex sourceVertex, Vertex destinationVertex)
  {
    if(adjList.containsKey(sourceVertex)) {
      adjList.get(sourceVertex).add(destinationVertex);
    } else {
      adjList.put(sourceVertex,new LinkedList<>());
      adjList.get(sourceVertex).add(destinationVertex);
    }

    // Making sure all the Vertices are considered, else
    // null pointer exception
    if(!adjList.containsKey(destinationVertex)) {
      adjList.put(destinationVertex,new LinkedList<>());
    }
  }

  public void showVisited()
  {
    for(Vertex v : visitTracker)
    {
      System.out.println(v);
    }
  }

  public void showAdjListOfVertex(Vertex v)
  {
    for(Vertex adj : adjList.get(v))
    {
      System.out.println(adj);
    }
  }

  public void  resetVisitToFalse(GraphAdjacencyList g)
  {
    for(Vertex v : visitTracker)
    {
      v.isVisited = false;
    }
    visitTracker.clear();
  }
}
