package com.richasdy.HelloTesting.JUnit.Hamcrest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.richasdy.HelloTesting.JUnit.Category.PerformanceTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestCategory2 {
	@Category(PerformanceTests.class)
	@Test
	public void test_a_1() {
		assertThat(1 == 1, is(true));
	}

	@Test
	public void test_a_2() {
		assertThat(1 == 1, is(true));
	}
}
