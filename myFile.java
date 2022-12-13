import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
public class myFile
{

    private ArrayList <String> qst = new ArrayList<String>();
    private ArrayList <String> correct = new ArrayList<String>();

    public ArrayList <String>  myReader()
    {
        String s;
        ArrayList <String> words = new ArrayList<String>();
        try {
            Scanner input = new Scanner(new File("file.txt"));
            while (input.hasNext())
            {
                s = input.nextLine();
                words.add(s);
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return words;
    }

    public void cleanQst()
    {
        this.qst.clear();
    }

    public void cleanCorr()
    {
        this.correct.clear();
    }

    public String getIndexCorr(int index)
    {
        return  correct.get(index);
    }

    public String getIndexQst(int index)
    {
        return  qst.get(index);
    }

    public int randQst(ArrayList <String> fileContent)
    {
        int num, count=0, k=0;
        ArrayList <Integer> rand = new ArrayList<>();
        for (int i = 0; i < fileContent.size(); i++)
        {
            if(i % 5 == 0)
            {
                qst.add(fileContent.get(i));
                if( i+1 < fileContent.size())
                correct.add(fileContent.get(i+1));
            }
        }
        for (int j = 0; j < qst.size(); j++)
        {
            rand.add(0);
        }
        Random r = new Random();
        num = r.nextInt(this.qst.size());
        while (k != -1)
        {
            if (rand.get(num) == 1) {
                if (count == rand.size()-1)
                {
                    return -1;
                }
                num = r.nextInt(this.qst.size());
                count++;
            }
            else
            {
                rand.set(num,1);
                k=-1;
            }
        }
        return num;
    }
}
