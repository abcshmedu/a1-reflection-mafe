package edu.hm;

import java.util.Arrays;
import java.util.Collection;

import edu.hm.renderer.Renderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RendererOutputTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        SomeClass object = new SomeClass(5);
        return Arrays.asList(new Object[][] {
                {object, "Instance of edu.hm.SomeClass:", true},
                {object, "foo (Type int): 5", true},
                {object, "array (Type int[]): [1, 2, 3, ]", true},
                {object, "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970", true},
                {object, "getArray() (ReturnType int[]): [1, 2, 3, ]", true},
                {object, "getFoo() (ReturnType int): 5", true},
                {object, "getDate()", false},
        });
    }
    
    @Parameter
    public Object obj;
    
    @Parameter(1)
    public String string;
    
    @Parameter(2)
    public boolean shouldContain;

    @Test
    public void test() {
        if (shouldContain) {
            assertThat(new Renderer(obj).render(), containsString(string));
        } else {
            assertThat(new Renderer(obj).render(), not(containsString(string)));
        }
    }

}
