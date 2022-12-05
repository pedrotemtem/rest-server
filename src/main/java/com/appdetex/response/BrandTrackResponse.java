package com.appdetex.response;

import com.appdetex.entity.BrandTrack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandTrackResponse {

    private Integer id;

    private String search_term;

    private Integer accountId;

    public BrandTrackResponse (BrandTrack brandTrack) {
        this.id = brandTrack.getId();
        this.search_term = brandTrack.getSearch_term();
        this.accountId = brandTrack.getAccountId();
    }
}
