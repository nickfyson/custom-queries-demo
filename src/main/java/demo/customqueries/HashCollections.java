package demo.customqueries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HashCollections {

    public static void main(String[] args) {

        Set<String> exampleSet;

        // We want to highlight this undesirable use of HashSet
        exampleSet = new HashSet<String>();

        // We add a new use of HashSet
        exampleSet = new HashSet<String>();

        // Whereas LinkedHashSet is the preferred alternative
        exampleSet = new LinkedHashSet<String>();

        // We also want to highlight creation of a HashSet via Collectors
        exampleSet = new ArrayList<String>().stream().collect(Collectors.toSet());

        // But other calls to a 'toSet' method should be ignored
        exampleSet = CoincidentallyNamed.toSet(new ArrayList<String>());

        exampleSet.add("dummy usage");
    }

    private static class CoincidentallyNamed {
        public static Set<String> toSet(List<String> list) {
            return list.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        }
    }

}

