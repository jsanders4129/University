import java.util.Comparator;

public class GenericComparator implements Comparator<Integer>
{
    public int compare(Integer s1, Integer s2)
    {
        // Switch s1 and s2 to sort Z-A
        return s1-s2;
    }
}
