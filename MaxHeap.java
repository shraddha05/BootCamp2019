//working code
import java.util.*;
public class MaxHeap {
    private int size;
    private int maxsize;
    private int[] myheap;
    private int[] otherheap;

    public MaxHeap(int val){
        this.maxsize=val;
        this.size=0;
        myheap=new int[this.maxsize+1];


    }
    private int parent(int position){
        return ((position-1)/2);
    }
    public void insert(int num){

        if(size == 0) {
            myheap[0] = num;
            //if(size>0){
            size++;
        }
        else {
            myheap[size] = num ;
            int curr = size;
            while(myheap[curr]>myheap[parent(curr)]) {
                swap(curr, parent(curr));
                curr = parent(curr);
            }
            size++;
        }
    }
    private void swap(int a,int b){
        int temp= myheap[a];
        myheap[a]=myheap[b];
        myheap[b]=temp;
    }
    public void prinn(){
        for(int i=0;i<size;i++)
            System.out.println(myheap[i]);

    }

    private boolean isLeaf(int pos) {
        if (pos>=(size/2) && pos<=size) {
            return true;
        }
        return false;
    }

    private void fix(int val) {
        if (isLeaf(val)){
            return;
        }

        if (myheap[val] < myheap[2 *val + 1] || myheap[val] < myheap[(2 *val) + 2]) {
            if (myheap[2 *val +1] > myheap[(2 *val) + 2]) {
                swap(val, ((val *2) +1));
                //  val=val*2;
                fix((val *2+1));
            } else {
                swap(val, ((val *2) + 2));
                //  val=val*2+1;
                fix((val *2 + 2));
            }
        }
    }
    public void deleteTop(){
        System.out.println("Deleting "+myheap[0]);
        myheap[0]=myheap[size-1];
        System.out.println("new top element is "+myheap[0]);
        size--;
        fix(0);
        //prinn();
    }

    public static void main(String[] args) {
        MaxHeap heapo=new MaxHeap(50);
        heapo.insert(12);
        heapo.insert(9);
        heapo.insert(10);
        heapo.insert(15);
        heapo.insert(6);

        System.out.println("Heap after inserting values : ");
        heapo.prinn();
        System.out.println("Deleting max element");
        heapo.deleteTop();
        System.out.println("New heap is :");
        heapo.prinn();

    }
}

