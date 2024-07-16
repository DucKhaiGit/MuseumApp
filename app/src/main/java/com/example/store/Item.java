package com.example.store;

import java.io.Serializable;

public class Item    implements Serializable {

    private int sourceId;
    private String name;

    private String script;

    public Item(int sourceId, String name, String script) {
        this.sourceId = sourceId;
        this.name = name;
        this.script = script;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
