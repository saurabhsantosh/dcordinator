package com.xurmo.test;


import org.junit.Test;
import com.xurmo.ds.Cordinator;
import junit.framework.TestCase;


public class CordinatorTest extends TestCase {
	
	@Test
	public void testInit()
	{
		Cordinator c=new Cordinator(10);
		c.InitServer();
	}

}
