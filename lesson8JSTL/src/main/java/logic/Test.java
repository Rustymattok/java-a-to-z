package logic;

import persistent.DbStore;

public class Test {
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    private String size;

    public static ValidateService getWork() {
        return work;
    }

    public String getSize() {
        size = "777";
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
