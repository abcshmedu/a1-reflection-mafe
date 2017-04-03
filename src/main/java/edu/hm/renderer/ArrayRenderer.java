package edu.hm.renderer;

public class ArrayRenderer {

    public String render(int[] arr) {
        String result = "(Type int[]): [";
        for (int elem: arr) {
            result += elem + ", ";
        }
        result += "]\n";
        return result;
    }

}
