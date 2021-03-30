package com.company;

public class Node extends NodeConstruc{
    public Node(Object value){
        super(value);
    }

    @Override
    NodeConstruc next() {
        return this.rightList;
    }

    @Override
    NodeConstruc setNext(NodeConstruc item) {
        this.rightList = item;
        return this.rightList;
    }

    @Override
    NodeConstruc previous() {
        return this.leftList;
    }

    @Override
    NodeConstruc setPrevious(NodeConstruc item) {
        this.leftList = item;
        return this.leftList;
    }
}