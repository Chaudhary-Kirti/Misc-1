
import java.util.*;

class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor for single integer value
    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }

    // Constructor for list
    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.value = null;
    }

    public boolean isInteger() {
        return this.value != null;
    }

    public Integer getInteger() {
        return this.value;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}

public class Main {
    public  void main(String[] args) {
        // Corrected method to create nested lists
        System.out.println(depthSum(Arrays.asList(
            new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))), // [1, 1]
            new NestedInteger(2), // 2
            new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1)))  // [1, 1]
        ))); // Output: 10

     // Nested List: [1, [4, [6]]]
        List<NestedInteger> nestedList2 = new ArrayList<>();
        nestedList2.add(new NestedInteger(1)); // depth 1
        nestedList2.add(new NestedInteger(Arrays.asList(
            new NestedInteger(4), // depth 2
            new NestedInteger(Arrays.asList(new NestedInteger(6))) // depth 3
        )));

        System.out.println(depthSum(nestedList2)); // Expected Output: 27
    }

    //bfs
    // public static int depthSum(List<NestedInteger> nestedList ){
    //     Queue<NestedInteger> q = new LinkedList<>();
    //     for(NestedInteger ne: nestedList){
    //         q.add(ne);
    //     }
    //     int depth = 1;
    //     int result = 0;
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         for(int i = 0; i < size; i++){
    //             NestedInteger curr = q.poll();
    //             if(curr.isInteger()){
    //                 result += curr.getInteger() * depth;
    //             }else{
    //                 for(NestedInteger ne: curr.getList()){
    //                     q.add(ne);       
    //                 }
    //             }
    //         }
    //         depth++;
    //     }
    //     return result;
    // }
    
    
    //dfs
      int result = 0;
        public  int depthSum(List<NestedInteger> nestedList ){
            dfs(nestedList, 1);
            return result;    
    }
    
    private  void dfs(List<NestedInteger> nestedList, int depth){
        
        for(NestedInteger ne: nestedList){
            if(ne.isInteger()){
                result += ne.getInteger() * depth;
            }else{
                dfs(ne.getList(), depth + 1);
            }
        }
    }
}