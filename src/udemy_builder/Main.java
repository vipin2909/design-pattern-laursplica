package udemy_builder;


import java.util.ArrayList;
import java.util.Collections;

class HtmlElem {
    public String name, text;
    public int indentCount = 2;
    public ArrayList<HtmlElem> elements = new ArrayList<>();
    private String newLine = System.lineSeparator();
    public HtmlElem(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public HtmlElem() {

    }

    public String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent*indentCount, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if(text!=null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(indentCount*(indent+1), " "))).append(text).append(newLine);
        }
        for(HtmlElem e: elements) {
            sb.append(e.toStringImpl(indent+1));
        }

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuild {
    private String rootName;
    HtmlElem root = new HtmlElem();
    public HtmlBuild(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public HtmlBuild addChild(String childName, String childText) {
        HtmlElem o = new HtmlElem(childName, childText);
        root.elements.add(o);
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
public class Main {

    public static void main(String[] args) {
        HtmlBuild builder = new HtmlBuild("ul");
        builder.addChild("li", "hello").addChild("li", "world").addChild("p", "CHIPS");
        System.out.println(builder);
    }
}
