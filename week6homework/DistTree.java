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

public class DistTree {
    private DistNode root;     

    public DistTree()
    {
        root = null;
    }

    public void insert(DistNode node)
    {
        root = insert(node, root);
    }

    private DistNode insert(DistNode node, DistNode tree)
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

    public void build(String startStr, String endStr)
    {
    	DistNode startNode = new DistNode(startStr);
    	insert(startNode);
    	buildChildren(root, endStr);
    }
    
    private void buildChildren(DistNode node, String endStr)
    {
    	if (node == null) {
    		return;
    	}
    	if (node.data.equals(endStr)) {
    		return;
    	}
    	if (node.data.length() > endStr.length()) {
    		char dataarr[] = node.data.toCharArray();
    		for (int i = 0; i < dataarr.length; i++) {
    			char ch = dataarr[i];
    			if (endStr.indexOf(ch) < 0) {
    				String ndata = new StringBuilder(node.data).deleteCharAt(i).toString();
    				DistNode nn = new DistNode(ndata);
    				node.addChild(nn);
    			} else {
    	    		char endsarr[] = endStr.toCharArray();
    	    		if (i < endsarr.length) {
    	    			if (dataarr[i] != endsarr[i]) {
    	    				String ndata = new StringBuilder(node.data).deleteCharAt(i).toString();
    	    				DistNode nn = new DistNode(ndata);
    	    				node.addChild(nn);
    	    			}
    	    		} else {
        				String ndata = new StringBuilder(node.data).deleteCharAt(i).toString();
        				DistNode nn = new DistNode(ndata);
        				node.addChild(nn);    	    			
    	    		}
    			}
    		}
    	}
    	else if (node.data.length() < endStr.length()) {
    		char endsarr[] = endStr.toCharArray();
    		for (int i = 0; i < endsarr.length; i++) {
    			char ch = endsarr[i];
    			if (node.data.indexOf(ch) < 0) {
    				int idx = (node.data.length() > i) ? i : node.data.length();
    				String ndata = new StringBuilder(node.data).insert(idx, ch).toString();
    				DistNode nn = new DistNode(ndata);
    				node.addChild(nn);
    			} else {
		    		char dataarr[] = node.data.toCharArray();
		    		if (i < dataarr.length) {
		    			if (endsarr[i] != dataarr[i]) {
		    				int idx = (node.data.length() > i) ? i : node.data.length();
		    				String ndata = new StringBuilder(node.data).insert(idx, ch).toString();
		    				DistNode nn = new DistNode(ndata);
		    				node.addChild(nn);
		    			}
		    		} else {
	    				int idx = (node.data.length() > i) ? i : node.data.length();
	    				String ndata = new StringBuilder(node.data).insert(idx, ch).toString();
	    				DistNode nn = new DistNode(ndata);
	    				node.addChild(nn);		    			
		    		}
				}
    		}
    	} 
    	else {
    		char dataarr[] = node.data.toCharArray();
    		char endsarr[] = endStr.toCharArray();
    		for (int i = 0; i < dataarr.length; i++) {
    			char ch = endsarr[i];
    			if (dataarr[i] != endsarr[i]) {
    				StringBuilder nstrbld = new StringBuilder(node.data);
    				nstrbld.setCharAt(i, ch);
    				DistNode nn = new DistNode(nstrbld.toString());
    				node.addChild(nn);
    			}
    		}
    	}
    	if (node.children.size() > 0) {
    		for (DistNode child : node.children) {
    			buildChildren(child, endStr);
    		}
    	}
    }
    
    private int calcParent(DistNode node) 
    {
    	int n = 0;
    	while (node != null) {
    		System.out.println(node.data);
    		n++;
    		node = node.parent;
    	}
    	return n - 1;
    }
    
    public int findPath(String endStr)
    {
    	return findPath(endStr, root);
    }
    
    private int findPath(String endStr, DistNode node) 
    {
    	ArrayList<DistNode> list = new ArrayList<DistNode>();
    	list.add(node);
    	while (list.size() > 0) {
    		DistNode one = list.remove(0);
    		if (one.data.equals(endStr)) {
    			return calcParent(one);
    		}
    		for (DistNode child : one.children) {
    			list.add(child);
    		}
    	}
    	return -1;
    }
    
    public void print() {
        print("", true, root);
    }

    private void print(String prefix, boolean isTail, DistNode node) {
        System.out.println(prefix + (isTail ? "--- " : "+-- ") + node.toString());
        DistNode last = null;
        if (node.children.size() > 0) {
        	last = node.children.get(node.children.size() - 1);
        	
        }
		for (DistNode child : node.children) {
			boolean lone = (child == last) ? true : false;
            print(prefix + (isTail ? "    " : "|   "), lone, child);
        }
     }

}
