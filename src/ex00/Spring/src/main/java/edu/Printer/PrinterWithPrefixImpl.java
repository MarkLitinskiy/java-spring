package edu.Printer;

import edu.Renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer, String prefix){
        this.renderer = renderer;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String str) {
        renderer.render (prefix + " " + str);
    }
}
