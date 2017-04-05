package edu.hm.renderer;

/**
 * Class for rendering int[].
 */
public class ArrayRenderer {

    /**
     * Method to render int[].
     * @param arr the int[] to render
     * @return string representation of the array
     */
    public String render(int[] arr) {
        String result = "int[]): [";
        for (int elem: arr) {
            result += elem + ", ";
        }
        result += "]\n";
        return result;
    }

}
