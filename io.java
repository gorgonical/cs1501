import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

class IO {
    public static void
    main(String[] args)
    {
        try {
            File fd = new File("input.txt");
            DataOutputStream ostream = new DataOutputStream(new FileOutputStream(fd));
            int num = 2000000000;
            String s = "this is a string";
            boolean b = true;
            ostream.writeInt(num);
            //ostream.writeBoolean(b);
            //ostream.writeChars(s);

            char c = 'a';
            DataInputStream istream = new DataInputStream(new FileInputStream(fd));
            while (true)
            {
                c = istream.readChar();
                //b = istream.readBoolean();
                System.out.println(c);
            }
        }
        catch (IOException e)
        {
            System.out.println("Some I/O error occurred.");
        }
    }
}
