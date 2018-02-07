import org.zenix.testing.quoteparser.models.Quote;
import org.zenix.testing.quoteparser.parsers.ParserYear;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.*;

public class SewerQuotesBot {
    // TODO https://jitpack.io/com/github/austinv11/Discord4j/2.9.3/javadoc/
    public static final String ENV_VARIABLE_KEY = "SEWERQUOTES_BOT_TOKEN";

    public SewerQuotesBot(String token) throws InterruptedException {
        ClientBuilder builder = new ClientBuilder();
        builder.withToken(token);

        IDiscordClient client = builder.login();
        EventDispatcher dispatcher = client.getDispatcher();

        do {
            Thread.sleep(200);
        }
        while (!client.isReady());
        printQuotesFromChannel(client);
    }

    private void printQuotesFromChannel(IDiscordClient client) throws InterruptedException {
        ParserYear parserYear = new ParserYear();
        for (IMessage message : client.getChannelByID(312686431921242116L).getFullMessageHistory()) {
            String messageString = message.toString();

            if (parserYear.isCorrectFormat(messageString)) {
                Quote quote = parserYear.parse(messageString);

                System.out.println(quote.getAuthor());
            }
        }
    }


    public static void main(String[] args) {
        String token = readTokenFromSystemVariable();
        try {
            SewerQuotesBot sewerQuotesBot = new SewerQuotesBot(token);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String readTokenFromSystemVariable() {
        String token = System.getenv(ENV_VARIABLE_KEY);

        if (token == null || "".equals(token)) {
            System.err.println("Cannot find environment variable with name " + ENV_VARIABLE_KEY);
            System.exit(1);
            return null;
        }

        return token;
    }

}
