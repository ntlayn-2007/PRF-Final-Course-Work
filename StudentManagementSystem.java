import java.util.*;

class StudentManagementSystem {
    // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;
    
    //Batch Common Number
    public static int Common = 24;
     
    //Lecture modes
    public static String Physical = "PR";
    public static String Online = "OR";
    
    //Student Counts of each batches
    public static int[] eachBatchStuCount = {25, 25, 25, 25, 25, 25};
    
    // Batch data
    public static int[] batchNameArray = { 105, 106, 107, 108, 109, 110 };
    public static int[] batchStatusArray = { 0, 0, 0, 0, 1, 1 };

    // Student data
    public static String[] regNoArray = {
            "PR24105001", "PR24105002", "PR24105003", "PR24105004", "PR24105005",
            "PR24105006", "PR24105007", "PR24105008", "PR24105009", "PR24105010",
            "OR24105011", "OR24105012", "OR24105013", "OR24105014", "OR24105015",
            "PR24105016", "PR24105017", "PR24105018", "OR24105019", "OR24105020",
            "PR24105021", "PR24105022", "OR24105023", "OR24105024", "PR24105025",
            "PR24106001", "PR24106002", "PR24106003", "PR24106004", "PR24106005",
            "PR24106006", "PR24106007", "PR24106008", "PR24106009", "PR24106010",
            "OR24106011", "OR24106012", "OR24106013", "OR24106014", "OR24106015",
            "PR24106016", "PR24106017", "PR24106018", "OR24106019", "OR24106020",
            "PR24106021", "PR24106022", "OR24106023", "OR24106024", "PR24106025",
            "PR24107001", "PR24107002", "PR24107003", "PR24107004", "PR24107005",
            "PR24107006", "PR24107007", "PR24107008", "PR24107009", "PR24107010",
            "OR24107011", "OR24107012", "OR24107013", "OR24107014", "OR24107015",
            "PR24107016", "PR24107017", "PR24107018", "OR24107019", "OR24107020",
            "PR24107021", "PR24107022", "OR24107023", "OR24107024", "PR24107025",
            "PR24108001", "PR24108002", "PR24108003", "PR24108004", "PR24108005",
            "PR24108006", "PR24108007", "PR24108008", "PR24108009", "PR24108010",
            "OR24108011", "OR24108012", "OR24108013", "OR24108014", "OR24108015",
            "PR24108016", "PR24108017", "PR24108018", "OR24108019", "OR24108020",
            "PR24108021", "PR24108022", "OR24108023", "OR24108024", "PR24108025",
            "PR24109001", "PR24109002", "PR24109003", "PR24109004", "PR24109005",
            "PR24109006", "PR24109007", "PR24109008", "PR24109009", "PR24109010",
            "OR24109011", "OR24109012", "OR24109013", "OR24109014", "OR24109015",
            "PR24109016", "PR24109017", "PR24109018", "OR24109019", "OR24109020",
            "PR24109021", "PR24109022", "OR24109023", "OR24109024", "PR24109025",
            "PR24110001", "PR24110002", "PR24110003", "PR24110004", "PR24110005",
            "PR24110006", "PR24110007", "PR24110008", "PR24110009", "PR24110010",
            "OR24110011", "OR24110012", "OR24110013", "OR24110014", "OR24110015",
            "PR24110016", "PR24110017", "PR24110018", "OR24110019", "OR24110020",
            "PR24110021", "PR24110022", "OR24110023", "OR24110024", "PR24110025"

    };

    public static String[] nicArray = {
            "199501012345", "199503153872", "199506202198", "199509102983", "199511258739",
            "199512303498", "199502183764", "199504223198", "199508153210", "199510293417",
            "199601102375", "199604182938", "199606243879", "199608142178", "199610312475",
            "199611173452", "199603293481", "199605083217", "199607232198", "199609192375",
            "199701212483", "199703132487", "199706253478", "199708083298", "199710243651",
            "199712152983", "199702182734", "199704293187", "199705142375", "199709083751",
            "199801032874", "199803232871", "199806193428", "199808013764", "199810242374",
            "199812302984", "199802152348", "199805213471", "199807172398", "199811283472",
            "199901122471", "199903052984", "199906213874", "199908093412", "199910273894",
            "199912153482", "199902202394", "199904163874", "199907293481", "199911083479",
            "200001112374", "200003143478", "200006293874", "200008103471", "200010252984",
            "200012043894", "200002193874", "200004212374", "200005183492", "200007153871",
            "200101232984", "200103083471", "200106273894", "200108123984", "200110043728",
            "200112213874", "200102253471", "200104103874", "200105293784", "200107202983",
            "200201013874", "200203253471", "200206143874", "200208083471", "200210293874",
            "200212183471", "200202103874", "200204123894", "200205283471", "200207153874",
            "200301093874", "200303283471", "200306153874", "200308123471", "200310083874",
            "200312243471", "200302273874", "200304203471", "200305123874", "200307213471",
            "200401153874", "200403123471", "200406293874", "200408083471", "200410213874",
            "200412153471", "200402203874", "200404273471", "200405143874", "200407183471",
            "200501023874", "200503193471", "200506153874", "200508213471", "200510083874",
            "200512293471", "200502123874", "200504153471", "200505283874", "200507173471"
            ,"200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678"
        };

    public static String[] nameArray = {
            "Gunawardena Weerasinghe", "Senanayake Silva", "Silva Kumara", "Kumara Herath", "Rathnayake Herath",
            "Wijesinghe Bandara", "Rajapaksha Herath", "Senanayake Karunaratne", "Karunaratne Jayasinghe",
            "Gunawardena Silva",
            "Weerasinghe Rajapaksha", "Silva Rathnayake", "Fernando Perera", "Kumara Abeysekera",
            "Ekanayake Rathnayake",
            "Herath Gunawardena", "Abeysekera Silva", "Weerasinghe Silva", "Jayasinghe Dias", "Bandara Rathnayake",
            "Silva Perera", "De Silva Dias", "Abeysekera Jayasinghe", "Rajapaksha Senanayake", "Kumara Karunaratne",
            "Silva Abeysekera", "Jayasinghe Bandara", "Rathnayake Kumara", "Weerasinghe Rajapaksha",
            "Senanayake Herath",
            "Perera Ekanayake", "Herath Jayasinghe", "Kumara Gunawardena", "Abeysekera Silva", "Dias Fernando",
            "Karunaratne Weerasinghe", "Ekanayake Bandara", "Rajapaksha Kumara", "Silva De Silva",
            "Gunawardena Rathnayake",
            "Bandara Karunaratne", "Fernando Perera", "De Silva Silva", "Rajapaksha Gunawardena", "Herath Weerasinghe",
            "Karunaratne Dias", "Jayasinghe Silva", "Senanayake Abeysekera", "Silva Jayasinghe", "Rathnayake Kumara",
            "Gunawardena Kumara", "Rajapaksha Silva", "Perera Jayasinghe", "Silva Ekanayake", "Dias Senanayake",
            "Herath Abeysekera", "Rathnayake Fernando", "Kumara Herath", "Weerasinghe Silva", "Senanayake Karunaratne",
            "Abeysekera Silva", "Bandara Gunawardena", "Karunaratne Weerasinghe", "Perera Herath", "Fernando Dias",
            "Weerasinghe Gunawardena", "Rathnayake Kumara", "Senanayake Fernando", "Silva Bandara", "Herath Rajapaksha",
            "Kumara Jayasinghe", "Abeysekera Perera", "Rathnayake Jayasinghe", "Kumara Weerasinghe",
            "Rajapaksha Ekanayake",
            "Fernando Rajapaksha", "Silva Gunawardena", "Perera Wijesinghe", "Herath Abeysekera",
            "Rajapaksha Ekanayake",
            "Karunaratne Silva", "Weerasinghe Fernando", "Silva Bandara", "Abeysekera Weerasinghe",
            "Kumara Karunaratne",
            "Dias Rajapaksha", "Herath Perera", "Rathnayake Gunawardena", "Ekanayake Jayasinghe", "Gunawardena Silva",
            "Rajapaksha Perera", "Karunaratne Jayasinghe", "Weerasinghe Abeysekera", "Rathnayake Fernando",
            "Kumara Herath",
            "Silva Weerasinghe", "Herath Karunaratne", "Abeysekera Silva", "Gunawardena Ekanayake",
            "Weerasinghe Kumara",
            "Weerasinghe Kumara", "Rajapaksha Abeysekera", "Gunawardena Perera", "Karunaratne Silva",
            "Herath Wijesinghe",
            "Rathnayake Ekanayake", "Silva Fernando", "Abeysekera Rajapaksha", "Fernando Bandara", "Perera Herath",
            "Weerasinghe Jayasinghe", "Silva Karunaratne", "Rathnayake Gunawardena", "Herath Kumara",
            "Abeysekera Silva",
            "Ekanayake Bandara", "Rajapaksha Fernando", "Gunawardena Weerasinghe", "Kumara Karunaratne", "Silva Dias",
            "Perera Weerasinghe", "Karunaratne Rajapaksha", "Jayasinghe Silva", "Rathnayake Perera", "Silva Ekanayake",
            "Silva Karunaratne", "Herath Fernando", "Kumara Jayasinghe", "Weerasinghe Perera", "Abeysekera Rajapaksha",
            "Rathnayake Karunaratne", "Ekanayake Bandara", "Gunawardena Perera", "Silva Wijesinghe",
            "Rajapaksha Jayasinghe",
            "Rathnayake Fernando", "Karunaratne Kumara", "Perera Silva", "Gunawardena Ekanayake", "Bandara Rajapaksha",
            "Silva Herath", "Rathnayake Weerasinghe", "Perera Gunawardena", "Herath Karunaratne", "Silva Rajapaksha",
            "Ekanayake Kumara", "Bandara Herath", "Weerasinghe Rajapaksha", "Karunaratne Abeysekera", "Perera Dias",

    };

    public static int[] prfArray = {
            85, 39, -1, 72, 44,
            91, 60, 38, 95, 49,
            -1, 67, 23, 58, 88,
            81, 73, 29, 62, -1,
            79, 53, 94, 47, 35,
            93, 15, -1, 82, 45,
            88, 23, 79, 37, -1,
            68, 100, 59, 29, 92,
            12, 77, 38, 66, 9,
            84, 51, 32, -1, 97,
            95, -1, 63, 88, 32,
            76, 97, 54, -1, 23,
            90, 35, 81, 61, 44,
            67, 100, 17, 85, 29,
            70, 42, -1, 60, 86,
            86, 57, 91, 35, -1,
            76, 48, 94, 23, 69,
            -1, 80, 55, 88, 32,
            100, 67, 43, -1, 90,
            60, 77, 25, 71, 84,
            92, 68, 59, 85, 63,
            76, 91, 70, 84, 63,
            72, 89, 45, 81, 77,
            68, 63, 88, 75, 90,
            57, 79, 92, 62, 100,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2

    };

    public static int[] dbmsArray = {
            66, 45, 93, 58, -1,
            37, 88, 21, 79, 40,
            76, 54, -1, 69, 92,
            25, 84, 33, 60, 71,
            59, -1, 98, 27, 48,
            35, 91, 60, -1, 72,
            49, 26, 80, 14, 89,
            67, -1, 31, 94, 53,
            78, 5, 90, 24, 86,
            39, -1, 61, 73, 100,
            38, 91, -1, 74, 55,
            82, 66, 49, 99, 13,
            80, 70, 93, 36, 59,
            85, 47, 90, -1, 22,
            77, 34, 63, 100, 29,
            79, 62, 87, -1, 54,
            46, 99, 39, 70, -1,
            75, 83, 58, 92, 30,
            91, 40, 63, 95, 68,
            -1, 66, 21, 88, 37,
            67, 91, 85, 73, 70,
            63, 76, 88, 55, 64,
            79, 80, 59, 92, 68,
            100, 77, 83, 45, 62,
            66, 59, 78, 85, 56,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2
    };

     //Array for the GPA values
    public static double[] gpaArray = new double[nameArray.length + 1];

    // console clear
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

     // Exit
    public static void exit() {
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
    }


    // home page
    public static void homePage() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tiCET Student Management System\t\t|");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("[1] Student Management");
        System.out.println("\n[2] Batch Management ");
        System.out.println("\n[3] Grade Management");
        System.out.println("\n[4] Report Generator");
        System.out.println("\n[5] Exit");

        Scanner input = new Scanner(System.in);
        do {

            System.out.print("\n\nEnter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    clearConsole();
                    studentManagement();
                    break;
                case 2:
                    clearConsole();
                    batchManagement();
                    break;
                case 3:
                    clearConsole();
                    gradeManagement();
                    break;
                case 4:
                    clearConsole();
                    reportGenerator();
                    break;
                case 5:
                    exit();
                    break;
            }
        } while (true);
    }




    // Student Management
    public static void studentManagement() {
        
         Scanner input = new Scanner(System.in);
        do {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tStudent Management\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
			System.out.println("[1] Add Student");
			System.out.println("\n[2] Update Student ");
			System.out.println("\n[3] View Student Profile");
			System.out.println("\n[4] Delete Student Profile");
			System.out.println("\n[5] Exit");
        

            System.out.print("\n\nEnter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    clearConsole();
                    addStudent();
                    break;
                case 2:
                    clearConsole();
                    updateStudent();
                    break;
                case 3:
                    clearConsole();
                    viewStudentProfile();
                    break;
                case 4:
                    clearConsole();
                    deleteStudentProfile();
                    break;
                case 5:
                    exit();
                    break;
            }
        } while (true);
    }

    public static void addStudent(){
		
		clearConsole();
		
		int batchNumber=0;
		String studentName="", studentNIC="";
		int lecMode=0;
		
		Scanner input = new Scanner(System.in);
        
        boolean repeat = true;
        do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tAdd Student\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			System.out.print("\nEnter Batch Number (Student should be added):");
			batchNumber = input.nextInt();
			
			for(int i=0; i < batchNameArray.length; i++){
				if(batchNameArray[i]==batchNumber){
					if(batchStatusArray[i]==ENROLLMENTCLOSED){
						System.out.println("\t\tStudents cannot be added to this batch because enrollment is closed.\n");
						
						System.out.print("Do you want to add student to another batch (Y/N) : ");
						String reEnter = input.next();
						repeat = isReEnter(reEnter);
						
						if(repeat==false){
							System.out.print("\nDo you want to go to the homepage or exit(Y/N) :");
							reEnter = input.next();
							repeat = isReEnter(reEnter);
							if(repeat==true){
								clearConsole();
								homePage();
							}
							else if(repeat==false){
								exit();
							}
						}
						
					}
					else if(batchStatusArray[i]==ENROLLMENTOPEN){
						System.out.print("Enter Student NIC : ");
						studentNIC=input.next();
						boolean nicCheck=false;
						for(int j=0; j<nicArray.length; j++){
							if(studentNIC.equals(nicArray[j])){
								System.out.println("\t\tThis student is already added to the system.");
								nicCheck=true;
							}
						}
						if(nicCheck==false){
							input.nextLine();
	 						System.out.print("Enter Student Name : ");
							studentName=input.nextLine();
							System.out.print("Enter Lecturer Mode (1-PHYSICAL 0-ONLINE): ");
							lecMode=input.nextInt();
							
							createStudentAccount(lecMode, batchNumber, studentNIC, studentName);
							
							System.out.println("Student was successfully added to the system.\n\n");
							System.out.print("Do you want to add another student(Y/N) : ");
							String reEnter = input.next();
							repeat = isReEnter(reEnter);
							if(repeat==false){
								System.out.print("Do you want to go to the homepage or exit(Y/N) :");
								reEnter = input.next();
								repeat = isReEnter(reEnter);
								if(repeat==true){
									clearConsole();
									homePage();
								}
								else if(repeat==false){
									exit();
								}
							}			
						}
					}
				}
			}
		}
		while(repeat);
		
		
	};
	
	public static void createStudentAccount(int lecMode, int batchNumber, String stuNIC, String stuName){
		String new_regNo = "";
		int count=0;
		int uniqueNo = 0;
		for(int i=0; i<regNoArray.length; i++){
			if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
				count++;
			}
		}
		uniqueNo = count+1;
		String Unique = String.format("%03d", uniqueNo);
		
		switch(lecMode){
			
			case 0 :
				new_regNo = Online + Common + batchNumber + Unique;
				System.out.println("\t\tStudent Registration Number - "+new_regNo);
				break;
			 
			case 1 : 
				new_regNo = Physical + Common + batchNumber + Unique;
				System.out.println("\t\tStudent Registration Number - "+new_regNo);
				break;
		}
		
		String[] temp_regNoArray = new String[regNoArray.length + 1];
		String[] temp_nicArray = new String[nicArray.length + 1];
		String[] temp_nameArray = new String[nameArray.length + 1];
		for (int i = 0; i < regNoArray.length; i++){
			temp_regNoArray[i] = regNoArray[i];
			temp_nicArray[i] = nicArray[i];
			temp_nameArray[i] = nameArray[i];
		}
		temp_regNoArray[regNoArray.length] = new_regNo;
		temp_nicArray[regNoArray.length] = stuNIC;
		temp_nameArray[regNoArray.length] = stuName;
		
		regNoArray = temp_regNoArray;
		nicArray = temp_nicArray;
		nameArray = temp_nameArray;
		
	}
	
    public static void updateStudent(){
		Scanner input = new Scanner(System.in);
		String reEnter = "";
		boolean repeat = true;
		boolean isRegFound = false;
		int i=0;
		
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tUpdate Student\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			String stuRegNo="", stuName="", stuNIC="";
		
			System.out.print("Enter Student Registration Number : ");
			stuRegNo = input.next();
        
			for(i=0; i<regNoArray.length; i++){
				if(stuRegNo.equals(regNoArray[i])){
					stuName = nameArray[i];
					stuNIC = nicArray[i];
					
					System.out.println("\t\tStudent Name\t: " + stuName);
					System.out.println("\t\tStudent NIC\t: " + stuNIC);
					isRegFound=true;
					
					System.out.println("\nWhat do you want to update ? ");
					System.out.println("\t\t(01) Student Name");
					System.out.println("\t\t(02) Student NIC");
					System.out.println("\t\t(03) Both(Name & NIC)\n");
					
					System.out.print("Enter your option - ");
					int updateOption = input.nextInt();
					
					updateArrays(updateOption, stuRegNo, stuNIC, stuName, i);
					
					System.out.print("Do you want to Update another Student Account(Y/N) : ");
					reEnter = input.next();
					repeat = isReEnter(reEnter);
				}
			}
			if(isRegFound==false){
				System.out.println("Student Registration Number not Found");
				System.out.print("Do you want to Re try (Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat==false){
					System.out.println("Do you want to go to homepage(Y/N) : ");
					reEnter = input.next();
					repeat = isReEnter(reEnter);
					if(repeat){
						homePage();
					}
					else if(repeat==false){
						exit();
					}
				}
			}	
		}
		while(repeat);
	}
	
    public static void viewStudentProfile(){
		Scanner input = new Scanner(System.in);
		String stuRegNo = "";
		boolean isRegFound = false;
		boolean repeat = true;
		
		do{
			clearConsole();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tView Student's Profile\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
			System.out.print("Enter Students Registratiion No : ");
			stuRegNo = input.next();
			for (int i = 0; i < regNoArray.length; i++){
				if(stuRegNo.equals(regNoArray[i])){
					isRegFound = true;
					
					String PRFmarks="" +prfArray[i];
					String DBMSmarks = ""+dbmsArray[i];
					if(prfArray[i]==-1){
						PRFmarks = "Absent";
					}
					else if(prfArray[i]==-2){
						PRFmarks = "Not Conducted";
					}
					if(dbmsArray[i]==-1){
						DBMSmarks = "Absent";
					}
					else if(dbmsArray[i]==-2){
						DBMSmarks = "Not Conducted";
					}
					
					System.out.println("\t\tRegistration No\t\t: "+stuRegNo);
					System.out.println("\t\tStudent Name\t\t: "+nameArray[i]);
					System.out.println("\t\tStudent NIC\t\t: "+nicArray[i]);
					System.out.println("\t\tStudent PRF Marks\t: "+PRFmarks);
					System.out.println("\t\tStudent DBMS Marks\t: "+DBMSmarks);
					System.out.println("\t\tStudent GPA\t\t: "+ createGPA(i));
				}
			}
			if(isRegFound==false){
				System.out.println("\t\tThis Student does not exist in the system.\n");
			}
				
			System.out.print("Do you want to search another student details(Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			if(repeat==false){
				System.out.print("Do you want to go to homepage(Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat){
					homePage();
				}
				else{
					exit();
				}
			}	
		}
		while(repeat);
		
	}
	
	public static double createGPA(int index){
		double prfGPA = 0;
		double dbmsGPA = 0;
	
		
		if(prfArray[index]>=90){
			prfGPA = 4.25;
		}
		else if(prfArray[index]>=80){
			prfGPA = 4.00;
		}
		else if(prfArray[index]>=75){
			prfGPA = 3.70;
		}
		else if(prfArray[index]>=70){
			prfGPA = 3.30;
		}
		else if(prfArray[index]>=65){
			prfGPA = 3.00;
		}
		else if(prfArray[index]>=60){
			prfGPA = 2.70;
		}
		else if(prfArray[index]>=55){
			prfGPA = 2.30;
		}
		else if(prfArray[index]>=50){
			prfGPA = 2.00;
		}
		else if(prfArray[index]>=45){
			prfGPA = 1.70;
		}
		else if(prfArray[index]>=40){
			prfGPA = 1.30;
		}
		else if(prfArray[index]>=30){
			prfGPA = 1.00;
		}
		else if(prfArray[index]>=20){
			prfGPA = 0.70;
		}
		
		if(dbmsArray[index]>=90){
			dbmsGPA = 4.25;
		}
		else if(dbmsArray[index]>=80){
			dbmsGPA = 4.00;
		}
		else if(dbmsArray[index]>=75){
			dbmsGPA = 3.70;
		}
		else if(dbmsArray[index]>=70){
			dbmsGPA = 3.30;
		}
		else if(dbmsArray[index]>=65){
			dbmsGPA = 3.00;
		}
		else if(dbmsArray[index]>=60){
			dbmsGPA = 2.70;
		}
		else if(dbmsArray[index]>=55){
			dbmsGPA = 2.30;
		}
		else if(dbmsArray[index]>=50){
			dbmsGPA = 2.00;
		}
		else if(dbmsArray[index]>=45){
			dbmsGPA = 1.70;
		}
		else if(dbmsArray[index]>=40){
			dbmsGPA = 1.30;
		}
		else if(dbmsArray[index]>=30){
			dbmsGPA = 1.00;
		}
		else if(dbmsArray[index]>=20){
			dbmsGPA = 0.70;
		}
		
		
		double finalGPA = (double)(prfGPA + dbmsGPA)/2;
		
		return finalGPA;
	}
	
    public static void deleteStudentProfile(){
		Scanner input = new Scanner(System.in);
		String stuRegNo = "";
		boolean isRegFound = false;
		boolean repeat = true;
		
		do{
			clearConsole();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tDelete Student Profile\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
			System.out.print("Enter Students Registratiion No : ");
			stuRegNo = input.next();
			
			for(int i=0; i<regNoArray.length; i++){
				if(stuRegNo.equals(regNoArray[i])){
					isRegFound=true;
					
					clearConsole();
					System.out.println("-----------------------------------------------------------------");
					System.out.println("|\t\t\tDelete Student Profile\t\t\t|");
					System.out.println("-----------------------------------------------------------------\n");
					
					String PRFmarks="" +prfArray[i];
					String DBMSmarks = ""+dbmsArray[i];
					if(prfArray[i]==-1){
						PRFmarks = "Absent";
					}
					else if(prfArray[i]==-2){
						PRFmarks = "Not Conducted";
					}
					if(dbmsArray[i]==-1){
						DBMSmarks = "Absent";
					}
					else if(dbmsArray[i]==-2){
						DBMSmarks = "Not Conducted";
					}
					System.out.println("Registration no\t\t: " + stuRegNo);
					System.out.println("Student Name\t\t: " + nameArray[i]);
					System.out.println("Student NIC\t\t: " + nicArray[i]);
					System.out.println("Student PRF Marks\t: " + PRFmarks);
					System.out.println("Student DBMS Marks\t: " + DBMSmarks);
					System.out.println("Student GPA\t\t: " + createGPA(i));
					
					System.out.print("Do you want to delete this student profile(Y/N) : ");
					String delete = input.next();
					repeat = isReEnter(delete);
					if(repeat==true){
						
						deleteFromArrays(stuRegNo);
						
						System.out.println("\tStudent was Successfully deleted from the system.");
					}
				}
			}
			if(isRegFound==false){
				System.out.println("\n\tThis student does ot exist in the system.\n");
			}
			System.out.print("Do you want to delete another student profile(Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			
			
		}
		while(repeat);
	}
	
	public static void deleteFromArrays(String stuRegNo){
		String[] temp_regNoArray = new String[regNoArray.length - 1];
		String[] temp_nicArray = new String[nicArray.length - 1];
		String[] temp_nameArray = new String[nameArray.length - 1];
		int[] temp_prfArray = new int[nicArray.length - 1];
		int[] temp_dbmsArray = new int[nameArray.length - 1];
		
		int j=0;
		for (int i = 0; i < regNoArray.length; i++){
			if(stuRegNo.equals(regNoArray[i])){
				continue;
			}
			temp_regNoArray[j] = regNoArray[i];
			temp_nicArray[j] = nicArray[i];
			temp_nameArray[j] = nameArray[i];
			temp_prfArray[j] = prfArray[i];
			temp_dbmsArray[j] = dbmsArray[i];
			j++;
		}
		regNoArray = temp_regNoArray;
		nicArray = temp_nicArray;
		nameArray = temp_nameArray;
		prfArray = temp_prfArray;
		dbmsArray = temp_dbmsArray;
	
	}
	
	
	public static void updateArrays(int updateOption, String stuRegNo, String stuNIC, String stuName, int i){
		Scanner input = new Scanner(System.in);
		clearConsole();
		switch(updateOption){
			case 1 : {
				System.out.println("Student Name Update");
				System.out.println("===================\n");
				
				System.out.println("Registration NUmber\t\t: " + stuRegNo);
				System.out.println("Student NIC\t\t\t: " + stuNIC);
				System.out.println("Student Current Name\t\t: " + stuName);
				
				System.out.print("\nEnter student name to update - ");
				stuName = input.nextLine();
				
				nameArray[i] = stuName;

				System.out.println("\n\n\t\tStudent Name updated successfully...\n");
				break;
			}
			case 2 : {
				System.out.println("Student NIC Update");
				System.out.println("===================\n");
				
				System.out.println("Registration NUmber\t\t: " + stuRegNo);
				System.out.println("Student NIC\t\t\t: " + stuNIC);
				System.out.println("Student Current Name\t\t: " + stuName);
				
				System.out.print("\nEnter student NIC to update - ");
				stuNIC = input.nextLine();
				
				nicArray[i] = stuNIC;
				
				System.out.println("\n\n\t\tStudent Name updated successfully...\n");
				break;	
			}
			case 3 : {
				System.out.println("Student Name & NIC Update");
				System.out.println("=========================\n");
				
				System.out.println("Registration NUmber\t\t: " + stuRegNo);
				System.out.println("Student NIC\t\t\t: " + stuNIC);
				System.out.println("Student Current Name\t\t: " + stuName);
				
				System.out.print("\nEnter student name to update - ");
				stuName = input.nextLine();
				
				nameArray[i] = stuName;
				
				System.out.print("\nEnter student NIC to update - ");
				stuNIC = input.nextLine();
				
				nicArray[i] = stuNIC;
				
				System.out.println("\n\n\t\tStudent Account updated successfully...\n");
				
				break;
			}
		}
	}

    
    // Batch Management
    public static void batchManagement() {
		Scanner input = new Scanner(System.in);
		
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tBatch Management\t\t\t|");
        System.out.println("-------------------------------------------------------------------------\n");
        
        System.out.println("[1] Add Batch");
        System.out.println("[2] Update Batch");
        System.out.println("[3] View Batch");
        System.out.println("[4] Exit\n");
        
        System.out.print("Enter an option to continue >");
        int option = input.nextInt();
        
        switch(option){
			case 1 : 
				clearConsole();
				addBatch();
				break;
			case 2 :
				clearConsole();
				updateBatch();
				break;
			case 3 :
				clearConsole();
				viewBatches();
				break;
			case 4 :
				clearConsole();
				exit();
				break;
		}

    }
    
    
    public static void addBatch(){
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t\tAdd Batch\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
        
			int batchNo = 100;
			int enrollment = 0;
			int studentCount = 0;
        
			System.out.print("Enter Batch Number : ");
			batchNo = input.nextInt();
			boolean isBatchNoFound = false;
			for(int i=0; i<batchNameArray.length; i++){
				if(batchNo==batchNameArray[i]){
					isBatchNoFound = true;
					System.out.println("Batch is already added to the system.");
				}
			}
			if(isBatchNoFound==false){
				System.out.print("Is Enrollment Open? (1-Open 0-Closed) : ");
				enrollment = input.nextInt();
				System.out.print("Enter the student count of the batch : ");
				studentCount = input.nextInt();
			
				addToBatchArray(batchNo, enrollment, studentCount);
			
				System.out.println("Batch was successfully added to the system.");
			}
			System.out.print("Do you want to add another batch to the system (Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			if(repeat==false){
				System.out.print("Do you want to go to homepage(Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat){
					homePage();
				}
				else if(repeat==false){
					exit();
				}
			}
		}
		while(repeat);
	}
	
	
	public static void addToBatchArray(int batchNo, int enrollment, int studentCount){
		int[] temp_batchNameArray = new int[batchNameArray.length+1];
		int[] temp_eachBatchstuCount = new int[eachBatchStuCount.length+1];
		int[] temp_batchStatusArray = new int[batchStatusArray.length+1];
		
		for (int i = 0; i < batchNameArray.length; i++){
			temp_batchNameArray[i] = batchNameArray[i];
			temp_eachBatchstuCount[i] = eachBatchStuCount[i];
			temp_batchStatusArray[i] = batchStatusArray[i];
		}
		temp_batchNameArray[batchNameArray.length] = batchNo;
		temp_eachBatchstuCount[eachBatchStuCount.length] = studentCount;
		temp_batchStatusArray[batchStatusArray.length] = enrollment;		
	}
	
	public static void updateBatch(){
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		int batchIndex = 0;
		boolean isBatchNoFound = false;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tUpdate Batch\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.print("Enter Batch Number : ");
			int batchNo = input.nextInt();
			for(int i=0; i<batchNameArray.length; i++){
				if(batchNameArray[i]==batchNo){
					batchIndex = i;
					isBatchNoFound = true;
				}
			}
			if(isBatchNoFound == true){
				System.out.println("Current Status : " + findCurrentBatchStatus(batchIndex));
				System.out.println("Student Count : " + eachBatchStuCount[batchIndex]);
				
				String oppositeBatchStatus = findCurrentBatchStatus(batchIndex).equals("ENROLLMENT OPEN") ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN" ;
				System.out.print("\nDo you Want to change the batch status to "+ oppositeBatchStatus + " (Y/N) : ");
				String changeBatchStatus = input.next();
				if(changeBatchStatus.equals("Y") || changeBatchStatus.equals("y")){
					batchStatusArray[batchIndex] = batchStatusArray[batchIndex]==0 ? 1 : 0 ;
					System.out.println("\t\tBatch Status uploaded successfully...");
				}
				else if(changeBatchStatus.equals("N") || changeBatchStatus.equals("n")){	}
				else{
					System.out.println("Invalid Input...");
				}
			}
			
			else if(isBatchNoFound==false){
				System.out.println("Batch Number is not found in the system.\n");
			}
			
			System.out.print("\nDo you want to enter another batch number? (Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			if(repeat==false){
				System.out.print("Do you want to go to home page(Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat){
					homePage();
				}
				else{
					exit();
				}
			}
		}
		while(repeat);
	}
	
	public static String findCurrentBatchStatus(int batchIndex){
		String batchStatus = "ENROLLMENT STATUS";
		if(batchStatusArray[batchIndex]==0){
			batchStatus = "ENROLLMENT CLOSED";
		}
		else if(batchStatusArray[batchIndex]==1){
			batchStatus = "ENROLLMENT OPEN";
		}
		return batchStatus;
	}
	
	public static void viewBatches(){
		Scanner input =new Scanner(System.in);
		boolean repeat = true;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tView Batch\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%-5s %10s %20s %15s %n","No","Batch No","Student Count","Status");
			System.out.println("--------------------------------------------------------------------");
			
			for(int i=0; i<batchNameArray.length; i++){
				System.out.printf("%-7s %-15s %-22s %-2s %n",(i+1),batchNameArray[i],eachBatchStuCount[i], findCurrentBatchStatus(i));
				System.out.println("--------------------------------------------------------------------");
			}
			System.out.print("Do you want to go to homepage(Y/N) : ");
			String homepage = input.next();
			repeat = isReEnter(homepage);
			if(repeat){
				clearConsole();
				homePage();
			}
			else{
				exit();
			}
		}
		while(repeat);
	}
	  

    // Grade Management
    public static void gradeManagement() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tGrade Management\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			System.out.println("[1] PRF Marks Update");
			System.out.println("\n[2] DBMS Marks Update ");
			System.out.println("\n[3] Exit\n");
        
			System.out.print("Enter an option to continue > ");
			int option = input.nextInt();
		
			switch(option){
				case 1 :
					prfMarksUpdate();
					break;
				case 2 : 
					dbmsMarksUpdate();
					break;
				case 3 :
					exit();
					break;
			}
			System.out.print("Do you want to re use the Grade Management menu(Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
		}
		while(repeat);
	
    }
    
    public static void prfMarksUpdate(){
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		boolean isRegNoFound = false;
		int stuIndex = 0;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tPRF Marks Update\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.print("Enter Student registration number : ");
			String regNo = input.next();
			
			for(int i=0; i<regNoArray.length; i++){
				if(regNo.equals(regNoArray[i])){
					isRegNoFound = true;
					stuIndex = i;
				}
			}
			if(isRegNoFound==true){
				clearConsole();
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tPRF Marks Update\t\t\t|");
				System.out.println("-------------------------------------------------------------------------\n\n");
				
				System.out.println("\t\tRegistration No\t\t: "+regNoArray[stuIndex]);
				System.out.println("\t\tStudent Name\t\t: "+nameArray[stuIndex]);
				System.out.println("\t\tStudent NIC\t\t: "+nicArray[stuIndex]);
				
				if(prfArray[stuIndex]==-1){
					System.out.println("This Student has been absent for the PRF exam.");
				}
				else if(prfArray[stuIndex]==-2){
					System.out.println("The PRF Exam has not been Conducted yet for this student.");
				}
				else{
					System.out.println("This student has already completed the PRF module.");
					System.out.println("\t\tPRF Marks : "+prfArray[stuIndex]);
					
					System.out.print("Do you want to update this student's PRF marks(Y/N) : ");
					String confirm = input.next();
					if(confirm.equals("Y") || confirm.equals("y")){
						System.out.print("\t\tEnter PRF Marks : ");
						int prfMarks = input.nextInt();
						if(prfMarks<-2 || prfMarks>100){
							System.out.println("\n\tInvalid input...(Marks maust be within 0 & 100)");
						}
						else{
							prfArray[stuIndex] = prfMarks;
							System.out.println("\n\tThis student's PRF marks updated successfully...");
						}
					}
				}	
			}
			else{
				System.out.println("Registration Number is not found in the system.\n");
			}
			System.out.print("Do you want to enter another registration number(Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			if(repeat == false){
				System.out.print("Do you want to go to homepage(Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat){
					homePage();
				}
				else{
					exit();
				}
			}
		}
		while(repeat);
	}
	
	public static void dbmsMarksUpdate(){
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		boolean isRegNoFound = false;
		int stuIndex = 0;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tDBMS Marks Update\t\t\t|");
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.print("Enter Student registration number : ");
			String regNo = input.next();
			
			for(int i=0; i<regNoArray.length; i++){
				if(regNo.equals(regNoArray[i])){
					isRegNoFound = true;
					stuIndex = i;
				}
			}
			if(isRegNoFound==true){
				clearConsole();
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tDBMS Marks Update\t\t\t|");
				System.out.println("-------------------------------------------------------------------------\n\n");
				
				System.out.println("\t\tRegistration No\t\t: "+regNoArray[stuIndex]);
				System.out.println("\t\tStudent Name\t\t: "+nameArray[stuIndex]);
				System.out.println("\t\tStudent NIC\t\t: "+nicArray[stuIndex]);
				
				if(dbmsArray[stuIndex]==-1){
					System.out.println("This Student has been absent for the DBMS exam.");
				}
				else if(dbmsArray[stuIndex]==-2){
					System.out.println("The DBMS Exam has not been Conducted yet for this student.");
				}
				else{
					System.out.println("This student has already completed the DBMS module.");
					System.out.println("\t\tDBMS Marks : "+dbmsArray[stuIndex]);
					
					System.out.print("Do you want to update this student's DBMS marks(Y/N) : ");
					String confirm = input.next();
					if(confirm.equals("Y") || confirm.equals("y")){
						System.out.print("\t\tEnter DBMS Marks : ");
						int dbmsMarks = input.nextInt();
						if(dbmsMarks<-2 || dbmsMarks>100){
							System.out.println("\n\tInvalid input...(Marks maust be within 0 & 100)");
						}
						else{
							dbmsArray[stuIndex] = dbmsMarks;
							System.out.println("\n\tThis student's PRF marks updated successfully...");
						}
					}
				}	
			}
			else{
				System.out.println("Registration Number is not found in the system.\n");
			}
			System.out.print("Do you want to enter another registration number(Y/N) : ");
			String reEnter = input.next();
			repeat = isReEnter(reEnter);
			if(repeat == false){
				System.out.print("Do you want to go to homepage(Y/N) : ");
				reEnter = input.next();
				repeat = isReEnter(reEnter);
				if(repeat){
					homePage();
				}
				else{
					exit();
				}
			}
		}
		while(repeat);
	}
	
    
    // Report Generator
    public static void reportGenerator() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tReport Generator\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------------\n");
			System.out.println("\n[1] Student Registration Report");
			System.out.println("\n[2] BatchiWise Student Report ");
			System.out.println("\n[3] Industry Training Eligibility Report");
			System.out.println("\n[4] Exit");

			System.out.print("Enter an option to continue > ");
			int option = input.nextInt();
        
			switch(option){
				case 1 :
					studentRegistrationReport();
					break;
				case 2 :
					batchWiseStudentReport();
					break;
				case 3 :
					industryEligibilityReport();
					break;
				case 4 :
					exit();
			}
			System.out.print("\n\nDo you want to re use the report Generator(Y/N) : ");
			String reuse = input.next();
			repeat = isReEnter(reuse);
			if(repeat==false){
				System.out.print("Do you want to go to homepage(Y/N) : ");
				String homepage = input.next();
				repeat = isReEnter(reuse);
				if(repeat){
					homePage();
				}
				else{
					exit();
				}
			}
		}
		while(repeat);
    }
    
    
    public static void studentRegistrationReport(){
		clearConsole();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tStudent Registration Report\t\t\t\t|");
		System.out.println("-----------------------------------------------------------------------------------------\n");
		sortArraysAlphabetcal();
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
		
		for (int i=0; i<nameArray.length; i++) {
            System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",(i+1), regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
        }
	}
	
	public static void batchWiseStudentReport(){
		Scanner input = new Scanner(System.in);
		clearConsole();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tStudent Registration Report\t\t\t\t|");
		System.out.println("-----------------------------------------------------------------------------------------\n");
		
		System.out.println("[1] 105 Batch");
		System.out.println("[2] 106 Batch");
		System.out.println("[3] 107 Batch");
		System.out.println("[4] 108 Batch");
		System.out.println("[5] 109 Batch");
		System.out.println("[6] 110 Batch");
		System.out.println("[7] exit");
		
		System.out.print("Enter an option to continue : ");
		int option = input.nextInt();
		
		sortArraysAlphabetcal();
		clearConsole();
		switch(option){
			
		case 1 :
			int batchNumber = 105;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t105 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			int j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 2 :
			batchNumber = 106;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t106 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 3 :
			batchNumber = 107;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t107 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 4 :
			batchNumber = 108;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t108 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 5 :
			batchNumber = 109;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t109 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 6 :
			batchNumber = 110;
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\t110 Batch Student Report\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------\n");
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
			j=0;
			for (int i=0; i<nameArray.length; i++) {
				if( Character.getNumericValue(regNoArray[i].charAt(4)) == batchNumber/100  &&  Character.getNumericValue(regNoArray[i].charAt(5)) == (batchNumber/10)%10  &&  Character.getNumericValue(regNoArray[i].charAt(6)) == batchNumber%100%10 ){
					j++;
					System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
				}
			}
			break;
		case 7 :
			break;
			
		}
	}
	
	public static void industryEligibilityReport(){
		clearConsole();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tIndustry Eligibility Report\t\t\t\t|");
		System.out.println("-----------------------------------------------------------------------------------------\n");
		sortArraysAlphabetcal();
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %s %n", "No", "Registration No", "Student Name", "NIC", "PRF Mars","DBMS Marks","GPA");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
		int j=0;
		for (int i = 0; i < nameArray.length; i++){
			double GPA = createGPA(i);
			if(prfArray[i] > 50 && dbmsArray[i] > 50 && GPA > 3.25){
				j++;
				System.out.printf("%-7s %-24s %-30s %-20s %-10s %-15s %.3f %n",j , regNoArray[i], nameArray[i], nicArray[i], prfArray[i], dbmsArray[i], gpaArray[i]);
			}
		}
		
	}
	
	public static void sortArraysAlphabetcal(){
		for (int i = 0; i < nameArray.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < nameArray.length - 1 - i; j++) {
                if (nameArray[j].compareTo(nameArray[j + 1]) > 0) {
                    String temp = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = temp;
                    swapped = true;
                    
                    temp = regNoArray[j];
                    regNoArray[j] = regNoArray[j + 1];
                    regNoArray[j + 1] = temp;
                    
                    temp = nicArray[j];
                    nicArray[j] = nicArray[j + 1];
                    nicArray[j + 1] = temp;
                    
                    int temp_marks = prfArray[j];
                    prfArray[j] = prfArray[j + 1];
                    prfArray[j + 1] = temp_marks;
                    
                    temp_marks = dbmsArray[j];
                    dbmsArray[j] = dbmsArray[j + 1];
                    dbmsArray[j + 1] = temp_marks;
                    
                }
            }
            if (!swapped) {
                break;
            }
        } 
        for(int i=0; i<nameArray.length; i++){
			double GPA = createGPA(i);
			gpaArray[i] = GPA;
		}
        
	}
    
   
	// Re-Enter Function
	public static boolean isReEnter(String reEnter){
		
		if(reEnter.equals("Y") || reEnter.equals("y")){
			return true;
		}
		else if(reEnter.equals("N") || reEnter.equals("n")){
			return false;
		}
		else{
			System.out.println("Invalid Input... ");
			return false;
		}
	};  
    
    
    // main method
    public static void main(String args[]) {
        homePage();
    }

}
