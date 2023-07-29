package com.bugtracker.model;

import java.util.Objects;

public class BugList {

    private int bugListId;
    private String title;
    private String description;
    private int userId;

    public BugList(int bugListId, String title, String description, int userId) {
        this.bugListId = bugListId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public BugList() {

    }


    public int getBugListId() {
        return bugListId;
    }

    public void setBugListId(int bugListId) {
        this.bugListId = bugListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BugList{" +
                "bugListId=" + bugListId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BugList bugList = (BugList) o;
        return Objects.equals(bugListId, bugList.bugListId) && Objects.equals(title, bugList.title) && Objects.equals(description, bugList.description) && Objects.equals(userId, bugList.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugListId, title, description, userId);
    }
}
