package org.example;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Sakancom {
    private static final Logger logger = Logger.getLogger(Sakancom.class.getName());

    private static final String VALUE = "The Value:";
    public static void main(String[] args) throws SQLException {
        String line="_____________________________________________"+"\n";
        while(true){
            logger.info(line);
            logger.info("Choose from the following "+"\n");
            logger.info("1-Login"+"\n");
            logger.info("2-Signup"+"\n");
            logger.info(VALUE);
            Scanner input = new Scanner(System.in);
            int loginOrSignUp = 0;
            loginOrSignUp = input.nextInt();
            logger.info(line);

            if (loginOrSignUp == 1) {
                logger.info("\n******* Login Page *******\n");
                LoginEntity in = new LoginEntity();
                Scanner input1 = new Scanner(System.in);
                logger.info("Enter User Name: "+"\n");
                in.userName = input1.nextLine();
                logger.info("Enter the Password: "+"\n");
                in.passWord = input1.nextLine();
                String role = in.checkValues(in.userName, in.passWord);


                if (role.equals("tenant")) {
                    while (true) {
                        logger.info("_________________Tenant_________________"+"\n");
                        logger.info("Choose from the following"+"\n");
                        logger.info("1-View the available housing"+"\n");
                        logger.info("2-Furniture"+"\n");
                        logger.info("3-Control Panel"+"\n");
                        logger.info("4-Logout"+"\n");
                        logger.info(VALUE);
                        Scanner input2 = new Scanner(System.in);
                        int choose = input2.nextInt();
                        logger.info(line);
                        if (choose == 1) {
                            HousingEntity e = new HousingEntity();
                            int avb = e.showAvailable();
                            if (avb > 1) {
                                logger.info("do you want to book  accommodation? (Yes or No)"+"\n");
                                Scanner inp = new Scanner(System.in);
                                String yn = inp.nextLine();
                                if (yn.equals("Yes")) {
                                    logger.info("Enter house ID: "+"\n");
                                    Scanner id = new Scanner(System.in);
                                    String iD = id.nextLine();
                                    e.booking(iD, in.userName);
                                }
                            }
                        }
                        if (choose == 2) {
                            while (true) {
                                logger.info(line);
                                logger.info("Choose from the following"+"\n");
                                logger.info("1-View the available Furniture's"+"\n");
                                logger.info("2-Add Furniture's"+"\n");
                                logger.info("3-Sell Furniture's"+"\n");
                                logger.info("4-Back"+"\n");
                                logger.info(VALUE);
                                Scanner inp = new Scanner(System.in);
                                int ch = inp.nextInt();
                                logger.info(line);
                                Furniture o = new Furniture();
                                if (ch == 1) {
                                    o.displayFurniture(in.userName);

                                } else if (ch == 2) {
                                    Scanner inp1 = new Scanner(System.in);
                                    logger.info("\nEnter Picture: "+"\n");
                                    o.picture = inp1.nextLine();
                                    logger.info("Enter Description: "+"\n");
                                    o.description = inp1.nextLine();
                                    logger.info("Enter Price: "+"\n");
                                    o.price = inp1.nextLine();
                                    logger.info("Enter ID: "+"\n");
                                    o.id = inp1.nextLine();
                                    o.selled = "No";
                                    o.addFurniture(in.userName, o.picture, o.description, o.price, o.id, o.selled);

                                } else if (ch == 3) {
                                    Scanner inp1 = new Scanner(System.in);
                                    logger.info("Enter ID to sell: ");
                                    o.id = inp1.nextLine();
                                    o.sellFurniture(o.id, in.userName);
                                } else if (ch == 4) {
                                    break;
                                }

                            }
                        } else if
                        (choose == 3) {
                            ControlPanel e = new ControlPanel();
                            e.displayControlPanel(in.userName);
                        } else if (choose == 4) {
                            break;
                        }
                    }

                } else if (role.equals("owner")) {
                    logger.info("____________________Owner____________________"+"\n");
                    logger.info("Choose from the following "+"\n");
                    logger.info("1-Housing "+"\n");
                    logger.info("2-Logout "+"\n");
                    logger.info(VALUE);
                    Scanner i = new Scanner(System.in);
                    int inp = i.nextInt();
                    if (inp == 1) {
                        while (true) {
                            OwnerEntity obj = new OwnerEntity();
                            logger.info("\n___________________Housing___________________"+"\n");
                            logger.info("1-Add Housing "+"\n");
                            logger.info("2-Show Housings "+"\n");
                            logger.info("3-Logout "+"\n");
                            logger.info(VALUE);
                            Scanner inp1 = new Scanner(System.in);
                            int input2 = inp1.nextInt();
                            if (input2 == 1) {
                                Scanner inp3 = new Scanner(System.in);
                                logger.info("________________Add Housing________________"+"\n");
                                logger.info("Enter Housing ID: ");
                                obj.counter = inp3.nextLine();
                                logger.info("\nEnter Owner username: ");
                                logger.info(in.userName);
                                logger.info("\n");
                                obj.addHousing(in.userName);
                                logger.info("Enter Department name: ");
                                String depName = inp3.nextLine();
                                obj.departmentName(depName);
                                logger.info("\nDo you want to insert picture? "+"\n");
                                String yn = inp3.nextLine();
                                if (yn.equals("Yes")) {
                                    logger.info("Enter the picture: ");
                                    String photo = inp3.nextLine();
                                    obj.addPhoto(photo);
                                }
                                logger.info("\nDo you want to Enter Housing Location? \n");
                                String yn2 = inp3.nextLine();
                                if (yn2.equals("Yes")) {
                                    logger.info("Enter Housing Location: ");
                                    String location = inp3.nextLine();
                                    obj.addLocationInfo(location);
                                }
                                logger.info("\nDo you want to Enter Housing Services? \n");
                                String yn3 = inp3.nextLine();
                                if (yn3.equals("Yes")) {
                                    logger.info("Enter Housing Services: ");
                                    String services = inp3.nextLine();
                                    obj.addServices(services);
                                }
                                logger.info("\nDo you want to Enter Rent price? \n");
                                String yn4 = inp3.nextLine();
                                if (yn4.equals("Yes")) {
                                    logger.info("Enter Rent price: ");
                                    String price = inp3.nextLine();
                                    obj.addPrice(price);
                                }
                            }

                            if (input2 == 2) {
                                logger.info("\n_______________Show Housings_______________\n");
                                obj.showHousings(in.userName);
                            }
                            if (input2 == 3)
                                break;
                        }
                    }
                } else if (role.equals("admin")) {
                    AdminEntity obj = new AdminEntity();
                    logger.info("____________________Admin____________________\n");
                    logger.info("Choose from the following \n");
                    logger.info("1-See pending Housings \n");
                    logger.info("2-See Reservations \n");
                    logger.info("3-Logout \n");
                    logger.info(VALUE);
                    Scanner inp1 = new Scanner(System.in);
                    int input2 = inp1.nextInt();
                    if (input2 == 1) {
                        while (true) {
                            obj.pendingHousings();
                            logger.info("Enter housing id: ");
                            Scanner inp4 = new Scanner(System.in);
                            String id = inp4.nextLine();
                            logger.info("Do you want to accept it? \n");
                            String acceptance = inp4.nextLine();
                            if (acceptance.equals("Yes")) {
                                obj.acceptRejectHousing(id, acceptance);
                                logger.info("Housing accepted! \n");
                            } else {
                                logger.info("Housing Rejected! \n");
                            }
                            break;
                        }
                    }
                    if (input2 == 2) {
                        while (true) {
                            obj.showReservations();
                            break;
                        }
                    }
                    if (input2 == 3) {
                        while(true) {
                            logger.info("Logged out successfully\n");
                            break;
                        }
                    }
                }
            }
            else if (loginOrSignUp==2) {
                logger.info(line);
                logger.info("Choose from the following \n");
                logger.info("1-Owner\n");
                logger.info("2-Tenant\n");
                logger.info(VALUE);
                Scanner in = new Scanner(System.in);
                int inp = in.nextInt();
                if(inp == 1) {
                    LoginEntity obj  = new LoginEntity();
                    Scanner inp1 = new Scanner(System.in);
                    logger.info("\n________________Signup as Owner________________\n");
                    logger.info("Please enter your First name: ");
                    String fName = inp1.nextLine();
                    logger.info("\nPlease enter your Middle name name: ");
                    String mName = inp1.nextLine();
                    logger.info("\nPlease enter your Last name: ");
                    String lName = inp1.nextLine();
                    logger.info("\nPlease enter your Email: ");
                    String owEmail = inp1.nextLine();
                    logger.info("\nPlease enter your age: ");
                    obj.age = inp1.nextLine();
                    logger.info("\nPlease enter your Phone number: ");
                    String phone = inp1.nextLine();
                    logger.info("\nPlease enter your username: ");
                    String owUser = inp1.nextLine();
                    logger.info("\nPlease enter your password: ");
                    String owPass = inp1.nextLine();
                    logger.info("\nCreating Owner Account... \n");
                    if (obj.printOwner(fName, mName, lName, phone, owEmail, owUser, owPass)) {
                        logger.info("Owner Account Created\n");
                    } else {
                        logger.info("Error! Creation Failed\n");
                    }
                }
                else if(inp == 2)
                {
                    LoginEntity ob  = new LoginEntity();
                    Scanner inp3 = new Scanner(System.in);
                    logger.info("________________Signup as Tenant________________\n");
                    logger.info("Please enter your First name: ");
                    String fName = inp3.nextLine();
                    logger.info("\nPlease enter your Middle name name: ");
                    String mName = inp3.nextLine();
                    logger.info("\nPlease enter your Last name: ");
                    String lName = inp3.nextLine();
                    logger.info("\nPlease enter your Phone number: ");
                    String phone = inp3.nextLine();
                    logger.info("\nPlease enter your Email: ");
                    String tenEmail = inp3.nextLine();
                    logger.info("\nPlease enter your age: ");
                    ob.age = inp3.nextLine();
                    logger.info("\nPlease enter your Registration number: ");
                    ob.rNum = inp3.nextLine();
                    logger.info("\nPlease enter your major: ");
                    ob.mJor = inp3.nextLine();
                    logger.info("\nPlease enter your username: ");
                    ob.userName = inp3.nextLine();
                    logger.info("\nPlease enter your password: ");
                    ob.passWord = inp3.nextLine();
                    logger.info("Creating Tenant Account... \n");
                    if(ob.printTenant(fName, mName, lName, phone, tenEmail, ob.userName, ob.passWord)) {
                        logger.info("Tenant Account Created\n");
                    }
                    else{
                        logger.info("Error! Creation Failed\n");
                    }
                }
                else {break;}
            }
        }
    }
}