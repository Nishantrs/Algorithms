package DynamicProgramming;

public class DiscreteKnapsack
{
  public int computeMaxValue(int[] values, int[] weights, int sackCapacity)
  {
    // Adding extra row and column for base case scenario
    int[][] weightsXcapacity = new int[weights.length + 1][sackCapacity+1];

    for (int i = 0; i <= weights.length; i++)
    {
      for (int j = 0; j <= sackCapacity; j++)
      {
        // Initializing base conditions
        if(i == 0 || j == 0) {
          weightsXcapacity[i][j] = 0;
          continue;
        }

        if (j - weights[i-1] >= 0) {
          weightsXcapacity[i][j] = Math.max(values[i-1] + weightsXcapacity[i-1][j - weights[i-1]],
          weightsXcapacity[i-1][j]);
        } else {
          weightsXcapacity[i][j] = weightsXcapacity[i-1][j];
        }
      }
    }
    return weightsXcapacity[values.length][sackCapacity];
  }

  public static void main(String[] args) {

  }
}

