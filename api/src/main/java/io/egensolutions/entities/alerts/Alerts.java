package io.egensolutions.entities.alerts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(schema = "alerts_db")
public class Alerts {
    @Id
    String id;
    String message;
    String priority;


    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = UUID.randomUUID().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
