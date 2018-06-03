package contactlist.contacts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is containing information about person from Contact List
 */
@Document(collection = "Peoplelist")
public class Person {

    /**
     * Fields with info about person
     */
    @Id
    private String id;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String EMAIL;
    private String PHONE;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }


    public Person(){}

    public Person(String id, String FIRST_NAME, String LAST_NAME, String EMAIL, String PHONE) {
        this.id = id;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.PHONE = PHONE;
    }


    @Override
    public String toString() {
        return FIRST_NAME + " " + LAST_NAME + " - " + EMAIL + "; " + PHONE;
    }
}
