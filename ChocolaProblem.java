//Greedy Approach
// We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2, ..., xm-1 and along horizontal lines with y1, y2, ..., yn-1.
// Compute the minimal cost of breaking the whole chocolate into single squares.

import java.util.*;
public class ChocolaProblem { //O(nlogn)
    public static void main(String[] args) {
        Integer verCost[] = {2, 1, 3, 1, 4};
        Integer horCost[] = {4, 1, 2};
        int n = 4, m = 6;

        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horCost, Collections.reverseOrder());

        int h = 0, v = 0, cost = 0;
        int hp = 1, vp = 1;

        while (h < horCost.length && v < verCost.length) {
            if(horCost[h] <= verCost[v]) { //vertical cuts
                cost += verCost[v] * hp;
                v++;
                vp++;
            } else { //horizontal cuts
                cost += horCost[h] * vp;
                h++;
                hp++;
            }
        }
        while (h < horCost.length) {
            cost += horCost[h] * vp;
            h++;
            hp++;
        }
        while (v < verCost.length) {
            cost += verCost[v] * hp;
            v++;
            vp++;
        }

        System.out.println("Minimun cost for cuts = " + cost);
    }
}
