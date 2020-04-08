package tests;

import lib.ArraySlicer;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ArraySlicerTest {
    private ArraySlicer slicer;

    @Before
    public void setUp() {
        slicer = new ArraySlicer();
    }

    @Test
    public void assertResultIsNullWhenListIsNull() {
        assertNull(slicer.partition(null, 10));
    }


    @Test
    public void assertResultIsEmptyWhenSubCollectionSizeIsNegative() {
        List<?> list = Collections.emptyList();
        List<?> expected = Collections.emptyList();
        assertEquals(expected, slicer.partition(list, -1));
    }

    @Test
    public void assertResultIsEmptyWhenSubCollectionSizeIsZero() {
        List<?> list = Arrays.asList(1, 2);
        List<?> expected = Collections.emptyList();
        assertEquals(expected, slicer.partition(list, 0));
    }

    @Test
    public void assertResultIsEmptyWhenSubCollectionSizeIsNegativeAndListIsNotNull() {
        List<?> list = Arrays.asList(1, 2);
        List<?> expected = Collections.emptyList();
        assertEquals(expected, slicer.partition(list, -1));
    }

    @Test
    public void assertResultIsEmptyWhenListIsEmpty() {
        List<?> list = Collections.emptyList();
        List<?> expected = Collections.emptyList();
        assertEquals(expected, slicer.partition(list, 0));
    }


    @Test
    public void assertResultIsEmptyWhenListIsEmpty_() {
        List<?> list = Collections.emptyList();
        List<?> expected = Collections.emptyList();
        assertEquals(expected, slicer.partition(list, 0));
    }


    @Test
    public void assertSlicedSubCollectionSizeEqualToOneWhenSubCollectionSizeEqualToOne() {
        List<?> list = Arrays.asList(1, 2, 3);
        slicer.partition(list, 1).forEach(element -> assertEquals(1, element.size()));
    }

    @Test
    public void assertSlicedSubCollectionSizeGreaterThanOneWhenSubCollectionSizeGreaterThanOne() {
        List<?> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9);
        int size = 3;
        slicer.partition(list, size).forEach(element -> assertTrue(element.size() <= size));
    }


    @Test
    public void assertResultSlicedSubCollectionSizeGreaterThanOne() {
        List<?> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9);
        int size = 3;
        slicer.partition(list, size).forEach(element -> assertTrue(element.size() <= size));
    }


    @Test
    public void BigTest__ONE() {

        // partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4], [5] ]

        List<?> list = Arrays.asList(1, 2, 3, 5);

        List<Collection<?>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(3, 4));
        expected.add(Collections.singletonList(5));

        assertEquals(expected, slicer.partition(list, 2));
    }


    @Test
    public void BigTest__TWO() {

        // partition([1,2,3,4,5], 3) retourne: [ [1,2,3], [4,5] ]

        List<?> list = Arrays.asList(1, 2, 3, 5);

        List<Collection<?>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(4, 5));

        assertEquals(expected, slicer.partition(list, 3));
    }


    @Test
    public void BigTest__THREE() {
        // partition([1,2,3,4,5], 1) retourne: [ [1], [2], [3], [4], [5] ]
        List<?> list = Arrays.asList(1, 2, 3, 5);

        List<Collection<?>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(1));
        expected.add(Collections.singletonList(2));
        expected.add(Collections.singletonList(3));
        expected.add(Collections.singletonList(4));
        expected.add(Collections.singletonList(5));

        assertEquals(expected, slicer.partition(list, 1));
    }


}
