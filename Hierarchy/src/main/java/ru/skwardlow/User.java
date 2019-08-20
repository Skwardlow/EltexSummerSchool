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

    public int compareTo(User user2) {
        return this.userid.compareTo(user2.userid);
    }

    public boolean equals(User user2) {
        return this.fio.equals(user2.fio);
    }

    @Override
    public String toString() {
        return this.userid+" "+this.fio+" "+this.phone+" "+this.mailbox+" ";
    }

}
