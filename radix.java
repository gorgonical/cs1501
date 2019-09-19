import java.util.*;
import java.lang.*;

class Radix
{
    public static void main(String[] args)
    {
        int input_size = Integer.parseInt(args[0]);
        int[] input = new int[input_size];
        Random r = new Random();

        System.out.println("Initial input:");
        for (int i = 0; i < input_size; i++)
        {
            input[i] = r.nextInt(100);
            System.out.print(input[i] + " ");
        }
        System.out.println();

        int width = 0;
        for (int i = 0; i < input_size; i++)
        {
            int curr_width = num_digits(input[i]);
            width = Math.max(width, curr_width);
        }
        //System.out.println("longest digit is " + width);

        // Know how many passes to do now
        for (int i = 0; i < width; i++)
        {
            // System.out.println("Pass " + i);
            LinkedList<Integer>[] buckets = new LinkedList[10];
            for (int ll=0; ll<10;ll++) { buckets[ll] = new LinkedList<Integer>(); }

            for (int j = 0; j < input_size; j++)
            {
                int current_digit = n_digit(input[j], i);
                buckets[current_digit].add(input[j]);
            }

            // Recombine buckets
            int input_index = 0;
            for (int b = 0; b < 10; b++)
            {
                for (int in_bucket = 0; in_bucket < buckets[b].size(); in_bucket++)
                {
                    //System.out.println(buckets[b].get(in_bucket));
                    input[input_index++] = buckets[b].get(in_bucket);
                }
            }

            //Input should be sorted partway
        }

        System.out.println("Sorted: ");
        for (int i=0; i<input_size;i++) { System.out.print(input[i] + " "); }
        System.out.println();

    }

    public static int
    num_digits(int input)
    {
        return (int) Math.ceil(Math.log10(input));
    }

    public static int
    n_digit(int input, int position)
    {
        // Come back to this for off by one errors?
        return (input / (int)Math.pow(10,position)) % 10;
    }

}
