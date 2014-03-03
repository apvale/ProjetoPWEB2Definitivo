package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="usuario_administrador")
@DiscriminatorValue("Administrador")
@CascadeOnDelete
@SuppressWarnings("serial")
public class Administrador extends Usuario {

}
