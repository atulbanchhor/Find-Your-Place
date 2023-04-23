package com.lcwd.rating.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("User_Rating")                //In mongo we use document instead of Entity
public class Rating {
    @Id                                 //In mongo it takes automatically random
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
