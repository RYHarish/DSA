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

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrder(bt.root);
        System.out.println();
        bt.preOrderStack(bt.root);
        System.out.println();
        bt.inOrder(bt.root);
        System.out.println();
        bt.inOrderStack(bt.root);
    }
}
