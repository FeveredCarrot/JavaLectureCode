package org.example.week3_methods;

public class AlignText
{
    public static void main(String[] args)
    {
        int[] classCodes = {2545, 2505, 2560};
        String[] classNames = {"Java", "C#", "Web"};
        double[] averageClassSizes = {22.34233, 17.14323, 14.234234};

        // the -10 tells it to add up to 10 spaces before the next part of the string
        String tableTemplateString = "%-10d%-10s%-10.2f\n";
        for (int c = 0; c < classCodes.length; c++)
        {
            int code = classCodes[c];
            String name = classNames[c];
            double averageClassSize = averageClassSizes[c];
            //String templateString = "%-10d%-10s\n";
            // print the formatted string
            System.out.printf(tableTemplateString, code, name, averageClassSize);
        }
    }
}
