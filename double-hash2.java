import java.lang.*;
import java.util.Random;

/*
  author: Nick Gordon

  This double-hash implementation was fixed after the live-coding fact and is known to work.
 */

class DoubleHash
{
    public static void main(String[] args)
    {
        HashTable ht = new HashTable(100);
        Random r = new Random();

        for (int i=0; i < 75; i++)
        {
            ht.insert(r.nextInt(1000));
        }

        ht.insert(55);
        ht.insert(23);

        System.out.println("55 at " + ht.find(55));
        System.out.println("23 at " + ht.find(23));

        //ht.print();
    }
}

class HashTable
{
    //integers
    Integer[] internal_array;
    int size;
    int m;

    public
    void print()
    {
        for (int i =0; i<this.size; i++)
        {
            if (internal_array[i] == null)
            {
                System.out.println("ht["+i+"] = null");
            }
            else
            {
                System.out.println("ht["+i+"] = "+internal_array[i]);
            }
        }
    }

    public HashTable(int size)
    {
        this.internal_array = new Integer[size];
        this.size = size;
        this.m = 13;
    }

    public int
    h1(int value)
    {
        //return 1 + ((int)Math.pow(2, value)) % (this.m-1); // M - 1
        return 1 + (value % (this.m-1)); // M - 1
    }

    public int
    h2(int value)
    {
        //return 1 + ((int)Math.pow(2, value)) % (this.m-2); // M -2
        return 1 + (value % (this.m-2)); // M -2
    }

    public void
    insert(int value)
    {
        // spot open
        int k1 = h1(value);
        if (internal_array[k1] == null)
        {
            internal_array[k1] = value;
            return;
        }
        // collision, use second
        else if (internal_array[k1] != value)
        {
            int k2 = h2(value);
            int i2 = (k1+k2) % this.size;
            for (int counter = 0; counter < this.size; counter++)
            {
                if (internal_array[i2] == null)
                {
                    internal_array[i2] = value;
                    return;
                }
                i2 = (i2 + k2) % this.size;
            }
            System.out.println("Could not insert " + value);
            return;
        }
        // two collisions
        else // hash table is full
        {
            System.out.println(internal_array[k1] + " and " + value);
            System.out.println("No spots found!");
        }
    }

    public int
    find(int value)
    {
        int k1 = h1(value);
        if (internal_array[k1] == null)
        {
            return -1;
        }
        else if (internal_array[k1] == value)
        {
            return k1;
        }
        else // internal_array[k1] != value
        {
            int k2 = h2(value);
            int i2 = (k1+k2) % this.size;
            for (int counter = 0; counter < this.size; counter++)
            {
                if (internal_array[i2] == value)
                {
                    return i2;
                }
                i2 = (i2 + k2) % this.size;
            }
            return -2;
        }
    }
}
