package ru.makarov.application.logicui;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * Class for NIO search using parameters.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;
    private String fileName;
    private String logFile;
    private int flag = 0;

    public MyFileVisitor(String pattern,String fileName,String logFile) {
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

    public void find(Path path){
        Path name = path.getFileName();
        if(matcher.matches(name)){
            FileLog fileLog = new FileLog(fileName,logFile);
            fileLog.saveLog(path.getParent() +"\\" + path.getFileName());
            flag++;
        }
    }

    public int getFlag() {
        return flag;
    }
}
