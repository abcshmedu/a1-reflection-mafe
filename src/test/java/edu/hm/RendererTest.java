package edu.hm;

import edu.hm.renderer.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RendererTest {

    @Test(expected = ClassNotFoundException.class)
    public void testNoClassForField() throws Exception {
        BrokenNoClassField toRender = new BrokenNoClassField();
        Renderer renderer = new Renderer(toRender);
        renderer.render();
    }
    
    @Test(expected = NoSuchMethodException.class)
    public void testNoMethodForField() throws Exception {
        BrokenNoMethodField toRender = new BrokenNoMethodField();
        Renderer renderer = new Renderer(toRender);
        renderer.render();
    }
    
    @Test(expected = ClassNotFoundException.class)
    public void testNoClassForMethod() throws Exception {
        BrokenNoClassMethod toRender = new BrokenNoClassMethod();
        Renderer renderer = new Renderer(toRender);
        renderer.render();
    }
    
    @Test(expected = NoSuchMethodException.class)
    public void testNoMethodForMethod() throws Exception {
        BrokenNoMethodMethod toRender = new BrokenNoMethodMethod();
        Renderer renderer = new Renderer(toRender);
        renderer.render();
    }
}
