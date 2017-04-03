package edu.hm;

import edu.hm.renderer.Renderer;

public class Main {

    public static void main(String[] argv) {
        SomeClass toRender = new SomeClass(5);
        Renderer render = new Renderer(toRender);
        System.out.println("Renderer output: ");
        System.out.println(render.render());
    }

}
