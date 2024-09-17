package org.example.tree;

import java.util.*;

public class TreeSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        inorder(root,result);
        return result;

    }

    public void inorder(TreeNode root,List<Integer>result)
    {
        if (root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);

    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);

    }

    public TreeNode invertTree(TreeNode root) {

        if (root!=null)
        {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode t=root.left;
            root.left= root.right;
            root.right=t;
        }
        return root;

    }


    int r=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return r;

    }

    public int diameter(TreeNode root) {
        if(root==null)
            return 0;

        int num1=diameter(root.left);
        int num2=diameter(root.right);

        r=Math.max(r,num1+num2);
        return Math.max(num1+1,num2+1);

    }


    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST1(nums,0,nums.length-1);

    }

    public  TreeNode sortedArrayToBST1(int[] nums,int left,int right) {

        if(left>right)
            return null;
        int mid=(left+right)/2;
        TreeNode treeNode = new TreeNode();
        treeNode.val=nums[mid];
        treeNode.left=sortedArrayToBST1(nums,left,mid-1);
        treeNode.right=sortedArrayToBST1(nums,mid+1,right);
        return treeNode;


    }


    double isValidBSTMaxNum=-1<<31-1;
    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        if(!isValidBST(root.left))
            return false;

        if(isValidBSTMaxNum>=root.val)
            return false;

        isValidBSTMaxNum=root.val;
        return isValidBST(root.right);

    }

    int kthSmallestK;
    int currentK;
    public int kthSmallest(TreeNode root, int k) {

        currentK=k;
        kthSmallest1(root);
        return kthSmallestK;

    }

    public void kthSmallest1(TreeNode root) {
        if (root==null)
            return;
        kthSmallest1(root.left);
            currentK--;
        if (currentK==0)
        {
            kthSmallestK=root.val;
            return;
        }
        if(currentK>0)
        kthSmallest1(root.right);


    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode p=root;
        Deque<TreeNode> queue=new LinkedList();
        queue.add(root);
        if(root==null)
            return list;

        while (!queue.isEmpty())
        {
            TreeNode t=queue.remove();
            if(t.left!=null)
                queue.add(t.left);
            if(t.right!=null)
                queue.add(t.right);
            if(t==p)
            {
                list.add(t.val);
                if (!queue.isEmpty())  //若最后队列为空 抛NoSuchElement异常
               p=queue.getLast();

            }

        }
        return list;


    }


    TreeNode last=new TreeNode(0,null,null);
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        TreeNode l=root.left;
        TreeNode r=root.right;
        last.right=root;
        root.left=null;
        root.right=null;
        last=root;
        flatten(l);
        flatten(r);

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder,0,preorder.length-1 ,inorder,0,inorder.length-1);


    }

    public TreeNode buildTree1(int[] preorder,int preFirst,int preLast ,int[] inorder,int inFirst,int inLast) {
        if(inFirst>inLast||preFirst>preLast||preLast>=preorder.length||inLast>=inorder.length||preFirst<0||inFirst<0)
            return null;
        TreeNode root=new TreeNode(preorder[preFirst],null,null);
        int i;
        for ( i = inFirst; i <=inLast ; i++) {
            if(inorder[i]==preorder[preFirst])
                break;
        }
        root.left=buildTree1(preorder,preFirst+1,preFirst+i-inFirst ,inorder,inFirst,i-1);

        root.right=buildTree1(preorder,preFirst+i-inFirst+1,preLast ,inorder,i+1,inLast);

        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        boolean l=isChild(root.left,p,q);
        boolean r=isChild(root.right,p,q);
        if(l==true&&r==true||root==p||root==q)
            return root;
        if(l==true)
            return lowestCommonAncestor(root.left, p,  q);
        else return lowestCommonAncestor(root.right, p,  q);



    }

    public boolean isChild(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)
            return false;
        if(root==p||root==q)
            return true;
        if(isChild(root.left,p,q))
            return true;
        else return isChild(root.right,p,q);

    }







    }


