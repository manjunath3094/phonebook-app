package in.myprojects.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm { // class to capture data from the Contact Form i.e DTO class

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSwitch; // to maintain "SOFT DELETE" functionality
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
