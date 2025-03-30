import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode frist = new TreeNode(7);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(9);
        TreeNode fourth = new TreeNode(0);
        TreeNode fifth = new TreeNode(2);

        root = frist;
        frist.left = second;
        frist.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
        
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
        
    }

    public void preOrderStack(TreeNode root){ // recursive
        if(root == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode temp = st.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null){
                st.push(temp.right);
            }
            if(temp.left != null){
                st.push(temp.left);
            }
        } 
        
    }

    public void inOrderStack(TreeNode root){ //iterative
        if(root == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(!st.empty() || temp != null){;
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            else{
                temp = st.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        } 
        
    }

    public void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderStack(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while(current != null || !st.isEmpty() ){
            if(current!= null){
                st.push(current);
                current = current.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    System.out.print(temp.data+" ");
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    current = temp;
                }
            }
        }
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.print("pre Order : ");
        bt.preOrder(bt.root);
        System.out.println();
        System.out.print("pre Order Stack : ");
        bt.preOrderStack(bt.root);
        System.out.println();
        System.out.print("In Order : ");
        bt.inOrder(bt.root);
        System.out.println();
        System.out.print("In Order Stack : ");
        bt.inOrderStack(bt.root);
        System.out.println();
        System.out.print("Post Order: ");
        bt.postOrder(bt.root);
        System.out.println();
        System.out.print("Post Order Stack : ");
        bt.postOrderStack(bt.root);
        System.out.println();
        System.out.print("level Order: ");
        bt.levelOrder(bt.root);
    }
}
