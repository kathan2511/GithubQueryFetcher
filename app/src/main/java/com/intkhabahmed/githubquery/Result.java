package com.intkhabahmed.githubquery;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("incomplete_results")
    private boolean incompleteResult;
    @SerializedName("items")
    private List<Item> items;

    public Result(int totalCount, boolean incompleteResult, List<Item> items) {
        this.totalCount = totalCount;
        this.incompleteResult = incompleteResult;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Result{" +
                "totalCount=" + totalCount +
                ", incompleteResult=" + incompleteResult +
                ", items=" + items +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResult() {
        return incompleteResult;
    }

    public void setIncompleteResult(boolean incompleteResult) {
        this.incompleteResult = incompleteResult;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
