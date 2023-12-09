package model;

import java.time.LocalDateTime;

public class BaseEntity {
    private long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity() {
    }

    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity(long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseEntity(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "id =" + id +
                        "createdAt = " + createdAt +
                        "updatedAt = " + updatedAt
                ;
    }
}
