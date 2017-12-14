import java.util.*;

public class VariantImpl1 extends AbstractVariant
{
    private final String variant = "вариант 1";

    @Override
    public String getVariant() {
        return variant;
    }

    VariantImpl1(String inString) {
        super(inString);
    }

    @Override
    public Map<String, List<String>>  getStructureVariant(String s) {
        List<String> listWord = new ArrayList( Arrays.asList(s.split(" ")));
        //Collections.sort(listWord);

        TreeMap<String, List<String>> mapString = new TreeMap();
        for (String word : listWord){
            if (word.isEmpty()){
                continue;
            }

            String firstLitter = word.substring(0,1);
            if (mapString.containsKey(firstLitter)) {
                List<String> value = mapString.get(firstLitter);
                value.add(word);
                mapString.put(firstLitter, value);
            } else {
                mapString.put(firstLitter, new ArrayList<>(Arrays.asList(word)));
            }
        }

        // sort
        for(Map.Entry<String, List<String>> entry : mapString.entrySet()){
            List<String> value = mapString.get(entry.getKey());
            Collections.sort(value);
            mapString.put(entry.getKey(), value);
        }

        //print
        printResultVariant(mapString);
        return mapString;
    }

}
