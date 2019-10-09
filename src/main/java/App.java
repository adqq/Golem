import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter {
    public static void main(String [] args) throws Exception{

        JDA jda = new JDABuilder(AccountType.BOT).setToken("").buildBlocking();
        CommandClientBuilder builder = new CommandClientBuilder();

        builder.setOwnerId("");
        builder.setPrefix("!");
        builder.setGame(Game.watching("hi"));
        builder.setStatus(OnlineStatus.IDLE);

        builder.addCommand(new MemberInfoCommand());
        builder.addCommand(new ServerInfoCommand());
        builder.addCommand(new HelpCommand());

        CommandClient client = builder.build();

        jda.addEventListener(client);

    }
}


