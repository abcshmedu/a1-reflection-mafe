package edu.hm;

import edu.hm.renderer.Renderer;

/**
 * Main class for testing purposes.
 */
public final class Main {

    /**
     * Main method.
     * @param argv command line arguments
     */
    public static void main(String[] argv) {
        SomeClass toRender = new SomeClass(5);
        Renderer render = new Renderer(toRender);
        System.out.println(render.render());
    }

}
