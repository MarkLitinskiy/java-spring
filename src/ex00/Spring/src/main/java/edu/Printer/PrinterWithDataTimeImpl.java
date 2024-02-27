package edu.Printer;

import edu.Renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDataTimeImpl implements Printer{

    Renderer renderer;

    PrinterWithDataTimeImpl(Renderer renderer){
        this.renderer = renderer;
    }
    LocalDateTime date = LocalDateTime.now();

    @Override
    public void print(String str) {
        renderer.render(str + " " + date.toString());
    }
}
