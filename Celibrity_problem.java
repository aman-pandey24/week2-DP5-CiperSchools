package CP;

import java.util.Stack;

public class Celibrity_problem {
    public static boolean find_celebrity(int[][] matrix){
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<matrix.length;i++){
            stack.push(i);
        }
        while (stack.size()>=2){
            int person1=stack.pop();
            int person2=stack.pop();
            if (matrix[person1][person2]==1){
                stack.push(person2);
            }
            else {
                stack.push(person1);
            }
        }
        int remainingPerson=stack.pop();
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][remainingPerson]==0||matrix[remainingPerson][i]==1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matrix={
                {0,1,0,1},
                {0,0,0,1},
                {0,1,0,1},
                {1,1,1,0}
        };
        System.out.println(find_celebrity(matrix));
    }
}
