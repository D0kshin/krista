package org.tree.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    @Test
    void  createNode(){
        Node node = new Node("name123");
        assertEquals("name123", node.getName());
    }

    @Test
    void createTree(){
        Tree tree = new Tree("123aa");
        assertEquals(tree.findNode(tree.getRootNode(), 0).getName(), "123aa");
    }

    @Test
    void addNode(){
        Node node = new Node("root");
        Tree tree = new Tree(node);
        tree.addChild(tree.getRootNode().getId(), "child1");
        assertEquals(tree.findNode(tree.getRootNode(), 1).getName(), "child1");
    }

    @Test
    void addNodesById(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        assertEquals(tree.findNode(tree.getRootNode(), 4).getName(), "child4");
    }

    @Test
    void addNodesByName1(){
        Node root = new Node("us");
        Tree tree = new Tree(root);
        tree.addChild(root.getName(), "child1");
        tree.addChild(root.getName(), "child2");
        tree.addChild(root.getName(), "child3");
        tree.addChild("child3", "child4");
        assertEquals(tree.findNode(tree.getRootNode(), 4).getName(), "child4");
    }

    @Test
    void addNodesByName2(){
        Node root = new Node("us");
        Tree tree = new Tree(root);
        tree.addChild(root.getName(), "child1");
        tree.addChild(root.getName(), "child2");
        tree.addChild(root.getName(), "child3");
        tree.addChild("child3", "child4");
        tree.addChild("child4", "child5");
        tree.addChild("child5", "child6");
        assertEquals(tree.findNode(tree.getRootNode(), "child5").getName(), "child5");
    }

    @Test
    void searchNodesById1(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(tree.findNode(root, 3).getId(), "child4");
        tree.addChild(tree.findNode(root, 3).getId(), "child5");
        tree.addChild(tree.findNode(root, 3).getId(), "child6");
        tree.addChild(tree.findNode(root, 4).getId(), "child7");
        assertEquals(tree.findNode(tree.getRootNode(), 4).getName(), "child4");
    }

    @Test
    void findNodeById2(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild(5, "child8");
        tree.addChild(5, "child9");
        tree.addChild(9, "child10");
        assertEquals(tree.findNode(root, 10).getName(), "child10");
    }

    @Test
    void searchNodesByIdisBull(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(tree.findNode(root, 3).getId(), "child4");
        tree.addChild(tree.findNode(root, 3).getId(), "child5");
        tree.addChild(tree.findNode(root, 3).getId(), "child6");
        tree.addChild(tree.findNode(root, 4).getId(), "child7");
        assertEquals(tree.findNode(tree.findNode(tree.getRootNode(), 4), 1), null);
    }

    @Test
    void findNodeByName1(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        assertEquals(tree.findNode(root, "child3").getId(), 3);
    }

    @Test
    void findNodeByName2(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        assertEquals(tree.findNode(root, "child7").getId(), 7);
    }

    @Test
    void findNodeByName3(){
        Node root = new Node("root");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild(5, "child8");
        tree.addChild(5, "child9");
        tree.addChild(9, "child10");
        assertEquals(tree.findNode(root, "child10").getId(), 10);
    }

    @Test
    void startSearchNodeFinding1(){
        Node root = new Node("aaa");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild(5, "child8");
        tree.addChild(5, "child9");
        tree.addChild(9, "child10");
        assertEquals(tree.findNode(root, "aaa").getName(), "aaa");
    }

    @Test
    void startSearchNodeFinding2(){
        Node root = new Node("aaa");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild(5, "child8");
        tree.addChild(5, "child9");
        tree.addChild(9, "child10");
        assertEquals(tree.findNode(root, 0).getName(), "aaa");
    }
    @Test
    void deleteAllChildren(){
        Node root = new Node("aaa");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild(5, "child8");
        tree.addChild(5, "child9");
        tree.addChild(9, "child10");
        tree.deleteAllChildren(3);
        assertEquals(tree.findNode(root, "child5"), null);
        assertEquals(tree.findNode(root, 9), null);
        assertEquals(tree.findNode(root, 2).getName(), "child2");
        tree.deleteAllChildren("aaa");
        assertEquals(tree.findNode(root, 3), null);
        assertEquals(tree.findNode(root, 2), null);
    }

    @Test
    void deleteNode(){
        Tree tree = new Tree("h1h2h");
        Node root = tree.getRootNode();
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild("child1", "child11");
        tree.addChild("child1", "child12");
        tree.addChild("child1", "child13");
        tree.addChild("child2", "child21");
        tree.addChild("child2", "child22");
        tree.deleteChild("child12");
        assertEquals(tree.findNode(root, "child12"), null);
        assertEquals(tree.findNode(root, "child13").getName(), "child13");
        assertEquals(tree.findNode(root, "child11").getName(), "child11");
        tree.deleteChild(6);
        assertEquals(tree.findNode(root, 6), null);
        assertEquals(tree.findNode(root, 7).getName(), "child22");
    }

    @Test
    void changeNodeName(){
        Tree tree = new Tree("h1h2h");
        Node root = tree.getRootNode();
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild("child1", "child11");
        tree.addChild("child1", "child12");
        tree.addChild("child1", "child13");
        tree.addChild("child2", "child21");
        tree.addChild("child2", "child22");
        tree.changeNodeName("child12", "newChild12");
        assertEquals(tree.findNode(root, "child12"), null);
        assertEquals(tree.findNode(root, "newChild12").getName(), "newChild12");
        tree.changeNodeName(6, "newChild21");
        assertEquals(tree.findNode(root, 6).getName(), "newChild21");
        assertEquals(tree.findNode(root, 7).getName(), "child22");
    }
}
