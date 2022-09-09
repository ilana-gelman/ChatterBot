import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] repliesToIllegalRequest = {"what " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER, "say I should say " };
        String[] repliesToLegalRequest = {"say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER +"? okay: " +ChatterBot.REQUESTED_PHRASE_PLACEHOLDER ,"You want me to say "+ChatterBot.REQUESTED_PHRASE_PLACEHOLDER+", do you? alright: " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER };
        ChatterBot[] bots = new ChatterBot[2];
        bots[0] = new ChatterBot("Ilana",repliesToLegalRequest,repliesToIllegalRequest);
        repliesToIllegalRequest = new String[] { "whaaat " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER, "say say "};
        bots[1]= new ChatterBot("Liora",repliesToLegalRequest,repliesToIllegalRequest);
        String statement =scanner.nextLine();
        for(int i = 0 ; ; i++) {
            statement = bots[ i % bots.length ].replyTo(statement);
            System.out.print(bots[ i % bots.length ].getName()+": "+statement);
            scanner.nextLine();
        }



        







    }
}
