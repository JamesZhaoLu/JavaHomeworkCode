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

public class TreeNode {
    int key;
    int height;
    String data;
    TreeNode left, right;
 
    public TreeNode(int key, String data) 
    {
    	this.key = key;
        this.data = data;
        this.height = 0;
        this.left = this.right = null;
    }
    //System.out.println(a);

    public String toString()
    {
    	return "" + key + " " + data;
    }

}