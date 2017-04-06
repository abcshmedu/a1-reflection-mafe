package edu.hm;

import edu.hm.renderer.RenderMe;
import java.util.*;

public class SomeClass {
    
    private String s = "Hallo";

    @RenderMe
    private int foo;
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer")
    int[] array = {1, 2, 3, };
    @RenderMe
    private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }
    
    @RenderMe
    public int getFoo() {
        return foo;
    }
    
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer")
    public int[] getArray() {
        return array;
    }
    
    public Date getDate() {
        return date;
    }
}
