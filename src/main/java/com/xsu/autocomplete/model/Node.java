package com.xsu.autocomplete.model;

public class Node {

    private char storeChar;

    //is the end of a word
    private boolean isComplete;

    private Node leftChild;
    private Node centerChild;
    private Node rightChild;

    public char getStoreChar() {
        return storeChar;
    }

    public void setStoreChar(char storeChar) {
        this.storeChar = storeChar;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getCenterChild() {
        return centerChild;
    }

    public void setCenterChild(Node centerChild) {
        this.centerChild = centerChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    //constructor
    public Node(char storeChar,boolean isComplete) {
        this.storeChar = storeChar;
        this.isComplete = isComplete;
    }
}
