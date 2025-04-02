/*
 * takes array of emails and sorts by domain name
 */
package hashexercises;

import java.util.Map;
import java.util.TreeMap;

public class EmailOrganizer {
    public static void main(String[] args) {
        String[] emails = { "Fred@google.com", "Bob@yahoo.com", "Tom@gmail.com",
                "Mia@ucla.edu", "stevep3@newpaltz.edu" };

        emailSort(emails);
    }

    public static TreeMap<String, String> emailSort(String[] emailList) {
        TreeMap<String, String> emails = new TreeMap<>();

        for (int i = 0; i < emailList.length; i++) {
            String[] email = emailList[i].split("@");
            emails.put(email[1], emailList[i]);
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        return emails;
    }
}
