package tak.poc.openapipoc.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class InfoItem {

    private int id;
    private String information;

    public InfoItem (int id) {
        this.id = id;
        this.information = "The id of this info is " + id + ".";
    }

    public InfoItem appendTo (String msg) {
        this.information = this.information + msg;
        return this;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static class InfoItemNotFound extends RuntimeException {}
}