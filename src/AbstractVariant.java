import java.util.*;

public abstract class AbstractVariant {
    private String inString;

    public abstract String getVariant();

    AbstractVariant(String inString){
        this.inString = inString;
    }

    public void calc(){
        System.out.println("");
        System.out.println(getVariant());
        System.out.println("");
        System.out.println("Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.");
        System.out.println(inString);
        System.out.println("Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.");
        Map<String, List<String>> structure = getStructureVariant(inString);
        System.out.println("");
        System.out.println("Затем вывести только группы, содержащие более одного элемента.Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове." +
                "Слова внутри группы нужно сортировать по убыванию (по количеству символов); если число символов равное, то сортировать в алфавитном порядке.");
        viewOnlyHaveCountOrMore(structure, 1);
        System.out.println("");
    }

    public abstract Map<String, List<String>> getStructureVariant(String s);

    public void printResultVariant(Map<String, List<String>> result){
        StringBuffer outString = new StringBuffer();
        for(Map.Entry<String, List<String>> entry : result.entrySet()){
            if (!outString.toString().isEmpty()){
                outString.append(", ");
            }
            outString.append(entry.getKey() + "=" + entry.getValue().toString());
        }
        System.out.print("[" + outString.toString() + "]");
    }

    public void  viewOnlyHaveCountOrMore(Map<String, List<String>> result, int count) {
        StringBuffer outString = new StringBuffer();
        for(Map.Entry<String, List<String>> entry : result.entrySet()){
            if (entry.getValue().size() <= count){
                continue;
            }
            if (!outString.toString().isEmpty()){
                outString.append(", ");
            }
            outString.append(entry.getKey() + "=" + entry.getValue().toString());
        }
        System.out.print("[" + outString.toString() + "]");
    }

}
