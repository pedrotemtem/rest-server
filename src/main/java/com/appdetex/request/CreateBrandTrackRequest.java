package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBrandTrackRequest {

    private String searchTerm;

    private Integer accountId;
}
