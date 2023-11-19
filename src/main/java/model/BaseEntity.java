package model;

import java.time.LocalDateTime;

public class BaseEntity {

    private final long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity(long id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }


    public BaseEntity(long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return this.id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
