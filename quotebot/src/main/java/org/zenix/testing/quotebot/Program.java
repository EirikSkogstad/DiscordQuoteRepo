package org.zenix.testing.quotebot;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.zenix.testing.quoteparser.models.Quote;
import org.zenix.testing.quoteparser.parsers.ParserYear;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.IMessage;

public class Program {
    // https://jitpack.io/com/github/austinv11/Discord4j/2.9.3/javadoc/
    private static final String ENV_VARIABLE_KEY = "SEWERQUOTES_BOT_TOKEN";
    private final IDiscordClient client;

    private Program(IDiscordClient client) {
        this.client = client;
        EventDispatcher dispatcher = client.getDispatcher();

        dispatcher.registerListener(new EventListener());
    }

    private static IDiscordClient createDiscordClient() {
        ClientBuilder builder = new ClientBuilder();
        String token = readTokenFromSystemVariable();
        if (token == null) {
            System.err.println("Cannot find token for bot");
            return null;
        }
        builder.withToken(token);
        IDiscordClient client = builder.login();
        EventDispatcher dispatcher = client.getDispatcher();

        return client;
    }

    private static String readTokenFromSystemVariable() {
        return System.getenv(ENV_VARIABLE_KEY);
    }

    public static void main(String[] args) {
        IDiscordClient discordClient = createDiscordClient();
        if (discordClient == null) {
            System.exit(0);
        }

        Program program = new Program(discordClient);
    }

}
