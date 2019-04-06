import java.util.*;

public class BinaryTree {
   private TreeNode root;
   private Scanner console;
   
   public BinaryTree() {
      console = new Scanner(System.in);
      buildTree();
   }
   
   private void buildTree() {
      boolean done = false;
      System.out.print("data of overall root? ");
      String input = console.nextLine();
      if (!input.equals("null")) {      
         root = new TreeNode(Integer.parseInt(input));
         while (!done) {
            System.out.print("path (0 -> left, 1 -> right, return to quit)? ");
            String path = console.nextLine();
            if (path.length() == 0) {
               done = true;
            } else {
               System.out.print("data? ");
               int data = Integer.parseInt(console.nextLine());
               TreeNode curr = root;
               for (int i = 0; i < path.length(); i++) {
                  if (path.charAt(i) == '0') {
                     curr.left = check(curr.left);
                     curr = curr.left;
                  } else {
                     curr.right = check(curr.right);
                     curr = curr.right;
                  }
               }
               curr.data = data;
            }
         }
      }
   }
   
   private TreeNode check(TreeNode curr) {
      if (curr == null) {
         return new TreeNode(0);
      }
      return curr;
   }
   
   public void print() {
      print(root);
   }
   
   private void print(TreeNode curr) {
      if (curr == null) {
         System.out.print("null");
      } else if (curr.left != null || curr.right != null) {
         System.out.print("(");
         print(curr.left);
         System.out.print(", " + curr.data + ", ");
         print(curr.right);
         System.out.print(")");
      } else {
         System.out.print(curr.data);
      }
   }
   
   private static class TreeNode {
      public int data;
      public TreeNode left;
      public TreeNode right;
      
      public TreeNode(int data) {
         this.data = data;
      }
   }
}