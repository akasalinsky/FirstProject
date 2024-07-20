package ru.kasalinskyandrey.lesson6;

public class StringArrayStack implements StringStack{
    private static final int INIT_SIZE = 16;

    private static final double INCREASE_COEF = 1.5;

    private String[] innerArray;

    //указывает на номер пустого элемента массива, в который будет произведена запись
    private int actualSize;

    //Конструктор для создания стека с размером 16
    public StringArrayStack() {
        this.innerArray = new String[INIT_SIZE];
        this.actualSize = 0;
    }

    //Конструктор для создания стека с нужным размером S
    public StringArrayStack(int S) {
        this.innerArray = new String[S];
        this.actualSize = 0;
    }

    private void increaseSize() {
        // increase size of array
        int currentSize = innerArray.length;
        int newSize = (int) (currentSize * INCREASE_COEF);
        String[] newInnerArray = new String[newSize];

        for (int i = 0; i < innerArray.length; i++) {
            newInnerArray[i] = innerArray[i];
        }
        innerArray = newInnerArray;
    }

    @Override
    public void push(String str){
        if (actualSize == innerArray.length) {
            increaseSize();
        }

        innerArray[actualSize] = str;
        actualSize++;

    }

    @Override
    public String pop(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }

        return innerArray[--actualSize];

    }

    @Override
    public String peek(){
        if (actualSize <= 0) {
            throw new IndexOutOfBoundsException("Size: " + actualSize);
        }

        return innerArray[actualSize-1];

    }

    @Override
    public boolean empty(){
        return (actualSize == 0);
    }
}
