package in.myprojects.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.myprojects.bindings.ContactForm;
import in.myprojects.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactService;
	private List<ContactForm> viewContacts;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
//		String status = contactService.saveContact(form); // code smell
//		return status; // code smell
		return contactService.saveContact(form);
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewContacts() {
		System.out.println("viewContacts() method called");
		return contactService.viewContacts();
//		List<ContactForm> viewContacts = contactService.viewContacts();
//		return viewContacts;
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return contactService.editContact(contactId);
	}
	
//	@GetMapping("delete/{contactId}")
	@DeleteMapping("delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		return contactService.deleteContact(contactId);
	}
}
