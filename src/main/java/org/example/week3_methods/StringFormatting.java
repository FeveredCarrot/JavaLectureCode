package org.example.week3_methods;

public class StringFormatting
{
    public static void main(String[] args)
    {
        String college = "MCTC";
        String className = "Java Programming";
        int classCode = 2545;
        int credits = 6;
        double averageGrade = 84.54345;
        boolean isOnline = true;

        // using string concatenation
        System.out.println("This class code is " + classCode);

        //using string formatting
        // %d = int
        // %s = String, whatever else
        // %f = double %.2f rounds to 2 places
        System.out.printf("This class is %d %s. It is taught at %s. It is %d credits. " +
                "The average grade is %.2f%%. Is it online? %s.\n",
                classCode, className, college, credits, averageGrade, isOnline);

    }
}
