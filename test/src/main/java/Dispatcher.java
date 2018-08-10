public class Dispatcher{
	private PersonView pv;
	private ContactView cv;
	
	public Dispatcher() {
		pv = new PersonView();
		cv = new ContactView();	
	 }
	
	public void requestView(String entity) {
		if(entity.equals("PERSON")) {
			pv.show();
		 }else if (entity.equals("CONTACT")) {
		 	cv.show();
		 }
	 }
 }
