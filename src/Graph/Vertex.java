package Graph;

public class Vertex
{
  // This definition can be customized
  // Accordingly addEdge method in GraphAdjacencyList needs to be updated, along with
  // equals, hashCode and toString
  int data;
  boolean isVisited; // Graph can be traversed only once once it is set

  public Vertex(int val)
  {
    data = val;
    isVisited = false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vertex)) return false;

    Vertex vertex = (Vertex) o;

    return data == vertex.data;

  }

  @Override
  public int hashCode() {
    return data;
  }

  @Override
  public String toString()
  {
    return "["+" "+"data: "+data+", "+"visited: "+isVisited+"]";
  }
}
