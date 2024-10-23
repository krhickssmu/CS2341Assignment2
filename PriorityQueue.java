public class PriorityQueue<Item extends Comparable<Item>>{
    private Item[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity){
        this.capacity=capacity;
        heap = (Item[]) new Comparable[capacity];
        size=0;
    }

    public void insert(Item item){
        if (size==capacity){
            resize();
        }
        heap[size]=item;
        size++;
        swim(size-1);
    }

    public Item remove(){
        if(size==0){
            return null;
        }
        Item min = heap[0];
        heap[0] = heap [size-1];
        size--;
        sink(0);
        return min;
    }

    public void swim(int index){
        while(index>0){
            int parent = (index-1)/2;
            if(heap[index].compareTo(heap[parent])<0){
                swap(index,parent);
                index = parent;
            }
            else{
                break;
            }
        }
    }

    public void sink(int index){
        while(index<size){
            int leftChild = 2*index+1;
            int rightChild=2*index+2;
            int min = index;
            if(leftChild<size && heap[leftChild].compareTo(heap[min]) < 0) {
                min = leftChild;
            }
            if(rightChild<size && heap[rightChild].compareTo(heap[min]) < 0) {
                min = rightChild;
            }
            if(min!=index) {
                swap(index, min);
            }
            else{
                break;
            }

        }
    }
    private void swap(int i, int j) {
        Item temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private void resize() {
        capacity = capacity * 2;
        Item[] newHeap = (Item[]) new Comparable[capacity];
        for (int i = 0; i < size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

}
