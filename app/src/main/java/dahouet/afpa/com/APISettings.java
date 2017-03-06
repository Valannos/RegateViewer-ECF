package dahouet.afpa.com;

/**
 * Created by Afpa on 01/03/2017.
 */

public class APISettings {

    public enum URI {

        GET_CURRENT_CHALLENGE,
        GET_REGATES_FROM_CHALLENGE,
        GET_PARTICIPATION_FROM_REGATE_WITHOUT_RESULT,
        GET_PARTICIPATION_FROM_REGATE_WITH_RESULTS,


    }

    private static final String HOST = "10.105.49.20";
    private static final int PORT = 4567;

    private static final String HTTP = "http://";
    private static final String GET_CURRENT_CHALLENGE = "/currentChallenge";
    private static final String GET_REGATES_FROM_CHALLENGE = "/currentRegates";
    private static final String GET_PARTICIPATION_FROM_REGATE_WITHOUT_RESULT = "/participations_without_result";
    private static final String GET_PARTICIPATION_FROM_REGATE_WITH_RESULTS = "/participations_with_result";


    public static String getURI(URI uri) {

        switch (uri) {

            case GET_CURRENT_CHALLENGE:
                return HTTP + HOST + ":" + PORT + GET_CURRENT_CHALLENGE;
            case GET_REGATES_FROM_CHALLENGE:
                return HTTP + HOST + ":" + PORT + GET_REGATES_FROM_CHALLENGE;
            case GET_PARTICIPATION_FROM_REGATE_WITHOUT_RESULT:
                return HTTP + HOST + ":" + PORT + GET_PARTICIPATION_FROM_REGATE_WITHOUT_RESULT;
            case GET_PARTICIPATION_FROM_REGATE_WITH_RESULTS:
                return HTTP + HOST + ":" + PORT + GET_PARTICIPATION_FROM_REGATE_WITH_RESULTS;
            default:
                return "";

        }

    }

}
