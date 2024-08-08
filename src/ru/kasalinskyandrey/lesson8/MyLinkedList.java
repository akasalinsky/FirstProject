package ru.kasalinskyandrey.lesson8;

public class MyLinkedList<E> implements MyLinkedL<E>{

    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public MyLinkedList() {
        lstNode = new Node<>(null, fstNode, null);
        fstNode = new Node<>(null, null, lstNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<>(null, prev, null);
        prev.setNextElement(lstNode);

        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> prev = fstNode;
        prev.setCurrentElement(e);
        fstNode = new Node<>(null, null, prev);
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

    @Override
    public void remove(E e) {
        Node<E> testElement = fstNode.getNextElement();

        for(int i = 1; i <= size ; i++) {

            E testCurrentElement = testElement.getCurrentElement();

            if(e.equals(testCurrentElement)){

                testElement.getPrevElement().setNextElement(testElement.getNextElement());
                testElement.getNextElement().setPrevElement(testElement.getPrevElement());
                size--;
            }

            testElement = testElement.getNextElement();
        }


    }

    @Override
    public void removeFirst() {

        fstNode.setNextElement(fstNode.getNextElement().getNextElement());

        size--;

    }

    @Override
    public void removeLast() {

        lstNode.setPrevElement(lstNode.getPrevElement().getPrevElement());

        size--;

    }

    @Override
    public E getFirstElement() {
        return fstNode.getNextElement().getCurrentElement();
    }

    @Override
    public E getLastElement() {
        return lstNode.getPrevElement().getCurrentElement();
    }

    @Override
    public int indexOf(E e) {
        Node<E> testElement = fstNode.getNextElement();

        for(int i = 1; i <= size ; i++) {

            E testCurrentElement = testElement.getCurrentElement();

            if(e.equals(testCurrentElement)){

                return i;
            }

            testElement = testElement.getNextElement();
        }


        return 0;
    }

    @Override
    public void clearAll() {
        lstNode = new Node<>(null, fstNode, null);
        fstNode = new Node<>(null, null, lstNode);
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

        public Node<E> getPrevElement() { return prevElement; }

        public void setNextElement(Node<E> nextElement) { this.nextElement = nextElement; }

        public void setPrevElement(Node<E> prevElement) { this.prevElement = prevElement; }
    }

}
