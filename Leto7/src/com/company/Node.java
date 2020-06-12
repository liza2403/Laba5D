package com.company;

public class Node {

    private Gems gem;
    private Node next;
    private Node previous;


    public Node(Gems gem, Node next, Node previous) {
        this.gem = gem;
        this.next = next;
        this.previous =previous;
    }

    public Node(Gems gems) {
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous){
        this.previous = previous;
    }

    public Gems getGem() {
        return gem;
    }
    public void setGem(Gems gemmy){
        gem = gemmy;
    }

    public Node getNext() {
        return next;
    }
    public Node getPrevious(){
        return previous;
    }
}
