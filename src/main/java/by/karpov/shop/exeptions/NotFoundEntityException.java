package by.karpov.shop.exeptions;

import lombok.Getter;

@Getter
public class NotFoundEntityException extends RuntimeException {
    private final Long id;
    private final Class<?> type;

    public NotFoundEntityException(Long id, Class<?> type) {
        super("not found " + type.getSimpleName() + " with id " + id);
        this.id = id;
        this.type = type;
    }
}
