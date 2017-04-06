package edu.hm;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RendererOutputTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        
        return null;
    }
    
    @Parameter
    public Object obj;
    
    @Parameter(1)
    public String string;
    
    @Parameter(2)
    public boolean bool;
    
    public void test() {
        
    }

}
