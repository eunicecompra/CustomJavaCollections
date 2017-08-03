package custom.list.test;

import custom.list.SinglyLinkedList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


public class SinglyLinkedListTest {

    /**
     * Test Case: Add elements to the list
     */
    @Test
    public void testAdd() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(50);
        list.add(30);
        list.add(10);

        assertEquals(3,list.getSize());
        assertEquals("[50, 30, 10]",list.toString());
    }

    /**
     * Test case: Remove tail from an empty list
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveTailEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(0,list.getSize());
        list.removeTail();
    }

    /**
     * Test case: Remove tail from a list with one element
     */
    @Test
    public void testRemoveTailOneElementList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(100);
        assertEquals(100,list.removeTail());
        assertEquals(0,list.getSize());
        assertEquals("[]",list.toString());
    }

    /**
     * Test case: Remove tail from a list with multiple elements
     */
    @Test
    public void testRemoveTailMultipleElementList() {
        SinglyLinkedList list = new SinglyLinkedList();
        for ( int num = 1; num <= 10000; num++) {
            list.add(num);
        }
        assertEquals(10000,list.getSize());
        assertEquals(10000,list.removeTail());
        assertEquals(9999,list.getSize());
    }

    /**
     * Remove larger values from list with one element. Target value is larger than the element.
     */
    @Test
    public void testRemoveLargerValues1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(100);
        assertEquals(0,list.removeLargerValues(150));
        assertEquals(1,list.getSize());
    }

    /**
     * Remove larger values from list with one element. Target value is less than the element.
     */
    @Test
    public void testRemoveLargerValues2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(100);
        assertEquals(1,list.removeLargerValues(5));
        assertEquals(0,list.getSize());
    }

    /**
     * Remove larger values from list with multiple elements.
     */
    @Test
    public void testRemoveLargerValues3() {
        SinglyLinkedList list = new SinglyLinkedList();
        for ( int num = 5; num <= 50; num+=5) {
            list.add(num);
        }
        assertEquals(5,list.removeLargerValues(25));
        assertEquals(5,list.getSize());
    }

    /**
     * Remove larger values from an empty list.
     */
    @Test
    public void testRemoveLargerValues4() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(0,list.removeLargerValues(5));
        assertEquals(0,list.getSize());
        assertEquals("[]",list.toString());
    }

    /**
     * Remove larger values from list with multiple elements.
     */
    @Test
    public void testRemoveLargerValues5() {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] randomNum = {5,3,45,100,23,46,12,1,18,65};

        for ( int i = 0; i < randomNum.length; i++) {
            list.add(randomNum[i]);
        }
        assertEquals(9,list.removeLargerValues(1));
        assertEquals(1,list.getSize());
        assertEquals("[1]",list.toString());
    }

    /**
     * Remove larger values from list with multiple elements.
     */
    @Test
    public void testRemoveLargerValues6() {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] randomNum = {300,301,30,100,205,46,34,67,18,200};

        for ( int i = 0; i < randomNum.length; i++) {
            list.add(randomNum[i]);
        }

        assertEquals(4,list.removeLargerValues(199));
        assertEquals(6,list.getSize());
        assertEquals("[30, 100, 46, 34, 67, 18]",list.toString());
    }


}
