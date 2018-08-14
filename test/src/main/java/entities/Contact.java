package entities;
public class Contact {
		private int id;
		private ContactType type;
		private String details;
		private int idx;
	
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
		public ContactType getType() {
			return type;
		 }
			
		public void setType(ContactType type) {
			this.type = type;
		 }
		 
		public String getDetails() { 
			return details;
		 }
	
		public void setDetails (String details) {
			this.details = details;
		 } 
		public int getIdx(){
			return idx;
		 }
		public void setIdx(int idx) {
			this.idx = idx;
		 }
	 }
