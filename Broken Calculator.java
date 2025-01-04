
//optimized tc- O(log n) +O(k)
//its a approach with '/' and '+'
class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;

        while(target > startValue){
            if(target % 2 == 0){
                target = target/2;
            }else{
                target += 1;
            }
            count++;
        }

        return count + (startValue - target);
        
    }
}


//bfs exponential time limit exceed 

// class Solution {
//     public int brokenCalc(int startValue, int target) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(startValue);

//         HashSet<Integer> visited = new HashSet<>();
//         visited.add(startValue);
//         int level = 0;

//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 int curr = q.poll();
//                 if(curr == target) return level;
//                 if(curr < target){
//                     int ne = curr * 2;
//                     if(!visited.contains(ne)){
//                         visited.add(ne);
//                         q.add(ne);
//                     }                    
//                 }
//                  if(curr > 1){
//                     int ne = curr - 1;
//                     if(!visited.contains(ne)){
//                         visited.add(ne);
//                         q.add(ne);
//                     }                    
//                 }

//             }
//             level++;
//         }

//         return -1;
        
//     }
// }