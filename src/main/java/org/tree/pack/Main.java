package org.tree.pack;

import org.tree.pack.Tree;


public class Main {
    public static void main(String[] args) {

        Node root = new Node("as");
        Tree tree = new Tree(root);
        tree.addChild(root.getId(), "child1");
        tree.addChild(root.getId(), "child2");
        tree.addChild(root.getId(), "child3");
        tree.addChild(3, "child4");
        tree.addChild(2, "aboba");
        tree.addChild(2, "aboba");
        tree.addChild(2, "aboba");
        tree.addChild(3, "child5");
        tree.addChild(4, "child6");
        tree.addChild(4, "child7");
        tree.addChild("aboba", "azeth");
        tree.printTreeInFile();
    }
}