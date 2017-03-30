package edu.hm.cs.swa.projekt_1;

/**
 * Created by christian on 29.03.17.
 */

import edu.hm.SomeClass;
import edu.hm.SomeClass1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RendererTest {
    private SomeClass toRender;
    private SomeClass1 toRender2;
    private Renderer renderer;
    private Renderer renderer2;

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        toRender2 = new SomeClass1('t');
        renderer = new Renderer(toRender);
        renderer2 = new Renderer(toRender2);
    }

    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass:\n" +
                "foo (Type int) 5\n" +
                "array (Type int[]) [1, 2, 3]\n" +
                "date (Type java.util.Date) Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

    @Test
    public void testRendering2() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass1:\n" +
                "varChar (Type char) t\n" +
                "array (Type char[]) [@, a, ], ., w]\n" + "" +
                "test (Type java.lang.String) testString\n", renderer2.render());
    }
}