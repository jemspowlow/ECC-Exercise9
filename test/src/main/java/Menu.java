
public class Menu {
	private Dispatcher dispatcher;
	public Menu(){
		dispatcher = new Dispatcher();
	 }
	
	public static void main(String[] args) {
      
      
      ManagePerson ME = new ManagePerson();
	  List<Contact> contactInfo = new ArrayList<Contact>();
      Address address = ME.addAddress("9","Pasig","1600");
	  LocalDate birthDay = LocalDate.of(1996,9,23);
	  LocalDate dateHired = LocalDate.of(2018,6,18);
		Date bd = Date.from(birthDay.atStartOfDay(ZoneId.systemDefault()).toInstant());  
		Date dh = Date.from(dateHired.atStartOfDay(ZoneId.systemDefault()).toInstant());  
      /* Add employee records in the database */
      Integer personID1 = ME.addPerson("James","Menguito","Wagas",bd,dh,2.50,"MALE",true,"UPLB",address,contactInfo);
      /* Add another employee record in the database */
     // Integer personID2 = ME.addEmployee("Dilip", "Kumar", 3000, address);

      /* List down all the employees */
      ME.listPeople();
	  HibernateUtil.shutdown();
	  System.exit(0);
      /* Update employee's salary records */
      //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      //ME.deleteEmployee(empID2);

      /* List down all the employees */
      //ME.listEmployees();

   }
   
   public void displayMenu() {
   		int choice;
   		
   		System.out.println("Select Entity:");
   		switch(choice){
   			case 1: 
   				break;
   			
   			case 2: 
   				break;
   			case 3:
   			
   			
   		
   		}
   						
    }
	
 }
