package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Advertisement extends BaseEntity {
    private final String title;
    private final String description;
    private final BigDecimal price;
    private final boolean isActive;

    private final Category category;

    public Advertisement(long id, LocalDateTime createdAt, LocalDateTime updatedAt,
                         String title, String description, BigDecimal price, boolean isActive, Category category) {

        super(id, createdAt, updatedAt);
        this.title = title;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return
                "\n" + "Advertisement" + "\n" +
                        "id = " + super.getId() + " \n" +
                        "title = '" + title + "' \n" +
                        "description = '" + description + "' \n" +
                        "price = '" + price + "'\n" +
                        "is Active = '" + isActive + "'\n" +
                        "created At = '" + super.getCreatedAt() + "'\n" +
                        "updated At = '" + super.getUpdatedAt() + "'\n" +
                        category;
    }

}
