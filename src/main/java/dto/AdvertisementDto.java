package dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdvertisementDto {
    private final long id;

    private final String title;
    private final String description;
    private final BigDecimal price;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;


    private final boolean isActive;
    private final long userId;
    private final long categoryId;


    public AdvertisementDto(long id, String title, String description, BigDecimal price, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive, long userId, long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "\n"+
                "AdvertisementDto" +"\n"+
                "id = " + id  +"\n"+
                "title = " + title  +"\n"+
                "description = " + description + "\n"+
                "price = " + price +"\n"+
                "isActive = " + isActive +"\n"+
                "created = " + createdAt +"\n"+
                "updated = " + updatedAt +"\n"+
                "userId = " + userId +"\n"+
                "categoryId = " + categoryId +
                "\n";
    }
}
