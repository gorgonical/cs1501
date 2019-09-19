import java.lang.*;
import java.util.Random;

class DoubleHash
{
    public
    static void main(String[] args)
    {
        HT ht = new HT(100);
        Random r = new Random();
        for (int i = 0; i<100; i++)
        {
            int to_insert = r.nextInt(10000);
            System.out.println("Inserting " + to_insert);
            ht.insert(to_insert);
        }
        ht.print_ht();
    }
}

class HT
{
    Integer[] internal_array;
    int size;
    int m = 11;

    int
    h1(int value)
    {
        return 1 + (value % (m-1));
    }

    int
    h2(int value)
    {
        return 1 + (value % (m-2));
    }

    public void
    insert(int value)
    {
        int k1 = h1(value) % size;
        if (internal_array[k1] == null)
        {
            //System.out.println("Successfully inserting at " + k1);
            internal_array[k1] = value;
        }
        // In the case that we have the same value, nbd
        else if (internal_array[k1] == value)
        {
            //System.out.println("Same value found in ht at " + k1);
            // No problem
        }
        // Something else is in the slot, hash collision
        else if (internal_array[k1] != value)
        {
            ///System.out.println("Hash collision at " + k1);
            // Now need to use h2
            int k2 = h2(value);

            int i2 = k1 - k2;
            if (i2 < 0) { i2 += size; }

            for (int i = 0; i < size; i++)
            {
                //System.out.println("Trying second hash " + i2);
                // Empty cell found, good job
                if (internal_array[i2] == null)
                {
                    //System.out.println("Found empty second slot");
                    internal_array[i2] = value;
                    return;
                }
                else
                {
                    i2 -= k2;
                    if (i2 < 0) { i2 += size; }
                }
            }
            System.out.println("No slots available!");
        }
    }

    public void
    print_ht()
    {
        for (int i=0;i<size;i++) {

            if (internal_array[i] == null)
            {
                System.out.println("ht["+i+"] = null");
            }
            else
            {
                System.out.println("ht["+i+"] = " + internal_array[i]); }
            }
    }

    public HT(int size)
    {
        this.size = size;
        this.internal_array = new Integer[size];
    }
}
