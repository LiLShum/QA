package jdbc.dao.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder<T> {

    /**
     * Main method of the Builder interface that is used
     * to build java bean class using {@link ResultSet}.
     *
     * @param resultSet the {@link ResultSet}
     * @return the {@link T} java bean class.
     * @throws SQLException builder can throw when it encounters difficulty
     */
    T build(ResultSet resultSet) throws SQLException;
}
