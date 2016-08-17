package ru.makarov.application.logicui;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * Class for NIO search using parameters.
 */
public class FileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;
    private String fileName;
    private String logFile;
    private int flag = 0;

    public FileVisitor(String pattern, String fileName, String logFile) {
        matcher = FileSystems.getDefault().getPathMatcher(pattern);
        this.fileName = fileName;
        this.logFile = logFile;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        find(file);
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs)  {
        find(file);
        return FileVisitResult.CONTINUE;
    }
    /**
     * Method for compare file wich we need and which we have.
     * @param path - file way.
     */
    public void find(Path path){
        Path name = path.getFileName();
        if(matcher.matches(name)){
            FileLog fileLog = new FileLog(fileName,logFile);
            fileLog.saveLog(new StringBuilder().append(path.getParent()).append("\\").append(path.getFileName()).toString());
            flag++;
        }
    }

    public int getFlag() {
        return flag;
    }
}
