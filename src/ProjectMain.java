// test push
import java.util.StringTokenizer;

public class ProjectMain {

    public KeyboardInputClass input = new KeyboardInputClass();
    public LList keywordsEmail = new LList();
    public LList keywordsUser = new LList();
    public void main(String[] args) {
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

    }

    public void initializeDB() {
        String[] compareThis = {"Jackson","Compound","Radius","Fender","Red","Floyd","Rose","HSS","Solid-Body","Electric"};
        user newUser = new user(compareThis,"ramison@samford.edu","JonAshley","Amison");
        keywordsUser.add(newUser);
        for (int i = 1; i <= keywordsUser.getLength(); i++) {
            user currentUser = (user)keywordsUser.getEntry(i);
            for (int j = 0; j < currentUser.compareThis.length; j++) {
                currentUser.compareThis[i]=currentUser.compareThis[i].toUpperCase();                
            }           
        }
    }
}

class user{
    public String[] compareThis;
    public String email;
    public String fname;
    public String lname;
    user(String[] passedString, String passedEmail, String fnameP,String lnameP){
        compareThis=passedString;
        email=passedEmail;
        fname=fnameP;
        lname=lnameP;
    }
}
