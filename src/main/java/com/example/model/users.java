package com.example.model;
//import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

//import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "card_id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "first_name")
	@Length(max = 30, message = "*Your name can have at most 30 characters")
	@NotEmpty(message = "*Please provide your first name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "please enter first name correctly")
	private String firstname;
	@Column(name = "middle_name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "please enter middle name correctly")
	private String middlename;
	@Column(name = "last_name")
	@Length(max = 30, message = "*Your name can have at most 30 characters")
	@NotEmpty(message = "*Please provide your last name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "please enter last name correctly")
	private String lastname;
	@Column(name = "bank_name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "please enter bank name correctly")
	@NotEmpty(message = "*Please provide your bank name")
	private String bankname;
	@Column(name = "card_no")
	@NotEmpty(message = "*Please provide your card no.")
	@Pattern(regexp = "^[0-9]{16}$", message = "please enter correctly")
	//@CreditCardNumber(message="*not a valid card no.")
	private String cardno;
	@Column(name = "cvv")
	@NotEmpty(message = "*Please provide your cvv no.")
	@Pattern(regexp = "^[0-9]{3}$", message = "please enter correctly")
	private String cvv;
	@Column(name = "valid")
	@NotEmpty(message = "*Please provide your card valid from date")
	@Pattern(regexp = "^(?:0[1-9]|1[0-2])/[0-9]{2}$", message = "please enter date in correct format")
	private String validfrom;
	@Column(name = "expiry")
	@Pattern(regexp = "^(?:0[1-9]|1[0-2])/[0-9]{2}$", message = "please enter date in correct format")
	@NotEmpty(message = "*Please provide your card expiry date")
	private String expiry;
	@Column(name = "cardtype")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "please enter valid card type")
	@NotEmpty(message = "*Please provide your cardtype")
	private String cardtype;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(String validfrom) {
		this.validfrom = validfrom;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	
	
	

}
