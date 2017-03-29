package edu.hm.renderer;

import edu.hm.cs.swa.projekt_1.AnnotationRenderer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by christian on 29.03.17.
 */
public class ArrayRenderer implements AnnotationRenderer {

    public String render(Field field, Object o) {
        StringBuilder result = new StringBuilder("[");

        try {
            for (int i = 0; i < Array.getLength(field.get(o)); i++)
                result.append(Array.getInt(field.get(o), i)).append(", ");
        } catch (IllegalAccessException e) {
            result.append("no access");
        }
        result.append("]");
        return result.toString();
    }
}
