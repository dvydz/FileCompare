import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String file1 = "CAT_EWS_ORG_20190919.txt";
        String file2 = "dasl_data.txt";

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\Users\\k28172\\Desktop\\verifyCatSubmitter\\" + file1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("C:\\Users\\k28172\\Desktop\\verifyCatSubmitter\\" + file2));
        String currentLine;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while ((currentLine = bufferedReader1.readLine()) != null)
        {
            list1.add(currentLine.trim());
        }
        while ((currentLine = bufferedReader2.readLine()) != null)
        {
            list2.add(currentLine.trim());
        }

        list1.removeAll(Arrays.asList("", null));
        list2.removeAll(Arrays.asList("", null));
        List<String> tmpList = new ArrayList<>();

        tmpList.addAll(list1);
        tmpList.removeAll(list2);

        System.out.println(String.format("Number of rows in %s : %d", file1, list1.size()));
        if (tmpList.size() == 0)
        {
            System.out.println(String.format("THERE ARE NO ROWS IN %s THAT IS DIFFERENT FROM %s !", file1, file2));
        }
        else
        {
            System.out.println(String.format("Number of rows different from %s : %d", file2, tmpList.size()));
            System.out.println(String.format("\nRows from %s which is not there in %s : \n", file1, file2));

            for (int i = 0; i < tmpList.size(); i++)
            {
                System.out.println(tmpList.get(i));
            }
        }

        System.out.println("\nLOADING..............................................................." +
            "................................................................................................. \n");
        tmpList.addAll(list2);
        tmpList.removeAll(list1);
        System.out.println(String.format("Number of rows in %s : %d", file2, list2.size()));
        if (tmpList.size() == 0)
        {
            System.out.println(String.format("THERE ARE NO ROWS IN %s THAT IS DIFFERENT FROM %s !", file2, file1));
        }
        else
        {
            System.out.println(String.format("Number of rows different from %s : %d", file1, tmpList.size()));
            System.out.println(String.format("\nRows from %s which is not there in %s : \n", file2, file1));

            for (int i = 0; i < tmpList.size(); i++)
            {
                System.out.println(tmpList.get(i));
            }
        }
    }
}
