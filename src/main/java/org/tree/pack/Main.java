package org.tree.pack;

import org.tree.pack.Tree;

public class Main {
    public static void main(String[] args) {

        Node root = new Node("asd");
        Tree tree = new Tree(root);
        tree.addChild(0,"child1");

        TreeLoader.saveTreeInFile(tree, "firstSave");
    }
}