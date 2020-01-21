package binaryTree;

import java.util.Random;

public class IntegerBinaryTreeTest extends BinaryTreeTest<Integer>
{
    private static Random _random = new Random();

    @Override
    public Integer genItem()
    {
        return _random.nextInt();
    }
}