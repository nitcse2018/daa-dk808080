import java.util.Random;
import java.lang.Math;
public class mergeSort
{
  static void merge(int numbers[], int l, int r, int m)
  {
    int n1 = m-l+1;
    int n2 = r-m;
    int[] leftnums = new int[n1];
    int[] rightnums = new int[n2];
    for(int i =0; i< n1; i++)
    {
      leftnums[i] = numbers[l + i];
    }
    for(int j =0; j< n2; j++)
    {
      rightnums[j] = numbers[m+j+1];
    }
    int i = 0;
    int j =0;
    int k =l;
    while(i<n1 && j<n2)
    {
      if(leftnums[i]<=rightnums[j])
      {
        numbers[k] = leftnums[i];
        i++;
        k++;
      }
      else
      {
        numbers[k] = rightnums[j];
        j++;
        k++;
      }
    }
    while(i<n1)
    {
      numbers[k] = leftnums[i];
      i++;
      k++;
    }
    while(j<n2)
    {
      numbers[k] = rightnums[j];
      j++;
      j++;
    }
  }
  static void merge_sort(int numbers[], int l, int r)
  {
    if(l<r)
    {
      int m = (l+r)/2;
      merge_sort(numbers,l,m);
      merge_sort(numbers,m+1,r);
      merge(numbers,l,r,m);
    }
  }

  public static void main(String args[])
  {
    Random rn = new Random();
    int[] numbers = new int[10000];
    System.out.println("this is list of all the numbers:");
    for (int i = 0; i< numbers.length; i++)
    {
      numbers[i] = rn.nextInt();
      System.out.println(numbers[i]);
    }
    System.out.println();
    int n = numbers.length;
    long start = System.currentTimeMillis();
    merge_sort(numbers,0,n-1);
    long end = System.currentTimeMillis();
    System.out.println("this is list of all sorted numbers:");
    for(int i =0; i<n; i++)
    {
      System.out.println(numbers[i]);
    }
    System.out.println("time taken in execution in milli secs is: " + (end - start));
  }
}
