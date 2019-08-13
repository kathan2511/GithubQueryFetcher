package com.intkhabahmed.githubquery;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    private int id;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("name")
    private String name;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nodeId=" + nodeId +
                ", name='" + name + '\'' +
                '}';
    }

    public Item(int id, String nodeId, String name) {
        this.id = id;
        this.nodeId = nodeId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
