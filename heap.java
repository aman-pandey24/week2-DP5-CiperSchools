package CP;

import java.util.ArrayList;
import java.util.PriorityQueue;
class Minheap{
    ArrayList<Integer> data;
    Minheap(){
        data=new ArrayList<>();
        data.add(null);
    }
    public void addElement(int element){
        // time complexity- log(n)
        data.add(element);
        int curr_index=data.size()-1;
        int parent_index=curr_index/2;

        while(curr_index!=1){
            if (data.get(curr_index)>=data.get(parent_index)){
                return;
            }
            int curr_data=data.get(curr_index);
            int parent_data=data.get(parent_index);
            data.set(curr_index,parent_data);
            data.set(parent_index,curr_data);
            curr_index=parent_index;
            parent_index=curr_index/2;
        }
    }
    public int min(){
        return data.get(1);
    }
    public int removeMin(){
        int last_index=data.size()-1;
        int first_index=1;
        int a1=data.get(1);
        int a_last=data.get(last_index);
        data.set(last_index,a1);
        data.set(first_index,a_last);
        data.remove(last_index);

        minheapify(1);
        return a1;
    }
    public boolean isLeaf(int pos)
    {

        if (pos > (data.size()/ 2)) {
            return true;
        }
        return false;
    }
    private int leftChild(int pos) { return (2 * pos); }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    public void minheapify(int pos){
        if(!isLeaf(pos)){
            int swapPos= pos;
            if(rightChild(pos)<=data.size()){
                swapPos = data.get(leftChild(pos))<data.get(rightChild(pos))?leftChild(pos):rightChild(pos);
            }
            else
                swapPos= data.get(leftChild(pos));

            if(data.get(pos)>data.get(leftChild(pos))|| data.get(pos)>data.get(rightChild(pos))){
                int old=data.get(pos);
                int neww=data.get(swapPos);
                data.set(pos,neww);
                data.set(swapPos,old);
                minheapify(swapPos);
            }

        }
    }
}
public class heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(5);
        pq.offer(1);
        pq.add(3);
        System.out.println(pq.peek());
        Minheap heap=new Minheap();
        heap.addElement(5);
        heap.addElement(1);
        heap.addElement(3);
        heap.addElement(15);
        heap.addElement(8);
        System.out.println(heap.min());
        System.out.println(heap.removeMin());
        System.out.println(heap.data);
    }
}
