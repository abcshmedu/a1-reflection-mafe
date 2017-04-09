package edu.hm;

import edu.hm.renderer.RenderMe;

public class BrokenNoMethodField {
    
    @RenderMe(with = "edu.hm.SomeClass")
    int[] array = {1, 2, 3, };

}
