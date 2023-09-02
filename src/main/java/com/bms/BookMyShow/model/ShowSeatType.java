package com.bms.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
//@Table(name = "show_seattype_mapping")
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private double price;
}