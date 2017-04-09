package edu.hm;

import edu.hm.renderer.RenderMe;

public class BrokenNoClassField {

    @RenderMe(with = "edu.hm.renderer.BlaRenderer")
    int[] array = {1, 2, 3, };
}
