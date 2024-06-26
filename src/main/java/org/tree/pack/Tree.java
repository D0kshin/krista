package org.tree.pack;

import java.util.ArrayList;

public class Tree {
    private Node rootNode;
    private Integer currentMaxId = 0;
    public Tree(Node node){
        rootNode = node;
        rootNode.setId(0);
    }
    public Tree(String nodeName){
        rootNode = new Node(nodeName);
        rootNode.setId(0);
    }
    //GET
    public Node getRootNode() {
        return rootNode;
    }
    public Node findNode(Node startSearchNode, Integer id) {
        //поиск уздла дерева по айди искомого узла. поиск начинается от указанного узла
        if(startSearchNode.getId() == id){
            return startSearchNode;
        }
        if(startSearchNode.getChildren() == null){
            return null;
        }
        for (Node child : startSearchNode.getChildren()){
            if(child.getId() != id){
                Node res = findNode(child, id);
                if(res != null){
                    return res;
                }
            }
            else{
                return child;
            }
        }
        return null;
    }
    public Node findNode(Node startSearchNode, String name){
        //поиск уздла дерева по имени искомого узла. поиск начинается от указанного узла
        if(startSearchNode.getName() == name){
            return startSearchNode;
        }
        if(startSearchNode.getChildren() == null){
            return null;
        }
        for (Node child : startSearchNode.getChildren()){
            if(child.getName() != name){
                Node res = findNode(child, name);
                if(res != null){
                    return res;
                }
            }
            else{
                return child;
            }
        }
        return null;
    }
    public void addChild(Integer parentId, String childName){
        //добавление дочернего узла к родительскому узлу по айди родительского узла
        Node parent = findNode(rootNode, parentId);
        Node child = new Node(childName);
        child.setParent(parent);
        currentMaxId += 1;
        child.setId(currentMaxId);
        parent.addChild(child);
    }
    public void addChild(String parentName, String childName){
        //добавление дочернего узла к родительскому узлу по имени родительского узла
        Node parent = findNode(rootNode, parentName);
        Node child = new Node(childName);
        child.setParent(parent);
        currentMaxId += 1;
        child.setId(currentMaxId);
        parent.addChild(child);
    }
    public void deleteAllChildren(Integer nodeId){
        //удаление всех дочерних узлов у родительского узла по его айди
        Node parent = findNode(rootNode, nodeId);
        parent.setChildrenNodes(new ArrayList<Node>());
    }
    public void deleteAllChildren(String nodeName){
        //удаление всех дочерних узлов у родительского узла по его имени
        Node parent = findNode(rootNode, nodeName);
        parent.setChildrenNodes(new ArrayList<Node>());
    }
    public void deleteChild(Integer nodeId){
        //удаление дочернего узла у родительского узла по айди дочернего узла
        Node child = findNode(rootNode, nodeId);
        ArrayList<Node> parentChildList = child.getParent().getChildren();
        parentChildList.remove(child);
    }
    public void deleteChild(String nodeName){
        //удаление дочернего узл у родительского узла по имени дочернего узла
        Node child = findNode(rootNode, nodeName);
        ArrayList<Node> parentChildList = child.getParent().getChildren();
        parentChildList.remove(child);
    }
    public void changeNodeName(Integer nodeId, String newName){
        //изменение имени узла по его айди
        Node node = findNode(rootNode, nodeId);
        node.setName(newName);
    }
    public void changeNodeName(String oldNodeName, String newName){
        //изменение имени узла по его имени
        Node node = findNode(rootNode, oldNodeName);
        node.setName(newName);
    }
    public String getTreeHTMLString(){
        String result =
                "<html>" +
                "  <head>" +
                "    <title>Вывод Дерева</title>" +
                "  </head>" +
                "  <body>" +
                "    <h1>Дерево</h1>" +
                "    <ul>"+
                "    <pre>" +
                recursivePrint(rootNode, 0, "")+
                "   </pre>" +
                "    </ul>" +
                "  </body>" +
                "</html>";
        return result;
    }
    private String recursivePrint(Node startSearchNode, Integer i, String res){
        //печать дерева с текущего узла
        if(i != 0) {
            res += "\n";
            for(int j = 0; j < i; j+=1){
                res += " ";
            }
            res += "\\";
            res += "\n";
        }
        for(int j = 0; j < i; j+=1){
            res += " ";
        }
        res += startSearchNode.getName();
        res += " <a href=\"edit/" + startSearchNode.getId() + "\">Редактировать</a> </li>";
        if(startSearchNode.getChildren().isEmpty()){
            return res;
        }
        i += startSearchNode.getName().length();
        for(Node child: startSearchNode.getChildren()){
            res = recursivePrint(child, i, res);
        }
        return res;
    }
}
