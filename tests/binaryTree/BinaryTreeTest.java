package binaryTree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

abstract class BinaryTreeTest<T extends Comparable<? super T>>
{
    @Test
    public void Test10()
    {
        testingTraverse(10);
    }

    @Test
    public void Test100()
    {
        testingTraverse(100);
    }

    @Test
    public void Test20()
    {
        testingTraverse(20);
    }

    @Test
    public void Test60()
    {
        testingTraverse(60);
    }

    @Test
    public void Test30()
    {
        testingTraverse(30);
    }

    @Test
    public void testMinusOne()
    {
        assertThrows(NegativeArraySizeException.class, ()-> testingTraverse(-1));
    }
    @Test
    public void testMinusFifty()
    {
        assertThrows(NegativeArraySizeException.class, ()-> testingTraverse(-50));
    }

    @Test
    public void testMinusOneHundred()
    {
        assertThrows(NegativeArraySizeException.class, ()-> testingTraverse(-100));
    }

    private void testingTraverse(int size)
    {
        ArrayList<T> test = genData(size);
        BinaryTree<T> tree = new BinaryTree<T>();

        for (T i : test)
            tree.insert(i);

        List<T> out = tree.traverse();
        //This testing shows if all items in traversal are monotonic

        T l = null;
        int i1 = 0;
        for (T t : out)
            if (l == null)
                l = t;

            else if (i1 == 0)
                i1 = l.compareTo(t);

            else
                assertTrue(
                        (l.compareTo(t) > 0 && i1 > 0)
                                || (l.compareTo(t) < 0 && i1 < 0));

        //This tests that all items added to tree exist in traversal.
        for (T i : test)
        {
            boolean present = false;
            for (T t : out)
                if ((present = i == t))
                    break;

            if (!present)
                fail(i + " is not present in tree after traversal.");
        }
    }

    private ArrayList<T> genData(int size)
    {
        if (size < 0)
            throw new NegativeArraySizeException();

        ArrayList<T> item = new ArrayList<T>();
        for (int i = 0; i < size; i++)
            item.add( genItem());

        return item;
    }

    public abstract T genItem();
}

