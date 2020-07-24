package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class Node <T extends Comparable<T>> implements INode<T> {

    private ArrayList<INode<T>> heap;
    private int index;
    private T value;

    public Node (ArrayList<INode<T>> heap, int index, T value){
        this.heap = heap;
        this.index = index;
        this.value = value ;
    }

    @Override
    public INode<T> getLeftChild() {
        int leftIndex = (this.index * 2 ) + 1;
        if (leftIndex < this.heap.size()){
            return this.heap.get(leftIndex);
        }
        return null;
    }

    @Override
    public INode<T> getRightChild() {
        int rightIndex = (this.index * 2) + 2;
        if (rightIndex < this.heap.size()){
            return this.heap.get(rightIndex);
        }
        return null;
    }

    @Override
    public INode<T> getParent() {
        if (this.index == 0) return null;
        int parentIndex = ( this.index - 1 ) / 2 ;
        if (parentIndex >= 0){
            return this.heap.get(parentIndex);
        }
        return null;
    }

    @Override
    public T getValue() {
        return this.value ;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
