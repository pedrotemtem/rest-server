package com.appdetex.entity;

import com.appdetex.request.CreateBrandTrackRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "brand_tracks")
public class BrandTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "search_term")
    private String search_term;

    @Column(name = "account_id")
    private Integer accountId;

    public BrandTrack(CreateBrandTrackRequest createBrandTrackRequest) {
        this.search_term = createBrandTrackRequest.getSearch_term();
        this.accountId = createBrandTrackRequest.getAccount_id();
    }
}
