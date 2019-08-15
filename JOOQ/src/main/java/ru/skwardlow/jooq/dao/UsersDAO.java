package ru.skwardlow.jooq.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.skwardlow.database.tables.Developers;
import ru.skwardlow.database.tables.records.DevelopersRecord;
import ru.skwardlow.jooq.utils.Auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*CRUD*/
public class UsersDAO {
    public static void createUser(int id,String fio, String email, String phone) throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        context.insertInto(Developers.DEVELOPERS).set(Developers.DEVELOPERS.ID,id)
        .set(Developers.DEVELOPERS.FIO,fio)
        .set(Developers.DEVELOPERS.MAILBOX,email)
        .set(Developers.DEVELOPERS.PHONE,phone).execute();
        context.close();
        connection.close();
    }

    public static String readDevelopers() throws SQLException {
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        StringBuilder sb = new StringBuilder();
        Result<DevelopersRecord> developers = context.selectFrom(Developers.DEVELOPERS).fetch();
        for (DevelopersRecord dev : developers) {
            sb.append(dev.getId()).append(dev.getFio()).append(dev.getPhone()).append(dev.getMailbox()).append("\n");
        }
        context.close();
        connection.close();
        return sb.toString();
    }

    public static void updateUser(int id,String fio, String email, String phone)throws SQLException{
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        context.update(Developers.DEVELOPERS).set(Developers.DEVELOPERS.FIO,fio).where(Developers.DEVELOPERS.ID.eq(id)).execute();
        context.close();
        connection.close();
    }

    public static void deleteUser(int id)throws SQLException{
        Connection connection = DriverManager.getConnection(Auth.getHOST(),Auth.getLOGIN(),Auth.getPASSWD());
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        context.delete(Developers.DEVELOPERS).where(Developers.DEVELOPERS.ID.eq(id)).execute();
        context.close();
        connection.close();
    }



}
