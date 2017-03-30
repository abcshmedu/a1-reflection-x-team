package edu.hm;


import edu.hm.cs.swa.projekt_1.RenderMe;

public class SomeClass1 {

    @RenderMe
    private char varChar;
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer")
    char[] array = {'@', 'a', ']', '.', 'w'};
    @RenderMe
    private String test = "testString";

    public SomeClass1(char varChar) {
        this.varChar = varChar;
    }
}