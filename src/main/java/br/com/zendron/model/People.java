package br.com.zendron.model;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.MultitenantType;
import org.eclipse.persistence.annotations.TenantTableDiscriminator;
import org.eclipse.persistence.annotations.TenantTableDiscriminatorType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: Zendron Date: 16/09/13 Time: 15:46 To change this template use File | Settings |
 * File Templates.
 */
@Entity
@Multitenant(value = MultitenantType.TABLE_PER_TENANT, includeCriteria = false)
@TenantTableDiscriminator(type = TenantTableDiscriminatorType.SCHEMA, contextProperty = "eclipselink.tenant-id")
@Table(name = "people")
@NamedQueries({
        @NamedQuery(name = "People.all", query = "select p from People p")
})
public class People implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
