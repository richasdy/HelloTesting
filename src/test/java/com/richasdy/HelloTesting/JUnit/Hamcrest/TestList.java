package com.richasdy.HelloTesting.JUnit.Hamcrest;

import org.junit.Test;

import com.richasdy.HelloTesting.JUnit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import java.util.Objects;

public class TestList {

	@Test
	public void testAssertListString() {

		List<String> actual = Arrays.asList("a", "b", "c");
		List<String> expected = Arrays.asList("a", "b", "c");

		// All passed / true

		// 1. Test equal.
		assertThat(actual, is(expected));

		// 2. If List has this value?
		assertThat(actual, hasItems("b"));

		// 3. Check List Size
		assertThat(actual, hasSize(3));

		assertThat(actual.size(), is(3));

		// 4. List order

		// Ensure Correct order
		assertThat(actual, contains("a", "b", "c"));

		// Can be any order
		assertThat(actual, containsInAnyOrder("c", "b", "a"));

		// 5. check empty list
		assertThat(actual, not(IsEmptyCollection.empty()));

		assertThat(new ArrayList<Object>(), IsEmptyCollection.empty());

	}

	@Test
	public void testAssertListInt() {

		List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

		// All passed / true

		// 1. Test equal.
		assertThat(actual, is(expected));

		// 2. Check List has this value
		assertThat(actual, hasItems(2));

		// 3. Check List Size
		assertThat(actual, hasSize(5));

		assertThat(actual.size(), is(5));

		// 4. List order

		// Ensure Correct order
		assertThat(actual, contains(1, 2, 3, 4, 5));

		// Can be any order
		assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));

		// 5. check empty list
		assertThat(actual, not(IsEmptyCollection.empty()));

		assertThat(new ArrayList<Object>(), IsEmptyCollection.empty());

		// 6. Test numeric comparisons
		assertThat(actual, everyItem(greaterThanOrEqualTo(1)));

		assertThat(actual, everyItem(lessThan(10)));

	}

	@Test
	public void testAssertListObj() {

		List<Fruit> list = Arrays.asList(new Fruit("Banana", 99), new Fruit("Apple", 20));

		// Test equals
		assertThat(list, hasItem(new Fruit("Banana", 99)));

		assertThat(list, hasItem(new Fruit("Apple", 20)));

		assertThat(list, hasItems(new Fruit("Banana", 99), new Fruit("Apple", 20)));

		assertThat(list, containsInAnyOrder(new Fruit("Apple", 20), new Fruit("Banana", 99)));

		// TEST hasProperty, still error
		// Customer customer = new Customer("Donni");
		// Customer customer2 = new Customer("Donni");
		// assertThat(customer, samePropertyValuesAs(customer2));

		// i dont know why, but its failed. maybe wrong logic
		// Test class property, and its value
		assertThat(list, containsInAnyOrder(hasProperty("name", is("Apple")), hasProperty("name", is("Banana"))));

	}
}
