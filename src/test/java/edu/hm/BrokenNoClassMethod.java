package edu.hm;

import edu.hm.renderer.RenderMe;

public class BrokenNoClassMethod {
    
    @RenderMe(with = "edu.hm.renderer.BlaRenderer")
    public int getFive() {
        return 5;
    }

}
