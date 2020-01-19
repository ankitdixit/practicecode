package OnlineCoding;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
public class BalancedParanthesis
{
    public static void main(String[] args)
    {
        int n = 2;
        System.out.println(generateEnumerations("", n, 0, 0));
    }

    static List<String> generateEnumerations(String prefix, int n, int openCount, int closeCount)
    {
        List<String> result = new ArrayList<>();
        if (closeCount == n) {
            result.add(prefix);
        }
        else {
            if (openCount > closeCount) {
                result.addAll(generateEnumerations(prefix + ")", n, openCount, closeCount + 1));
            }
            if (openCount < n) {
                result.addAll(generateEnumerations(prefix + "(", n, openCount + 1, closeCount));
            }
        }
        return result;
    }
}
