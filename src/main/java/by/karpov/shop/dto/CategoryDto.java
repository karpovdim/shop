package by.karpov.shop.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class CategoryDto {
    Long id;
    Long parentId;
    List<Long> sub;
    String categoryName;
    List<Long> products;
}
