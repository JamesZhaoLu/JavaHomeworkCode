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

import java.util.ArrayList;

public class GridTree {
    private GridNode root;     

    public GridTree()
    {
        root = null;
    }

    public void insert(GridNode node)
    {
        root = insert(node, root);
    }

    private GridNode insert(GridNode node, GridNode tree)
    {
        if (tree == null) {
            tree = node;
        }
        else
        {
            tree.children.add(node);
        }
        return tree;
    }

    public void build(String[] matrix)
    {
    	int depth = matrix.length;
    	int width = matrix[0].length();
		char marr[] = matrix[0].toCharArray();
		char ch = marr[0];
		GridNode nn = new GridNode(Character.toString(ch));
		insert(nn);
    	buildChildren(matrix, 0, 1, depth, width, root);
    	buildChildren(matrix, 1, 0, depth, width, root);
    }
    
    private void buildChildren(String[] matrix, int di, int wi, int depth, int width, GridNode node)
    {
    	if (node == null) {
    		return;
    	}
    	if (di >= depth || wi >= width) {
    		return;
    	}
    	if (di < depth) {
    		char marr[] = matrix[di].toCharArray();
    		if (wi < width) {
    			char ch = marr[wi];
				GridNode nn = new GridNode(Character.toString(ch));
				node.addChild(nn);
		    	buildChildren(matrix, di+1, wi, depth, width, nn);
		    	buildChildren(matrix, di, wi+1, depth, width, nn);
			}
		}
    	return;
    }
    
    private String getReverse(GridNode node) 
    {
    	String str = "";
    	while (node != null) {
    		str += node.data;
    		node = node.parent;
    	}
    	return str;
    }
    
    public ArrayList<String> findPalins()
    {
    	return findPalins(root);
    }
    
    private ArrayList<String> findPalins(GridNode node) 
    {
      	ArrayList<String> palins = new ArrayList<String>();
       	ArrayList<GridNode> list = new ArrayList<GridNode>();
    	list.add(node);
    	while (list.size() > 0) {
    		GridNode one = list.remove(0);
    		if (one.children.size() == 0) {
    			String reverse = getReverse(one);
    			String invert = new StringBuilder(reverse).reverse().toString();
    			if (reverse.equals(invert)) {
    				if (!palins.contains(reverse)) {
    					palins.add(reverse);
    				}
    			}
    		}
    		for (GridNode child : one.children) {
    			list.add(child);
    		}
    	}
    	return palins;
    }
    
    public void print() {
        print("", true, root);
    }

    private void print(String prefix, boolean isTail, GridNode node) {
        System.out.println(prefix + (isTail ? "--- " : "+-- ") + node.toString());
        GridNode last = null;
        if (node.children.size() > 0) {
        	last = node.children.get(node.children.size() - 1);
        	
        }
		for (GridNode child : node.children) {
			boolean lone = (child == last) ? true : false;
            print(prefix + (isTail ? "    " : "|   "), lone, child);
        }
     }
    
}
