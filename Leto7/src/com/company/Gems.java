package com.company;

public class Gems extends Necklace{
    private int size;
    public Gems(int price, int weight, int transparency, int size) {
        super(price, weight, transparency);
        this.size = size;
    }



    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() !=o.getClass()) return false;
        Gems gems = (Gems) o;
        return size == gems.size;
}

}