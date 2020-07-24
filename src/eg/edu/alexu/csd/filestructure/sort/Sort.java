package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
public class Sort <T extends Comparable<T>> implements ISort<T> {
    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        IHeap ordered = new Heap();
        if (unordered==null||unordered.isEmpty()||unordered.size()==0){
            return ordered;
        }
        Heap heap1 = new Heap();
        heap1.build(unordered);
        int n = heap1.size();
        for (int i = n-1; i>=0; i--){
            unordered.set(i, (T) heap1.extract());
        }
        ArrayList<INode<T>> reversed = new ArrayList<>(unordered.size());
        for (T element : unordered){
            reversed.add(new Node<>(reversed, reversed.size(), element));
        }
        return new Heap<>(reversed);
    }
    @Override
    public void sortSlow(ArrayList unordered) {
        if(unordered==null||unordered.isEmpty()||unordered.size()==0){
            return;
        }
        boolean swapped;
        T temp;
        for(int i = 0; i<unordered.size()-1; i++){
            swapped=false;
            for(int j=0; j<unordered.size()-i-1; j++){
                T a = (T) unordered.get(j);
                T b = (T) unordered.get(j+1);
                if (a.compareTo(b)>0){
                    temp = (T)unordered.get(j);
                    unordered.set(j,unordered.get(j+1));
                    unordered.set((j+1), temp);
                    swapped=true;
                }
            }
            if(swapped==false){
                break;
            }
        }
    }
    @Override
    public void sortFast(ArrayList unordered) {
        if(unordered==null||unordered.isEmpty()||unordered.size()==0){
            return;
        }
        int low = 0;
        int high = unordered.size()-1;
        quickSort(unordered, low, high);
    }
    private void quickSort (ArrayList unordered, int low, int high){
        if(low>=high){
            return;
        }
        int middle = low + (high-low)/2;
        T pivot = (T) unordered.get(middle);
        int i = low, j = high;
        while (i<=j){
            while (((T)unordered.get(i)).compareTo(pivot)<0){
                i++;
            }
            while(((T)unordered.get(j)).compareTo(pivot)>0){
                j--;
            }
            if (i<=j){
                T temp = (T)unordered.get(i);
                unordered.set(i,unordered.get(j));
                unordered.set(j, temp);
                i++;
                j--;
            }
        }
        if(low<j){
            quickSort(unordered,low,j);
        }
        if (high>i){
            quickSort(unordered, i, high);
        }
    }
}