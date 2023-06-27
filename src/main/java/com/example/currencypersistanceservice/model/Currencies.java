package com.example.currencypersistanceservice.model;

import lombok.Data;
import javax.validation.Valid;
import java.util.List;

@Data
public class Currencies {
    @Valid
    private List<Rate> rate;
}

