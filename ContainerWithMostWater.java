import java.util.*;
public class ContainerWithMostWater {
    public static int StoreWater(ArrayList<Integer> heightList) {
        int maxarea = 0;
        int left = 0; int right = heightList.size() - 1;
        while(left < right) {
            int height = Math.min(heightList.get(left), heightList.get(right));
            int width = right - left;
            int currarea = height * width;
            maxarea = Math.max(maxarea, currarea);

            if(heightList.get(left) < heightList.get(right)) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxarea;
    }
    public static void main(String[] args) {
        ArrayList<Integer> heightList = new ArrayList<>();
        heightList.add(1);
        heightList.add(8);
        heightList.add(6);
        heightList.add(2);
        heightList.add(5);
        heightList.add(4);
        heightList.add(8);
        heightList.add(3);
        heightList.add(7);
        //[1,8,6,2,5,4,8,3,7]

        System.out.println("Maximum Water = " + StoreWater(heightList));
    }
}
