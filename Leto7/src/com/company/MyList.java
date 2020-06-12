package com.company;

import java.util.*;

public class MyList implements List<Gems> {

    private Node head;
    private Node tail;
    private int size;


    public MyList() {
    }

    public MyList(Gems gem) {
        add(gem);
    }

    public MyList(Collection<? extends Gems> gemcollection) {
        addAll(gemcollection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Gems gems : this) {
            if (gems.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Gems> iterator() {
        return new Myiterator();
    }

    class Myiterator implements Iterator<Gems> {

        protected Node currentNode = head;

        @Override
        public boolean hasNext() {
            if (currentNode != null) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public Gems next() {
            try {
                Gems gem = currentNode.getGem();
                currentNode = currentNode.getNext();
                return gem;
            } catch (NullPointerException e) {
                throw new NoSuchElementException();
            }
        }
    }


    @Override
    public Object[] toArray() {
        Gems[] gems = new Gems[size];
        Node arr = head;
        for (int i = 0; i < gems.length; i++) {
            gems[i] = arr.getGem();
            arr = arr.getNext();
        }
        return gems;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(Gems gem) {
        Node node = new Node(gem, null, null);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node jojo = head;
        while (jojo != null) {
            if (jojo.equals(o)) {
                if (jojo.getPrevious() != null && jojo.getNext() != null)

                {

                    jojo.getPrevious().setNext(jojo.getNext());
                    jojo.getNext().setPrevious(jojo.getPrevious());
                } else {
                    if (jojo.getPrevious() == null) {
                        head = jojo.getNext();
                        head.setPrevious(null);
                    } else if (jojo.getNext() == null)
                        jojo.getPrevious().setNext(null);

                }
            }
            jojo = jojo.getNext();
    }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object o[] = c.toArray();
        boolean operation = true;
        for (int i = 0; i < c.size(); i++) {
            if (!this.contains(o[i])) {
                operation = false;
            }
        }
        return operation;
    }

    @Override
    public boolean addAll(Collection<? extends Gems> c) {
        boolean isCoChanged = false;
        for (Gems gems : c) {
            isCoChanged |= add(gems);
        }
        return isCoChanged;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Gems> c) {
        Object[] arr = c.toArray();
        head = new Node((Gems) arr[0]);
        size++;
        Node jojo = head;
        for (int i = 0; i < arr.length; i++) {
            jojo.setNext(new Node((Gems) arr[i]));
            Node mimi = jojo;
            jojo = jojo.getNext();
            jojo.setPrevious(mimi);
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] o = c.toArray();
        boolean result = true;
        for (int i = 0; i < c.size(); i++)
        if (this.indexOf(o[i]) != -1){
            this.remove(this.indexOf(o[i]));
        }
        else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node jojo = head;
        for (int i = 0; i < size; i++) {
            Node mimi = jojo;
            if (!c.contains(jojo.getGem())) {
                remove(i);
                i--;
            }
            jojo = mimi.getNext();
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    @Override
    public Gems get(int index) {
        Node beg = head;
        for (int i = 0; i < index - 1; i++) {
            beg = beg.getNext();
        }
        return beg.getGem();
    }

    @Override
    public Gems set(int index, Gems gems) {
        Node jojo = head;
        for (int i = 0; i < index - 1; i++) {
            jojo = jojo.getNext();
        }
        Gems a = jojo.getGem();
        jojo.setGem(gems);
        return a;
    }

    @Override
    public void add(int index, Gems gems) {
        if (index == 0) {
            new Node(gems).setPrevious(head);
            head.getPrevious().setNext(head);
            head = head.getPrevious();
        } else {
            int i = 0;
            Node beg = head;
            for (i = 0; i < index; i++) {
                beg = beg.getNext();
            }
            beg.getPrevious().setNext(new Node(gems));
            beg.getPrevious().getNext().setPrevious(beg.getPrevious());
            beg.setPrevious(beg.getPrevious().getNext());
            beg.getPrevious().setPrevious(beg);
        }


    }

    @Override
    public Gems remove(int index) {
        Gems result = null;
        if (index == 0) {
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        if (index != 0) {
            Node jojo = head.getNext();
            for (int i = 1; i < index; i++)
            jojo = jojo.getNext();
            result = jojo.getGem();
            jojo.getPrevious().setNext(jojo.getNext());
            jojo.getNext().setPrevious(jojo.getPrevious());
            size --;
            return result;
    }

    @Override
    public int indexOf(Object o) {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.getGem().equals(o)) {
                return i;
            }
            cur = cur.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int last = -1;
        for (int i = size - 1; (i >= 0) && (last == -1); i--) {
            if (get(i).equals(o)) {
                last = i;
            }
        }
        return last;
    }

    @Override
    public ListIterator<Gems> listIterator() {
        return new MyListIterator();
    }

    class MyListIterator extends Myiterator implements ListIterator<Gems> {

        /*private Node currentNode;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Gems next() {
            return null;
        }
*/
        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Gems previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Gems gems) {

        }

        @Override
        public void add(Gems gems) {

        }

    }

    @Override
    public ListIterator<Gems> listIterator(int index) {
        return null;
    }

    @Override
    public List<Gems> subList(int fromIndex, int toIndex) {
        MyList result = new MyList();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(this.get(i));
        }
        return result;
    }
}