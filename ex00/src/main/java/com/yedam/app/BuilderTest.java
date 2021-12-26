package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuilderTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void member() {
		Member member = Member.builder().id("1").build();
		assertEquals(member.getId(), "1");
	}
}
