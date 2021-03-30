package com.company;

public abstract class NodeConstruc {
    protected NodeConstruc rightList = null;
    protected NodeConstruc leftList = null;
    protected Object value;

    public NodeConstruc(Object value){
        this.value = value;
    }
    abstract NodeConstruc next();
    abstract NodeConstruc setNext(NodeConstruc item);
    abstract NodeConstruc previous();
    abstract NodeConstruc setPrevious(NodeConstruc item);
    public Object getValue() {
        return value;
    }
}
