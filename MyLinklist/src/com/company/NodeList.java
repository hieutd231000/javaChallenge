package com.company;

public interface NodeList {
    NodeConstruc getRoot();
    boolean addItem(NodeConstruc item);
    boolean removeItem(NodeConstruc item);
    void listItem(NodeConstruc root);
}
