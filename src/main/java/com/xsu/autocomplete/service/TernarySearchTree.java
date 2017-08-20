package com.xsu.autocomplete.service;

import com.xsu.autocomplete.model.Node;

import java.util.TreeSet;

public class TernarySearchTree {

    //root node
    private Node root;

    private int topNumber;

    //stock the result in tree set with no duplication but in order
    TreeSet<String> result = new TreeSet<String>();

    //construct the tree recursively
    public Node insert(String word,Node node,Integer index) {
        if(word == null || "".equals(word))
            return null;

        //convert the word to a char array
        char[] charArray = word.toCharArray();

        //condition of the end of the recursion; create a new node if no modification
        if(node == null) {
            node = new Node(charArray[index],false);
        }

        if(charArray[index] < node.getStoreChar()) {
            node.setLeftChild(this.insert(word, node.getLeftChild(),index));
        } else if(charArray[index] == node.getStoreChar()) {

            //if is the last char of the word, set complete
            if(index + 1 == charArray.length) {
                node.setComplete(true);
            } else {
                node.setCenterChild(this.insert(word, node.getCenterChild(),++index));
            }

        } else {
            node.setRightChild(this.insert(word, node.getRightChild(),index));
        }

        return node;
    }

    //insert the tree to the root node
    public void insert(String word) {
        root = this.insert(word,root,0);
    }

    public String toString() {
        traverse(root, "");
        return "\nTernary Search Tree : "+ result;
    }
    //Traverse the tree
    private void traverse(Node node, String str) {
        if (node != null)
        {
            traverse(node.getLeftChild(), str);

            str = str + node.getStoreChar();
            if (node.isComplete())
                result.add(str);

            traverse(node.getCenterChild(), str);
            str = str.substring(0, str.length() - 1);

            traverse(node.getRightChild(), str);
        }
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(Node node, char[] word, int index) {
        if (node == null)
            return false;

        if (word[index] < node.getStoreChar())
            return search(node.getLeftChild(), word, index);
        else if (word[index] > node.getStoreChar())
            return search(node.getRightChild(), word, index);
        else
        {
            if (node.isComplete() && index == word.length - 1)
                return true;
            else if (index == word.length - 1)
                return false;
            else
                return search(node.getCenterChild(), word, index + 1);
        }
    }

    private Node findNode(String prefix) {
        return findNode(root,prefix.toCharArray(),0);
    }

    private Node findNode(Node node, char[] word, int index) {
        if (node == null)
            return null;

        if (word[index] < node.getStoreChar())
            return findNode(node.getLeftChild(), word, index);
        else if (word[index] > node.getStoreChar())
            return findNode(node.getRightChild(), word, index);
        else
        {
            if (index == word.length - 1)
                return node.getCenterChild();
            else
                return findNode(node.getCenterChild(), word, index + 1);
        }
    }

    //search the word with the same prefix
    public TreeSet<String> prefixSearch(String prefix,Node node) {

        if(result.size() == topNumber){
            return result;
        } else {
            if(node != null) {
                if(node.isComplete()) {
                    result.add(prefix + node.getStoreChar());
                }

                prefixSearch(prefix,node.getLeftChild());
                prefixSearch(prefix + node.getStoreChar(), node.getCenterChild());
                prefixSearch(prefix,node.getRightChild());
            }

            if(search(prefix))
                result.add(prefix);
        }

        return result;
    }

    public TreeSet<String> prefixSearch(String prefix, int topNumber) {
        Node node = findNode(prefix);
        this.topNumber = topNumber;

        TreeSet<String> resultHashSet = prefixSearch(prefix,node);

        return resultHashSet;
    }

}
