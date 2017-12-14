import java.util.*;
import java.util.stream.Collectors;

public class VariantImpl2 extends AbstractVariant{

    VariantImpl2(String inString) {
        super(inString);
    }

    private final String variant = "вариант 2 используя stream java 1.8";

    @Override
    public String getVariant() {
        return variant;
    }
    @Override
    public Map<String, List<String>>  getStructureVariant(String s) {

        List<String> listWord = new ArrayList( Arrays.asList(s.split(" ")));
        Map<String, List<String>> mapString =  listWord.stream().collect(Collectors.groupingBy(x->x.substring(0,1)));

        // sort
        for(Map.Entry<String, List<String>> entry : mapString.entrySet()){
            List<String> value = mapString.get(entry.getKey());
            Collections.sort(value);
            mapString.put(entry.getKey(), value);
        }

        // print
        printResultVariant(mapString);
        return mapString;
    }

}
