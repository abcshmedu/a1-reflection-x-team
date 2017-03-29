package edu.hm.cs.swa.projekt_1;

/**
 * Created by christian on 29.03.17.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RendererTest {
    private SomeClass toRender;
    private Renderer renderer;

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }

    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass:\n" +
                "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java" +
                ".util.Date):Fri Jan 02 11:17:36 CET 1970\n ", renderer.render());
    }
}