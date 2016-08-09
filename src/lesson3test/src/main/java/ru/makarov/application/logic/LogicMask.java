package ru.makarov.application.logic;

import ru.makarov.application.interfaces.*;
import ru.makarov.application.logicui.MyFileVisitor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * This class describe Logic for global.
 */
public class LogicMask implements AlgaritmSearch {
    /**
     * @param mask - String parameter choose filter for search.
     * @param logFile - String parameter choose logway.
     * @param myFileVisitor - parameter for search from NIO.
     */
    private String mask;
    private String logFile;
    private MyFileVisitor myFileVisitor;


    public LogicMask(String logFile,String mask) {
        this.mask = mask;
        this.logFile = logFile;
    }


    public void startwork(String dir) {
        Path patch1 = Paths.get(dir);
        String pattern = "glob:" + mask;
        myFileVisitor = new MyFileVisitor(pattern,dir,logFile);
        try {
            Files.walkFileTree(patch1, myFileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFileVisitor getMyFileVisitor() {
        return myFileVisitor;
    }
}
