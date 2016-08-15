package ru.makarov.application.logic;

import ru.makarov.application.interfaces.AlgaritmSearch;
import ru.makarov.application.logicui.FileVisitor;
import ru.makarov.application.logicui.ShowInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * This class describe Logic for regex.
 */
public class LogicReg implements AlgaritmSearch {
    /**
     * @param mask - String parameter choose filter for search.
     * @param logFile - String parameter choose logway.
     * @param myFileVisitor - parameter for search from NIO.
     */
    private String mask;
    private String logFile;
    private FileVisitor myFileVisitor;

    public LogicReg(String logFile,String mask) {
        this.mask = mask;
        this.logFile = logFile;
    }
    /**
     * Method for start searching by mask.
     * @param dir - add to log.txt files wich were found.
     */
    public void startwork(String dir) {
        Path patch1 = Paths.get(dir);
        //String pattern = "regex:" + mask;
        String pattern = new StringBuilder().append("regex:").append(mask).toString();
        myFileVisitor = new FileVisitor(pattern,dir,logFile);
        try {
            if (Files.exists(patch1)) {
                Files.walkFileTree(patch1, myFileVisitor);
            }else {
                new ShowInterface().noFolder();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileVisitor getMyFileVisitor() {
        return myFileVisitor;
    }
}
