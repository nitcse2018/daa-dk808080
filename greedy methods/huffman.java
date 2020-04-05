import java.util.PriorityQueue;
import java.util.Comparator;
class HuffmanNode
{
  int data;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}
class MyComparator implements Comparator<HuffmanNode>
{
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}
public class huffman
{
public static void printCode(HuffmanNode root, String s)
{
  if (root.left == null && root.right == null && Character.isLetter(root.c))
   {
     System.out.println(root.c + ":" + s);
     return;
   }
   printCode(root.left, s + "0");
   printCode(root.right, s + "1");
}
public static void main(String args[])
{
  int n=7;
  char[] char_array = {'a','e','i','o','u','s','t'};
  int[] char_freq = {10,15,12,3,4,13,1};
  PriorityQueue<HuffmanNode> Q  = new PriorityQueue<HuffmanNode>(n, new MyComparator());
  for(int i=0;i<n;i++)
  {
    HuffmanNode hn = new HuffmanNode();
    hn.data = char_freq[i];
    hn.c = char_array[i];
    hn.left = null;
    hn.right = null;
    Q.add(hn);
  }
  HuffmanNode root = null;
  while(Q.size()>1)
  {
    HuffmanNode x = Q.peek();
    Q.poll();
    HuffmanNode y = Q.peek();
    Q.poll();
    HuffmanNode z = new HuffmanNode();
    z.data = x.data + y.data;
    z.c = '-';
    z.left = x;
    z.right = y;
    root = z;
    Q.add(z);
  }
 printCode(root, "");
}
}
