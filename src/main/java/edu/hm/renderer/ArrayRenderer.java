package edu.hm.renderer;

public class ArrayRenderer {

    public String render(int[] arr) {
        String result = "int[]): [";
        for (int elem: arr) {
            result += elem + ", ";
        }
        result += "]\n";
        return result;
    }

}
