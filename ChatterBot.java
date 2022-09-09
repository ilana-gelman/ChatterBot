import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Ilana gelmman
 */
class ChatterBot {
    static final String REQUEST_PREFIX = "say ";
    static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
    static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

    Random rand = new Random();
    String[ ] repliesToIllegalRequest;
    String name;
    String[] repliesToLegalRequest;

    /**
     *
     *  the constructor of the class, initializes the given fields
     *
     *
     * @param name the name of the objects
     * @param repliesToLegalRequest list with optional replies to legal requests
     * @param repliesToIllegalRequest list with optional replies to illegal request
     */
    ChatterBot(String name,  String[] repliesToLegalRequest ,String[] repliesToIllegalRequest) {

        this.name= name;
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
        this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
        for(int i = 0 ; i < repliesToLegalRequest.length ; i = i+1) {
            this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
        }

    }

    /**
     *
     * this function manages the dialog of the two bots, decides if the statement is legal or not
     * and calls to helper function that deals with the reply statement
     *
     * @param statement the statement to reply to
     * @return the reply sentence
     */
    String replyTo(String statement) {
        if(statement.startsWith(REQUEST_PREFIX)) {
            String phrase =statement.replaceFirst(REQUEST_PREFIX, "");
            return replacePlaceholderInARandomPattern(repliesToLegalRequest,REQUESTED_PHRASE_PLACEHOLDER,phrase);

        }
        return replacePlaceholderInARandomPattern(repliesToIllegalRequest,ILLEGAL_REQUEST_PLACEHOLDER,statement);
    }

    /**
     *
     * @return this function returns the name of the current  object(the bot)
     */
    String getName(){
        return this.name;
    }

    /**
     * this function chooses what to respond by choosing random index in the range of the given list length,
     * and replaces all the  requests  places by the given statement
     * @param dialoglst list with reply options
     * @param request  REQUESTED_PHRASE_PLACEHOLDER  in case of legal request , ILLEGAL_REQUEST_PLACEHOLDER
     *         in case of illegal request
     * @param statement the word to replace with the request
     * @return the next reply
     */
    String replacePlaceholderInARandomPattern(String[ ] dialoglst, String request, String statement){
        int randomIndex = rand.nextInt(dialoglst.length);
        String reply = dialoglst[randomIndex];
        return reply.replaceAll(request, statement);

    }



}