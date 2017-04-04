package edu.hm.cs.swa.projek_1.resources;

import edu.hm.cs.swa.projekt_1.RenderMe;

public class SomeRenderTestClass {
	
	/**
	 * 
	 * 
	 * 
	 */
	
	@RenderMe(with = "edu.hm.renderer.ArrayRenderer")
	public float[] array = {0.1f,2.5f};
	
	@RenderMe(with = "java.lang.Object")
	public int[] wrongRenderer = {1,2,3,4};
	
	@RenderMe(with = "java.lang.Ob")
	public int[] wrongRendererPackage = {1,2,3,4};	
	
	private int privVar = 0;

}
