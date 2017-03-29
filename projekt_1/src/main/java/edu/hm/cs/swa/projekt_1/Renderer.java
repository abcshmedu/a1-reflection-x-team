package edu.hm.cs.swa.projekt_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Renderer implements AnnotationRenderer{

	private Object o;

	public Renderer(Object o) {
		this.o = o;
	}

	@Override
	public String render() {

		StringBuilder builder = new StringBuilder();

		for (Field field : this.o.getClass().getDeclaredFields()) {

			RenderMe annotation = field.getAnnotation(RenderMe.class);
			
			if ( annotation != null) {

				field.setAccessible(true);

				builder.append(field.getName() + "(" + field.getType() + ") ");

				try {

					if (field.getType().equals(int.class)) {
						builder.append(field.getInt(o));
					} else if (field.getType().equals(boolean.class)){
						builder.append(field.getBoolean(o));}
					else{
						
						String customRenderer = annotation.with();
						
						if(customRenderer.length()>0){
							
							 Class.forName(customRenderer);
							 
						}
						
						
					}
				

				} catch (IllegalAccessException eae) {
					builder.append("no access");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					builder.append("no renderer class found");
				}

				builder.append("\n");

			}
		}

		return builder.toString();
	}
}
