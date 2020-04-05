public class knap_sack
{

  static int knap_sack(int max_w, int weight[], int profit[], int n)
  {
    int i,w;
    int k[][] = new int[n+1][max_w+1];
    for(i=0;i<=n;i++)
    {
      for(w=0;w<=max_w;w++)
      {
        if(i==0||w==0)
        {
          k[i][w] = 0;
        }
        else if((weight[i-1]<=w) && ((k[i-1][w-weight[i-1]] + profit[i-1]) >k[i-1][w]))
        {
          k[i][w] = k[i-1][w-weight[i-1]] + profit[i-1];
        }
        else
        {
          k[i][w] = k[i-1][w];
        }
      }
    }
    return k[n][max_w];
  }

public static void main(String args[])
{
int profit[] = new int[]{24,18,18,10};
int weight[] = new int[]{24,10,10,7};
int max_w = 25;
int n = profit.length;
System.out.println(knap_sack(max_w,weight,profit,n));
}
}
