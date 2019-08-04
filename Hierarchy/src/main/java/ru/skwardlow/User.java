package ru.skwardlow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements CSV,JSON {
    @Getter @Setter
    protected Byte userid;
    @Getter @Setter
    protected String fio;
    @Getter @Setter
    protected String phone;
    @Getter @Setter
    protected String mailbox;



    @Override
    public String toString() {
        return this.userid+" "+this.fio+" "+this.phone+" "+this.mailbox+" ";
    }

}
