package ru.makarov.application.logicui;


import ru.makarov.application.interfaces.AlgaritmSearch;

public class LogicUI {
    private AlgaritmSearch algaritmSearch;

    public LogicUI(AlgaritmSearch algaritmSearch) {
        this.algaritmSearch = algaritmSearch;
    }

    public void setAlgaritmSearch(AlgaritmSearch algaritmSearch) {
        this.algaritmSearch = algaritmSearch;
    }

    public void logic(String text){
        algaritmSearch.startwork(text);
    }
}
