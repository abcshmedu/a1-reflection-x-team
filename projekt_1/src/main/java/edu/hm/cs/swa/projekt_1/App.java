package edu.hm.cs.swa.projekt_1;

import edu.hm.SomeClass;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Start reflection renderer");

        Renderer ren = new Renderer(new SomeClass(5));
        String renderedString = ren.render();

        System.out.println(renderedString);
    }
}
