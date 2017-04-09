package edu.hm;

import edu.hm.renderer.RenderMe;

public class BrokenNoMethodMethod {
    
    @RenderMe(with = "edu.hm.SomeClass")
    public int getFive() {
        return 5;
    }

}
