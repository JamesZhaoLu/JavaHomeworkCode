/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6homework;

/**
 *
 * @author jameslu
 */
public class TreeBalance {
    private TreeNode root;     

    public TreeBalance()
    {
        root = null;
    }

    public void insert(TreeNode node)
    {
        root = insert(node, root);
    }

    public String inorder()
    {
        return inorder(root);
    }
    
    private String inorder(TreeNode node)
    {
    	String data = "";
        if (node != null)
        {
            data += inorder(node.left);
            data += node.data + " ";
            data += inorder(node.right);
        }
        return data;
    }
    
    public String outorder()
    {
        return outorder(root);
    }
    
    private String outorder(TreeNode node)
    {
    	String data = "";
        if (node != null)
        {
            data += outorder(node.right);
            data += node.data + " ";
            data += outorder(node.left);
        }
        return data;
    }
    
    private int height(TreeNode node)
    {
        return (node == null) ? -1 : node.height;
    }

    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    
    private TreeNode shiftLeftChild(TreeNode node)
    {
        TreeNode nl = node.left;
        node.left = nl.right;
        nl.right = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        nl.height = max(height(nl.left), nl.height) + 1;
        return nl;
    }

    private TreeNode shiftRightChild(TreeNode node)
    {
        TreeNode nr = node.right;
        node.right = nr.left;
        nr.left = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        nr.height = max(height(nr.right ), nr.height) + 1;
        return nr;
    }

    private TreeNode shiftShiftLeftChild(TreeNode node)
    {
        node.left = shiftRightChild(node.left);
        return shiftLeftChild(node);
    }
    
    private TreeNode shiftShiftRightChild(TreeNode node)
    {
        node.right = shiftLeftChild(node.right);
        return shiftRightChild(node);
    }    

    private TreeNode insert(TreeNode node, TreeNode tree)
    {
        if (tree == null) {
            tree = node;
        }
        else if (node.key < tree.key)
        {
            tree.left = insert(node, tree.left);
            if (height( tree.left ) - height( tree.right ) >= 2) {
                if (node.key < tree.left.key) {
                    tree = shiftLeftChild(tree);
                } else {
                    tree = shiftShiftLeftChild(tree);
                }
            }
        }
        else if( node.key > tree.key )
        {
            tree.right = insert(node, tree.right );
            if (height(tree.right) - height(tree.left) >= 2) {
                if( node.key > tree.right.key) {
                    tree = shiftRightChild(tree);
                } else {
                    tree = shiftShiftRightChild(tree);
                }
            }
        }

        tree.height = max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public void print() {
        print("", true, root);
    }

    private void print(String prefix, boolean isLeft, TreeNode node) {
        System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + node.toString());
        if (node.left != null) {
            print(prefix + (isLeft ? "    " : "    "), true, node.left);
        }
        if (node.right != null) {
            print(prefix + (isLeft ? "    " : "    "), false, node.right);
        }
     }

}

