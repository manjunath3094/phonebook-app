package in.myprojects.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.myprojects.entities.Contact;
	
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
