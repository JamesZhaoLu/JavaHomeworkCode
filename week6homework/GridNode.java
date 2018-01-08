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

public class GridNode {
    String data;
    ArrayList<GridNode> children;
    GridNode parent;
 
    public GridNode(String data) 
    {
        this.data = data;
        this.children = new ArrayList<GridNode>();
        parent = null;
    }
    
    public void addChild(GridNode child)
    {
    	child.parent = this;
    	children.add(child);
    }
    
    public String toString()
    {
    	return data;
    }
}