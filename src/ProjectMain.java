// test

import java.util.StringTokenizer;

public class ProjectMain {

    public KeyboardInputClass input = new KeyboardInputClass();
    public LList keywordsEmail = new LList();
    public LList keywordsUser = new LList();

    public void main(String[] args) {
        while (true) {
            keywordsEmail.clear();
            keywordsUser.clear();
            TextFileClass text = new TextFileClass();
            text.getFileName("Get The Email Name");
            text.getFileContents();
            String allString = "";
            for (int i = 0; i < text.text.length; i++) {
                allString += text.text[i];
            }
            StringTokenizer token = new StringTokenizer(allString);
            while (token.hasMoreElements()) {
                String currentToken = token.nextToken(" ");
                currentToken = currentToken.toUpperCase();
                if (!currentToken.equals(" ") && !currentToken.equals("AND") && !currentToken.equals("OR") && !currentToken.equals("THE")
                        && !currentToken.equals("IF") && !currentToken.equals("A") && !currentToken.equals("AN") && !currentToken.equals("ALL")
                        && !currentToken.equals("SOME") && !currentToken.equals("FEW")) {
                    keywordsEmail.add(currentToken);
                }
            }
            char quitMe = input.getCharacter(true, 'N', "Y,N", 1, "Would You Like To Exit The Program? (Y/N Default=N)");
            if (quitMe == 'Y') {                                        // exit the program
                break;
            }
        }
    }
    public LList emails = new LList();
    public void processingContent(){
        emails.clear();
        for (int i = 1; i <= keywordsUser.getLength(); i++) {
            user currentUser = (user) keywordsUser.getEntry(i);
            boolean breaker = false;
            for (int j = 0; j < currentUser.compareThis.length; j++) {
                String currentCompare = currentUser.compareThis[j];
                for (int k = 1; k <= keywordsUser.getLength(); k++) {
                    String currentKey = (String)keywordsUser.getEntry(k);
                    if(currentKey.equals(currentCompare)){
                        emails.add(currentUser.email);
                        breaker=true;
                        break;
                    }
                }
                if(breaker==true){
                    break;
                }
            }            
        }
    }
    public void sendEmails(){
        for (int i = 1; i <= emails.getLength(); i++) {
            String currentEmail = (String)emails.getEntry(i);
           /* code to send an email to the current email string*/
            
        }
    }
    public void initializeDB() {
        String[] compareThis = {"Jackson", "Compound", "Radius", "Fender", "Red", "Floyd", "Rose", "HSS", "Solid-Body", "Electric"};
        user newUser = new user(compareThis, "ramison@samford.edu", "JonAshley", "Amison");
        keywordsUser.add(newUser);
        for (int i = 1; i <= keywordsUser.getLength(); i++) {
            user currentUser = (user) keywordsUser.getEntry(i);
            for (int j = 0; j < currentUser.compareThis.length; j++) {
                currentUser.compareThis[i] = currentUser.compareThis[i].toUpperCase();
            }
        }
    }
}

class user {

    public String[] compareThis;
    public String email;
    public String fname;
    public String lname;

    user(String[] passedString, String passedEmail, String fnameP, String lnameP) {
        compareThis = passedString;
        email = passedEmail;
        fname = fnameP;
        lname = lnameP;
    }
}
