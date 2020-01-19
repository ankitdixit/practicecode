package OnlineCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindMaxAliveYear
{
    public static void main(String[] args)
    {
        List<Person> people = new ArrayList<>();
        people.add(new Person(101, 105));
        people.add(new Person(100, 110));
        people.add(new Person(105, 105));
        System.out.println(findMaxAlive(people));
    }

    private static int findMaxAlive(List<Person> people)
    {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        populateTreeMap(treeMap, people);
        int maxPopulation = 0;
        int currPopulation = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            currPopulation += entry.getValue();
            maxPopulation = Math.max(currPopulation, maxPopulation);
        }
        return maxPopulation;
    }

    private static void populateTreeMap(TreeMap<Integer, Integer> treeMap, List<Person> people)
    {
        for (Person person : people) {
            int count = treeMap.containsKey(person.birthYear) ? treeMap.get(person.birthYear) : 0;
            treeMap.put(person.birthYear, count + 1);
            count = treeMap.containsKey(person.deathYear + 1) ? treeMap.get(person.deathYear + 1) : 0;
            treeMap.put(person.deathYear + 1, count - 1);
        }
    }
}

class Person
{
    int birthYear;
    int deathYear;

    public Person(int birthYear, int deathYear)
    {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
}

