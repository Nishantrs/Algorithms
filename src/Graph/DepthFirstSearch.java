package Graph;

import java.util.Stack;

public class DepthFirstSearch
{
  void DFSRecursive(GraphAdjacencyList g, Vertex v)
  {
    v.isVisited = true;
    g.visitTracker.add(v);

    for(Vertex adjVertex : g.adjList.get(v))
    {
      if(!adjVertex.isVisited) {
        DFSRecursive(g, adjVertex);
      }
    }
  }

  void DFSIterative(GraphAdjacencyList g, Vertex v)
  {
    if (!g.adjList.keySet().contains(v)) {
      System.out.println("Vertex no present");
      return;
    }

    Stack<Vertex> stackVertex = new Stack();
    stackVertex.push(v);

    while(!stackVertex.isEmpty())
    {
      Vertex curr = stackVertex.pop();
      g.visitTracker.add(curr);
      // Instead of visited array for primitive data type
      curr.isVisited = true;

      for(Vertex adjVertex : g.adjList.get(curr))
      {
        if(!adjVertex.isVisited) {
          stackVertex.push(adjVertex);
        }
      }
    }
  }

  public static void main(String[] args) {
    GraphAdjacencyList graphObj = new GraphAdjacencyList();
    DepthFirstSearch obj = new DepthFirstSearch();

    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Vertex v3 = new Vertex(3);
    Vertex v4 = new Vertex(4);
    Vertex v5 = new Vertex(5);
    Vertex v6 = new Vertex(6);
    Vertex v7 = new Vertex(7);
    Vertex v8 = new Vertex(8);
    Vertex v9 = new Vertex(9);
    Vertex v10 = new Vertex(10);
    Vertex v11 = new Vertex(11);
    Vertex v12 = new Vertex(12);

    graphObj.addEdge(v1,v2);
    graphObj.addEdge(v1,v3);
    graphObj.addEdge(v1,v4);
    graphObj.addEdge(v2,v5);
    graphObj.addEdge(v2,v6);
    graphObj.addEdge(v3,v7);
    graphObj.addEdge(v3,v8);
    graphObj.addEdge(v4,v9);
    graphObj.addEdge(v4,v10);
    graphObj.addEdge(v9,v11);
    graphObj.addEdge(v10,v12);
    graphObj.addEdge(v5,v1);

    obj.DFSRecursive(graphObj, v1);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);

    System.out.println("///////////////////////////////////");

    obj.DFSIterative(graphObj, v1);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);

    obj.DFSRecursive(graphObj, v2);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);

    obj.DFSIterative(graphObj, v2);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);

    obj.DFSRecursive(graphObj, v4);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);

    obj.DFSIterative(graphObj, v4);
    graphObj.showVisited();
    graphObj.resetVisitToFalse(graphObj);
  }
}
