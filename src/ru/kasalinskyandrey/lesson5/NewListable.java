package ru.kasalinskyandrey.lesson5;

public interface NewListable {
    public boolean isEmpty();
    public int getSize();
    public String[] addFirst(String str);
    public String[] add(Integer index, String str);
    public String[] addLast(String str);
    public String getFirst();
    public String getLast();
    public int getIndex(String str);
    public String[] removeFirst();
    public String[] removeLast();
    public String[] remove(Integer index);
    public boolean contains(String str);
}
