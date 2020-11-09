package com.zxin.java.design.action.chain;

/**
 * @author zxin
 */
public class Chain {

    private Node<Handler> head;

    private Node<Handler> tail;

    public Chain(Handler e){
        head = new Node<>(e);
        tail = new Node<>(e);
    }

    public Chain next(Handler e){
        tail.next = new Node<>(e);
        tail = tail.next;
        return this;
    }

    public void doHandle(){
        for (Node<Handler> node = head; node != null; node = node.next) {
            node.item.handle();
        }
    }



    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E element) {
            this.item = element;
        }
    }
}
