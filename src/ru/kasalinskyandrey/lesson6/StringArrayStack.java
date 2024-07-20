package ru.kasalinskyandrey.lesson6;

public class StringArrayStack implements StringStack{
    private static final int INIT_SIZE = 16;

    private static final double INCREASE_COEF = 1.5;

    private String[] innerArray;

    private int actualSize;

    public StringArrayStack() {
        this.innerArray = new String[INIT_SIZE];
        this.actualSize = 0;
    }

    @Override
    public void push(String str){
        innerArray[actualSize] = str;
        actualSize++;

    }

    @Override
    public String pop(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }
        String pop1 = innerArray[actualSize-1];
        innerArray[actualSize-1] = null;
        actualSize--;

        return pop1;

    }

    @Override
    public String peek(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }

        return innerArray[actualSize-1];

    }
}
