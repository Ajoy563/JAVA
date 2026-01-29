public class TrapRainWater {
    public static int TrapWater(int height[]) {
        int n = height.length;
        int left[] = new int[n];
        left[0] = height[0];
        //left max boundary
        for(int i=1; i<n; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        //Right max boundary
        int right[] = new int[n];
        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }
        int trap_water = 0;
        for(int i=0; i<n; i++) {
            //Find water level
             //WaterLevel = min(Right max boundary, left max boundary)
            int WaterLevel = Math.min(right[i], left[i]);
            trap_water += WaterLevel - height[i];
        }
        return trap_water;
    }
    public static void main(String args[]) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int total = TrapWater(height);
        System.out.println("Total Capacity of water trapped: " + total + " unit.");
    }
}
