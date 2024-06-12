package me.minikuma.mvc.common;

import java.util.Objects;

public class MyRequestCondition {
    private final MyRequestMethod requestMethod;
    private final String path;

    public MyRequestCondition(MyRequestMethod requestMethod, String path) {
        this.requestMethod = requestMethod;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyRequestCondition that = (MyRequestCondition) o;
        return requestMethod == that.requestMethod && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestMethod, path);
    }
}
