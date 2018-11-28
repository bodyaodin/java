package contactlist.management;

import contactlist.connections.PostgreSQLConnection;
import contactlist.contacts.Person;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

/**
 * This class is used for inserting, updating and selecting data from PostgreSQL DB
 */
public class PostgreSQLDBManagement implements DBManagement {

//    private PostgreSQLConnection postgreSQLConnection;
//    private Connection connection;

    /**
     * Spring jdbcTemplate for works with PostgreSQL Data base queries
     */
//    private JdbcTemplate jdbcTemplate;

    /**
     * Spring sessionFactory for works with PostgreSQL DB via Hibernate
     */
    private SessionFactory sessionFactory;

    /**
     * Field for Table name from Contact List
     */
    private String tableName;


//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public PostgreSQLDBManagement() {}

//    @Autowired
//    public PostgreSQLDBManagement(PostgreSQLConnection postgreSQLConnection) {
//        this.postgreSQLConnection = postgreSQLConnection;
//    }


    /**
     * method for inserting data to DB table
     */
    @Override
    public void insertToDBTable(Person person) {
        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(person);
                session.getTransaction().commit();
            } finally {
                session.close();
            }

            System.out.printf("%s %s was added to %s!%n", person.getFIRST_NAME(), person.getLAST_NAME(), this.tableName);
            System.out.println();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        /*
        String updateQuery = "INSERT INTO " + this.tableName.toUpperCase() + " (FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(updateQuery, person.getFIRST_NAME(), person.getLAST_NAME(), person.getEMAIL(), person.getPHONE());

            System.out.printf("%s %s was added to %s!%n", person.getFIRST_NAME(), person.getLAST_NAME(), this.tableName);
            System.out.println();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            try {
                connection = postgreSQLConnection.getConnectionToDB();

                PreparedStatement statement = connection.prepareStatement(updateQuery);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, phone);
                statement.executeUpdate();
                statement.close();

                System.out.printf("%s %s was added to %s!%n", firstName, lastName, tableName);
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * method for deleting all data from DB table
     */
    @Override
    public void deleteAllFromDBTable() {
        String deleteQuery = "DELETE FROM " + Person.class.getSimpleName();

        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.createQuery(deleteQuery).executeUpdate();
                session.getTransaction().commit();
            } finally {
                session.close();
            }

            System.out.println("All data was deleted from " + this.tableName + "!");
            System.out.println();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        /*
        String deleteQuery = "DELETE FROM " + this.tableName.toUpperCase();

        try {
            int deletedLines = jdbcTemplate.update(deleteQuery);

            System.out.println("All data was deleted! Count of deleted lines - " + deletedLines + "!");
            System.out.println();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                int deletedLines = statement.executeUpdate(deleteQuery);
                statement.close();

                System.out.println("Count of deleted lines - " + deletedLines + "!");
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * method for deleting some data from DB table where name is ...
     */
    @Override
    public void deleteFromDBTableForName(Person person) {
        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.delete(person);
                session.getTransaction().commit();
            } finally {
                session.close();
            }

            System.out.println("Records with name " + person.getFIRST_NAME() + " was deleted from " + this.tableName + "!");
            System.out.println();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        /*
        String deleteQuery = "DELETE FROM " + this.tableName.toUpperCase() + " WHERE FIRST_NAME = '" + person.getFIRST_NAME() + "'";

        try {
            int deletedLines = jdbcTemplate.update(deleteQuery);

            System.out.println("Records with name " + person.getFIRST_NAME() + " was deleted from " + this.tableName + "! Count of deleted lines - " + deletedLines + "!");
            System.out.println();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            try{
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                int deletedLines = statement.executeUpdate(deleteQuery);
                statement.close();

                System.out.println("Count of deleted lines - " + deletedLines + "!");
                System.out.println();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }


    /**
     * method for selecting all data from DB table
     */
    @Override
    public void selectAllFromDBTable() {
        String selectQuery = "FROM " + Person.class.getSimpleName();

        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();

                List<Person> peopleList = session.createQuery(selectQuery).list();
                int i = 1; //counter of people
                for (Iterator<Person> iterator = peopleList.iterator(); iterator.hasNext(); ) {
                    System.out.printf("Person #%d: %s%n", i++, iterator.next());
                }
                System.out.println();

                session.getTransaction().commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        /*
        String selectQuery = "SELECT * FROM " + this.tableName.toUpperCase();

        try {
            List<String> rowsFromTable = jdbcTemplate.query(selectQuery, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE");
                    return resultLine;
                }
            });

            int i = 1; //counter of people
            for (Iterator<String> iterator = rowsFromTable.iterator(); iterator.hasNext(); ) {
                System.out.printf("Person #%d: %s%n", i++, iterator.next());
            }
            System.out.println();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            try {
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                int i = 1; //counter of people
                while (resultSet.next()) {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE");
                    System.out.printf("Person #%d: %s%n", i++, resultLine);
                }
                System.out.println();

                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * method for selecting some data from DB table where name is ...
     */
    @Override
    public void selectFromDBTableForName(Person person) {
        String selectQuery = "FROM " + Person.class.getSimpleName();

        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Person selectedPerson = (Person) session.get(Person.class, person.getId());
                session.getTransaction().commit();

                int i = 1; //counter of people
                System.out.printf("Person #%d: %s%n", i++, selectedPerson);
                System.out.println();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        /*
        String selectQuery = "SELECT * FROM " + this.tableName.toUpperCase() + " WHERE FIRST_NAME = '" + person.getFIRST_NAME() + "'";

        try {
            List<String> rowsFromTable = jdbcTemplate.query(selectQuery, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE");
                    return resultLine;
                }
            });

            int i = 1; //counter of people
            for (Iterator<String> iterator = rowsFromTable.iterator(); iterator.hasNext(); ) {
                System.out.printf("Person #%d: %s%n", i++, iterator.next());
            }
            System.out.println();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        */

        /*
        try {
            try {
                connection = postgreSQLConnection.getConnectionToDB();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                int i = 1; //counter of people
                while (resultSet.next()) {
                    String resultLine = resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME")
                            + " - " + resultSet.getString("EMAIL") + "; " + resultSet.getString("PHONE");
                    System.out.printf("Person #%d: %s%n", i++, resultLine);
                }
                System.out.println();

                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    public void updateRecordInDBTable(Person oldPerson, Person newPerson) {
        try (final Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Person selectedPerson = (Person) session.get(Person.class, oldPerson.getId());
                selectedPerson.setFIRST_NAME(newPerson.getFIRST_NAME());
                selectedPerson.setLAST_NAME(newPerson.getLAST_NAME());
                selectedPerson.setEMAIL(newPerson.getEMAIL());
                selectedPerson.setPHONE(newPerson.getPHONE());
                session.update(selectedPerson);
                session.getTransaction().commit();

                System.out.printf("Record with name %s was updated!%n", selectedPerson.getFIRST_NAME());
                System.out.println();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
