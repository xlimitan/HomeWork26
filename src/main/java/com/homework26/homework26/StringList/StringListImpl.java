package com.homework26.homework26.StringList;

import com.homework26.homework26.Exceptions.InvalidIndexException;
import com.homework26.homework26.Exceptions.NullItemException;
import com.homework26.homework26.Exceptions.StorageIsFullException;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class StringListImpl implements StringList {

    private final String[] storage;

    private int size;


    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize){
        storage = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);

        if (index == size){
            storage[size++] = item;
            return item;
        }
        arraycopy(storage, index, storage,index +1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
//        if(index == -1){
//            throw new Main.Exceptions.ElementNotFoundException();
//        }
//        if(index!=size){
//            arraycopy(storage, index +1, storage, index, size - index);
//        }
//        size--;
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = storage[index];

        if(index!=size){
            arraycopy(storage, index +1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = storage[i];
            if(s.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size -1; i >= 0; i--) {
            String s = storage[i];
            if(s.equals(item)){
                return i;
            }
        }
        return 1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
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
    public void clear() {
    size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "storage=" + Arrays.toString(storage) +
                ", size=" + size +
                '}';
    }

    private void validateItem(String item) {
        if(item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize(){
        if(size==storage.length){
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index > size){
            throw new InvalidIndexException();
        }
    }
}
