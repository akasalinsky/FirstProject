package ru.kasalinskyandrey.lesson8;

public class MyLinkedList<E> implements MyLinkedL<E>{

    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public MyLinkedList() {
        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<E>(null, prev, null);
        prev.setNextElement(lstNode);

        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> prev = fstNode;
        prev.setCurrentElement(e);
        fstNode = new Node<E>(null, null, prev);
        prev.setPrevElement(fstNode);
        size++;

    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> name = fstNode.getNextElement();
        for(int i = 1; i <= size ; i++) {
           if(i == counter){
               return name.getCurrentElement();
           }
           else name = name.getNextElement();
       }

        return null;
    }
  
    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }


        public E getCurrentElement() { return currentElement; }

        public void setCurrentElement(E currentElement) { this.currentElement = currentElement; }

        public Node<E> getNextElement() { return nextElement; }

        public void setNextElement(Node<E> nextElement) { this.nextElement = nextElement; }

        public void setPrevElement(Node<E> prevElement) { this.prevElement = prevElement; }
    }

}
