package com.xurmo.test;

import org.junit.Test;
import com.xurmo.ds.ServerNode;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CordinatorTest extends TestCase {

	ServerNode c;

	@Override
	protected void setUp() throws Exception {
		c = new ServerNode(10);

	}

	@Test
	public void testConnection() {
		Assert.assertTrue(c.testchat().equals("OK"));
	}

}
