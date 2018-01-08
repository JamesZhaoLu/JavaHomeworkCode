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

public class DistNode {
    String data;
    ArrayList<DistNode> children;
    DistNode parent;
 
    public DistNode(String data) 
    {
        this.data = data;
        this.children = new ArrayList<DistNode>();
        parent = null;
    }
    public void addChild(DistNode child)
    {
    	child.parent = this;
    	children.add(child);
    }
    
    public String toString()
    {
    	return data;
    }

}
