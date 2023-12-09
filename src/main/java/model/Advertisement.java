package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Advertisement extends BaseEntity {
    private final String title;
    private final String description;
    private final BigDecimal price;
    private final boolean isActive;
    private final long userId;
    private final long categoryId;

    public Advertisement(
            long id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String title,
            String description,
            BigDecimal price,
            boolean isActive,
            long userId,
            long categoryId) {
        super(id, createdAt, updatedAt);
        this.title = title;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Advertisement(
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String title,
            String description,
            BigDecimal price,
            boolean isActive,
            long userId,
            long categoryId) {
        super(createdAt, updatedAt);
        this.title = title;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.userId = userId;
        this.categoryId = categoryId;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return isActive;
    }

    public long getUserId() {
        return userId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return
                "\n" + "Advertisement" + "\n" +
                        "id = '" + super.getId() + "' \n" +
                        "title = '" + title + "' \n" +
                        "description = '" + description + "' \n" +
                        "price = '" + price + "'\n" +
                        "is Active = '" + isActive + "'\n" +
                        "created At = '" + super.getCreatedAt() + "'\n" +
                        "updated At = '" + super.getUpdatedAt() + "'\n";
    }

}
