package br.com.adlermo.store.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class SalesReportVO {
    private String name;
    private Long amount;
    private LocalDateTime date;


    public SalesReportVO(String name, Long amount, LocalDateTime date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.amount + " | " + this.date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
