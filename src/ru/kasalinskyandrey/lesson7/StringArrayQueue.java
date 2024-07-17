package ru.kasalinskyandrey.lesson7;

public class StringArrayQueue implements StringQueue{
    private static final int INIT_SIZE = 16;

    private static final double INCREASE_COEF = 1.5;

    private String[] innerArray;

    private int actualSize;

    public StringArrayQueue() {
        this.innerArray = new String[INIT_SIZE];
        this.actualSize = 0;
    }

    @Override
    public void add(String str){
        innerArray[actualSize] = str;
        actualSize++;
    }

    @Override
    public String poll(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }
        String pop1 = innerArray[0];

        for (int i = 0; i < actualSize; i++){
            innerArray[i] = innerArray[i+1];
        }

        actualSize--;

        return pop1;
    }

    @Override
    public String peek(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }
        return innerArray[0];
    }
}
