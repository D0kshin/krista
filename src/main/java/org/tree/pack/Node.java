package org.tree.pack;

import java.util.ArrayList;

public class Node {
    private String name;
    private Integer id = null;
    private ArrayList<Node> childrenNodes = new ArrayList<>();
    private Node parent = null;
    public Node(String name){
        this.name = name;
    }
    public void addChild(Node child){
        childrenNodes.add(child);
    }

    //GET
    public int getId() {
        return this.id;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Node> getChildren(){
        return childrenNodes;
    }
    public Node getParent(){
        return  parent;
    }

    //SET
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setChildrenNodes(ArrayList<Node> list){
        this.childrenNodes = list;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }

}
