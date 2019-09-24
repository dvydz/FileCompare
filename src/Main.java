import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //The path for two files to compare
        Path path1 = Paths.get("C:\\Users\\k28172\\Desktop\\verifyCatSubmitter\\CAT_EWS_ORG_20190923.txt");
        Path path2 = Paths.get("C:\\Users\\k28172\\Desktop\\verifyCatSubmitter\\CAT_EWS_ORG_20190924.txt");

        String file1Name = path1.getFileName().toString();
        String file2Name = path2.getFileName().toString();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(path1.toString()));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(path2.toString()));
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

        System.out.println(String.format("Number of rows in %s : %d", file1Name, list1.size()));
        if (tmpList.size() == 0)
        {
            System.out.println(String.format("THERE ARE NO ROWS IN %s THAT IS DIFFERENT FROM %s !", file1Name, file2Name));
        }
        else
        {
            System.out.println(String.format("Number of rows different from %s : %d", file2Name, tmpList.size()));
            System.out.println(String.format("\nRows from %s which is not there in %s : \n", file1Name, file2Name));

            for (int i = 0; i < tmpList.size(); i++)
            {
                System.out.println(tmpList.get(i));
            }
        }

        System.out.println("\nLOADING..............................................................." +
            "................................................................................................. \n");

        tmpList.addAll(list2);
        tmpList.removeAll(list1);
        System.out.println(String.format("Number of rows in %s : %d", file2Name, list2.size()));
        if (tmpList.size() == 0)
        {
            System.out.println(String.format("THERE ARE NO ROWS IN %s THAT IS DIFFERENT FROM %s !", file2Name, file1Name));
        }
        else
        {
            System.out.println(String.format("Number of rows different from %s : %d", file1Name, tmpList.size()));
            System.out.println(String.format("\nRows from %s which is not there in %s : \n", file2Name, file1Name));

            for (int i = 0; i < tmpList.size(); i++)
            {
                System.out.println(tmpList.get(i));
            }
        }
    }
}
