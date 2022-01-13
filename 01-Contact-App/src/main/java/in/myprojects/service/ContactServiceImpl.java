package in.myprojects.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myprojects.bindings.ContactForm;
import in.myprojects.entities.Contact;
import in.myprojects.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(ContactForm form) {
		
		// We have received form binding object
		//Repository save(entity) is expecting Entity object
		//So copy the form binding obj to entity obj using "BeanUtils.copyProperties(source, target)"
		Contact entity = new Contact();
		
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSwitch("Y");
		
		entity = contactRepository.save(entity);
		
		if(entity.getContactId() != null) {
			return "SUCCESS, Contact Saved";
		}
		return "FAILED, Contact NOT Saved";
	}

	@Override
	public List<ContactForm> viewContacts() {  // returns "BINDING Objects"
		
		List<ContactForm> contactList = new ArrayList();
		
		List<Contact> findAll = contactRepository.findAll(); // returns "ENTITY Objects" but method returns "Binding objects"
		
		// Converting "ENTITY Objects" to "Binding Objects"
		for(Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			contactList.add(form);			
		}
		return contactList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		
		Optional<Contact> findById = contactRepository.findById(contactId);
		
		if(findById.isPresent()) {
			ContactForm form = new ContactForm();
			
			Contact entity = findById.get();
						
			BeanUtils.copyProperties(entity, form);		
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepository.deleteById(contactId);
		return viewContacts();
	}

}
