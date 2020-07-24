package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class Heap <T extends Comparable<T>> implements IHeap<T> {

    private ArrayList<INode<T>> heap ;

    public Heap (){
        this.heap = new ArrayList<>();
    }

    public Heap (ArrayList<INode<T>> heap){
        this.heap = heap;
    }

    @Override
    public INode<T> getRoot() {
        if (size() == 0) return null;
        return this.heap.get(0);
    }

    @Override
    public int size() {
        return this.heap.size();
    }

    @Override
    public void heapify(INode<T> node) {
        if (node == null || size() == 0 || size() == 1) return;
        if (size() == 2){
            if (this.heap.get(1).getValue().compareTo(this.heap.get(0).getValue()) > 0){
                T temp = this.heap.get(0).getValue();
                this.heap.get(0).setValue(this.heap.get(1).getValue());
                this.heap.get(1).setValue(temp);
            }
            return;
        }
        if (size() == 3){
            INode<T> leftChild;
            INode<T> rightChild;
            if (node.getParent() != null) {
                node = node.getParent();
            }
            leftChild = node.getLeftChild();
            rightChild = node.getRightChild();
            if (!(leftChild.getValue().compareTo(rightChild.getValue()) < 0) && leftChild.getValue().compareTo(node.getValue()) > 0){
                T temp = node.getValue();
                node.setValue(leftChild.getValue());
                leftChild.setValue(temp);
            }
            else if ((rightChild.getValue().compareTo(leftChild.getValue()) > 0) && rightChild.getValue().compareTo(node.getValue()) > 0){
                T temp = node.getValue();
                node.setValue(rightChild.getValue());
                rightChild.setValue(temp);
            }
            return;
        }
        //heapify up
        while (node.getParent() != null){
            node = node.getParent() ;
            INode<T> leftChild = node.getLeftChild();
            if (leftChild == null){
                node = node.getParent();
                continue;
            }
            INode<T> rightChild = node.getRightChild();
            if ( (rightChild == null) || !(leftChild.getValue().compareTo(rightChild.getValue()) < 0) ) {
                if (leftChild.getValue().compareTo(node.getValue()) > 0){
                    T temp = node.getValue();
                    node.setValue(leftChild.getValue());
                    leftChild.setValue(temp);
                }
            }
            else {
                if (rightChild.getValue().compareTo(node.getValue()) > 0){
                    T temp = node.getValue();
                    node.setValue(rightChild.getValue());
                    rightChild.setValue(temp);
                }
            }
        }
        //heapify down
        while (node.getLeftChild() != null){
            INode<T> leftChild = node.getLeftChild();
            INode<T> rightChild = node.getRightChild();
            if (rightChild == null){
                if (leftChild.getValue().compareTo(node.getValue()) > 0) {
                    T temp = node.getValue();
                    node.setValue(leftChild.getValue());
                    leftChild.setValue(temp);
                }
                break;
            }
            if ( !(leftChild.getValue().compareTo(rightChild.getValue()) < 0) && leftChild.getValue().compareTo(node.getValue())>0){
                T temp = node.getValue();
                node.setValue(leftChild.getValue());
                leftChild.setValue(temp);
                node = leftChild;
            }
            else if (rightChild.getValue().compareTo(leftChild.getValue()) > 0 && rightChild.getValue().compareTo(node.getValue())>0){
                T temp = node.getValue();
                node.setValue(rightChild.getValue());
                rightChild.setValue(temp);
                node = rightChild;
            }
            else {
                break;
            }
        }
    }

    @Override
    public T extract() {
        if (this.heap.size() == 0) return null;
        T max = this.getRoot().getValue();
        if (size() == 1){
            this.heap.remove(0);
        }
        else if (size() == 2){
            this.getRoot().setValue(this.heap.get(1).getValue());
            this.heap.remove(1);
        }
        else if (size() == 3){
            if (this.heap.get(2).getValue().compareTo(this.heap.get(1).getValue()) < 0){
                this.heap.get(0).setValue(this.heap.get(1).getValue());
                this.heap.get(1).setValue(this.heap.get(2).getValue());
            }
            else {
                this.heap.get(0).setValue(this.heap.get(2).getValue());
            }
            this.heap.remove(2);

        }
        else{
            this.getRoot().setValue(this.heap.get(this.heap.size() -1).getValue());
            this.heap.remove(this.heap.size() - 1);
            heapify(getRoot());
        }
        return max;
    }

    @Override
    public void insert(T element) {
        if (element == null) return ;
        INode<T> add = new Node<>(this.heap, size(), element);
        heap.add(add);
        heapify(add);
    }

    @Override
    public void build(Collection<T> unordered) {
        if (unordered == null) return;
        this.heap = new ArrayList<>();
        for (T element : unordered){
            insert(element);
        }
    }
}
