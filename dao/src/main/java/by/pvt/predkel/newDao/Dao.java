package by.pvt.predkel.newDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {
    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet result;

}

