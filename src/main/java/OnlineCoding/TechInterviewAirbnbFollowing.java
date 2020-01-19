package OnlineCoding;

public class TechInterviewAirbnbFollowing
{
    public static void main(String[] args)
    {
        System.out.println(reverse(""));

        System.out.println(findMissingElement(new int[] {1,2,3,4,5}, new int[]{1,3,4,5}));
    }

    private static String reverse(String s)
    {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >=0 ; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }


    private static int findMissingElement(int[] first, int[] second)
    {
        int l = 0;
        int r = first.length;

        while (l != r) {
            int mid =  (l+r)/2;
            if (first[mid] == second[mid]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return first[l];
    }
}
