package CP;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumInEachWindow {
    public static void printMaximum(int[] arr,int k){
        Deque<Integer> deque=new LinkedList<>();
        int curr_index=0;
        for (curr_index=0;curr_index<k;curr_index++){
            while(!deque.isEmpty()&&arr[curr_index]>=arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(curr_index);
        }
        for (;curr_index<arr.length;curr_index++){
            System.out.println(arr[deque.peek()]);
            while (!deque.isEmpty()&&deque.peek()<=curr_index-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&&arr[curr_index]>=arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.add(curr_index);
        }
        System.out.println(arr[deque.peek()]);
        while (!deque.isEmpty()){
            deque.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] arr={7,6,8,5,8,3,2,10};
        printMaximum(arr,3);
    }
}
