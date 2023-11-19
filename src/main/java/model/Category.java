package model;

import java.time.LocalDateTime;

public class Category extends BaseEntity {
    private final String name;
    private final String description;

    public Category(long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {
        return
                "\n" + "Category" + "\n" +
                        "name = '" + name + "' \n" +
                        "description = '" + description + "' \n";

    }
}
