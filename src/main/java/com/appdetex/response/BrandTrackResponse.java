package com.appdetex.response;

import com.appdetex.entity.BrandTrack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandTrackResponse {

    private Integer id;

    private String searchTerm;

    private Integer accountId;

    public BrandTrackResponse (BrandTrack brandTrack) {
        this.id = brandTrack.getId();
        this.searchTerm = brandTrack.getSearchTerm();
        this.accountId = brandTrack.getAccountId();
    }
}
