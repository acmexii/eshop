package eshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceorderCommand {

    private String userId;
    private Long productId;
    private Integer qty;
}
