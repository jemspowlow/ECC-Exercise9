
public class Contact {
		private int id;
		private ContactType type;
		private String details;
		
		private enum ContactType {
		MOBILE,LANDLINE,EMAIL;
	 	}
		public Contact(){}
		public Contact(ContactType type, String details) {
			this.type = type;
			this.details = details;
		 }
		
		public int getId() {
			return id;
		 }
		
		public void setId(int id) {
			this.id = id;
		 }
		public ContactType getContactType() {
			return type;
		 }
			
		public void setContactType(ContactType type) {
			this.type = type;
		 }
		 
		public String getDetails() { 
			return details;
		 }
	
		public void setDetails (String details) {
			this.details = details;
		 } 
	 }
