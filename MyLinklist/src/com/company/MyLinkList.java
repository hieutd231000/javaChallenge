package com.company;

public class MyLinkList implements NodeList{
    private NodeConstruc root;
    public MyLinkList(NodeConstruc root){
        this.root = root;
    }
    @Override
    public NodeConstruc getRoot() {
        return root;
    }

    @Override
    public boolean addItem(NodeConstruc newItem) {
        if(this.root==null){
            this.root = newItem;
            return true;
        }
        NodeConstruc currentItem = this.root;
        while(currentItem!=null){
            int compare = ((String) currentItem.getValue()).compareTo(((String) newItem.getValue()));
            if(compare<0){
                if(currentItem.next()!=null){
                    currentItem = currentItem.next();
                }else{
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }
            else if(compare>0){
                if(currentItem.previous()!=null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                    return true;
                }else{
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                    this.root = newItem;
                    return true;
                }
            }
            else{
                System.out.println("Cant add");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(NodeConstruc removeItem) {
        if(this.root==null){
            System.out.println("Cant remove");
            return false;
        }
        NodeConstruc currentItem = this.root;
        while(currentItem!=null){
            int compare = ((String) currentItem.getValue()).compareTo(((String) removeItem.getValue()));
            if(compare<0){
                if(currentItem.next().next()!=null){
                    currentItem = currentItem.next();
                }else{
                    currentItem.setNext(null);
                    return true;
                }
            }
            else if(compare==0){
                if(currentItem.previous()!=null){
                    currentItem.next().setPrevious(currentItem.previous());
                    currentItem.previous().setNext(currentItem.next());
                    return true;
                }else{
                    currentItem.next().setPrevious(null);
                    this.root = currentItem.next();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void listItem(NodeConstruc root) {
        if(root==null){
            System.out.println("List empty");
        }else{
            while(root!=null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
